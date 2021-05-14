package com.comcast.orion.workorder.integration;

import com.comcast.orion.data.vo.CustomerVO;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.command.NewCreateWorkOrderCommand;
import com.comcast.orion.workorder.command.ONPCommand;
import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountResponse;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.domain.onp.insertwo.InsertWORequest;
import com.comcast.orion.workorder.domain.onp.insertwo.Job;
import com.comcast.orion.workorder.domain.onp.insertwo.JobCustomer;
import com.comcast.orion.workorder.domain.onp.insertwo.WorkOrderRequest;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest;
import com.comcast.orion.workorder.utils.DroolsUtil;
import com.comcast.orion.workorder.utils.WorkOrderServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.SQOScheduleWOMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import java.util.List;

@Component
public class SQOScheduleWOAggregator {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    SQOScheduleWOMapper sqoScheduleWoMapper;

    @Autowired
    NewCreateWorkOrderCommand newCreateWorkOrderCommand;

    @Autowired
    private WorkOrderServiceUtil workOrderServiceUtil;

    @Autowired
    DroolsUtil droolsUtil;

    @Autowired
    ONPCommand onpCommand;

    /** The mapper. */
    @Autowired
    ObjectMapper mapper;

    /**
     * Aggregates site, account and data service response
     * @param messages
     * @return
     * @throws OrionMiddlewareServiceException
     */
    @Aggregator(inputChannel = "sqoScheduleWoAggregator", outputChannel = "sqoScheduleWOResponse")
    public SQOScheduleWoResponse aggregate(List<Message> messages) throws OrionMiddlewareServiceException {
        log.info("SQOScheduleWOAggregator::aggregate::enters");
        if(CollectionUtils.isEmpty(messages)){
            log.error("Empty messages");
            throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
        }
        SiteResponse siteResponse = null;
        CustomerAccountResponse customerAccountResponse = null;
        CustomerVO customerVO = null;
        SQOScheduleWO sqoScheduleWO = null;
        for(Message message : messages){
            if(message.getPayload() instanceof OrionMiddlewareServiceException){
                throw (OrionMiddlewareServiceException) message.getPayload();
            }
            if(message.getPayload() instanceof SiteResponse){
                siteResponse = (SiteResponse) message.getPayload();

            }
            if(message.getPayload() instanceof CustomerAccountResponse) {
                customerAccountResponse = (CustomerAccountResponse) message.getPayload();
            }

            if(message.getPayload() instanceof CustomerVO){
                customerVO = (CustomerVO) message.getPayload();
            }
            if(message.getPayload() instanceof SQOScheduleWO){
                sqoScheduleWO = (SQOScheduleWO) message.getPayload();
            }
        }
        if(sqoScheduleWO == null || siteResponse == null || customerAccountResponse == null || customerVO == null) {
            log.error("Required fields are null");
            throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
        }
        log.info("SQOScheduleWOAggregator::aggregate::start mapping");
        WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest = sqoScheduleWoMapper.mapSqoScheduleWORequest(sqoScheduleWO.getScheduleWorkorderRequest(),
                siteResponse,customerAccountResponse,customerVO);
        sqoScheduleWoMapper.mapRuleResults(wfxCreateWorkOrderRequest, customerVO, sqoScheduleWO);
        if(ScheduleWorkorderRequest.RequestType.NEW_REQUEST.value().equalsIgnoreCase(
                sqoScheduleWO.getScheduleWorkorderRequest().getRequestType().value())){
            InsertWORequest insertWORequest = getOnpInsertWORequest(sqoScheduleWO, wfxCreateWorkOrderRequest);
            try {
                onpCommand.insertWOEvent(getNotificationPayloadString(insertWORequest));
            }catch (Exception e){
                log.info("Error posting to ONP", e);
            }
        }
        log.info("SQOScheduleWOAggregator::aggregate::finished mapping");
        String firstName = wfxCreateWorkOrderRequest.getJobCustomer().getFirstName();
        String lastName = wfxCreateWorkOrderRequest.getJobCustomer().getLastName();
        String jobComment = wfxCreateWorkOrderRequest.getJob().getJobComment();
        wfxCreateWorkOrderRequest.getJob().setJobComment(workOrderServiceUtil.formatJobComment(firstName, lastName, jobComment));
        return invokeWFX(sqoScheduleWO.getScheduleWorkorderRequest().getWorkOrderNumber(), wfxCreateWorkOrderRequest);
    }

