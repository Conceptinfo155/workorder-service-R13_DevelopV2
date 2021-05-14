package com.comcast.orion.workorder.service;

import static net.logstash.logback.marker.Markers.append;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.comcast.orion.workorder.command.*;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail;
import com.comcast.orion.workorder.domain.onp.insertwo.InsertWORequest;
import com.comcast.orion.workorder.domain.onp.insertwo.Job;
import com.comcast.orion.workorder.domain.onp.insertwo.JobCustomer;
import com.comcast.orion.workorder.domain.onp.insertwo.WorkOrderRequest;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.JobLocation;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import com.comcast.orion.workorder.integration.SQOScheduleWOGateway;
import com.comcast.orion.workorder.utils.WorkOrderServiceUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.config.ErrorPropertyConfig;
import com.comcast.orion.workorder.config.OdsPropertyConfig;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.GetWorkorderRequest;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.WorkOrderDetailsRequest;
import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.Address;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.JobReasonCdList;
import com.comcast.orion.workorder.domain.getfutureworkorder.FutureWorkorderResponse;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.Feature;
import com.comcast.orion.workorder.domain.getworkorder.Resource;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.pointofinterest.request.DeletePointOfRequest;
import com.comcast.orion.workorder.domain.pointofinterest.response.DeletePointOfResponse;
import com.comcast.orion.workorder.domain.product.response.Characteristic;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.domain.product.response.Site;
import com.comcast.orion.workorder.domain.referencedata.Attribute;
import com.comcast.orion.workorder.domain.referencedata.AttributeSet;
import com.comcast.orion.workorder.domain.referencedata.AttributeSubSet;
import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.saveNotes.SaveRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderRequest;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderRequest.RequestType;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.domain.updateappointment.response.UpdateAppointmentResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.GetWorkOrderWFXResponse;
import com.comcast.orion.workorder.integration.WorkorderServiceGateway;
import com.comcast.orion.workorder.integration.createwo.CreateWorkorderGateway;
import com.comcast.orion.workorder.integration.createwo.CreateWorkorderWrapper;
import com.comcast.orion.workorder.utils.Constants;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.CancelWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.RescheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import com.comcast.orion.workorder.utils.mapper.CancelWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.GetWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.PointOfInterestMapper;
import com.comcast.orion.workorder.utils.mapper.SaveJobCommentsMapper;
import com.comcast.orion.workorder.utils.mapper.ScheduleWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.UpdateWorkOrderMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import net.logstash.logback.encoder.org.apache.commons.lang.exception.ExceptionUtils;
import services.web.trackem.ResultBase;
import com.comcast.orion.workorder.domain.poi.POIRequest;
import com.comcast.orion.workorder.domain.poi.POIResponse;

/**
 * WorkorderServiceImpl
 *
 */
/**
 * @author 664739
 *
 */
@Service
public class WorkorderServiceImpl implements WordorderService {

	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WorkorderServiceImpl.class);

	/**
	 * WorkorderAuthCommand
	 */
	@Autowired
	private WorkorderAuthCommand workorderAuthCommand;

	@Autowired
	private PointOfInterestImpl pointOfInterestImpl;

	@Autowired
	private UpdateAppointmentCommand updateCommand;
	/**
	 * LocationRequestCommand
	 */
	@Autowired

	private LocationRequestCommand locationRequestCommand;

	/**
	 * WordorderService
	 */
	@Autowired
	private WordorderService workorderService;

	/**
	 * CreateWorkOrderCommand
	 */
	@Autowired
	private CreateWorkOrderCommand createWorkOrderCommand;

	/**
	 * ProductCommand
	 */
	@Autowired
	private ProductCommand productCommand;
	
	@Value("${officetrack.pointofdelete.username}")
	String officeTrackUserName;
	
	@Value("${officetrack.pointofdelete.password}")
	String officeTrackPassword;
	
	@Value("${vms.tnFeatures.voiceMailValue}")
	String voiceMailValue;

	/**
	 * CreateWorkOrderCommand
	 */
	@Autowired
	private NewCreateWorkOrderCommand newCreateWorkOrderCommand;

	/**
	 * UpdateWorkOrderCommand
	 */
	@Autowired
	private UpdateWorkOrderCommand updateWorkOrderCommand;

	/**
	 * UpdateWorkOrderCommand
	 */
	@Autowired
	private NewUpdateWorkOrderCommand newUpdateWorkOrderCommand;

	@Autowired
	private KieContainer kieContainer;

	@Autowired
	private SiteCommand siteCommand;

	@Autowired
	private BookAppointmentCommand bookAppointmentCommand;

	/**
	 * GetWorkOrderCommand
	 */
	@Autowired
	private GetWorkOrderCommand getWorkOrderCommand;

	/**
	 * GetWFXWorkOrderCommand
	 */
	@Autowired
	private GetWFXWorkOrderCommand getWFXWorkOrderCommand;

	/**
	 * GetWFXWorkOrderCommand
	 */
	@Autowired
	private GetWFXWorkOrderBySiteIdCommand getWFXWorkOrderBySiteIdCommand;
	/**
	 * ObjectMapper
	 */
	@Autowired
	private ObjectMapper objectMapper;

	/**
	 * CreateWorkOrderMapper
	 */
	@Autowired
	private CreateWorkOrderMapper createWorkOrderMapper;

	/**
	 * UpdateWorkOrderMapper
	 */
	@Autowired
	private UpdateWorkOrderMapper updateWorkOrderMapper;

	/**
	 * GetWorkOrderMapper
	 */
	@Autowired
	private GetWorkOrderMapper getWorkOrderMapper;

	@Autowired
	private WorkorderServiceGateway workorderServiceGateway;
	

	private static final String HTTP_CLIENT_ERROR = "Exception Occurred in LocationServiceImpl#createWorkorder --- HttpClientErrorException - Message: {}";

	@Autowired
	private ScheduleWorkOrderMapper scheduleWorkOrderMapper;
	
	@Autowired
	private PointOfInterestMapper pointOfInterestMapper;

	@Autowired
	private CancelAppointmentCommand cancelAppointmentCommand;

	@Autowired
	private CancelWorkOrderCommand cancelWorkOrderCommand;
	
	@Autowired
	private OdsPropertyConfig prop;

	@Autowired
	private SaveNotesCommand saveNotesCommand;
	
	@Autowired
	private GetInstallbaseTnFeaturesCommand getInstallbaseTnFeaturesCommand;
	
	@Autowired
	private ReferenceDataCommand referenceDataCommand;

	@Autowired
	private SaveJobCommentsMapper saveJobCommentsMapper;
	
	@Autowired

	private OTDeletePointOfInterestCommand otDeletePointOfInterestCommand;
	
	@Autowired
	CreateWorkorderGateway createWorkorderGateway;

	@Autowired
	SQOScheduleWOGateway sqoScheduleWOGateway;

	@Autowired
	ONPCommand onpCommand;

	/** The mapper. */
	@Autowired
	ObjectMapper mapper;

	@Autowired
	private CancelWorkOrderMapper cancelWorkOrderMapper;
	private static final String FAILURE = "FAILURE";
	private static final String BVE = "BVE";
	private static final String BV = "BV";
	private static final String SUCCESS = "SUCCESS";
	private static final String CREATEWO = "createWorkorder";
	private static final String RESCHEDULEWORKORDER = "reScheduleAppointment";
	private static final String IS_OTT = "IS_OTT";
	private static final String BUSINESS_VOICE_EDGE = "Business VoiceEdge";
	private static final String YES = "YES";
	private static final String OTT = "OTT";

	@Value("${site.enabled}")
	private boolean scheduleSite;

	@Value("${site.enabled}")
	private boolean enableSite;

	@Value("${saveNotes.jobComments}")
	private String jobComments;

	@Value("${saveNotes.retryLimit}")
	private int retryLimit;

	@Value("${saveNotes.source}")
	private String source;

	@Value("${woconstants.optionId}")
	private String optionId;

	@Value("${woconstants.reservationId}")
	private String reservationId;

	@Value("${woconstants.scheduleDate}")
	private String scheduleDate;

	@Value("${woconstants.timeSlotCd}")
	private String timeSlotCd;

	@Value("${woconstants.jobNum}")
	private String jobNumPrefix;

	@Value("${woconstants.woPrefix}")
	private String workOrderPrefix;

	@Value("${workorder.wfx.isEnabled}")
	private boolean wfxFlag;
	
	@Value("${omw.referencedata.templateName}")
	private String referenceTemplateName;
	
	@Value("${workorder.parallelcall.isEnabled}")
	private boolean isParallelEnabled;
	
	@Value("${tnFeatures.installbase.isEnabled}")
	private boolean isInstallbaseTnFeaturesEnabled;
	
	@Value("${tnFeatures.vms.isEnabled}")
	private boolean isVMSTnFeaturesEnabled;
	
	private String jobtype="";
	
	private String quotapoints="";

	@Autowired
	ErrorPropertyConfig config;
	/**
	 * EXCEPTION_STR
	 */
	private static final String EXCEPTION_STR = "exception";

	/**
	 * US1769241
	 * Set to hold all the jobReasoncodes from Reference data
	 */
//	private Map<String, List<String>> jobReasonCodeMap = new HashMap<>();

