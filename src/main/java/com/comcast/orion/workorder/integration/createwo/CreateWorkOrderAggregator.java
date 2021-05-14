package com.comcast.orion.workorder.integration.createwo;

import java.util.List;

import com.comcast.orion.workorder.utils.WorkOrderServiceUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.domain.createwo.JobCustomer;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;

@Component
public class CreateWorkOrderAggregator {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CreateWorkOrderMapper createWorkOrderMapper;

    @Autowired
    WorkOrderServiceUtil workOrderServiceUtil;
	
	@Aggregator(inputChannel = "createworkorderAggregatorChannel", outputChannel = "wfxChannel")
    public CreateWorkorderWrapper aggregateInstallbaseTnFeatures(List<Message> messages) {
        log.info("createworkorderAggregatorChannel::Enters");
        CreateWorkorderWrapper createWorkorderWrapper=new CreateWorkorderWrapper();
        WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest =new WFXCreateWorkOrderRequest();
        String siteSignageName=null;
        if (!CollectionUtils.isEmpty(messages)) {
            for (Message message : messages) {
                if (message.getPayload() != null) {
                	createWorkorderWrapper = (CreateWorkorderWrapper) message.getPayload();
                }
            }
            //Added below condition to set siteSignageName from getSite api response or createWO request as part of US1885802
            if(StringUtils.isNotEmpty(createWorkorderWrapper.getSiteSignageName())){
            	siteSignageName=createWorkorderWrapper.getSiteSignageName();
            }else if(StringUtils.isNotEmpty(createWorkorderWrapper.getCreateWorkorderRequest().getJobCustomer().getSiteSignageName())){
            	siteSignageName=createWorkorderWrapper.getCreateWorkorderRequest().getJobCustomer().getSiteSignageName();
            }
            wfxCreateWorkOrderRequest = createWorkOrderMapper
					.workOrderReqToWFXCreateRequest(createWorkorderWrapper.getCreateWorkorderRequest());
            workOrderServiceUtil.populateWFXFirstNameLastName(siteSignageName, wfxCreateWorkOrderRequest);
            String firstName = createWorkorderWrapper.getCreateWorkorderRequest().getJobCustomer().getFirstName();
            String lastName = createWorkorderWrapper.getCreateWorkorderRequest().getJobCustomer().getLastName();
            String jobComment = createWorkorderWrapper.getCreateWorkorderRequest().getJob().getJobComment();
            wfxCreateWorkOrderRequest.getJob().setJobComment(workOrderServiceUtil.formatJobComment(firstName, lastName, jobComment));
            createWorkorderWrapper.setWfxCreateWorkOrderRequest(wfxCreateWorkOrderRequest);
        }
        log.info("aggregateInstallbaseTnFeatures::Exists");
        
        return createWorkorderWrapper;
    }

}