    /**
     * builds the InsertWORequest
     * @param sqoScheduleWO
     * @param wfxCreateWorkOrderRequest
     * @throws OrionMiddlewareServiceException
     */
    private InsertWORequest getOnpInsertWORequest(SQOScheduleWO sqoScheduleWO, WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest) throws OrionMiddlewareServiceException {
        InsertWORequest insertWORequest = new InsertWORequest();
        WorkOrderRequest workOrderRequest = new WorkOrderRequest();
        workOrderRequest.setWorkOrderId(sqoScheduleWO.getScheduleWorkorderRequest().getWorkOrderNumber());
        workOrderRequest.setSource("SQO");
        Job job = new Job();
        com.comcast.orion.workorder.domain.nWFX.create.Job wfxCreateWorkOrderRequestJob = wfxCreateWorkOrderRequest.getJob();
        job.setJobNum(wfxCreateWorkOrderRequestJob.getJobNum());
        job.setJobClassCd(wfxCreateWorkOrderRequestJob.getJobClassCd());
        if(wfxCreateWorkOrderRequestJob.getJobUnits() != null)
            job.setJobUnits(wfxCreateWorkOrderRequestJob.getJobUnits().toString());
        job.setScheduleDate(wfxCreateWorkOrderRequestJob.getScheduleDate());
        job.setJobTypeCd(wfxCreateWorkOrderRequestJob.getJobTypeCd());
        job.setDispatcherStatusCd(wfxCreateWorkOrderRequestJob.getDispatcherStatusCd());
        job.setTimeSlotCd(wfxCreateWorkOrderRequestJob.getTimeSlotCd());
        job.setTroubleCallIndicator(wfxCreateWorkOrderRequestJob.getTroubleCallIndicator());
        JobCustomer jobCustomer = new JobCustomer();
        jobCustomer.setCustomerId(sqoScheduleWO.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getCustomerId());
        jobCustomer.setSiteId(sqoScheduleWO.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getSiteId());
        workOrderRequest.setJobCustomer(jobCustomer);
        workOrderRequest.setJob(job);
        insertWORequest.setWorkOrderRequest(workOrderRequest);
        return insertWORequest;
    }

    private SQOScheduleWoResponse invokeWFX(String workOrderNumber, WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest) throws OrionMiddlewareServiceException {
        try {
            log.info("SQOScheduleWOAggregator::invokeWFX::calling wfx");
            ResponseEntity<WFXCreateWorkOrderRespone> wfxCreateWorkOrderResponseResponseEntity =
                    newCreateWorkOrderCommand.createWorkorder(wfxCreateWorkOrderRequest, workOrderNumber);
            SQOScheduleWoResponse sqoScheduleWoResponse = sqoScheduleWoMapper.mapSqoScheduleWOResponse(wfxCreateWorkOrderResponseResponseEntity.getBody());
            log.info("SQOScheduleWOAggregator::invokeWFX::exits");
            return sqoScheduleWoResponse;
        }catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException e){
            if (HttpStatus.NOT_FOUND.value() == e.getRawStatusCode()
                    || HttpStatus.SERVICE_UNAVAILABLE.value() == e.getRawStatusCode()
                    && e.getResponseBodyAsString().contains("ZuulException")) {
                throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
            }
            throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX, e.getResponseBodyAsString());
        }catch (ResourceAccessException e) {
            throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
        }catch(OrionMiddlewareServiceException e){
            throw e;
        }
        catch (Exception e){
            log.error("SQOScheduleWOAggregator::downstream error", e);
            throw new OrionMiddlewareServiceException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,"Error creating work order");
        }
    }

    /**
     * Mapping request to string payload
     */
    private String getNotificationPayloadString(Object request)
            throws OrionMiddlewareServiceException {
        String strPayload = "";
        try {
            strPayload = mapper.writeValueAsString(request);
            log.info("Onp request payload {}", strPayload);
        } catch (JsonProcessingException e) {
            log.error("Error occurred on converting the callback obj to String :: {}", e.getMessage());
            throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,
                    "Error occurred on converting the callback object to String");
        }
        return strPayload;
    }

}