//	private Map<String, Map<String,
//			List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>> jobTypeCdReasonCdSolnDtlMap = new LinkedHashMap<>();

	@Value("#{'${orderType.toAllowJobReasonCodeType}'.split(',')}")
	private List<String> toAllowJobReasonCodeType;
	
	@Value("#{'${vms.tnFeatures.serviceType}'.split(',')}")
	private List<String> tnFeatureServiceTypeList;

	@Autowired
	WorkOrderServiceUtil workOrderServiceUtil;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#createWorkorder(com.
	 * comcast.orion.workorder.domain.CreateWORequest, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public CreateWorkorderResponse createWorkorder(CreateWORequest createWORequest, String orderNumber,
			String operationName, String token) throws OrionMiddlewareServiceException {

		CreateWorkorderResponse createWorkorderResponse = null;
		ResponseEntity<WFXCreateWorkOrderRespone> response = null;
		try {

			// call to new endpoint
			LOG.info("wfxFlag : " + wfxFlag);
			if (wfxFlag) {
				//Moved wfx createWO code into spring gateway as part of US1851017
				CreateWorkorderWrapper createWorkorderWrapper=new CreateWorkorderWrapper();
				createWorkorderWrapper.setWorkorderRequest(createWORequest);
				createWorkorderWrapper.setOrderNumber(orderNumber);
				createWorkorderResponse = (CreateWorkorderResponse) createWorkorderGateway.createWfxWorkorder(createWorkorderWrapper);
				//response = newCreateWorkOrderCommand.createWorkorder(wfxCreateRequest, orderNumber);
			} else {
				MDC.put("downstream", "location");
				MDC.put("sourceName", "Orion");
				MDC.put("downstreamUrl", "locationEndpoint");
				ResponseEntity<LocationServiceResponse> responseEntity = getLocationDetails(createWORequest.getCreateWorkorderRequest().getJobLocation().getAddrId());
				LocationServiceResponse locationServiceResponse = responseEntity.getBody();
				LOG.info("Location Response: {}", locationServiceResponse);
				CreateWorkorderRequest workOrderRequest = locationResponseToCreateWorkOrderRequest(locationServiceResponse,
						createWORequest.getCreateWorkorderRequest());

				WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest = createWorkOrderMapper
						.workOrderReqToWFXCreateWorkOrderRequest(workOrderRequest);
				/* OMW v2 REQUEST to convert OMW v1 request to WFX Start */
				if (!enableSite) {
					wfxCreateWorkOrderRequest.setJobEquipmentList(null);
					wfxCreateWorkOrderRequest.setJobProductList(null);
					if (wfxCreateWorkOrderRequest.getJobCustomer() != null) {
						wfxCreateWorkOrderRequest.getJobCustomer().setAccountId(null);
					}
				}
				/* OMW v2 REQUEST to convert OMW v1 request to WFX End */
				String authToken = getAuthToken(operationName);
				response = createWorkOrderCommand.createWorkorder(wfxCreateWorkOrderRequest, orderNumber, authToken);
				if (null != response && null != response.getBody()) {
					createWorkorderResponse = createWorkOrderMapper
							.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(response.getBody());
					InsertWORequest insertWORequest = getOnpInsertWORequest(orderNumber, createWORequest, wfxCreateWorkOrderRequest);
					onpCommand.insertWOEvent(getNotificationPayloadString(insertWORequest));
					LOG.info("CreateWorkorderResponse : {}", createWorkorderResponse);
				}
			}
			
		} catch (HttpClientErrorException | HttpServerErrorException httpClientErrorException) {
			LOG.error(HTTP_CLIENT_ERROR, httpClientErrorException);
			if (httpClientErrorException.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Failed to create a work order with this request: ");
			}
		} catch (ResourceAccessException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
		}
		// Save Job Comments
		saveJobComments(createWORequest, createWorkorderResponse);
		return createWorkorderResponse;

	}

	/**
	 * builds the InsertWORequest
	 * @param workOrderNumber
	 * @param wfxCreateWorkOrderRequest
	 * @throws OrionMiddlewareServiceException
	 */
	private InsertWORequest getOnpInsertWORequest(String workOrderNumber,CreateWORequest createWORequest, WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest){
		InsertWORequest insertWORequest = new InsertWORequest();
		WorkOrderRequest workOrderRequest = new WorkOrderRequest();
		workOrderRequest.setWorkOrderId(workOrderNumber);
		workOrderRequest.setSource("SQO");
		Job job = new Job();
		com.comcast.orion.wfx.domain.workorder.Job wfxCreateWorkOrderRequestJob = wfxCreateWorkOrderRequest.getJob();
		job.setJobNum(wfxCreateWorkOrderRequestJob.getJobNum());
		job.setJobClassCd(wfxCreateWorkOrderRequestJob.getJobClassCd());
		if(!StringUtils.isNotEmpty(wfxCreateWorkOrderRequestJob.getJobUnits()))
			job.setJobUnits(wfxCreateWorkOrderRequestJob.getJobUnits());
		job.setScheduleDate(wfxCreateWorkOrderRequestJob.getScheduleDate());
		job.setJobTypeCd(wfxCreateWorkOrderRequestJob.getJobTypeCd());
		job.setDispatcherStatusCd(wfxCreateWorkOrderRequestJob.getDispatcherStatusCd());
		job.setTimeSlotCd(wfxCreateWorkOrderRequestJob.getTimeSlotCd());
		job.setTroubleCallIndicator(wfxCreateWorkOrderRequestJob.getTroubleCallIndicator());
		JobCustomer jobCustomer = new JobCustomer();
		jobCustomer.setCustomerId(createWORequest.getCreateWorkorderRequest().getJobCustomer().getCustomerId());
		jobCustomer.setSiteId(createWORequest.getCreateWorkorderRequest().getJobCustomer().getSiteId());
		workOrderRequest.setJobCustomer(jobCustomer);
		workOrderRequest.setJob(job);
		insertWORequest.setWorkOrderRequest(workOrderRequest);
		return insertWORequest;
	}

	/**
	 * Mapping request to string payload
	 */
	private String getNotificationPayloadString(Object request)
			throws OrionMiddlewareServiceException {
		String strPayload = "";
		try {
			strPayload = mapper.writeValueAsString(request);
			LOG.info("Onp request payload {}", strPayload);
		} catch (JsonProcessingException e) {
			LOG.error("Error occurred on converting the callback obj to String :: {}", e.getMessage());
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,
					"Error occurred on converting the callback object to String");
		}
		return strPayload;
	}

	/**
	 * @param createWORequest
	 * @param createWorkorderResponse
	 * @throws OrionMiddlewareServiceException
	 */
	private void saveJobComments(CreateWORequest createWORequest, CreateWorkorderResponse createWorkorderResponse)
			throws OrionMiddlewareServiceException {
		int retryCount = 0;
		SaveRequest saveNoteReq = saveJobCommentsMapper.getSaveNotesRequest(createWORequest.getCreateWorkorderRequest(),
				createWorkorderResponse.getWorkOrderNum(), jobComments, source);
		sendToDownstream(saveNoteReq, retryCount);
	}

	/**
	 * @param saveNoteReq
	 * @param retryCount
	 * @throws OrionMiddlewareServiceException
	 */
	private void sendToDownstream(SaveRequest saveNoteReq, int retryCount) throws OrionMiddlewareServiceException {
		try {
			saveNotesCommand.saveJobComments(saveNoteReq);
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append(EXCEPTION_STR, ex.getResponseBodyAsString()),
					"HttpServerErrorException|HttpClientErrorException occured in savenotes");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
					|| ex.getResponseBodyAsString() != null && ex.getResponseBodyAsString().contains("ZuulException")) {
				LOG.error("Unable to process the request.NotesService/Unified Notes is Down.");
				if (retryCount < retryLimit) {
					retryCount++;
					saveNotesCommand.saveJobComments(saveNoteReq);
				} else {
					LOG.error(append(EXCEPTION_STR, ExceptionUtils.getStackTrace(ex)),
							"Exception while saving JOB Comments");
				}
			}
		} catch (RestClientException ex) {
			LOG.error(append(EXCEPTION_STR, ExceptionUtils.getStackTrace(ex)),
					"RestClientException while saving JOB Comments");
		}
	}

	private ResponseEntity<LocationServiceResponse> getLocationDetails(String locationId) throws OrionMiddlewareServiceException {
		ResponseEntity<LocationServiceResponse> responseEntity = null;
		try {
			//US1715624 changes
			//removed token passing as xspinteceptor will be pass the Authorization token
			responseEntity = locationRequestCommand.getLocation(locationId);
		} catch (HttpClientErrorException httpClientErrorException) {
			LOG.error(HTTP_CLIENT_ERROR, httpClientErrorException);
			if (httpClientErrorException.getStatusCode() == HttpStatus.NOT_FOUND) {
				LOG.info("Not able to connect location service");
				throw new OrionMiddlewareServiceException(OrionErrorCode.LOCATION_SERVICE_CONNECTIVITY_ERROR);
			} else if (httpClientErrorException.getStatusCode() == HttpStatus.BAD_REQUEST) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Error occured in Location Service. No Address found with this request.");
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Error occured in Location Service :: " + httpClientErrorException.getMessage());
			}
		}

		return responseEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#createWorkorder(com.
	 * comcast.orion.workorder.domain.CreateWORequest, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	void createWorkorderForReschedule(RescheduleRequest rescheduleRequest, SiteResponse siteResponse,
			String orderNumber,ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		CreateWorkorderResponse createResponse = null;

		try {
			if (rescheduleRequest != null) {
				// US1732141 use reference data
				LOG.info("Inside getReferenceDataResponse Enters ::: ");
				setOrderTypeAndQuotaPoints(referenceDataResponse,rescheduleRequest);
				LOG.info("Inside getReferenceDataResponse End ::: ");
				//GetWorkOrderRule rule = setJobtypeCdAndJobUnits(rescheduleRequest);
				CreateWORequest wfxCreateRequest = scheduleWorkOrderMapper
						.rescheduleWOToWFXCreateWorkOrderRequest(rescheduleRequest, jobtype,quotapoints,siteResponse);

				createResponse = createWorkorder(wfxCreateRequest, orderNumber, CREATEWO, CREATEWO);
				LOG.info("Create workorder for Reschedule response ", createResponse);
			}
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			try {
				ErrorMessage errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);

				if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
					throw new RescheduleWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							orderNumber);
				} else {
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							orderNumber);
				}
			} catch (IOException e) {
				LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
				throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
						ex.getResponseBodyAsString());
			}
		} catch (OrionMiddlewareServiceException e1) {
			throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED, e1.getMessage());
		}

	}



		public GetWorkOrderRule setJobTypeCodeAndQuotaPoints(ScheduleWorkorderRequest scheduleRequest) throws ScheduleWorkOrderException, OrionMiddlewareServiceException{
			
			ReferenceDataResponse referenceDataResponse=null;
			referenceDataResponse = referenceDataCommand.getReferenceData(referenceTemplateName);
			String  orderType  = scheduleRequest.getSolutionDetails().get(0).getOrderType();
			if  (orderType.equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_TC)) {
				return  setJobTypeCodeAndQuotaPointsTC( referenceDataResponse, scheduleRequest);
			} 	
			return setJobTypeCodeAndQuotaPointsNonTC(referenceDataResponse, scheduleRequest);
		
		}
		
		
		public GetWorkOrderRule setJobTypeCodeAndQuotaPointsNonTC(ReferenceDataResponse referenceDataResponse,
	            ScheduleWorkorderRequest scheduleRequest) throws ScheduleWorkOrderException {
			String jobReasonCode = scheduleRequest.getCreateWorkOrder().getJob().getJobReasonCode();
	        String solutionStype = scheduleRequest.getSolutionDetails().get(0).getSolutionType();
	        String transportType = scheduleRequest.getSolutionDetails().get(0).getTransportType();
	        String orderType = scheduleRequest.getSolutionDetails().get(0).getOrderType();
			
			List <GetWorkOrderRule> rules = new ArrayList<GetWorkOrderRule>(); //we are just this for storing the jobtypecode and quotapoints.
			//Added below code change to filter referencedata based on jobResonCode 
			List <AttributeSet> attributeSets = new ArrayList<AttributeSet>();
			if(toAllowJobReasonCodeType.contains(orderType)){
				if(StringUtils.isNotBlank(jobReasonCode)){
					attributeSets=referenceDataResponse.getAttributeSets().stream().
								filter(attrSet->jobReasonCode.equalsIgnoreCase(attrSet.getAttributeSetValue()))
								.collect(Collectors.toList());
				}
			}else{
				attributeSets.addAll(referenceDataResponse.getAttributeSets());
			}
			//End here
	
	        for (AttributeSet attributeSet : attributeSets) {
	            List<AttributeSubSet> attributeSubSets = attributeSet.getAttributeSubSets();
	            for (AttributeSubSet attributeSubSet : attributeSubSets) {
				     
	                if (attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(solutionStype)) {
					Map<String,String> attributesMap = new HashMap<String,String>();
	                    List<Attribute> attributes = attributeSubSet.getAttributes();
	                     for (Attribute attribute : attributes) {
	                    	 if (attribute.getAttributeKey().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE)) {
	                    		 attributesMap.put(WorkOrderConstants.ORDER_TYPE, attribute.getAttributeValue());
	                    	 }else if (attribute.getAttributeKey().equalsIgnoreCase(WorkOrderConstants.JOB_TYPE_CODE)) {
	                    		 attributesMap.put(WorkOrderConstants.JOB_TYPE_CODE, attribute.getAttributeValue());
	                    	 } else if (attribute.getAttributeKey().equalsIgnoreCase(WorkOrderConstants.QUOTA_POINTS)) {
	                    		 attributesMap.put(WorkOrderConstants.QUOTA_POINTS, attribute.getAttributeValue());
	                    	 } else if (attribute.getAttributeKey().equalsIgnoreCase(WorkOrderConstants.TRANSPORT_TYPE)) {
	                    		 attributesMap.put(WorkOrderConstants.TRANSPORT_TYPE, attribute.getAttributeValue());
	                    	 }
							 
	                     
	                    } // end of attributes FOR loop
						
						addRules(attributesMap,orderType,transportType,rules,jobReasonCode);
						
	                } // end IF solutionType check
	            } // end of attributeSubSets FOR loop
	        } // end of attributeSets FOR loop
	        if (rules.isEmpty()) {
	        	if (toAllowJobReasonCodeType.contains(orderType)) {
	        		throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
		                    "Invalid value is passed in the request for the solutionType, orderType, jobReasonCode  combination");
	        	}else{
	            throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
	                    "Invalid value is passed in the request for the solutionType, orderType, transportType combination");
	        	}
	        }
			
			if (rules.size() > 1) {
	            throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
	                    "schedule is not possible with the selected job reason code: "+jobReasonCode);
	        }
	        return rules.get(0);
	    }
		
		
		private void addRules(Map<String,String> map,String ordertype,String transporttype,List<GetWorkOrderRule> rules, String jobReasonCode){
			      GetWorkOrderRule rule = null; 
		         String referenceOrdertype =  map.get(WorkOrderConstants.ORDER_TYPE);
				 String referenceJobTypeCode =  map.get(WorkOrderConstants.JOB_TYPE_CODE);
				 String referenceQuotaPoints =  map.get(WorkOrderConstants.QUOTA_POINTS);
				 if (!StringUtils.equalsIgnoreCase(ordertype, WorkOrderConstants.ORDER_TYPE_SRO)){ 
	
				 String referenceTransporttype =  map.get(WorkOrderConstants.TRANSPORT_TYPE);
				 //Modified below condition to avoid nullpointerexception
				 if  (StringUtils.isNotEmpty(transporttype)) {
					 if (ordertype.equalsIgnoreCase(referenceOrdertype) && StringUtils.isNotEmpty(transporttype)&& 
							 transporttype.equalsIgnoreCase(referenceTransporttype) ){
					     rule = new GetWorkOrderRule();
					    rule.setJobTypeCd(referenceJobTypeCode);
						rule.setJobUnits(referenceQuotaPoints);
						
					}
					 
				 } else if (ordertype.equalsIgnoreCase(referenceOrdertype)) {
					 rule = new GetWorkOrderRule();
					rule.setJobTypeCd(referenceJobTypeCode);
					rule.setJobUnits(referenceQuotaPoints);
				
				}
				 
				 
				 } else {
					 if (ordertype.equalsIgnoreCase(referenceOrdertype)) {
						 rule = new GetWorkOrderRule();
						rule.setJobTypeCd(referenceJobTypeCode);
						rule.setJobUnits(referenceQuotaPoints);
					 }
					 
				 }
				 
				 
				 if (rule != null) {
					 if(StringUtils.isNotEmpty(jobReasonCode)) {
						 rule.setJobReasonCd(jobReasonCode); 
					 }
					 rules.add(rule);
				 }
		}
		
		
		
		public GetWorkOrderRule setJobTypeCodeAndQuotaPointsTC(ReferenceDataResponse referenceDataResponse,ScheduleWorkorderRequest scheduleRequest) throws ScheduleWorkOrderException{
			List <GetWorkOrderRule> rules = new ArrayList<GetWorkOrderRule>(); //we are just this for storing the jobtypecode and quotapoints.
			boolean isOrderTypeMatch=false;
			if (referenceDataResponse != null) {
				
				if (referenceDataResponse.getAttributeSets() != null) {
					for (AttributeSet attributeSet : referenceDataResponse.getAttributeSets()) {
						if(attributeSet.getAttributeSetValue() != null && attributeSet.getAttributeSetValue()
								.equalsIgnoreCase(scheduleRequest.getCreateWorkOrder().getJob().getJobReasonCode())) {
							for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
								if (attributeSubSet.getAttributeSubSetValue() != null) {
									if (attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(
											scheduleRequest.getSolutionDetails().get(0).getSolutionType())) {
										GetWorkOrderRule rule = new GetWorkOrderRule();isOrderTypeMatch=false;
										rule.setJobReasonCd(scheduleRequest.getCreateWorkOrder().getJob().getJobReasonCode());
										for (Attribute attribute : attributeSubSet.getAttributes()) {
											String key = StringUtils.isEmpty(attribute.getAttributeKey()) ? ""
													: attribute.getAttributeKey();
											String value = StringUtils.isEmpty(attribute.getAttributeValue()) ? ""
													: attribute.getAttributeValue();
											if (WorkOrderConstants.QUOTA_POINTS.equalsIgnoreCase(key)) {
												rule.setJobUnits(value);
											}
											if (WorkOrderConstants.JOB_TYPE_CODE.equalsIgnoreCase(key)) {
												rule.setJobTypeCd(value);
											}//Added below condition to fix Regression defect #209015
											if (WorkOrderConstants.ORDER_TYPE.equalsIgnoreCase(key) && 
													WorkOrderConstants.ORDER_TYPE_TC.equalsIgnoreCase(value)) {
												isOrderTypeMatch=true;
											}
											
										/*
										 * LOG.info("get WFX wo - job type code in reference data :: " + value +
										 * " for the key " + attribute.getAttributeKey());
										 */
										}//Added below condition to fix Regression defect #209015
										if(isOrderTypeMatch){
											rules.add(rule);
										}
									}
									
								}
							}
						}

					}
				}
			}
			
			if (rules.size() > 1) {
				throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,"schedule is not possible with the selected job reason code ");
			}
			
			if (rules.isEmpty()) {
				throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
						"Invalid value is passed in the request for the solutionType, orderType, JobReasonCode combination");
			}
			return  rules.get(0); 
		}

	
	//US1732141 -Method to fetch jobtypecd and quotapoints from reference data response
	public void setOrderTypeAndQuotaPoints(ReferenceDataResponse referenceDataResponse,RescheduleRequest rescheduleRequest){
		if (referenceDataResponse != null) {
			boolean found=false;
			if (referenceDataResponse.getAttributeSets() != null) {
				exitattributeset: for (AttributeSet attributeSet : referenceDataResponse.getAttributeSets()) {
					if(attributeSet.getAttributeSetValue() != null && attributeSet.getAttributeSetValue()
							.equalsIgnoreCase(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode())) {
						for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
							if (attributeSubSet.getAttributeSubSetValue() != null) {
								if (CollectionUtils.isNotEmpty(rescheduleRequest.getSolutionDetails())
									&& rescheduleRequest.getSolutionDetails().size() > 0
									&& attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(
										rescheduleRequest.getSolutionDetails().get(0).getSolutionType())) {
									for (Attribute attribute : attributeSubSet.getAttributes()) {
										String key = StringUtils.isEmpty(attribute.getAttributeKey()) ? ""
												: attribute.getAttributeKey();
										String value = StringUtils.isEmpty(attribute.getAttributeValue()) ? ""
												: attribute.getAttributeValue();
										if (WorkOrderConstants.QUOTA_POINTS.equalsIgnoreCase(key)) {
											quotapoints = value;
										}
										if (WorkOrderConstants.JOB_TYPE_CODE.equalsIgnoreCase(key)) {
											jobtype = value;
										}
										LOG.info("get WFX wo - job type code in reference data :: " + value
												+ " for the key " + attribute.getAttributeKey());
										if (WorkOrderConstants.ORDER_TYPE.equalsIgnoreCase(key)) {
											//Added below contion to allow SRO orderType as part of US1819566
											if (WorkOrderConstants.ORDER_TYPE_TC.equalsIgnoreCase(value) || 
													WorkOrderConstants.ORDER_TYPE_SRO.equalsIgnoreCase(value)) {
												found = true;
											} else {
												break;
											}
										}
									}
								}
								if (found == false) {
									continue;
								}
								break exitattributeset;
							}
						}
					}

				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#getWorkOrderDetails(java
	 * .lang.String, java.lang.String)
	 */
	
	//Invoke ODO, ProductService and Installbase Sequential calls
	public WorkorderResponse getWorkOrderDetails(String workOrderNumber, String authToken, String trackingId)
			throws OrionMiddlewareServiceException {
		AMILWorkorderResponse amilResponse = null;
		WorkorderResponse workOrderResponse = null;
		try {
			amilResponse = getWorkOrderCommand.getWorkorder(constructRequestObject(workOrderNumber), authToken);
			if (amilResponse == null) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECH_AMIL_ERR);
			}
			workOrderResponse = getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(amilResponse);
			mapServiceTypeBVE(workOrderResponse);
			//Based on the flag value get tnfeature from insatllbase or vms.
			if(isInstallbaseTnFeaturesEnabled){
				mapInstallbase(workOrderResponse, trackingId);
			}else if(isVMSTnFeaturesEnabled){
				mapVMSTnFeatures(workOrderResponse);
			}
		} catch (HttpClientErrorException | ResourceAccessException e) {
			LOG.error(HTTP_CLIENT_ERROR, e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR);
		} catch (RestClientException restClientException) {
			HttpServerErrorException e = (HttpServerErrorException) restClientException;
			throw new OrionMiddlewareServiceException(getErrorCode(e.getResponseBodyAsString()));

		}

		return workOrderResponse;
	}
	
	

	//US1731126 Call ODO and mapped to get workOrder details
	public WorkorderResponse getBasicWorkOrderDetails(String workOrderNumber, String authToken, String trackingId)
			throws OrionMiddlewareServiceException {
		AMILWorkorderResponse amilResponse = null;
		WorkorderResponse workOrderResponse = null;
		try {
			amilResponse = getWorkOrderCommand.getWorkorder(constructRequestObject(workOrderNumber), authToken);
			if (amilResponse == null) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECH_AMIL_ERR);
			}
			workOrderResponse = getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(amilResponse);
		} catch (HttpClientErrorException | ResourceAccessException e) {
			LOG.error(HTTP_CLIENT_ERROR, e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR);
		} catch (RestClientException restClientException) {
			HttpServerErrorException e = (HttpServerErrorException) restClientException;
			throw new OrionMiddlewareServiceException(getErrorCode(e.getResponseBodyAsString()));

		}

		return workOrderResponse;
	}
	
	@Override
	public WorkorderResponse getWorkOrderDetails(String workOrderNumber, String authToken, String trackingId, String siteId, String customerId, String include)
			throws OrionMiddlewareServiceException {
		
		//Based on the flag value sequential call will happen.
		if (!isParallelEnabled) {
			return getWorkOrderDetails(workOrderNumber, authToken, trackingId);
		}
		//Based on the flag value ODO API will be called.
		if(isParallelEnabled && ((StringUtils.isEmpty(include) || ((StringUtils.equalsIgnoreCase(include, "BasicWorkorderDetails")))))) {
			return getBasicWorkOrderDetails(workOrderNumber, authToken, trackingId);
	   }
		return getEnrichedWorkOrderDetails(workOrderNumber,authToken,trackingId,siteId,customerId,include);
	}	
	

	//US1731126 Parallel calls to ODO and ProductService to get workOrder details
	public WorkorderResponse getEnrichedWorkOrderDetails(String workOrderNumber, String authToken, String trackingId, String siteId, String customerId, String include)
			throws OrionMiddlewareServiceException {

		AMILWorkorderResponse amilResponse = null;
		WorkorderResponse workOrderResponse = null;
		ServiceDetailsResponse serviceDetailsResponse = null;
		Map<String, String> mapOfVariables = new HashMap();
		mapOfVariables.put("workOrderNumber", workOrderNumber);
		mapOfVariables.put("authToken", authToken);
		mapOfVariables.put("trackingId", trackingId);
		mapOfVariables.put("siteId", siteId);
		mapOfVariables.put("customerId", customerId);
		
		Map<WorkorderResponse, Object> response = workorderServiceGateway.getWorkOrderDetails(workOrderNumber,mapOfVariables);
		for (Map.Entry<WorkorderResponse, Object> entry : response.entrySet()) {
	       workOrderResponse = entry.getKey();
	       if (entry.getValue() instanceof ErrorMessage) {
	    	   throw new OrionMiddlewareServiceException(OrionErrorCode.PRODUCT_SERVICE_CONNECTIVITY_ERROR);
	    	   
	       } else{
	    	   serviceDetailsResponse = (ServiceDetailsResponse) entry.getValue();
	       }
	       
	    }
		if (serviceDetailsResponse  != null) {
			mapServiceTypeBVE(workOrderResponse, serviceDetailsResponse);
			mapProductCharactersticToOMWEquipment(workOrderResponse, serviceDetailsResponse);
		}else {
			LOG.info("serviceDetailsResponse is null");
		}
		//Based on the flag value get tnfeature from insatllbase or vms.
		if(isInstallbaseTnFeaturesEnabled){
			mapInstallbase(workOrderResponse, trackingId);
		}else if(isVMSTnFeaturesEnabled){
			mapVMSTnFeatures(workOrderResponse);
		}
		return workOrderResponse;
	}
	
	public void mapInstallbase(WorkorderResponse workOrderResponse, String trackingId) throws OrionMiddlewareServiceException {
		Set<com.comcast.orion.workorder.domain.installbase.tnFeature.Service> serviceList = new HashSet<com.comcast.orion.workorder.domain.installbase.tnFeature.Service>();
		if (null != workOrderResponse.getWorkOrderDetails()) {
				if(CollectionUtils.isNotEmpty(workOrderResponse.getWorkOrderDetails().getEquipment())){
				for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse.getWorkOrderDetails().getEquipment()) {
						if(CollectionUtils.isNotEmpty(equipment.getServices())){
						for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment.getServices()) {
							if (!StringUtils.isBlank(service.getServiceType())) {
								if (service.getServiceType().equals(BV)) {
									com.comcast.orion.workorder.domain.installbase.tnFeature.Service serviceIdObj = new com.comcast.orion.workorder.domain.installbase.tnFeature.Service();
									serviceIdObj.setServiceId(service.getServiceId());
									serviceIdObj.setServiceType(service.getServiceType());
									serviceList.add(serviceIdObj);									
								}
							}

						}
					}
				}
			}
		}
		if(!serviceList.isEmpty()) {
			List<ServiceDetail> serviceDetails = workorderServiceGateway.getInstallbaseTnFeatures(serviceList, trackingId);
			workOrderResponse.getWorkOrderDetails().getServiceDetails().addAll(serviceDetails);			
		}
	}

	/**
	 * @param workOrderResponse
	 *
	 * @throws OrionMiddlewareServiceException
	 */
	public void mapVMSTnFeatures(WorkorderResponse workOrderResponse) throws OrionMiddlewareServiceException {
		Set<String> designIdList = new HashSet<String>();//change to set
		if (null != workOrderResponse.getWorkOrderDetails()) {
				if(CollectionUtils.isNotEmpty(workOrderResponse.getWorkOrderDetails().getEquipment())){
				for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse.getWorkOrderDetails().getEquipment()) {
						if(CollectionUtils.isNotEmpty(equipment.getServices())){
						for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment.getServices()) {
							if (!StringUtils.isBlank(service.getServiceType())) {
								if (tnFeatureServiceTypeList.contains(service.getServiceType())) {
							if(!CollectionUtils.isEmpty(service.getCharacteristics())){
								for(com.comcast.orion.workorder.domain.getworkorder.Characteristic characteristic : service.getCharacteristics()){
									if(!ObjectUtils.isEmpty(characteristic) && !StringUtils.isBlank(characteristic.getCharacteristicName())){
										if(characteristic.getCharacteristicName().equalsIgnoreCase(Constants.VOICE_DESIGN_ID)){
											if(!StringUtils.isBlank(characteristic.getCharacteristicValue())){
												designIdList.add(characteristic.getCharacteristicValue());
											}
										}
									}
								}
							}
						  }
						}
						}
					}
				}
			}
		}
		if(!designIdList.isEmpty()) {
			List<ServiceDetail> serviceDetails = workorderServiceGateway.getVMSTnFeatures(designIdList);
			if(null != serviceDetails && serviceDetails.size() > 0) {
				for(ServiceDetail serviceDetail: serviceDetails) {
					List<Resource> resourceList  = serviceDetail.getResources();
					if(null != resourceList && resourceList.size() > 0) {
						for(Resource resource: resourceList) {
							List<Feature> featuresList  = resource.getFeatures();
							if(null != featuresList && featuresList.size() > 0) {
								for(Feature feature: featuresList) {
									if(null != feature && StringUtils.isNotEmpty(feature.getName())
											&& feature.getName().equalsIgnoreCase(Constants.VOICE_MAIL)) {
										feature.setValue(voiceMailValue);
									}
									
								}
								
							}
						}
					}
				}
			}
			workOrderResponse.getWorkOrderDetails().getServiceDetails().addAll(serviceDetails);			
		}	
	}

	/**
	 * @param workOrderResponse
	 * 
	 * @throws OrionMiddlewareServiceException
	 */

	public void mapServiceTypeBVE(WorkorderResponse workOrderResponse) throws OrionMiddlewareServiceException {
		String siteId = "";
		String customerId = "";
		boolean productResFlag = false;
		ResponseEntity<String> responseEntity = null;
		ServiceDetailsResponse serviceDetailsResponse = null;
		List<Site> sites = new ArrayList<Site>();
		if (null != workOrderResponse.getWorkOrderDetails()) {
			if (!StringUtils.isBlank(workOrderResponse.getWorkOrderDetails().getSiteId())) {
				siteId = workOrderResponse.getWorkOrderDetails().getSiteId();
			}
			if (!StringUtils.isBlank(workOrderResponse.getWorkOrderDetails().getCustomerId())) {
				customerId = workOrderResponse.getWorkOrderDetails().getCustomerId();
			}
			if (null != workOrderResponse.getWorkOrderDetails().getEquipment()
					&& !workOrderResponse.getWorkOrderDetails().getEquipment().isEmpty()) {
				for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse
						.getWorkOrderDetails().getEquipment()) {
					if (null != equipment.getServices() && !equipment.getServices().isEmpty()) {
						for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment
								.getServices()) {
							if (!StringUtils.isBlank(service.getServiceType())) {
								if (service.getServiceType().equals(BVE)) {
									try {
										if (productResFlag == false) {
											MDC.put("downstream", "product");
											MDC.put("sourceName", "Orion");
											MDC.put("downstreamUrl", "productEndpoint");
											responseEntity = productCommand.getServiceDetails(customerId, siteId);
											productResFlag = true;
											if (responseEntity.getStatusCode() == HttpStatus.OK) {
												ObjectMapper objectMapper = new ObjectMapper();
												objectMapper.configure(
														DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
												if (null != responseEntity) {
													if (null != responseEntity.getBody()
															&& !responseEntity.getBody().isEmpty()) {
														serviceDetailsResponse = objectMapper.readValue(
																responseEntity.getBody(), ServiceDetailsResponse.class);
													}
													if (null != serviceDetailsResponse.getServicedetails()) {
														if (null != serviceDetailsResponse.getServicedetails()
																.getCustomer()) {
															if (null != serviceDetailsResponse.getServicedetails()
																	.getCustomer().getSite()
																	|| !serviceDetailsResponse.getServicedetails()
																			.getCustomer().getSite().isEmpty()) {
																sites = serviceDetailsResponse.getServicedetails()
																		.getCustomer().getSite();
															}
														}
													}
												}
											} else {
												throw new OrionMiddlewareServiceException(
														OrionErrorCode.BUSINESS_ERROR_PRODUCT_INVALID_ID);
											}
										}
										mapProductCharacteristicGToWOCharacteristic(service, sites);
									} catch (HttpServerErrorException | HttpClientErrorException
											| UnknownHttpStatusCodeException ex) {
										try {
											if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
													|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
													|| (ex.getResponseBodyAsString() != null && ex
															.getResponseBodyAsString().contains("ZuulException"))) {
												throw new OrionMiddlewareServiceException(
														OrionErrorCode.PRODUCT_SERVICE_CONNECTIVITY_ERROR);
											} else {
												ErrorMessage errorMessage = objectMapper
														.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
												List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage
														.getErrors();
												if (errorList != null && errorList.size() > 0) {
													com.comcast.orion.workorder.domain.Error error = errorList.get(0);
													throw new OrionMiddlewareServiceException(
															OrionErrorCode.BUSINESS_ERROR_PRODUCT, error.getMessage());
												}
											}
										} catch (IOException e) {
											throw new OrionMiddlewareServiceException(
													OrionErrorCode.BUSINESS_ERROR_PRODUCT,
													"Error while processing the response from product service : "
															+ e.getMessage());
										}
									} catch (RestClientException e) {
										throw new OrionMiddlewareServiceException(
												OrionErrorCode.PRODUCT_SERVICE_CONNECTIVITY_ERROR);
									} catch (Exception e) {
										LOG.error(
												"Exception Occurred in WorkorderServiceImpl#getWorkOrderDetails --- Exception - Message: {}",
												e);
										throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
									}
								}else if(WorkOrderConstants.SDWAN.equalsIgnoreCase(service.getServiceType())) {
									Map<String, String> sdwanMap = prop.getServiceType();
									String sdwanDisplayServiceType = null;
									List<com.comcast.orion.workorder.domain.getworkorder.Characteristic> characteristics = service.getCharacteristics();
									if(null != characteristics && characteristics.size() > 0) {
										for(com.comcast.orion.workorder.domain.getworkorder.Characteristic characteristic : characteristics) {
											if(null != characteristic.getCharacteristicName()
													&& characteristic.getCharacteristicName().equalsIgnoreCase(sdwanMap.get(WorkOrderConstants.SDWAN))) {
												sdwanDisplayServiceType = WorkOrderConstants.SDWAN + " " + characteristic.getCharacteristicValue();
											}
											
										}
									}
									if(null != sdwanDisplayServiceType) {
										service.setDisplayServiceType(sdwanDisplayServiceType);
									}
							}
						  }
						}
					}
				}
			}
		}
	}
	
	
	
	/**
	 * @param workOrderResponse
	 * 
	 * @throws OrionMiddlewareServiceException
	 */

	public void mapServiceTypeBVE(WorkorderResponse workOrderResponse,ServiceDetailsResponse serviceDetailsResponse) throws OrionMiddlewareServiceException {
		
	
		List<Site> sites = new ArrayList<Site>();
		if (null != workOrderResponse.getWorkOrderDetails()) {
			
			if (null != workOrderResponse.getWorkOrderDetails().getEquipment()
					&& !workOrderResponse.getWorkOrderDetails().getEquipment().isEmpty()) {
				for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse
						.getWorkOrderDetails().getEquipment()) {
					if (null != equipment.getServices() && !equipment.getServices().isEmpty()) {
						for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment
								.getServices()) {
							if (!StringUtils.isBlank(service.getServiceType())) {
								if (service.getServiceType().equals(BVE)) {
									try {
										
										if (null != serviceDetailsResponse.getServicedetails()) {
											if (null != serviceDetailsResponse.getServicedetails()
													.getCustomer()) {
												if (null != serviceDetailsResponse.getServicedetails()
														.getCustomer().getSite()
														|| !serviceDetailsResponse.getServicedetails()
																.getCustomer().getSite().isEmpty()) {
													sites = serviceDetailsResponse.getServicedetails()
															.getCustomer().getSite();
												}
											}
										}
										
										mapProductCharacteristicGToWOCharacteristic(service, sites);
									}  catch (Exception e) {
										LOG.error(
												"Exception Occurred in WorkorderServiceImpl#getWorkOrderDetails --- Exception - Message: {}",
												e);
										throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);
									}
								}
							}

						}
					}
				}
			}
		}
	}

	private void mapProductCharacteristicGToWOCharacteristic(
			com.comcast.orion.workorder.domain.getworkorder.Service service, List<Site> sites) {
		sites.stream().forEach(site -> {
			if (null != site.getService() && !site.getService().isEmpty()) {
				for (com.comcast.orion.workorder.domain.product.response.Service serviceProduct : site.getService()) {

					if (serviceProduct.getServiceType().equals(BUSINESS_VOICE_EDGE)) {
							if (null != serviceProduct.getCharacteristics()
									&& !serviceProduct.getCharacteristics().isEmpty()) {
								for (Characteristic characteristic : serviceProduct.getCharacteristics()) {
									if (characteristic.getAttributeName().equals(IS_OTT)
											&& characteristic.getAttributeValue().equalsIgnoreCase(YES)) {
										List<com.comcast.orion.workorder.domain.getworkorder.Characteristic> characteristicList = null;
										if (null != service.getCharacteristics()
												&& !service.getCharacteristics().isEmpty()) {
											characteristicList = service.getCharacteristics();
											com.comcast.orion.workorder.domain.getworkorder.Characteristic characteristicGetWO = new com.comcast.orion.workorder.domain.getworkorder.Characteristic();
											characteristicGetWO.setCharacteristicName(characteristic.getAttributeName());
											characteristicGetWO.setCharacteristicValue(characteristic.getAttributeValue());
											characteristicList.add(characteristicGetWO);
											service.setCharacteristics(characteristicList);
											// added for R11-US1858164
											service.setDisplayServiceType(service.getServiceType()+ " "+ OTT);
										}
										
									}
								}
							}
						
					}
				}
			}
		});

	}
	
	//Mapping to get ownedBy attribute from ARM
	public void mapProductCharactersticToOMWEquipment (
			WorkorderResponse workOrderResponse, ServiceDetailsResponse serviceDetailsResponse) {
		List<Site> sites = new ArrayList<Site>();
		if (null != serviceDetailsResponse.getServicedetails()) {
			if (null != serviceDetailsResponse.getServicedetails()
					.getCustomer()) {
				if (null != serviceDetailsResponse.getServicedetails()
						.getCustomer().getSite()
						|| !serviceDetailsResponse.getServicedetails()
								.getCustomer().getSite().isEmpty()) {
					sites = serviceDetailsResponse.getServicedetails()
							.getCustomer().getSite();
				}
			}
		}
	if (null != workOrderResponse.getWorkOrderDetails()) {
			if (null != workOrderResponse.getWorkOrderDetails().getEquipment()
					&& !workOrderResponse.getWorkOrderDetails().getEquipment().isEmpty()) {
				for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse
						.getWorkOrderDetails().getEquipment()) {
					if (null != equipment) {
						sites.stream().forEach(site -> {
						if (null != site.getService() && !site.getService().isEmpty()) {
							for (com.comcast.orion.workorder.domain.product.response.Service serviceProduct : site.getService()) {
								if (null != serviceProduct.getDevice() && !serviceProduct.getDevice().isEmpty()) {
										for (com.comcast.orion.workorder.domain.product.response.Device device : serviceProduct.getDevice()) {	
										if (device.getDeviceName().equalsIgnoreCase(equipment.getArmObjectName())) {
											if (null != device.getCharacteristics() && !device.getCharacteristics().isEmpty()) {
											  for (Characteristic characteristic : device.getCharacteristics()) {
												if (characteristic.getAttributeName().equalsIgnoreCase("OWNEDBY") && characteristic.getAttributeValue().equalsIgnoreCase("Customer") ) {
												equipment.setOwnedBy(characteristic.getAttributeValue());
							
											  }
														
											  }
													       
											  }
											
											 }
										  }
									  }
									
								}
							}
						 });
						
					}
				}
			}
		}

	}

	/**
	 * @param workOrderNumber
	 * @return
	 */
	private GetWorkorderRequest constructRequestObject(String workOrderNumber) {
		GetWorkorderRequest workOrderRequest = new GetWorkorderRequest();
		WorkOrderDetailsRequest workOrderDetailsRequest = new WorkOrderDetailsRequest();
		workOrderDetailsRequest.setWorkOrderId(workOrderNumber);
		workOrderRequest.setWorkOrderDetailsRequest(workOrderDetailsRequest);
		return workOrderRequest;

	}

	OrionErrorCode getErrorCode(String responseJSON) throws OrionMiddlewareServiceException {

		JSONParser parser = new JSONParser();
		JSONObject json;
		OrionErrorCode code = OrionErrorCode.GETWO_CONNECTIVITY_ERROR;
		try {
			json = (JSONObject) parser.parse(responseJSON);
			JSONObject objectRoot = (JSONObject) json.get("ROOT");
			Map errorObject = (JSONObject) objectRoot.get("Error");
			Iterator<Map.Entry> itr1 = errorObject.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				LOG.info(pair.getKey() + " : " + pair.getValue());
				if (pair.getKey().equals("Number")) {
					if (pair.getValue().equals("BUS_AMIL_ERR")) {
						code = OrionErrorCode.BUS_AMIL_ERR;
					} else {
						code = OrionErrorCode.TECH_AMIL_ERR;
					}
				}

			}

		} catch (Exception e) {
			LOG.error("Exception Occurred in LocationServiceImpl#getWorkOrderDetails --- Exception - Message: {}", e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.GETWO_CONNECTIVITY_ERROR);
		}
		return code;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#updateWorkorder(com.
	 * comcast.orion.workorder.domain.UpdateWORequest, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public UpdateWorkorderResponse updateWorkorder(UpdateWORequest updateWORequest, String orderNumber,
			String operationName, String token) throws OrionMiddlewareServiceException {
		UpdateWorkorderResponse updateWorkorderResponse = null;
		ResponseEntity<WFXUpdateWorkOrderResponse> response = null;
		try {

			ResponseEntity<LocationServiceResponse> responseEntity = null;
			try {
				MDC.put("downstream", "location");
				MDC.put("sourceName", "Orion");
				MDC.put("downstreamUrl", "locationEndpoint");
				//US1715624 changes
				responseEntity = locationRequestCommand.getLocation(updateWORequest.getUpdateWorkorderRequest().getJobLocation().getAddrId());
			} catch (HttpClientErrorException httpClientErrorException) {
				LOG.error(
						"Exception Occurred in LocationServiceImpl#updateWorkorder --- HttpClientErrorException - Message: {}",
						httpClientErrorException);
				if (httpClientErrorException.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
					LOG.info("Not able to connect location service");
					throw new OrionMiddlewareServiceException(OrionErrorCode.LOCATION_SERVICE_CONNECTIVITY_ERROR);
				} else if (httpClientErrorException.getRawStatusCode() == HttpStatus.BAD_REQUEST.value()) {
					throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
							"Error occured in Location Service. No Address found with this request.");
				} else {
					throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
							"Error occured in Location Service :: " + httpClientErrorException.getMessage());
				}
			}
			catch(UnknownHttpStatusCodeException ex){
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						ex.getResponseBodyAsString());
			}

			LocationServiceResponse locationResponse = responseEntity.getBody();
			LOG.info("Location Response : {}", locationResponse);

			UpdateWorkorderRequest workOrderRequest = locationResponseToUpdateWorkOrderRequest(locationResponse,
					updateWORequest.getUpdateWorkorderRequest());

			WFXUpdateWorkOrderRequest wfxUpdateWorkOrderRequest = updateWorkOrderMapper
					.workOrderReqToWFXUpdateWorkOrderRequest(workOrderRequest);

//			com.comcast.orion.workorder.domain.nWFX.update.WFXUpdateWorkOrderRequest wfxUpdateRequest = updateWorkOrderMapper
//					.workOrderReqToWFXUpdateRequest(workOrderRequest);
			com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest wfxUpdateRequest = updateWorkOrderMapper
					.workOrderReqToWFXUpdateRequest(workOrderRequest);

			// call to new endpoint
			if (wfxFlag) {
				//US1632662 - changes added to remove joblocation object for new WFX endpoint 
				 wfxUpdateRequest.setJobLocation(null);
				 try{
				response = newUpdateWorkOrderCommand.updateWorkorder(wfxUpdateRequest, orderNumber);
				}
				 catch (HttpClientErrorException | HttpServerErrorException ex) {
						if (ex.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
							LOG.info("Token got expired. So creating a token again ");
							newUpdateWorkOrderCommand.updateWorkorder(wfxUpdateRequest, orderNumber);
						}else{
							 throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
										"Failed to update the work order with this request: "
												+ ex.getResponseBodyAsString());
						}
					}
			} 
			else {
				String authToken = getAuthToken(operationName);
				response = updateWorkOrderCommand.updateWorkorder(wfxUpdateWorkOrderRequest, orderNumber, authToken);
			}

		} 
		catch (HttpClientErrorException httpClientErrorException) {
			LOG.error(
					"Exception Occurred in LocationServiceImpl#updateWorkorder --- HttpClientErrorException - Message: {}",
					httpClientErrorException);
			if (httpClientErrorException.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.CONNECTIVITY_ERROR);
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Failed to update the work order with this request: "
								+ httpClientErrorException.getResponseBodyAsString());
			}
		}
		if (null != response && null != response.getBody()) {
			updateWorkorderResponse = updateWorkOrderMapper
					.wfxUpdateWorkOrderResponseToWFXUpdateWorkOrderResponse(response.getBody());

			LOG.info("updateWorkorderResponse : {}", updateWorkorderResponse);

		}
		return updateWorkorderResponse;

	}

	/**
	 * @param operationName
	 * @return AuthToken
	 * @throws OrionMiddlewareServiceException
	 */
	public String getAuthToken(String operationName) throws OrionMiddlewareServiceException {

		Map<String, String> authMap = null;
		ResponseEntity<String> responseEntity = null;
		try {
			responseEntity = workorderAuthCommand.workorderLogin(operationName);
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(ex.getResponseBodyAsString(), ex);
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
					"Unable to get the websec token");

		}
		if (null != responseEntity && null != responseEntity.getBody()) {
			try {
				authMap = objectMapper.readValue(responseEntity.getBody(), new TypeReference<Map<String, String>>() {
				});
				LOG.info("workorder Auth token {}", responseEntity.getBody());
			} catch (IOException ex) {
				LOG.info("getAuthToken.HttpServerErrorException : {}", ex);
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, ex.getMessage());
			}
			if (null != authMap && null != authMap.get("token")) {
				return authMap.get("token");
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
						"Unable to get the websec token");
			}
		} else {
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX,
					"Unable to get the websec token");
		}

	}

	/**
	 * Populate the exception
	 * 
	 * @param exception
	 * @throws OrionMiddlewareServiceException
	 */
	public void populateException(String exception) throws OrionMiddlewareServiceException {
		LOG.error("Exception occurs : {}", exception);
		try {
			ErrorMessage errormsg = null;
			errormsg = objectMapper.readValue(exception, ErrorMessage.class);
			String msg = errormsg.getErrors().get(0).getCode() + "-" + errormsg.getErrors().get(0).getMessage();
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX, msg);
		} catch (IOException e) {
			LOG.error("Exception Occurred in LocationServiceImpl#LocationServiceImpl --- IOException - Message: {}", e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, exception);
		}
	}

	/**
	 * @param locationServiceResponse
	 * @param workOrderRequest
	 * @return CreateWorkorderRequest
	 */
	public CreateWorkorderRequest locationResponseToCreateWorkOrderRequest(LocationServiceResponse locationServiceResponse,
			CreateWorkorderRequest workOrderRequest) {

		CreateWorkorderRequest destination = createWorkOrderMapper.locationResponseToWorkOrderRequest(locationServiceResponse);

		if (workOrderRequest.getJobLocation().getAddress() != null) {

			Address woRequestAddress = workOrderRequest.getJobLocation().getAddress();
			Address locationAddress = destination.getJobLocation().getAddress();

			String addrLine1 = StringUtils.isNotBlank(woRequestAddress.getAddrLine1()) ? woRequestAddress.getAddrLine1()
					: locationAddress.getAddrLine1();
			String addrLine2 = StringUtils.isNotBlank(woRequestAddress.getAddrLine2()) ? woRequestAddress.getAddrLine2()
					: locationAddress.getAddrLine2();
			String city = StringUtils.isNotBlank(woRequestAddress.getCity()) ? woRequestAddress.getCity()
					: locationAddress.getCity();
			String state = StringUtils.isNotBlank(woRequestAddress.getState()) ? woRequestAddress.getState()
					: locationAddress.getState();
			String zipCode = StringUtils.isNotBlank(woRequestAddress.getZipCode()) ? woRequestAddress.getZipCode()
					: locationAddress.getZipCode();

			workOrderRequest.getJobLocation().getAddress().setAddrLine1(addrLine1);
			workOrderRequest.getJobLocation().getAddress().setAddrLine2(addrLine2);
			workOrderRequest.getJobLocation().getAddress().setCity(city);
			workOrderRequest.getJobLocation().getAddress().setState(state);
			workOrderRequest.getJobLocation().getAddress().setZipCode(zipCode);
		} else {
			if(destination.getJobLocation()!=null)
			workOrderRequest.getJobLocation().setAddress(destination.getJobLocation().getAddress());
		}
		
		if(workOrderRequest.getJobLocation() != null && destination.getJobLocation() != null) {
			workOrderRequest.getJobLocation().setNode(destination.getJobLocation().getNode());
			workOrderRequest.getJobLocation().setDropType(destination.getJobLocation().getDropType());
			workOrderRequest.getJobLocation().setDropTag1(destination.getJobLocation().getDropTag1());
			workOrderRequest.getJobLocation().setDropTag2(destination.getJobLocation().getDropTag2());
			workOrderRequest.getJobLocation().setDropTag3(destination.getJobLocation().getDropTag3());
			workOrderRequest.getJobLocation().setBridgerAddress(destination.getJobLocation().getBridgerAddress());
			workOrderRequest.getJobLocation().setManagementArea(destination.getJobLocation().getManagementArea());
			workOrderRequest.getJobLocation().setHookupType(destination.getJobLocation().getHookupType());
		}
		
		workOrderRequest.setBusinessUnit(destination.getBusinessUnit());
		workOrderRequest.setRouteCriteria(destination.getRouteCriteria());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		workOrderRequest.setCreateDateTime(sdt);
		return workOrderRequest;
		
	}

	/**
	 * @param locationResponse
	 * @param workOrderRequest
	 * @return UpdateWorkorderRequest
	 */
	private UpdateWorkorderRequest locationResponseToUpdateWorkOrderRequest(LocationServiceResponse locationResponse,
			UpdateWorkorderRequest workOrderRequest) {

		UpdateWorkorderRequest destination = updateWorkOrderMapper.locationResponseToWorkOrderRequest(locationResponse);

		if (workOrderRequest.getJobLocation().getAddress() != null) {

			com.comcast.orion.workorder.domain.updatewo.Address woRequestAddress = workOrderRequest.getJobLocation()
					.getAddress();
			com.comcast.orion.workorder.domain.updatewo.Address locationAddress = destination.getJobLocation()
					.getAddress();

			String addrLine1 = StringUtils.isNotBlank(woRequestAddress.getAddrLine1()) ? woRequestAddress.getAddrLine1()
					: locationAddress.getAddrLine1();
			String addrLine2 = StringUtils.isNotBlank(woRequestAddress.getAddrLine2()) ? woRequestAddress.getAddrLine2()
					: locationAddress.getAddrLine2();
			String city = StringUtils.isNotBlank(woRequestAddress.getCity()) ? woRequestAddress.getCity()
					: locationAddress.getCity();
			String state = StringUtils.isNotBlank(woRequestAddress.getState()) ? woRequestAddress.getState()
					: locationAddress.getState();
			String zipCode = StringUtils.isNotBlank(woRequestAddress.getZipCode()) ? woRequestAddress.getZipCode()
					: locationAddress.getZipCode();

			workOrderRequest.getJobLocation().getAddress().setAddrLine1(addrLine1);
			workOrderRequest.getJobLocation().getAddress().setAddrLine2(addrLine2);
			workOrderRequest.getJobLocation().getAddress().setCity(city);
			workOrderRequest.getJobLocation().getAddress().setState(state);
			workOrderRequest.getJobLocation().getAddress().setZipCode(zipCode);

		} else {
			if(destination.getJobLocation()!=null){
			workOrderRequest.getJobLocation().setAddress(destination.getJobLocation().getAddress());
			}
		}

		workOrderRequest.setBusinessUnit(destination.getBusinessUnit());
		workOrderRequest.setRouteCriteria(destination.getRouteCriteria());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		workOrderRequest.setCreateDateTime(sdt);

		return workOrderRequest;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#scheduleWorkorder(com.
	 * comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorder,
	 * java.lang.String)
	 */
	@Override
	public ScheduleWorkorderResponse scheduleWorkorder(ScheduleWorkorder request)
			throws ScheduleWorkOrderException, OrionMiddlewareServiceException {
		ScheduleWorkorderResponse scheduleWorkorderResponse = null;
		String operationName = WorkOrderConstants.SCHEDULE_WORK_ORDER.getValue();
		String workOrderNumber = null;
		if (request.getScheduleWorkorderRequest().getWorkOrderNumber() != null) {
			workOrderNumber = request.getScheduleWorkorderRequest().getWorkOrderNumber();
		} else {
			if (RequestType.RETRY_WORKORDER.equals(request.getScheduleWorkorderRequest().getRequestType())) {
				throw new ScheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
						"workOrderNumber should not be null.");
			} else {
				workOrderNumber = generateWorkOrderNumber(request);
			}
		}
		if (request.getScheduleWorkorderRequest().getNoScheduleIndicator() != null
				&& request.getScheduleWorkorderRequest().getNoScheduleIndicator()) {
			scheduleWorkOrderMapper.mapOptionalParametersForSchedule(request.getScheduleWorkorderRequest(), optionId,
					reservationId, scheduleDate, timeSlotCd);
		}
		GetWorkOrderRule rule = setJobTypeCodeAndQuotaPoints(request.getScheduleWorkorderRequest());
		com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail = getSiteResponse(request, workOrderNumber, operationName);
		if (!RequestType.RETRY_WORKORDER.equals(request.getScheduleWorkorderRequest().getRequestType())
				&& (request.getScheduleWorkorderRequest().getNoScheduleIndicator() == null
						|| !request.getScheduleWorkorderRequest().getNoScheduleIndicator())) {
			bookAppointment(request, workOrderNumber);
		}
		scheduleWorkorderResponse = scheduleUpdateWorkOrder(request, scheduleWorkorderResponse, workOrderNumber,
				siteDetail, rule);
		return scheduleWorkorderResponse;

	}

	@Override
	public SQOScheduleWoResponse sqoScheduleWO(SQOScheduleWO sqoScheduleWO) throws OrionMiddlewareServiceException, ScheduleWorkOrderException {
		if (StringUtils.isEmpty(sqoScheduleWO.getScheduleWorkorderRequest().getWorkOrderNumber()) ){
			if (com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest.RequestType.RETRY_WORKORDER.equals(sqoScheduleWO.getScheduleWorkorderRequest().getRequestType())) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
						"workOrderNumber should not be null.");
			} else {
				sqoScheduleWO.getScheduleWorkorderRequest().setWorkOrderNumber(generateWorkOrderNumber(sqoScheduleWO));
			}
		}

		if (!RequestType.RETRY_WORKORDER.equals(sqoScheduleWO.getScheduleWorkorderRequest().getRequestType())
				&& (sqoScheduleWO.getScheduleWorkorderRequest().getNoScheduleIndicator() == null
				|| !sqoScheduleWO.getScheduleWorkorderRequest().getNoScheduleIndicator())) {
			bookAppointment(sqoScheduleWO.getScheduleWorkorderRequest());
		}
		return sqoScheduleWOGateway.scheduleWO(sqoScheduleWO);
	}

	/**
	 * @param request
	 */
	private String generateWorkOrderNumber(ScheduleWorkorder request) {
		String newWorkOrder = "";
		Random random = new Random();
		if (request.getScheduleWorkorderRequest().getNoCrTicketIndicator() != null
				&& request.getScheduleWorkorderRequest().getNoCrTicketIndicator()) {
			String randomNumber = String.join("", Integer.toString(random.nextInt(0X100000)),
					String.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US))));
			newWorkOrder = String.join("", workOrderPrefix, randomNumber);
		} else if (request.getScheduleWorkorderRequest().getTicketNumber() != null) {
			newWorkOrder = request.getScheduleWorkorderRequest().getTicketNumber()
					.concat(Integer.toHexString(random.nextInt(0X1000000)).toUpperCase());
		}
		return newWorkOrder;
	}

	/**
	 * @param request
	 */
	private String generateWorkOrderNumber(com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO request) {
		String newWorkOrder = "";
		Random random = new Random();
		if (request.getScheduleWorkorderRequest().getNoCrTicketIndicator() != null
				&& request.getScheduleWorkorderRequest().getNoCrTicketIndicator()) {
			String randomNumber = String.join("", Integer.toString(random.nextInt(0X100000)),
					LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US)));
			newWorkOrder = String.join("", workOrderPrefix, randomNumber);
		} else if (request.getScheduleWorkorderRequest().getTicketNumber() != null) {
			newWorkOrder = request.getScheduleWorkorderRequest().getTicketNumber()
					.concat(Integer.toHexString(random.nextInt(0X1000000)).toUpperCase());
		}
		return newWorkOrder;
	}

	private com.comcast.orion.workorder.domain.sitev2.SiteResponse getSiteResponse(ScheduleWorkorder request, String workOrderNumber, String operationName)
			throws ScheduleWorkOrderException {
		com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail = null;
		try {

			siteDetail = siteCommand.getSiteDetailV2(
					request.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getSiteId(),
					operationName);
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new ScheduleWorkOrderException(OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage());
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							ex.getResponseBodyAsString());
				}

			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new ScheduleWorkOrderException(OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR);
		}
		return siteDetail;
	}

	private void bookAppointment(ScheduleWorkorder request, String workOrderNumber) throws ScheduleWorkOrderException {
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse;
		BookApmtRequest bookApmtRequest = scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(request,
				workOrderNumber);
		try {

			bookAmptresponse = bookAppointmentCommand.bookAppointment(bookApmtRequest);
			LOG.info("Book Appointment Status code :" + bookAmptresponse.getStatusCode());
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new ScheduleWorkOrderException(OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage());
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							ex.getResponseBodyAsString());
				}
			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new ScheduleWorkOrderException(OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR);
		}
	}

	/**
	 * @param scheduleWorkorderRequest
	 * @throws ScheduleWorkOrderException
	 */
	private void bookAppointment(com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest scheduleWorkorderRequest) throws ScheduleWorkOrderException {
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse;
		BookApmtRequest bookApmtRequest = scheduleWorkOrderMapper.scheduleSQOWORequestToBookAppointmentRequest(scheduleWorkorderRequest);
		try {
			bookAmptresponse = bookAppointmentCommand.bookAppointment(bookApmtRequest);
			LOG.info("Book Appointment Status code :" + bookAmptresponse.getStatusCode());
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				ErrorMessage errormessage;
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					if(!errormessage.getErrors().isEmpty())
						throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage());
					else{
						throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
								OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
					}
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR.getErrorDescription());
				}
			} else {
				ErrorMessage errormessage;
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage());
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_WORKORDER_NOT_SCHEDULED,
							ex.getResponseBodyAsString());
				}
			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new ScheduleWorkOrderException(OrionErrorCode.SCHEDULE_SERVICE_CONNECTIVITY_ERROR);
		}
	}

	private ScheduleWorkorderResponse scheduleUpdateWorkOrder(ScheduleWorkorder request,
			ScheduleWorkorderResponse scheduleWorkorderResponse, String workOrderNumber,
		  	com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail, GetWorkOrderRule rule)
			throws ScheduleWorkOrderException, OrionMiddlewareServiceException {
		ResponseEntity<WFXCreateWorkOrderRespone> response;
		try {

			ScheduleWorkorderRequest scheduleRequest = siteResponseToCreateWorkOrderRequest(siteDetail,
					request.getScheduleWorkorderRequest());

			// call to new endpoint
			if (wfxFlag) {
				if(scheduleRequest.getCreateWorkOrder() != null && scheduleRequest.getCreateWorkOrder().getJobCustomer() != null) {
					LOG.info("Site Signage Name in ScheduleWorkorderRequest payload : {}", scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteSignageName());
					if(scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteSignageName() == null) {
						LOG.info("Site Signage Name in SiteResponse payload : {}", siteDetail.getSiteSignageName());
						LOG.info("Site Name in SiteResponse payload : {}", siteDetail.getSiteName());
						String siteSignageSiteName = StringUtils.isEmpty(siteDetail.getSiteSignageName())
								? siteDetail.getSiteName() : siteDetail.getSiteSignageName();
						scheduleRequest.getCreateWorkOrder().getJobCustomer().setSiteSignageName(siteSignageSiteName);
					}
				}
				com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest wfxCreateRequest = scheduleWorkOrderMapper
						.schWorkOrderReqToWFXCreateRequest(scheduleRequest, siteDetail, rule, scheduleSite, jobNumPrefix);
				String siteSignageName = null;
				if(scheduleRequest.getCreateWorkOrder() != null && scheduleRequest.getCreateWorkOrder().getJobCustomer() != null) {
					siteSignageName = scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteSignageName();
				}
				workOrderServiceUtil.populateWFXFirstNameLastName(siteSignageName, wfxCreateRequest);
				String firstName = request.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getFirstName();
				String lastName = request.getScheduleWorkorderRequest().getCreateWorkOrder().getJobCustomer().getLastName();
				String jobComment = request.getScheduleWorkorderRequest().getCreateWorkOrder().getJob().getJobComment();
				wfxCreateRequest.getJob().setJobComment(workOrderServiceUtil.formatJobComment(firstName, lastName, jobComment));
				response = newCreateWorkOrderCommand.createWorkorder(wfxCreateRequest, workOrderNumber);
			} else {
				String authToken = authToken();
				WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest = scheduleWorkOrderMapper
						.schWorkOrderReqToWFXCreateWorkOrderRequest(scheduleRequest, siteDetail, rule, scheduleSite,
								jobNumPrefix);
				response = createWorkOrderCommand.createWorkorder(wfxCreateWorkOrderRequest, workOrderNumber,
						authToken);
			}
			// response = createWorkOrderCommand.createWorkorder(wfxCreateWorkOrderRequest,
			// workOrderNumber, authToken);

			if (null != response && null != response.getBody()) {
				scheduleWorkorderResponse = scheduleWorkOrderMapper
						.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(response.getBody());
				LOG.info("ScheduleWorkorderResponse : {}", scheduleWorkorderResponse);
			}

		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new ScheduleWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR);
			} else if (ex.getStatusCode() == HttpStatus.BAD_REQUEST) {
				JsonObject obj = new JsonParser().parse(ex.getResponseBodyAsString()).getAsJsonObject();
				//Added below changes to fix the reg defect#
				String errorMessage= "";
				if(obj.get("Response") !=null)
					errorMessage=obj.get("Response").getAsString();
				if(obj.get("message") !=null)
					errorMessage=obj.get("message").getAsString();
				throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
						errorMessage, workOrderNumber);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							workOrderNumber);
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");

					throw new ScheduleWorkOrderException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_SCHEDULED,
							ex.getResponseBodyAsString(), workOrderNumber);
				}
			}
		} catch (RestClientException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "RestClientException");
			throw new ScheduleWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR);
		}
		return scheduleWorkorderResponse;
	}

	private String authToken() {
		String authToken = null;

		try {
			authToken = getAuthToken("scheduleworkorder");
		} catch (OrionMiddlewareServiceException e) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(e)), "Unable to get the websec token");
			LOG.info("Unable to get the websec token");
		}
		return authToken;
	}

	/**
	 * @param request
	 * @return
	 */
	GetWorkOrderRule setJobtypeCdAndJobUnits(RescheduleRequest request) {
		GetWorkOrderRule ruleValue = null;
		SortedMap<Integer, GetWorkOrderRule> sm = new TreeMap<Integer, GetWorkOrderRule>();
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		if (request != null) {
			for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solutionDetail : request
					.getSolutionDetails()) {
				GetWorkOrderRule rule = new GetWorkOrderRule();
				rule.setSolutionType(solutionDetail.getSolutionType());
				rule.setOrderType(solutionDetail.getOrderType());
				kieSession.insert(rule);
				kieSession.fireAllRules();
				if (rule.getWeightAge() != 0) {
					sm.put(rule.getWeightAge(), rule);
				}
			}
		}
		kieSession.dispose();
		if (MapUtils.isNotEmpty(sm)) {
			ruleValue = sm.entrySet().stream().findFirst().get().getValue();
			LOG.info(ruleValue.getJobUnits() + " - " + ruleValue.getJobTypeCd());

		}
		return ruleValue;
	}

	

	ScheduleWorkorderRequest siteResponseToCreateWorkOrderRequest(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail,
			ScheduleWorkorderRequest scheduleWorkorderRequest) {

		ScheduleWorkorder scheduleWORequest = scheduleWorkOrderMapper.siteResponseToWorkOrderRequest(siteDetail);
		JobLocation jobLocation=new JobLocation();
		com.comcast.orion.workorder.domain.scheduleWorkOrder.Address address=new com.comcast.orion.workorder.domain.scheduleWorkOrder.Address();
		if (scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation() != null) {

			com.comcast.orion.workorder.domain.scheduleWorkOrder.Address woRequestAddress = scheduleWorkorderRequest
					.getCreateWorkOrder().getJobLocation().getAddress();
			com.comcast.orion.workorder.domain.scheduleWorkOrder.Address siteAddress = scheduleWORequest
					.getScheduleWorkorderRequest().getCreateWorkOrder().getJobLocation().getAddress();

			String addrLine1 = (woRequestAddress!=null && StringUtils.isNotBlank(woRequestAddress.getAddrLine1())) ? woRequestAddress.getAddrLine1()
					: siteAddress.getAddrLine1();
			String addrLine2 = (woRequestAddress!=null && StringUtils.isNotBlank(woRequestAddress.getAddrLine2())) ? woRequestAddress.getAddrLine2()
					: siteAddress.getAddrLine2();
			String city = (woRequestAddress!=null && StringUtils.isNotBlank(woRequestAddress.getCity())) ? woRequestAddress.getCity()
					: siteAddress.getCity();
			String state = (woRequestAddress!=null && StringUtils.isNotBlank(woRequestAddress.getState())) ? woRequestAddress.getState()
					: siteAddress.getState();
			String zipCode = (woRequestAddress!=null && StringUtils.isNotBlank(woRequestAddress.getZipCode())) ? woRequestAddress.getZipCode()
					: siteAddress.getZipCode();
			if(scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress() ==null){
				scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().setAddress(address);
			}
			scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress().setAddrLine1(addrLine1);
			scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress().setAddrLine2(addrLine2);
			scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress().setCity(city);
			scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress().setState(state);
			scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().getAddress().setZipCode(zipCode);

		} else {
				jobLocation.setAddress(scheduleWORequest.getScheduleWorkorderRequest().getCreateWorkOrder().getJobLocation().getAddress());
				scheduleWorkorderRequest.getCreateWorkOrder().setJobLocation(jobLocation);
			//scheduleWorkorderRequest.getCreateWorkOrder().getJobLocation().setAddress(
			//		scheduleWORequest.getScheduleWorkorderRequest().getCreateWorkOrder().getJobLocation().getAddress());
		}

		return scheduleWorkorderRequest;
	}

	/**
	 * 
	 * @param workOrderNumber method getWFXWorkOrder
	 * @return GetWorkorderResponse
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.comcast.orion.workorder.service.WordorderService#getWFXWorkOrder(java.
	 * lang.String)
	 */
	@Override
	public GetWorkorderOMWResponse getWFXWorkOrder(String workOrderNumber) throws OrionMiddlewareServiceException {
		LOG.info("Inside getWFXWorkOrder() for orderNumber: " + workOrderNumber);
		GetWorkorderOMWResponse getWorkOrderResponse = null;
		try {
			String authToken = getAuthToken(WorkOrderConstants.GETWORKORDER);
			ResponseEntity<GetWorkOrderWFXResponse> workOrderWFXResponse = getWFXWorkOrderCommand
					.getWFXWorkorder(workOrderNumber, authToken);
			if (workOrderWFXResponse.getBody().getJob() == null) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFAINVALIDWO);
			}

			/*** US1761689 - START **/
			ReferenceDataResponse referenceDataResponse=null;
			referenceDataResponse = referenceDataCommand.getReferenceData(referenceTemplateName);
			getWorkOrderResponse = getWorkOrderMapper.mapWFXResponseToWorkOrderResponse(workOrderWFXResponse.getBody() ,
					referenceDataResponse);
			/*** US1761689 - END **/
			List<Object> jobReasonCodeList = workOrderWFXResponse.getBody().getJob().getJobReasonCdList();
			String jobReasonCode = (CollectionUtils.isNotEmpty(jobReasonCodeList) && jobReasonCodeList.size() > 0) ?
					((Map<String, String>) jobReasonCodeList.get(0)).get("JobReasonCd") : "" ;
			LOG.info("GetWorkorder - Job Reason Code from WFX response :: "+jobReasonCode);
			getWorkOrderResponse.getWorkOrder().getJob().setJobReasonCode(jobReasonCode);
			Map<String, Map<String, List<SolutionDetail>>> jobTypeCdReasonCdSolnDtlMap = getReferenceDataResponseForGetWO();
			getWorkOrderResponse.getWorkOrder().setSolutionDetails(getWorkOrderMapper.mapSolutionDetailsForGetWO(jobTypeCdReasonCdSolnDtlMap, getWorkOrderResponse));
			isJobReasonCodeMatchForGetWO(jobTypeCdReasonCdSolnDtlMap, getWorkOrderResponse);
		} catch (HttpClientErrorException | HttpServerErrorException httpError) {
			if (httpError.getStatusCode() == HttpStatus.BAD_REQUEST) {
				JsonObject obj = new JsonParser().parse(httpError.getResponseBodyAsString()).getAsJsonObject();
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFA,
						obj.get("errorCode") + " - " + obj.get("errorMessage").getAsString());
			} else if (httpError.getStatusCode() == HttpStatus.NOT_FOUND) {
				//US1761689
				throw new OrionMiddlewareServiceException(OrionErrorCode.GETWFXWO_NO_RECORD_FOUND, httpError.getMessage());
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, httpError.getMessage());
			}
		} catch (ResourceAccessException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e.getMessage());
		}
		return getWorkOrderResponse;
	}

	GetWorkOrderRule setWFXJobtypeCdAndJobUnits(GetWorkOrderWFXResponse getWorkOrderWFXResponse) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession1");
		GetWorkOrderRule rule = null;
		if (getWorkOrderWFXResponse != null) {
			rule = new GetWorkOrderRule();
			rule.setJobTypeCd(getWorkOrderWFXResponse.getJob().getJobTypeCd());
			rule.setJobUnits(getWorkOrderWFXResponse.getJob().getJobUnits());
			kieSession.insert(rule);
			kieSession.fireAllRules();

		}
		return rule;
	}

	GetWorkOrderRule setWFXJobtypeCdAndJobUnits(GetWorkorderBySiteIdResponse getWorkorderBySiteIdResponse) {
		KieSession kieSession = kieContainer.newKieSession("rulesSession1");
		GetWorkOrderRule rule = null;
		if (getWorkorderBySiteIdResponse != null) {
			rule = new GetWorkOrderRule();
			rule.setJobTypeCd(getWorkorderBySiteIdResponse.getJob().getJobTypeCd());
			rule.setJobUnits(getWorkorderBySiteIdResponse.getJob().getJobUnits());
			kieSession.insert(rule);
			kieSession.fireAllRules();

		}
		return rule;
	}

	/**
	 * @param workOrderId
	 * @param siteId
	 * @return
	 * @throws CancelWorkOrderException
	 */
	@Override
	public CancelWorkorderResponse cancelWorkOrder(String workOrderId, String siteId, boolean scheduleIndicator,
			String reasonCodes) throws CancelWorkOrderException {
		List<String> reasonCodeList = new ArrayList<String>();
		if (reasonCodes != null && !reasonCodes.isEmpty()) {
			reasonCodeList = Arrays.asList(reasonCodes.split(","));
		}
		String operationName = WorkOrderConstants.CANCEL_WORK_ORDER.getValue();
		CancelWorkorderResponse cancelWorkorderResponse = new CancelWorkorderResponse();
		SiteResponse siteResponse = getSiteCancelWorkOrder(siteId, operationName);
		cancelUpdateWorkOrder(workOrderId, siteResponse, reasonCodeList);
		if (!scheduleIndicator) {
			cancelAppointment(workOrderId);
		}
		cancelWorkorderResponse.setStatus("SUCCESS");

		return cancelWorkorderResponse;

	}

	/**
	 * @param siteId
	 * @param operationName
	 * @return
	 * @throws CancelWorkOrderException
	 */
	private SiteResponse getSiteCancelWorkOrder(String siteId, String operationName) throws CancelWorkOrderException {
		SiteResponse siteResponse = null;
		try {
			siteResponse = siteCommand.getSiteDetail(siteId, operationName);
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new CancelWorkOrderException(OrionErrorCode.SITE_CONNECTIVITY_ERROR, FAILURE);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_WORKORDER_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							FAILURE);
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_WORKORDER_FAILED,
							ex.getResponseBodyAsString(), FAILURE);
				}

			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new CancelWorkOrderException(OrionErrorCode.SITE_CONNECTIVITY_ERROR, FAILURE);
		}
		return siteResponse;
	}

	/**
	 * 
	 * @param workOrderId
	 * @param siteResponse
	 * @param reasonCodeList
	 * @throws CancelWorkOrderException
	 */
	private void cancelUpdateWorkOrder(String workOrderId, SiteResponse siteResponse, List<String> reasonCodeList)
			throws CancelWorkOrderException {
		try {
			UpdateWORequest updateWORequest = cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(siteResponse,
					reasonCodeList);
			UpdateWOResponse updateWOResponse = cancelWorkOrderCommand.cancelWorkOrder(updateWORequest, workOrderId);
			LOG.info("Update Work Order Status -" + updateWOResponse.getUpdateWorkorderResponse().getResponse());
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new CancelWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_WORKORDER_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							FAILURE);
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_WORKORDER_FAILED,
							ex.getResponseBodyAsString(), FAILURE);
				}
			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new CancelWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR, FAILURE);
		}
	}

	/**
	 * @param workOrderNumber
	 * @throws CancelWorkOrderException
	 */
	private void cancelAppointment(String workOrderNumber) throws CancelWorkOrderException {
		CancelAppointmentResponseDetails cancelAppointmentResponseDetails = null;
		CancelApmtRequest cancelApmtRequest = cancelWorkOrderMapper
				.scheduleWORequestToCancelAppointmentRequest(workOrderNumber);
		try {
			cancelAppointmentResponseDetails = cancelAppointmentCommand.cancelAppointment(cancelApmtRequest);
			LOG.info("Cancel Appointment - Success" + cancelAppointmentResponseDetails.getCancelAppointmentResponse());
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new CancelWorkOrderException(OrionErrorCode.SCHEDULE_CONNECTIVITY_ERROR, SUCCESS);
			} else {
				ErrorMessage errormessage = new ErrorMessage();
				try {
					errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_APPOINTMENT_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							SUCCESS);
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(e)), "IOException");
					throw new CancelWorkOrderException(OrionErrorCode.CANCEL_APPOINTMENT_FAILED,
							ex.getResponseBodyAsString(), SUCCESS);
				}
			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new CancelWorkOrderException(OrionErrorCode.SCHEDULE_CONNECTIVITY_ERROR, SUCCESS);
		}
	}

	/**
	 * @param newAppointmentId
	 * @param rescheduleRequest
	 * @param workOrderNumber
	 * @throws ScheduleWorkOrderException
	 */
	void bookAppointment(RescheduleRequest rescheduleRequest, String newAppointmentId, String workOrderNumber)
			throws RescheduleWorkOrderException {
		LOG.info("Inside WorkorderServiceImpl ::bookAppointment ");
		ResponseEntity<BookAppointmentResponseDetails> bookResponse = null;
		try {
			if (rescheduleRequest != null && newAppointmentId != null) {
				bookResponse = bookAppointmentCommand.bookAppointment(
						scheduleWorkOrderMapper.mapBookAptRequest(rescheduleRequest, newAppointmentId));
				LOG.info("Reschedule workorder bookappointment response ::", bookResponse);
			}
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {

			try {

				ErrorMessage errormessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);

				if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
					throw new RescheduleWorkOrderException(OrionErrorCode.SCHEDULE_SERVICE_UPDATE_CONNECTIVITY_ERROR,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							workOrderNumber);
				} else {
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage(),
							workOrderNumber, null, FAILURE); // no need to send new appointment id/new workordernumber
																// incase of failure
				}
			} catch (IOException e) {
				LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
				throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
						ex.getResponseBodyAsString());
			}

		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new RescheduleWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR);
		}
	}
	
	////US1732141 -Get Reference data response to check valid solutiontype
	public ReferenceDataResponse getReferenceDataResponse(RescheduleRequest rescheduleRequest,
			ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		boolean flag = true;

		// Iterate and fetch reference data response and check for solution
		// type
		if (referenceDataResponse != null) {
			if (referenceDataResponse.getAttributeSets() != null) {
				List<String> solutiontypepresent = new ArrayList<String>();
				for (AttributeSet attributeSet : referenceDataResponse.getAttributeSets()) {
					if (attributeSet.getAttributeSubSets() != null) {
						if (rescheduleRequest != null && rescheduleRequest.getSolutionDetails() != null
								&& !rescheduleRequest.getSolutionDetails().isEmpty()) {
							if (rescheduleRequest.getSolutionDetails().get(0) != null
									&& rescheduleRequest.getSolutionDetails().get(0).getSolutionType() != null) {

								attributeSet.getAttributeSubSets().forEach(obj -> {
									if (obj.getAttributeSubSetValue().contains(
											rescheduleRequest.getSolutionDetails().get(0).getSolutionType())) {
										solutiontypepresent.add(obj.getAttributeSubSetValue());
									}

								});
							}
						} else {
							flag = false;
						}
					}
				}
				if (solutiontypepresent.size() == 0 && rescheduleRequest.getSolutionDetails() != null && flag) {
					List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
					errorList.add(
							getInvalidrequestError("RescheduleWorkorderRequest.solutionType: invalid value is passed"));
					populateInvalidRequestException(errorList);
				}
			}
		}

		return referenceDataResponse;

	}

	/**
	 * @param workOrderNumber
	 * @param rescheduleRequest
	 * @return RescheduleWorkorderResponse
	 * @throws ScheduleWorkOrderException
	 */
	@Override
	public RescheduleWorkorderResponse reschdeuleWorkOrder(RescheduleRequest rescheduleRequest, String workOrderNumber)
			throws RescheduleWorkOrderException {
		RescheduleWorkorderResponse rescheduleResponse = null;
		ReferenceDataResponse referenceDataResponse=null;
		String newWorkOrderNumber = null;
		try {
			MDC.put("downstream", "referencedata");
			MDC.put("sourceName", "Orion");
			MDC.put("downstreamUrl", "productEndpoint");
			referenceDataResponse = referenceDataCommand.getReferenceData(referenceTemplateName);
			referenceDataResponse=getReferenceDataResponse(rescheduleRequest,referenceDataResponse);
			referenceDataValidation(rescheduleRequest, referenceDataResponse);
			if (rescheduleRequest != null) {
				//US1760966 - Start
				if(CollectionUtils.isEmpty(rescheduleRequest.getWorkOrder().getJob().getReasonCodes())) {
					List<String> reasonCodes = new ArrayList<String>();
					if (!StringUtils.isEmpty(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode()))
						reasonCodes.add(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode());
					rescheduleRequest.getWorkOrder().getJob().setReasonCodes(reasonCodes);
				} else if(StringUtils.isEmpty(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode())) {
					rescheduleRequest.getWorkOrder().getJob().getReasonCodes().clear();
				} else {
					rescheduleRequest.getWorkOrder().getJob().getReasonCodes().clear();
					rescheduleRequest.getWorkOrder().getJob().getReasonCodes()
						.add(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode());
				}
				//US1760966 - End
				if (rescheduleRequest.getAppointment().getNoScheduleIndicator() != null
						&& rescheduleRequest.getAppointment().getNoScheduleIndicator()) {
					scheduleWorkOrderMapper.mapOptionalParametersForReschedule(rescheduleRequest, optionId,
							reservationId, scheduleDate, timeSlotCd);
				}
				SiteResponse siteResponse = getSiteDetailsToRescheduleAppointment(rescheduleRequest, workOrderNumber);
				LOG.info("WorkOrderServiceImpl#reschdeuleWorkOrder :: Site detail response ", siteResponse);
				if (rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator() != null
						&& rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator()) {
					bookAppointment(rescheduleRequest, workOrderNumber, workOrderNumber);
				} else {
					newWorkOrderNumber = generateNewWorkOrderNumber(workOrderNumber);
				}
				LOG.info("WorkOrderServiceImpl#reschdeuleWorkOrder :: New appointment Id", newWorkOrderNumber);
				if ((rescheduleRequest.getAppointment().getNoScheduleIndicator() == null
						|| !rescheduleRequest.getAppointment().getNoScheduleIndicator())
						&& (rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator() == null
								|| !rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator())) {
					LOG.info("WorkOrderServiceImpl#reschdeuleWorkOrder :: Book appointment response");
					bookAppointment(rescheduleRequest, newWorkOrderNumber, workOrderNumber);
					LOG.info("WorkOrderServiceImpl#reschdeuleWorkOrder :: Cancel appointment response");
					cancelAppointmentForReschedule(workOrderNumber, rescheduleRequest, siteResponse,
							newWorkOrderNumber,referenceDataResponse);
					LOG.info("WorkOrderServiceImpl#reschdeuleWorkOrder :: Update appointment response");
					updateAppointment(siteResponse, rescheduleRequest, workOrderNumber, newWorkOrderNumber,referenceDataResponse);
				}

				rescheduleResponse = rescheduleWOToNewTimeSlot(workOrderNumber, rescheduleRequest, siteResponse);
			}
				
		} catch (HttpClientErrorException | HttpServerErrorException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new RescheduleWorkOrderException(OrionErrorCode.CONNECTIVITY_ERROR, ex.getMessage());
			} else {

				try {
					ErrorMessage errormessage = objectMapper.readValue(ex.getResponseBodyAsString(),
							ErrorMessage.class);
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
							errormessage.getErrors().get(0).getCode() + " - "
									+ errormessage.getErrors().get(0).getMessage());
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
							ex.getResponseBodyAsString());
				}
			}
		} catch (OrionMiddlewareServiceException e) {
			// TODO Auto-generated catch block
			throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
					e.getErrorCode() +"-"+ e.getErrorMessage());
		}
		return rescheduleResponse;

	}

	/**
	 * This method will reverse other than first 2 number of given Id.
	 * 
	 * @param workOrderNumber
	 * @return
	 */
	private String generateNewWorkOrderNumber(String workOrderNumber) {
		String newNumber = "";
		if (!StringUtils.isEmpty(workOrderNumber) && workOrderNumber.length() > 2) {
			String alterString = workOrderNumber.replaceFirst(workOrderNumber.substring(0, 2), "");
			StringBuilder builder = new StringBuilder(alterString).reverse();
			newNumber = workOrderNumber.substring(0, 2).concat(builder.toString());
		} else {
			newNumber = workOrderNumber;
		}
		return newNumber;

	}

	/**
	 * @param orderNumber
	 * @param rescheduleRequest
	 * @param siteResponse
	 * @throws RescheduleWorkOrderException
	 * @return RescheduleWorkorderResponse
	 */
	RescheduleWorkorderResponse rescheduleWOToNewTimeSlot(String orderNumber, RescheduleRequest rescheduleRequest,
			SiteResponse siteResponse) throws RescheduleWorkOrderException {
		RescheduleWorkorderResponse rescheduleResponse = null;
		try {
			if (rescheduleRequest != null && siteResponse != null) {
				UpdateWORequest updateRequest = updateWorkOrderMapper.maprequestToUpdateWORequest(rescheduleRequest,
						siteResponse);
				UpdateWorkorderResponse updateResponse = updateWorkorder(updateRequest, orderNumber, CREATEWO,
						CREATEWO);
				if (updateResponse != null) {
					rescheduleResponse = scheduleWorkOrderMapper.mapResponse(updateResponse, orderNumber);
				}
			}
		} catch (OrionMiddlewareServiceException e) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(e)), "rescheduleWOToNewTimeSlot");
			if (rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator() != null
					&& rescheduleRequest.getAppointment().getScheduleANoScheduleIndicator()) {
				throw new RescheduleWorkOrderException(OrionErrorCode.APPOINTMENT_SCHEDULED_WORKORDER_NOT_UPDATED,
						e.getMessage(), orderNumber);
			} else if (e.getHttpStatus() == 590) {
				throw new RescheduleWorkOrderException(
						OrionErrorCode.UPDATE_APPOINTMENT_SUCCESS_WORKORDER_UPDATE_FAILED,
						"BadRequestError - Update packet work order not in WFX DB", orderNumber);
			} else if (e.getHttpStatus() == HttpStatus.NOT_FOUND.value()
					|| e.getHttpStatus() == HttpStatus.SERVICE_UNAVAILABLE.value()) {
				throw new RescheduleWorkOrderException(
						OrionErrorCode.UPDATE_APPOINTMENT_SUCCESS_WORKORDER_UPDATE_FAILED,
						"Not able to connect to Workorder service", orderNumber);
			} else if (e.getHttpStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new RescheduleWorkOrderException(
						OrionErrorCode.UPDATE_APPOINTMENT_SUCCESS_WORKORDER_UPDATE_FAILED, e.getMessage(), orderNumber);
			}
		}
		return rescheduleResponse;

	}

	/**
	 * @param rescheduleRequest
	 * @param siteResponse
	 * @param newWorkOrderNumber
	 * @throws ScheduleWorkOrderException
	 * @return
	 */
	void rescheduleWOFailure(SiteResponse siteResponse, RescheduleRequest rescheduleRequest, String workOrderNumber,
			String newWorkOrderNumber, ReferenceDataResponse referenceDataResponse)
			throws RescheduleWorkOrderException {
		LOG.info("Inside WorkorderServiceImpl ::rescheduleWOFailure ");
		if (rescheduleRequest != null && siteResponse != null) {
			createWorkorderForReschedule(rescheduleRequest, siteResponse, newWorkOrderNumber, referenceDataResponse);
			cancelWorkorderToReschedule(workOrderNumber, newWorkOrderNumber, siteResponse, rescheduleRequest);
			throw new RescheduleWorkOrderException(OrionErrorCode.NEW_WO_CREATION, workOrderNumber, newWorkOrderNumber,
					SUCCESS);
		}
	}

	/**
	 * @param workOrderId
	 * @param newWorkOrderNumber
	 * @param siteResponse
	 * @throws ScheduleWorkOrderException
	 * @return RescheduleWorkorderResponse
	 */
	void cancelWorkorderToReschedule(String workOrderId, String newWorkOrderNumber, SiteResponse siteResponse,
			RescheduleRequest rescheduleRequest) throws RescheduleWorkOrderException {
		LOG.info("Inside WorkorderServiceImpl ::cancelWorkorderToReschedule ");

		try {
			UpdateWORequest updateWORequest = cancelWorkOrderMapper
					.cancelWOReqToWFXRescheduleUpdateWorkOrderRequest(siteResponse, rescheduleRequest);
			cancelWorkOrderCommand.cancelWorkOrder(updateWORequest, workOrderId);
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()) {
				throw new RescheduleWorkOrderException(OrionErrorCode.SCHEDULE_SERVICE_CANCEL_CONNECTIVITY_ERROR,
						ex.getMessage(), workOrderId, newWorkOrderNumber, SUCCESS);
			} else {
				LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
				throw new RescheduleWorkOrderException(OrionErrorCode.CREATE_CANCEL_FAILURE,
						"BadRequestError - Update packet work order not in WFX DB", workOrderId, newWorkOrderNumber,
						SUCCESS);
			}

		}

	}

	/**
	 * @param rescheduleRequest
	 * @param workOrderNumber
	 * @param siteResponse
	 * @param newWorkOrderNumber
	 * @return RescheduleWorkorderResponse
	 * @throws ScheduleWorkOrderException
	 */
	//US1732141 - Added ReferenceDataResponse as a parameter
	void cancelAppointmentForReschedule(String workOrderNumber, RescheduleRequest rescheduleRequest,
			SiteResponse siteResponse, String newWorkOrderNumber ,ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {

		LOG.info("Inside WorkorderServiceImpl ::cancelAppointment ");

		try {
			if (workOrderNumber != null) {
				CancelAppointmentResponseDetails cancelAptResponse = cancelAppointmentCommand
						.cancelAppointment(scheduleWorkOrderMapper.mapCancelRequest(workOrderNumber));
				LOG.info("Reschedule workorder ::cancelAppointment  response ", cancelAptResponse);
			}
		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "cancelAppointmentForReschedule");
			//US1732141 Trigger failure for TC scenario -else handle exception
			List<com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail> solutionDetail=new ArrayList<com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail>();
			if(rescheduleRequest.getSolutionDetails()!=null && !(rescheduleRequest.getSolutionDetails().isEmpty()))
			{  solutionDetail=rescheduleRequest.getSolutionDetails();
				for(com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail tc: solutionDetail){
					//Added below condition to allow to createWO if orderType is SRO as part of US1819566
				if(tc.getOrderType() != null && (tc.getOrderType().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_TC) || 
						tc.getOrderType().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_SRO))){
							rescheduleWOFailure(siteResponse, rescheduleRequest, workOrderNumber, newWorkOrderNumber,referenceDataResponse);
						
				}else{
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)),
							"RescheduleWorkOrderException");
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED, "update work order failed in cancelappointment for orderType "+tc.getOrderType());
				}
			}
			}
			else{
				LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)),
						"RescheduleWorkOrderException");
				throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED, "update work order failed in cancelappointment for non TC order");
			}
			
		}

	}

	/**
	 * @param workOrderNumber
	 * @param siteResponse
	 * @param rescheduleRequest
	 * @throws ScheduleWorkOrderException
	 * @return
	 */
	public void updateAppointment(SiteResponse siteResponse, RescheduleRequest rescheduleRequest,
			String workOrderNumber, String newWorkOrderNumber ,ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		LOG.info("Inside WorkorderServiceImpl ::updateAppointment ");
		try {
			if (workOrderNumber != null) {
//				String newApponitmentId = new StringBuilder(workOrderNumber).reverse().toString();				
				ResponseEntity<UpdateAppointmentResponse> updateApmtCommand = updateCommand.updateAppointment(
						scheduleWorkOrderMapper.mapUpdateRequest(workOrderNumber), newWorkOrderNumber);
				LOG.info("Reschedule workorder updateappointment response ", updateApmtCommand);
			}
		} catch (HttpClientErrorException | HttpServerErrorException | ResourceAccessException x) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(x)), "updateAppointmentForReschedule");
			//US1732141 Trigger failure for TC scenario -else handle exception
			List<com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail> solutionDetail = new ArrayList<com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail>();
			if (rescheduleRequest.getSolutionDetails() != null && !(rescheduleRequest.getSolutionDetails().isEmpty())) {
				solutionDetail = rescheduleRequest.getSolutionDetails();
				for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail tc : solutionDetail) {
					//Added below condition to allow to createWO if orderType is SRO as part of US1819566
					if (tc.getOrderType() != null && (tc.getOrderType().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_TC) || 
							tc.getOrderType().equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE_SRO))) {
						rescheduleWOFailure(siteResponse, rescheduleRequest, workOrderNumber, newWorkOrderNumber,referenceDataResponse);
					} else {
						LOG.error(append("exception ", ExceptionUtils.getStackTrace(x)),
								"RescheduleWorkOrderException");
						throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED, "update work order failed in updateappointment for orderType "+tc.getOrderType());
					}
				}

			}
			else{
				LOG.error(append("exception ", ExceptionUtils.getStackTrace(x)),
						"RescheduleWorkOrderException");
				throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED, "update work order failed in updateappointment for non TC order");
			}
		}
	}

	/**
	 * @param workOrderNumber
	 * @throws ScheduleWorkOrderException
	 */
	public SiteResponse getSiteDetailsToRescheduleAppointment(RescheduleRequest request, String workOrderNumber)
			throws RescheduleWorkOrderException {
		LOG.info("Inside WorkorderServiceImpl ::getSiteDetailsToRescheduleAppointment ");
		SiteResponse siteDetail = null;
		try {

			siteDetail = siteCommand.getSiteDetail(request.getWorkOrder().getJobCustomer().getSiteId(),
					RESCHEDULEWORKORDER);

		} catch (HttpClientErrorException | HttpServerErrorException | UnknownHttpStatusCodeException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "Exception");
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
				throw new RescheduleWorkOrderException(OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR);
			} else {

				try {
					ErrorMessage errormessage = objectMapper.readValue(ex.getResponseBodyAsString(),
							ErrorMessage.class);
					if (errormessage != null) {
						throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
								errormessage.getErrors().get(0).getCode() + " - "
										+ errormessage.getErrors().get(0).getMessage(),
								workOrderNumber);
					}
				} catch (IOException e) {
					LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "IOException");
					throw new RescheduleWorkOrderException(OrionErrorCode.UPDATE_WORKORDER_FAILED,
							ex.getResponseBodyAsString());
				}
			}
		} catch (ResourceAccessException ex) {
			LOG.error(append("exception ", ExceptionUtils.getStackTrace(ex)), "ResourceAccessException");
			throw new RescheduleWorkOrderException(OrionErrorCode.SITE_SERVICE_CONNECTIVITY_ERROR);
		}
		return siteDetail;
	}

	@Override
	public GetWorkorderBySiteIdResponse[] getWorkOrderBySiteId(String siteId, String dispatcherStatusCd,
			String scheduleDate) throws OrionMiddlewareServiceException {
		LOG.info("Inside getWorkOrderBySiteId() for siteId: " + siteId);
		GetWorkorderBySiteIdResponse[] workOrderWFXResponseList;
		try {
			String authToken = getAuthToken(WorkOrderConstants.GETWORKORDER);
			workOrderWFXResponseList = getWFXWorkOrderBySiteIdCommand.getWFXWorkorder(siteId, authToken,
					dispatcherStatusCd, scheduleDate);

			if (ArrayUtils.isEmpty(workOrderWFXResponseList)) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFA_INVALID_SITEID);
			}

			// US1761699 - Invoke Reference Data Service to map Solution Details
			Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
				jobTypeCdReasonCdSolnDtlMap = getReferenceDataResponse();

			for (GetWorkorderBySiteIdResponse workOrderWFXResponse : workOrderWFXResponseList) {
				// GetWorkOrderRule ruleValue = setWFXJobtypeCdAndJobUnits(workOrderWFXResponse);
				//US1769241 - Start
				List<JobReasonCdList> jobReasonCodeList = workOrderWFXResponse.getJob().getJobReasonCdList();
				String jobReasonCode = (CollectionUtils.isNotEmpty(jobReasonCodeList) && jobReasonCodeList.size() > 0) ?
						jobReasonCodeList.get(0).getJobReasonCd() : "" ;
				workOrderWFXResponse.getJob().setJobReasonCode(jobReasonCode);
				LOG.info("GetWorkorders - Job Reason Code from WFX response :: "+jobReasonCode);
				//US1769241 - End
				workOrderWFXResponse.setSolutionDetails(getWorkOrderMapper
						.mapSolutionDetailsfromJobTypeCode(jobTypeCdReasonCdSolnDtlMap, workOrderWFXResponse));
				//US1769241 - Start
				isJobReasonCodeMatch(jobTypeCdReasonCdSolnDtlMap, workOrderWFXResponse);
				//US1769241 - End
			}

		} catch (HttpClientErrorException | HttpServerErrorException httpError) {

			if (httpError.getStatusCode() == HttpStatus.BAD_REQUEST) {
				JsonObject obj = new JsonParser().parse(httpError.getResponseBodyAsString()).getAsJsonObject();
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFA,
						obj.get("errorCode") + " - " + obj.get("errorMessage").getAsString());
			} else if (httpError.getStatusCode() == HttpStatus.NOT_FOUND) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.GETWFXWO_CONNECTIVITY_ERROR);
			} else {
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, httpError.getMessage());
			}
		} catch (ResourceAccessException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e.getMessage());

		}
		return workOrderWFXResponseList;
	}

	
	// Future workorder
	/**
	 * @param siteId
	 * @throws ScheduleWorkOrderException
	 */
	@Override
	public FutureWorkorderResponse getFutureWorkOrderBySiteId(String siteId) throws OrionMiddlewareServiceException {
		LOG.info("Inside getWorkOrderBySiteId() for siteId: " + siteId);
		FutureWorkorderResponse futureWorkorderResponse = new FutureWorkorderResponse();
		GetWorkorderBySiteIdResponse[] workOrderWFXResponseList = null;
		List<WorkOrderDetail> workOrderDetails = new ArrayList<WorkOrderDetail>();
		List<GetWorkorderBySiteIdResponse> futureWorkOrderWFXResponseList = new ArrayList<GetWorkorderBySiteIdResponse>();

		try {
			workOrderWFXResponseList = workorderService.getWorkOrderBySiteId(siteId, null, null);
			LOG.info("WorkorderWFXResponse : " + workOrderWFXResponseList);

			for (GetWorkorderBySiteIdResponse workOrderWFXResponse : workOrderWFXResponseList) {
				LocalDate scheduleDate = LocalDate.parse(workOrderWFXResponse.getJob().getScheduleDate());
				LocalDate currentDate = LocalDate.now();
				if (scheduleDate.isAfter(currentDate)) {
					futureWorkOrderWFXResponseList.add(workOrderWFXResponse);
				}
			}
			LOG.info("WorkorderWFXResponse : " + futureWorkOrderWFXResponseList);
			if (futureWorkOrderWFXResponseList.isEmpty()) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.NO_RECORD_FOUND);
			}
			Object response = workorderServiceGateway.getDeviceDetails(futureWorkOrderWFXResponseList);
			LOG.info("Response from Gateway : " + response);
			if (response instanceof com.comcast.orion.workorder.domain.Error) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.NO_RECORD_FOUND);
			} else {
				workOrderDetails = (List<WorkOrderDetail>) response;
			}

			futureWorkorderResponse.setWorkOrderDetails(workOrderDetails);
			LOG.info("FutureWorkOrderResponse : " + futureWorkorderResponse);
		} catch (ResourceAccessException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR, e.getMessage());
		}
		return futureWorkorderResponse;
	}
	
	// US1761699 - Method to get SolutionDetails from Reference Data Service
	// attributeSubSetValue is the solutionType and remaining values can be taken from attributes
	public Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>> getReferenceDataResponse()
			throws OrionMiddlewareServiceException {
		LOG.info("Inside getReferenceDataResponse Enters ::: ");
//		Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>> jobTypeCodewithValues = new HashMap<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>();
		Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
				jobTypeCdReasonCdSolnDtlMap = new LinkedHashMap<>();

		ReferenceDataResponse referenceDataResponse = referenceDataCommand.getReferenceData(referenceTemplateName);
		if (referenceDataResponse != null) {
			if (referenceDataResponse.getAttributeSets() != null) {
//				jobReasonCodeMap.clear();//US1769241
//				jobTypeCdReasonCdSolnDtlMap.clear();
				referenceDataResponse.getAttributeSets().forEach(attributeSet -> {
					if (attributeSet.getAttributeSubSets() != null) {
						attributeSet.getAttributeSubSets().forEach(attributeSubSet -> {
							if (attributeSubSet.getAttributeSubSetValue() != null) {
								List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailList = new ArrayList<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>();
								com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetail = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
								solutionDetail.setSolutionType(attributeSubSet.getAttributeSubSetValue().trim());
								if (attributeSubSet.getAttributes() != null) {
									attributeSubSet.getAttributes().forEach(attribute -> {
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE)) {
											solutionDetail.setOrderType(attribute.getAttributeValue().trim());
										}
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.TRANSPORT_TYPE)) {
											if (StringUtils.isNotEmpty(attribute.getAttributeValue()))
												solutionDetail.setTransportType(attribute.getAttributeValue().trim());
										}
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.JOB_TYPE_CODE)) {
											jobtype = attribute.getAttributeValue().trim();
										}
									});
									solutionDetailList.add(solutionDetail);
									// For TroubleCall, more than one jobTypeCode can have same solutionType, 
									// so taking the first jobTypeCode to get solutionType,orderType and transportType
//									if (!jobTypeCodewithValues.containsKey(jobtype)) {
//										jobTypeCodewithValues.put(jobtype, solutionDetailList);
//										String jobReasonCode = attributeSet.getAttributeSetValue();
//										//US1769241 - Start
//										if(jobReasonCodeMap.containsKey(jobReasonCode)) {
//											List<String> jobTypeCodes = jobReasonCodeMap.get(jobReasonCode);
//											jobTypeCodes.add(jobtype);
//										} else {
//											List<String> jobTypeCodes = new ArrayList<>();
//											jobTypeCodes.add(jobtype);
//											jobReasonCodeMap.put(jobReasonCode,jobTypeCodes);
//										}
//										//US1769241 - End
//									}
									String jobReasonCd = attributeSet.getAttributeSetValue();
									if (jobTypeCdReasonCdSolnDtlMap.containsKey(jobtype)) {
										Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>> jobReasonCodeMap = jobTypeCdReasonCdSolnDtlMap.get(jobtype);
										if(jobReasonCodeMap.containsKey(jobReasonCd)) {
											List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solnDtls = jobReasonCodeMap.get(jobReasonCd);
											solnDtls.add(solutionDetail);
										} else {
											List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solnDtls = new ArrayList<>();
											solnDtls.add(solutionDetail);
											jobReasonCodeMap.put(jobReasonCd, solnDtls);
										}
									} else {
										Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>> jobReasonCodeMap = new LinkedHashMap<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>();
										List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solnDtls = new ArrayList<>();
										solnDtls.add(solutionDetail);
										jobReasonCodeMap.put(jobReasonCd, solnDtls);
										jobTypeCdReasonCdSolnDtlMap.put(jobtype, jobReasonCodeMap);
									}
								}
							}
						});
					}
				});
			}
		}
//		LOG.info("getReferenceDataResponse obtained ::: "+jobTypeCodewithValues.size());
		LOG.info("Inside getReferenceDataResponse End ::: ");
		return jobTypeCdReasonCdSolnDtlMap;
	}
	
	//Reschedule work order validation purpose -US1732141
	/**
	 * @param errorList
	 * @throws RescheduleWorkOrderException
	 */
	void populateInvalidRequestException(List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList) throws RescheduleWorkOrderException {
		if (!CollectionUtils.isEmpty(errorList)) {
			RescheduleWorkorderResponse woResponse = new RescheduleWorkorderResponse();
			woResponse.setErrors(errorList);
			woResponse.setStatus(FAILURE);
			throw new RescheduleWorkOrderException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, woResponse);
		}
	}
	//Reschedule work order validation purpose -US1732141
	/**
	 * @param errorMessage
	 * @return
	 */
	com.comcast.orion.workorder.domain.reschedule.response.Error getInvalidrequestError(String errorMessage) {
		com.comcast.orion.workorder.domain.reschedule.response.Error error = new com.comcast.orion.workorder.domain.reschedule.response.Error();
		error.setCode(OrionErrorCode.CONTRACT_VALIDATION_ERROR.getErrorCode());
		error.setMessage(errorMessage);
		return error;
	}

	/**
	 * //US1769241
	 * This method will be used to check whether WFX job reason code is match with Reference data job reason code value or not
	 * @param workOrderWFXResponse
	 * @return boolean
	 */
	private boolean isJobReasonCodeMatch(Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
												 jobTypeCdReasonCdSolnDtlMap, GetWorkorderBySiteIdResponse workOrderWFXResponse) {
		String jobReasonCodeWFX = workOrderWFXResponse.getJob().getJobReasonCode();
		String jobTypeCodeWFX = workOrderWFXResponse.getJob().getJobTypeCd();
		if (StringUtils.isEmpty(jobReasonCodeWFX)) {
			LOG.info("GetWorkorders - WFX job reason code :: "+jobReasonCodeWFX+" does not match with reference data");
			return false;
		}
		Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>
				jobReasonCdSolnDtlMap = jobTypeCdReasonCdSolnDtlMap.get(jobTypeCodeWFX);
		if(jobReasonCdSolnDtlMap != null && jobReasonCdSolnDtlMap.containsKey(jobReasonCodeWFX)) {
			LOG.info("GetWorkorders - WFX job reason code :: "+jobReasonCodeWFX+" is matched with reference data");
			return true;
		}
		LOG.info("GetWorkorders - WFX job reason code :: "+jobReasonCodeWFX+" does not match with reference data");
		return false;
	}

	/**
	 * This method is for reference data validation based on Order Types
	 * @param rescheduleRequest RescheduleRequest
	 * @param referenceDataResponse ReferenceDataResponse
	 * @throws RescheduleWorkOrderException
	 */
	public void referenceDataValidation(RescheduleRequest rescheduleRequest,
										ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		if(CollectionUtils.isNotEmpty(rescheduleRequest.getSolutionDetails())
				&& rescheduleRequest.getSolutionDetails().size() > 0) {
			String inputOrderType = rescheduleRequest.getSolutionDetails().get(0).getOrderType();
			if (WorkOrderConstants.ORDER_TYPE_TC.equalsIgnoreCase(inputOrderType)) {
				validationForOrderTypeTC(rescheduleRequest, referenceDataResponse);
				//Modified below condition as part of US1819566
			} else if (WorkOrderConstants.ORDER_TYPE_SRO.equalsIgnoreCase(inputOrderType)) {
				validationForOrderTypeSRO(rescheduleRequest, referenceDataResponse);
			} else if (WorkOrderConstants.ORDER_TYPE_NEW.equalsIgnoreCase(inputOrderType)
					|| WorkOrderConstants.ORDER_TYPE_CHANGE.equalsIgnoreCase(inputOrderType) || WorkOrderConstants.ORDER_TYPE_DISCONNECT.equalsIgnoreCase(inputOrderType)) {
				validationForOrderTypeNewChangeDisconnect(rescheduleRequest, referenceDataResponse);
			}
		}
	}

	/**
	 * This method created to ovoid duplicate code to throw exception
	 * @param errMessage String
	 * @throws RescheduleWorkOrderException
	 */
	private void throwRescheduleWorkOrderException(String errMessage) throws RescheduleWorkOrderException{
		List<com.comcast.orion.workorder.domain.reschedule.response.Error> errorList = new ArrayList<>();
		errorList.add(getInvalidrequestError(errMessage));
		populateInvalidRequestException(errorList);
	}

	/**
	 * This method is for reference data validation based on Order Type TC
	 * @param rescheduleRequest RescheduleRequest
	 * @param referenceDataResponse ReferenceDataResponse
	 * @throws RescheduleWorkOrderException
	 */
	private void validationForOrderTypeTC(RescheduleRequest rescheduleRequest,
										  ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		boolean isValidCombination = false;
		Map<String, Integer> jobTypeCodeCountMap = new HashMap<>();
		if (CollectionUtils.isEmpty(rescheduleRequest.getSolutionDetails()) && rescheduleRequest.getSolutionDetails().size() > 0
				|| StringUtils.isEmpty(rescheduleRequest.getSolutionDetails().get(0).getSolutionType())
				|| StringUtils.isEmpty(rescheduleRequest.getWorkOrder().getJob().getJobReasonCode())) {
			throwRescheduleWorkOrderException("Invalid value is passed in the request for the solutionType, orderType, jobReasonCode combination for TC OrderType");
			return;
		}
		for (AttributeSet attributeSet : referenceDataResponse.getAttributeSets()) {
			if (rescheduleRequest.getWorkOrder().getJob().getJobReasonCode().equalsIgnoreCase(attributeSet.getAttributeSetValue())) {
				for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
					for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solutionDetail : rescheduleRequest.getSolutionDetails()) {
						if (WorkOrderConstants.SOLUTION_TYPE.equalsIgnoreCase(attributeSubSet.getAttributeSubSetKey())
								&& attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(solutionDetail.getSolutionType())) {
							isValidCombination = getWorkOrderMapper.isAttributeKeyValueMatch(attributeSubSet.getAttributes(),
									WorkOrderConstants.ORDER_TYPE, solutionDetail.getOrderType());
							if(!isValidCombination) {
								throwRescheduleWorkOrderException("Invalid value is passed in the request for the solutionType, orderType, jobReasonCode combination for TC OrderType");
								return;
							}
							for (Attribute attribute : attributeSubSet.getAttributes()) {
								if (WorkOrderConstants.JOB_TYPE_CODE.equalsIgnoreCase(attribute.getAttributeKey())) {
									if(jobTypeCodeCountMap.containsKey(solutionDetail.getSolutionType())) {
										jobTypeCodeCountMap.put(solutionDetail.getSolutionType(), jobTypeCodeCountMap.get(solutionDetail.getSolutionType())+1);
									} else {
										jobTypeCodeCountMap.put(solutionDetail.getSolutionType(), 1);
									}
								}
							}
						}
					}
				}
			}
		}
		for(String key : jobTypeCodeCountMap.keySet()) {
			if (jobTypeCodeCountMap.get(key) > 1) {
				throwRescheduleWorkOrderException("schedule is not possible with the selected job reason code: "+rescheduleRequest.getWorkOrder().getJob().getJobReasonCode());
			}
		}
		if(!isValidCombination) {
			throwRescheduleWorkOrderException("Invalid value is passed in the request for the solutionType, orderType, jobReasonCode combination for TC OrderType");
		}
	}

	/**
	 * This method is for reference data validation based on Order Type Prewire
	 * @param rescheduleRequest RescheduleRequest
	 * @param referenceDataResponse ReferenceDataResponse
	 * @throws RescheduleWorkOrderException
	 */
	private void validationForOrderTypeSRO(RescheduleRequest rescheduleRequest,
			ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		boolean isOrderTypeMatched = false;
		// Changes made to include jobReasonCode for reference data filter
		int matchedCount = 0;
		String jobReasonCode = rescheduleRequest.getWorkOrder().getJob().getJobReasonCode();
		List<AttributeSet> attributeSets = new ArrayList<AttributeSet>();
		if (StringUtils.isNotBlank(jobReasonCode)) {
			attributeSets = referenceDataResponse.getAttributeSets().stream()
					.filter(x -> x.getAttributeSetValue().equalsIgnoreCase(jobReasonCode)).collect(Collectors.toList());
		} else {
			attributeSets.addAll(referenceDataResponse.getAttributeSets());
		}
		// Ends here
		for (AttributeSet attributeSet : attributeSets) {
			for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
				for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solutionDetail : rescheduleRequest
						.getSolutionDetails()) {
					if (WorkOrderConstants.SOLUTION_TYPE.equalsIgnoreCase(attributeSubSet.getAttributeSubSetKey())
							&& attributeSubSet.getAttributeSubSetValue()
									.equalsIgnoreCase(solutionDetail.getSolutionType())) {
						isOrderTypeMatched = getWorkOrderMapper.isAttributeKeyValueMatch(
								attributeSubSet.getAttributes(), WorkOrderConstants.ORDER_TYPE,
								solutionDetail.getOrderType());
						if (isOrderTypeMatched) {
//							return;
							matchedCount++;
						}
					}
				}
			}
		}
		if (!isOrderTypeMatched) {
			throwRescheduleWorkOrderException(
					"Invalid value is passed in the request for the solutionType, orderType, jobReasonCode combination for SRO OrderType");
		}
		if (matchedCount > 1) {
			throwRescheduleWorkOrderException("schedule is not possible with the selected job reason code: "
					+ rescheduleRequest.getWorkOrder().getJob().getJobReasonCode());
		}
	}

	/**
	 * This method is for reference data validation based on Order Types (New/Change/Disconnect)
	 * @param rescheduleRequest RescheduleRequest
	 * @param referenceDataResponse ReferenceDataResponse
	 * @throws RescheduleWorkOrderException
	 */
	private void validationForOrderTypeNewChangeDisconnect(RescheduleRequest rescheduleRequest,
														   ReferenceDataResponse referenceDataResponse) throws RescheduleWorkOrderException {
		boolean isOrderTypeMatched = false;
		boolean isTransportTypeMatched = false;
		if (referenceDataResponse == null) {
			return;
		}
		for (AttributeSet attributeSet : referenceDataResponse.getAttributeSets()) {
			for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
				for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solutionDetail : rescheduleRequest.getSolutionDetails()) {
					isOrderTypeMatched = false;
					isTransportTypeMatched = false;
					if (WorkOrderConstants.SOLUTION_TYPE.equalsIgnoreCase(attributeSubSet.getAttributeSubSetKey())
							&& attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(solutionDetail.getSolutionType())) {
						isOrderTypeMatched = getWorkOrderMapper.isAttributeKeyValueMatch(attributeSubSet.getAttributes(),
								WorkOrderConstants.ORDER_TYPE, solutionDetail.getOrderType());
						isTransportTypeMatched = getWorkOrderMapper.isAttributeKeyValueMatch(attributeSubSet.getAttributes(),
								WorkOrderConstants.TRANSPORT_TYPE, solutionDetail.getTransportType());
						if(isOrderTypeMatched && isTransportTypeMatched) {
							return;
						}
					}
				}
			}
		}
		if(!isOrderTypeMatched || !isTransportTypeMatched) {
			throwRescheduleWorkOrderException("Invalid value is passed in the request for the solutionType, orderType ,transportType combination for New/Change/Disconnect OrderTypes");
		}
	}

	@Override
	public DeletePointOfResponse deletePointOfInterest(@Valid DeletePointOfRequest request) throws OrionMiddlewareServiceException {
		DeletePointOfResponse deletePointOfResponse = new DeletePointOfResponse();
		ResultBase resultBase = otDeletePointOfInterestCommand.deletePointOfInterest(request.getId());
		deletePointOfResponse = pointOfInterestMapper.mapOmwToOTResponse(resultBase);
		if(!WorkOrderConstants.SUCCESS.equalsIgnoreCase(deletePointOfResponse.getStatus())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_OT,deletePointOfResponse.getErrors().get(0).getMessage());
		}
		return deletePointOfResponse;
	}

	@Override
	public POIResponse createPOI(POIRequest request, String token) throws OrionMiddlewareServiceException {
		POIResponse res = pointOfInterestImpl.insertOrUpdateCustomerSite(request);
		return res;
	}
	
	public Map<String, Map<String, List<SolutionDetail>>> getReferenceDataResponseForGetWO()
			throws OrionMiddlewareServiceException {
		LOG.info("Inside getReferenceDataResponseForGetWO Enters ::: ");
		Map<String, Map<String, List<SolutionDetail>>> jobTypeCdReasonCdSolnDtlMap = new LinkedHashMap<>();
		ReferenceDataResponse referenceDataResponse = referenceDataCommand.getReferenceData(referenceTemplateName);
		if (referenceDataResponse != null) {
			if (referenceDataResponse.getAttributeSets() != null) {
				referenceDataResponse.getAttributeSets().forEach(attributeSet -> {
					if (attributeSet.getAttributeSubSets() != null) {
						attributeSet.getAttributeSubSets().forEach(attributeSubSet -> {
							if (attributeSubSet.getAttributeSubSetValue() != null) {
								List<SolutionDetail> solutionDetailList = new ArrayList<SolutionDetail>();
								SolutionDetail solutionDetail = new SolutionDetail();
								solutionDetail.setSolutionType(attributeSubSet.getAttributeSubSetValue().trim());
								if (attributeSubSet.getAttributes() != null) {
									attributeSubSet.getAttributes().forEach(attribute -> {
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.ORDER_TYPE)) {
											solutionDetail.setOrderType(attribute.getAttributeValue().trim());
										}
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.TRANSPORT_TYPE)) {
											if (StringUtils.isNotEmpty(attribute.getAttributeValue()))
												solutionDetail.setTransportType(attribute.getAttributeValue().trim());
										}
										if (attribute.getAttributeKey()
												.equalsIgnoreCase(WorkOrderConstants.JOB_TYPE_CODE)) {
											jobtype = attribute.getAttributeValue().trim();
										}
									});
									solutionDetailList.add(solutionDetail);
									String jobReasonCd = attributeSet.getAttributeSetValue();
									if (jobTypeCdReasonCdSolnDtlMap.containsKey(jobtype)) {
										Map<String, List<SolutionDetail>> jobReasonCodeMap = jobTypeCdReasonCdSolnDtlMap.get(jobtype);
										if(jobReasonCodeMap.containsKey(jobReasonCd)) {
											List<SolutionDetail> solnDtls = jobReasonCodeMap.get(jobReasonCd);
											solnDtls.add(solutionDetail);
										} else {
											List<SolutionDetail> solnDtls = new ArrayList<>();
											solnDtls.add(solutionDetail);
											jobReasonCodeMap.put(jobReasonCd, solnDtls);
										}
									} else {
										Map<String, List<SolutionDetail>> jobReasonCodeMap = new LinkedHashMap<String, List<SolutionDetail>>();
										List<SolutionDetail> solnDtls = new ArrayList<>();
										solnDtls.add(solutionDetail);
										jobReasonCodeMap.put(jobReasonCd, solnDtls);
										jobTypeCdReasonCdSolnDtlMap.put(jobtype, jobReasonCodeMap);
									}
								}
							}
						});
					}
				});
			}
		}
		LOG.info("Inside getReferenceDataResponseForGetWO End ::: ");
		return jobTypeCdReasonCdSolnDtlMap;
	}

	private boolean isJobReasonCodeMatchForGetWO(Map<String, Map<String, List<SolutionDetail>>>
		 jobTypeCdReasonCdSolnDtlMap, GetWorkorderOMWResponse getWorkOrderResponse) {
		String jobReasonCodeWFX = getWorkOrderResponse.getWorkOrder().getJob().getJobReasonCode();
		String jobTypeCodeWFX = getWorkOrderResponse.getWorkOrder().getJob().getJobTypeCd();
		if (StringUtils.isEmpty(jobReasonCodeWFX)) {
			LOG.info("GetWorkorder - WFX job reason code :: "+jobReasonCodeWFX+" does not match with reference data");
			return false;
		}
		Map<String, List<SolutionDetail>> jobReasonCdSolnDtlMap = jobTypeCdReasonCdSolnDtlMap.get(jobTypeCodeWFX);
		if(jobReasonCdSolnDtlMap != null && jobReasonCdSolnDtlMap.containsKey(jobReasonCodeWFX)) {
			LOG.info("GetWorkorder - WFX job reason code :: "+jobReasonCodeWFX+" is matched with reference data");
			return true;
		}
		LOG.info("GetWorkorder - WFX job reason code :: "+jobReasonCodeWFX+" does not match with reference data");
		return false;
	}

}
