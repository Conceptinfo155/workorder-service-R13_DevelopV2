
package com.comcast.orion.workorder.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.doThrow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.command.BookAppointmentCommand;
import com.comcast.orion.workorder.command.CancelAppointmentCommand;
import com.comcast.orion.workorder.command.CancelWorkOrderCommand;
import com.comcast.orion.workorder.command.CreateWorkOrderCommand;
import com.comcast.orion.workorder.command.GetWFXWorkOrderBySiteIdCommand;
import com.comcast.orion.workorder.command.GetWFXWorkOrderCommand;
import com.comcast.orion.workorder.command.GetWorkOrderCommand;
import com.comcast.orion.workorder.command.LocationRequestCommand;
import com.comcast.orion.workorder.command.NewCreateWorkOrderCommand;
import com.comcast.orion.workorder.command.NewUpdateWorkOrderCommand;
import com.comcast.orion.workorder.command.OTDeletePointOfInterestCommand;
import com.comcast.orion.workorder.command.ProductCommand;
import com.comcast.orion.workorder.command.ReferenceDataCommand;
import com.comcast.orion.workorder.command.SiteCommand;
import com.comcast.orion.workorder.command.UpdateAppointmentCommand;
import com.comcast.orion.workorder.command.UpdateWorkOrderCommand;
import com.comcast.orion.workorder.command.WorkorderAuthCommand;
import com.comcast.orion.workorder.domain.Error;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.Job.DispatcherStatusCd;
import com.comcast.orion.workorder.domain.createwo.Job.JobClassCd;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.JobEquipmentList;
import com.comcast.orion.workorder.domain.getfutureworkorder.FutureWorkorderResponse;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.Characteristic;
import com.comcast.orion.workorder.domain.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.getworkorder.Service;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkOrderDetails;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.locationResponse.BillingDetailsInfo;
import com.comcast.orion.workorder.domain.locationResponse.CSGDetailsType;
import com.comcast.orion.workorder.domain.locationResponse.Capability;
import com.comcast.orion.workorder.domain.locationResponse.CapabilityInfo;
import com.comcast.orion.workorder.domain.locationResponse.CsgDetails;
import com.comcast.orion.workorder.domain.locationResponse.E911AddressInfo;
import com.comcast.orion.workorder.domain.locationResponse.GeographyInfo;
import com.comcast.orion.workorder.domain.locationResponse.LocationCapabilities;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.locationResponse.MarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.NetworkConnectivityInfo;
import com.comcast.orion.workorder.domain.locationResponse.PostalAddress;
import com.comcast.orion.workorder.domain.locationResponse.ResponseItems;
import com.comcast.orion.workorder.domain.locationResponse.SpeedTierInfo;
import com.comcast.orion.workorder.domain.locationResponse.TelephonyInfo;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.pointofinterest.request.DeletePointOfRequest;
import com.comcast.orion.workorder.domain.pointofinterest.response.DeletePointOfResponse;
import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.domain.reschedule.request.Appointment;
import com.comcast.orion.workorder.domain.reschedule.request.Job;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail;
import com.comcast.orion.workorder.domain.reschedule.request.WorkOrder;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.Address;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.BookAppointment;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.CreateWorkOrder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.JobCustomer;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.JobLocation;
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
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.CancelWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.RescheduleWorkOrderException;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import com.comcast.orion.workorder.utils.mapper.CancelWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.CreateWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.GetWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.ScheduleWorkOrderMapper;
import com.comcast.orion.workorder.utils.mapper.UpdateWorkOrderMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import services.web.trackem.ResultBase;

@RunWith(MockitoJUnitRunner.class)
public class WorkorderServiceImplTest {

	@Mock
	WorkorderServiceImpl workorderServiceImpll;

	@InjectMocks
	WorkorderServiceImpl workorderServiceImpl;

	@Mock
	CreateWorkOrderCommand createWorkOrderCommand;

	@Mock
	NewCreateWorkOrderCommand nCreateWorkOrderCommand;

	@Mock
	GetWorkOrderCommand getWorkOrderCommand;

	@Mock
	ProductCommand productCommand;
	
	@Mock
	OTDeletePointOfInterestCommand otDeletePointOfInterestCommand;

	@Mock
	UpdateWorkOrderCommand updateWorkOrderCommand;

	@Mock
	UpdateWorkOrderCommand nUpdateWorkOrderCommand;

	@Mock
	UpdateAppointmentCommand updateCommand;

	@Mock
	WorkorderAuthCommand workorderAuthCommand;

	@Mock
	LocationRequestCommand locationRequestCommand;

	@Mock
	ObjectMapper objectMapper;

	@Mock
	private CreateWorkOrderMapper createWorkOrderMapper;

	@Mock
	private UpdateWorkOrderMapper updateWorkOrderMapper;

	@Mock
	private ScheduleWorkOrderMapper scheduleWorkOrderMapper;

	@Mock
	private GetWFXWorkOrderCommand wfxWOCommand;

	@Mock
	private GetWorkOrderMapper getWorkOrderMapper;

	@Mock
	SiteCommand siteCommand;

	@Mock
	private KieContainer kieContainer;

	@Mock
	private KieSession kieSession;

	@Mock
	private CancelAppointmentCommand cancelAppointmentCommand;

	@Mock
	private CancelWorkOrderCommand cancelWorkOrderCommand;

	@Mock
	private BookAppointmentCommand bookAppointmentCommand;
	@Mock
	private NewUpdateWorkOrderCommand newUpdateWorkOrderCommand;
	
	@Mock
	private WordorderService workorderService;
	
	@Mock
	private WorkorderServiceGateway workorderServiceGateway;
	
	@Mock
	private GetWFXWorkOrderBySiteIdCommand getWFXWorkOrderBySiteIdCommand;
	
	@Mock
	private ReferenceDataCommand referenceDataCommand;

	private CreateWorkorderResponse createWorkorderResponse;
	private CreateWORequest createWORequest;
	private CreateWorkorderRequest createWorkorderRequest;
	private UpdateWorkorderResponse updateWorkorderResponse;
	private UpdateWORequest updateWORequest;
	private UpdateWorkorderRequest updateWorkorderRequest;
	//private LocationRequest locationRequest;
	private LocationServiceResponse locationResponse;
	private WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest;
	private WFXCreateWorkOrderRespone wFXCreateWorkOrderResponse;
	private WFXUpdateWorkOrderRequest wfxUpdateWorkOrderRequest;
	private WFXUpdateWorkOrderResponse wFXUpdateWorkOrderResponse;
	private WorkorderResponse workorderResponse;
	private DeletePointOfResponse deletePointOfResponse;
	private DeletePointOfRequest deletePointOfRequest;
	private AMILWorkorderResponse amilResponse;
	private GetWorkOrderWFXResponse getWFXResponse;
	GetWorkorderOMWResponse woResponse;
	private com.comcast.orion.workorder.domain.siteResponse.SiteResponse siteResponse;
	private com.comcast.orion.workorder.domain.sitev2.SiteResponse siteResponseV2;
	private UpdateWOResponse updateWOResponse;
	private CancelApmtRequest cancelApmtRequest;
	private CancelAppointmentResponseDetails cancelAppointmentResponseDetails;
	private ErrorMessage errormessage;
	private RescheduleRequest rescheduleRequest;
	private ScheduleWorkorder scheduleWorkOrder;
	private ScheduleWorkorderRequest scheduleWorkorderRequest;
	private GetWorkOrderRule rule;
	private ReferenceDataResponse referenceDataResponse;
	
	@Mock
	private RestTemplate restTemplate;

	@Mock
	private CancelWorkOrderMapper cancelWorkOrderMapper;

	@Before
	public void setUp() {

		createWorkorderRequest = new CreateWorkorderRequest();
		com.comcast.orion.workorder.domain.createwo.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.createwo.JobCustomer();
		com.comcast.orion.workorder.domain.createwo.Job job = new com.comcast.orion.workorder.domain.createwo.Job();
		job.setCallFirstPhoneNum("13qweqweqweqwe");
		job.setDispatcherStatusCd(DispatcherStatusCd.O);
		job.setJobClassCd(JobClassCd.C);
		job.setJobComment("TEST");
		job.setJobNum("0000");
		job.setTimeSlotCd("0");
		job.setScheduleDate("2017-07-30");
		job.setJobUnits("5");
		com.comcast.orion.workorder.domain.createwo.JobLocation jobLocation = new com.comcast.orion.workorder.domain.createwo.JobLocation();
		com.comcast.orion.workorder.domain.createwo.Address address = new com.comcast.orion.workorder.domain.createwo.Address();
		address.setAddrLine1("1354 E Boot Road");
		address.setAddrLine2("WEST");
		address.setCity("WEST CHESTER");
		address.setZipCode("2323");
		address.setState("PA");
		createWorkorderRequest.setJob(job);
		jobCustomer.setCustomerId("30370000001");
		jobCustomer.setEmailAddr("xyz@abc.com");
		jobCustomer.setFirstName("john");
		jobCustomer.setHomePhoneNum("7897987");
		jobCustomer.setWorkPhoneNum("7897987");
		jobCustomer.setSiteId("SITE");
		jobCustomer.setLastName("Doe");
		jobLocation.setAddress(address);
		jobLocation.setAddrId("205192378");

		createWorkorderRequest.setJobCustomer(jobCustomer);
		createWorkorderRequest.setJobLocation(jobLocation);
		createWorkorderRequest.setWfxDispatchLogin("ORION");
		createWORequest = new CreateWORequest();
		createWORequest.setCreateWorkorderRequest(createWorkorderRequest);
		createWorkorderResponse = new CreateWorkorderResponse();
		createWorkorderResponse.setResponse("test");
		createWorkorderResponse.setWorkOrderNum("11111134530");
		com.comcast.orion.workorder.domain.updatewo.Job updatewoJob = new com.comcast.orion.workorder.domain.updatewo.Job();
		updatewoJob.setCallFirstPhoneNum("13qweqweqweqwe");
		updatewoJob.setDispatcherStatusCd("2");
		updatewoJob.setJobClassCd("BD");
		updatewoJob.setJobComment("TEST");
		updatewoJob.setJobNum("0000");
		updatewoJob.setTimeSlotCd("0");
		updatewoJob.setScheduleDate("2017-07-30");
		updatewoJob.setJobUnits("5");
		com.comcast.orion.workorder.domain.updatewo.JobCustomer updatewoJobCustomer = new com.comcast.orion.workorder.domain.updatewo.JobCustomer();
		updatewoJobCustomer.setCustomerId("30370000001");
		updatewoJobCustomer.setEmailAddr("xyz@abc.com");
		updatewoJobCustomer.setFirstName("john");
		updatewoJobCustomer.setHomePhoneNum("7897987");
		updatewoJobCustomer.setWorkPhoneNum("7897987");
		updatewoJobCustomer.setLastName("Doe");
		com.comcast.orion.workorder.domain.updatewo.JobLocation updatewoJobLocation = new com.comcast.orion.workorder.domain.updatewo.JobLocation();
		com.comcast.orion.workorder.domain.updatewo.Address updatewoAddress = new com.comcast.orion.workorder.domain.updatewo.Address();
		updatewoAddress.setAddrLine1("1354 E Boot Road");
		updatewoAddress.setAddrLine2("WEST");
		updatewoAddress.setCity("WEST CHESTER");
		updatewoAddress.setZipCode("2323");
		updatewoAddress.setState("PA");
		updatewoJobLocation.setAddress(updatewoAddress);
		updatewoJobLocation.setAddrId("205192378");
		updateWorkorderRequest = new UpdateWorkorderRequest();
		updateWorkorderRequest.setJob(updatewoJob);
		updateWorkorderRequest.setJobCustomer(updatewoJobCustomer);
		updateWorkorderRequest.setJobLocation(updatewoJobLocation);
		updateWorkorderRequest.setWfxDispatchLogin("ORION");
		updateWORequest = new UpdateWORequest();
		updateWORequest.setUpdateWorkorderRequest(updateWorkorderRequest);
		updateWorkorderResponse = new UpdateWorkorderResponse();
		updateWorkorderResponse.setResponse("test");
		updateWorkorderResponse.setWorkOrderNum("11111134530");
		/*locationRequest = new LocationRequest();
		RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		locationRequest.setRequestItems(requestItems);*/

		getWFXResponse = new GetWorkOrderWFXResponse();
		com.comcast.orion.workorder.domain.wfx.getworkorder.request.Job jobWFX = new com.comcast.orion.workorder.domain.wfx.getworkorder.request.Job();
		jobWFX.setJobNum("12344");
		getWFXResponse.setJob(jobWFX);

		locationResponse = new LocationServiceResponse();
		ResponseItems responseItems = new ResponseItems();
		BillingDetailsInfo billingDetailsInfo = new BillingDetailsInfo();
		CsgDetails csgDetails = new CsgDetails();
		CSGDetailsType cSGDetailsType = new CSGDetailsType();
		cSGDetailsType.setTechnicianArea("technicianArea");
		csgDetails.setCSGDetailsType(cSGDetailsType);

		billingDetailsInfo.setCsgDetails(csgDetails);
		responseItems.setBillingDetailsInfo(billingDetailsInfo);
		CapabilityInfo capabilityInfo = new CapabilityInfo();
		LocationCapabilities locationCapabilities = new LocationCapabilities();
		Capability capability = new Capability();
		locationCapabilities.setCapability(capability);
		capabilityInfo.setLocationCapabilities(locationCapabilities);
		responseItems.setCapabilityInfo(capabilityInfo);
		E911AddressInfo e911AddressInfo = new E911AddressInfo();
		responseItems.setE911AddressInfo(e911AddressInfo);
		GeographyInfo geographyInfo = new GeographyInfo();
		responseItems.setGeographyInfo(geographyInfo);
		MarketInfo marketInfo = new MarketInfo();
		responseItems.setMarketInfo(marketInfo);
		NetworkConnectivityInfo networkConnectivityInfo = new NetworkConnectivityInfo();
		responseItems.setNetworkConnectivityInfo(networkConnectivityInfo);
		PostalAddress postalAddress = new PostalAddress();
		responseItems.setPostalAddress(postalAddress);
		SpeedTierInfo speedTierInfo = new SpeedTierInfo();
		responseItems.setSpeedTierInfo(speedTierInfo);
		TelephonyInfo telephonyInfo = new TelephonyInfo();
		responseItems.setTelephonyInfo(telephonyInfo);

		locationResponse.setResponseItems(responseItems);
		wfxCreateWorkOrderRequest = new WFXCreateWorkOrderRequest();
		wfxCreateWorkOrderRequest.setWFXDispatchLogin("yyy");
		wFXCreateWorkOrderResponse = new WFXCreateWorkOrderRespone();
		wFXCreateWorkOrderResponse.setResponse("success");
		wfxUpdateWorkOrderRequest = new WFXUpdateWorkOrderRequest();
		wfxUpdateWorkOrderRequest.setWFXDispatchLogin("wFXTechLogin");
		wFXUpdateWorkOrderResponse = new WFXUpdateWorkOrderResponse();
		wFXUpdateWorkOrderResponse.setResponse("response");
		amilResponse = new AMILWorkorderResponse();
		WorkOrderDetails workorderDetails = new WorkOrderDetails();
		workorderDetails.setCustomerId("929978670");
		workorderDetails.setSiteId("929978670");
		workorderDetails.setAgreementId("IFrameworkAgreementID_00110");
		workorderDetails.setWorkOrderId("ORION-0000000000001079");
		Equipment equipment = new Equipment();
		equipment.setAction("Add");
		equipment.setArmObjectName("");
		equipment.setServiceId("EQP17686578");
		List<Service> services = new ArrayList<Service>();
		Service service = new Service();
		service.setServiceType("BVE");
		service.setServiceId("BVE_18706886");
		List<Characteristic> characteristics = new ArrayList<Characteristic>();
		Characteristic characteristic = new Characteristic();
		characteristic.setCharacteristicName("voiceDesignID");
		characteristic.setCharacteristicValue("123456");
		characteristics.add(characteristic);
		service.setCharacteristics(characteristics);
		services.add(service);
		equipment.setServices(services);
		equipment.setEquipmentType("Comcast Business Router");
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(equipment);
		workorderDetails.setEquipment(equipmentList);
		workorderResponse = new WorkorderResponse();
		workorderResponse.setWorkOrderDetails(workorderDetails);

		scheduleWorkOrder = new ScheduleWorkorder();
		scheduleWorkorderRequest = new ScheduleWorkorderRequest();
		BookAppointment bookAppointment = new BookAppointment();
		com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail scheduleSolutionDetail = new com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail();
		scheduleSolutionDetail.setOrderType("TC");
		scheduleSolutionDetail.setSolutionType("BV");
		scheduleSolutionDetail.setTransportType("fiber");
		scheduleWorkorderRequest.getSolutionDetails().add(scheduleSolutionDetail);
		bookAppointment.setReservationId("12414");
		bookAppointment.setOptionId("1234");
		bookAppointment.setForceBookInd(true);
		scheduleWorkorderRequest.setBookAppointment(bookAppointment);
		scheduleWorkorderRequest.setRequestType(RequestType.NEW_REQUEST);
		CreateWorkOrder createWorkOrder = new CreateWorkOrder();
		JobCustomer jobCustomer1 = new JobCustomer();
		jobCustomer1.setSiteId("12412");
		createWorkOrder.setJobCustomer(jobCustomer1);
		scheduleWorkorderRequest.setCreateWorkOrder(createWorkOrder);
		scheduleWorkOrder.setScheduleWorkorderRequest(scheduleWorkorderRequest);

		rule = new GetWorkOrderRule();
		rule.setJobTypeCd("M5");
		rule.setJobUnits("18");

		siteResponse = new com.comcast.orion.workorder.domain.siteResponse.SiteResponse();
		com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo locationIdentifierInfo = new com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo();
		locationIdentifierInfo.setELocId("1234");
		siteResponse.setLocationIdentifierInfo(locationIdentifierInfo);
		siteResponseV2 = new com.comcast.orion.workorder.domain.sitev2.SiteResponse();
		com.comcast.orion.workorder.domain.sitev2.LocationIdentifierInfo locationIdentifierInfoV2 = new com.comcast.orion.workorder.domain.sitev2.LocationIdentifierInfo();
		locationIdentifierInfoV2.setELocId("1234");
		siteResponseV2.setLocationIdentifierInfo(locationIdentifierInfoV2);
		updateWOResponse = new UpdateWOResponse();
		UpdateWorkorderResponse updateWorkorderResponse = new UpdateWorkorderResponse();
		updateWorkorderResponse.setResponse("SUCCESS");
		updateWOResponse.setUpdateWorkorderResponse(updateWorkorderResponse);
		cancelApmtRequest = new CancelApmtRequest();
		CancelAppointmentRequest cancelAppointmentRequest = new CancelAppointmentRequest();
		cancelAppointmentRequest.setAppointmentId("ORION-123123");
		cancelApmtRequest.setCancelAppointmentRequest(cancelAppointmentRequest);
		cancelAppointmentResponseDetails = new CancelAppointmentResponseDetails();
		CancelAppointmentResponse cancelAppointmentResponse = new CancelAppointmentResponse();
		cancelAppointmentResponse.setMessage("SUCCESS");
		cancelAppointmentResponseDetails.setCancelAppointmentResponse(cancelAppointmentResponse);
		Appointment appointment = new Appointment();
		rescheduleRequest = new RescheduleRequest();

		List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail = new SolutionDetail();

		solutionDetail.setOrderType(WorkOrderConstants.ORDER_TYPE_DISCONNECT);
		solutionDetail.setSolutionType("BI");
		solutionDetails.add(solutionDetail);
		rescheduleRequest.setSolutionDetails(solutionDetails);
		appointment.setReservationId("342343");
		rescheduleRequest.setAppointment(appointment);
		WorkOrder workOrder = new WorkOrder();
		workOrder.setJob(new Job());
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jCustomer.setSiteId("23232");
		workOrder.setJobCustomer(jCustomer);
		rescheduleRequest.setWorkOrder(workOrder);
		errormessage = new ErrorMessage();
		List<Error> errors = new ArrayList<Error>();
		Error error = new Error();
		error.setCode("CANCEL_WORKORDER_FAILED");
		error.setMessage("cancel workorder opeartion failed");
		errors.add(error);
		errormessage.setErrors(errors);
		
		referenceDataResponse = new ReferenceDataResponse();
		com.comcast.orion.workorder.domain.referencedata.AttributeSet attrSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSet();
		com.comcast.orion.workorder.domain.referencedata.AttributeSubSet attrSubSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSubSet();
		com.comcast.orion.workorder.domain.referencedata.Attribute attr = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey1 = "JOB_TYPE_CODE";
		String attrValue1 = "34";
		attr.setAttributeKey(attrKey1);
		attr.setAttributeValue(attrValue1);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr1 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey2 = "ORDER_TYPE";
		String attrValue2 = "Disconnect";
		attr1.setAttributeKey(attrKey2);
		attr1.setAttributeValue(attrValue2);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr2 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey3 = "WEIGHT";
		String attrValue3 = "33";
		attr2.setAttributeKey(attrKey3);
		attr2.setAttributeValue(attrValue3);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr3 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey4 = "QUOTA_POINTS";
		String attrValue4 = "6";
		attr3.setAttributeKey(attrKey4);
		attr3.setAttributeValue(attrValue4);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr4 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey5 = "TRANSPORT_TYPE";
		String attrValue5 = "Coax";
		attr4.setAttributeKey(attrKey5);
		attr4.setAttributeValue(attrValue5);
		List<com.comcast.orion.workorder.domain.referencedata.Attribute> attrList = new ArrayList<>();
		attrList.add(attr);
		attrList.add(attr1);
		attrList.add(attr2);
		attrList.add(attr3);
		attrList.add(attr4);
		attrSubSet.setAttributes(attrList);
		attrSubSet.setAttributeSubSetValue("34");
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSubSet> attrSubSetList = new ArrayList<>();
		attrSubSetList.add(attrSubSet);
		attrSet.setAttributeSubSets(attrSubSetList);
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSet> attrSetList = new ArrayList<>();
		attrSetList.add(attrSet);
		referenceDataResponse.setAttributeSets(attrSetList);
		referenceDataResponse.setReferenceTemplateId("9");
		referenceDataResponse.setReferenceTemplateName("JobReasonCodes");
		
		deletePointOfResponse = new DeletePointOfResponse();
		deletePointOfResponse.setStatus("SUCCESS");
		deletePointOfRequest = new DeletePointOfRequest();
		deletePointOfRequest.setId("123456");

	}

	@Test(expected = Exception.class)
	public void testCreateWorkorderSuccess() throws OrionMiddlewareServiceException {
		String orderNumber = "11111134530";
		String operationName = "createWorkOrder";
		String token = "eyJhbGciOiJSU";
		ReflectionTestUtils.setField(workorderServiceImpl, "wfxFlag", true);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		ResponseEntity<WFXCreateWorkOrderRespone> wfxRespone = new ResponseEntity<WFXCreateWorkOrderRespone>(
				wFXCreateWorkOrderResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("6273838839"))
				.thenReturn(locationServiceResponse);
		Mockito.when(createWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(createWorkorderRequest);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);
		Mockito.when(
				createWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(nCreateWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(createWorkOrderMapper.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(createWorkorderResponse);
		try {
			createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, orderNumber, operationName,
					token);
		} catch (OrionMiddlewareServiceException e) {
		}
		assertNotNull(createWorkorderResponse);

	}

	@Test(expected = Exception.class)
	public void testCreateWorkorderSuccessForReschedule() throws RescheduleWorkOrderException,
			OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		referenceDataResponse = new ReferenceDataResponse();
		com.comcast.orion.workorder.domain.referencedata.AttributeSet attrSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSet();
		com.comcast.orion.workorder.domain.referencedata.AttributeSubSet attrSubSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSubSet();
		com.comcast.orion.workorder.domain.referencedata.Attribute attr = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey1 = "JOB_TYPE_CODE";
		String attrValue1 = "34";
		attr.setAttributeKey(attrKey1);
		attr.setAttributeValue(attrValue1);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr1 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey2 = "ORDER_TYPE";
		String attrValue2 = "TC";
		attr1.setAttributeKey(attrKey2);
		attr1.setAttributeValue(attrValue2);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr2 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey3 = "WEIGHT";
		String attrValue3 = "33";
		attr2.setAttributeKey(attrKey3);
		attr2.setAttributeValue(attrValue3);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr3 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey4 = "QUOTA_POINTS";
		String attrValue4 = "6";
		attr3.setAttributeKey(attrKey4);
		attr3.setAttributeValue(attrValue4);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr4 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey5 = "TRANSPORT_TYPE";
		String attrValue5 = "Coax";
		attr4.setAttributeKey(attrKey5);
		attr4.setAttributeValue(attrValue5);
		List<com.comcast.orion.workorder.domain.referencedata.Attribute> attrList = new ArrayList<>();
		attrList.add(attr);
		attrList.add(attr1);
		attrList.add(attr2);
		attrList.add(attr3);
		attrList.add(attr4);
		attrSubSet.setAttributes(attrList);
		attrSubSet.setAttributeSubSetValue("BI");
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSubSet> attrSubSetList = new ArrayList<>();
		attrSubSetList.add(attrSubSet);
		attrSet.setAttributeSubSets(attrSubSetList);
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSet> attrSetList = new ArrayList<>();
		attrSetList.add(attrSet);
		referenceDataResponse.setAttributeSets(attrSetList);
		referenceDataResponse.setReferenceTemplateId("9");
		referenceDataResponse.setReferenceTemplateName("JobReasonCodes");
	
		rescheduleRequest = new RescheduleRequest();

		List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail = new SolutionDetail();

		solutionDetail.setOrderType(WorkOrderConstants.ORDER_TYPE_TC);
		solutionDetail.setSolutionType("BI");
		solutionDetails.add(solutionDetail);
		rescheduleRequest.setSolutionDetails(solutionDetails);
		String operationName = "createWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U" + "0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Object myEntity;
		Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(String.class)))
				.thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		Mockito.when(createWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(createWorkorderRequest);
		Mockito.when(createWorkOrderMapper.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(createWorkorderResponse);
		Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);
		workorderServiceImpl.createWorkorderForReschedule(rescheduleRequest, siteResponse, "12345", referenceDataResponse);

		assertNotNull(createWorkorderResponse);
	}

	@Test(expected = Exception.class)
	public void testCreateWorkorderSuccessForRescheduleError() throws RescheduleWorkOrderException,
			OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		String operationName = "createWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U" + "0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);

		/*LocationRequest locationReq = new LocationRequest();
		RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		locationReq.setRequestItems(requestItems);*/
		String token = "eyJhbGciOiJSU";

		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationReq);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		Mockito.when(locationRequestCommand.getLocation("2333233233"))
				.thenThrow(httpClientErrorException);

		createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, "orderNumber", operationName,
				"eyJhbGciOiJSU");
		workorderServiceImpl.createWorkorderForReschedule(rescheduleRequest, siteResponse, "2333", referenceDataResponse);
		assertNotNull(createWorkorderResponse);
	}

	@Test(expected = Exception.class)
	public void testCreateWorkorderSuccessForRescheduleworkoreder() throws RescheduleWorkOrderException,
			OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		String operationName = "createWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U" + "0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);

		//LocationRequest locationReq = new LocationRequest();

		/*RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		requestItems.setAddressInfo(true);
		locationReq.setRequestItems(requestItems);*/
		String token = "eyJhbGciOiJSU";
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationReq);

		Mockito.when(locationRequestCommand.getLocation("25256747"))
				.thenReturn(locationServiceResponse);
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationReq);

		createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, "orderNumber", operationName,
				"eyJhbGciOiJSU");
		workorderServiceImpl.createWorkorderForReschedule(rescheduleRequest, siteResponse, "2333", referenceDataResponse);
		assertNotNull(createWorkorderResponse);
	}

	@Test
	public void testGetWorkorderSuccess() {
		String orderNumber = "11111134530";
		String token = "eyJhbGciOiJSU";
		String trackingId = "6677676";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(responseEntity);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}
	
	@Test
	public void testGetBasicWorkorderSuccess() {
		String orderNumber = "1222234530";
		String token = "eyJhbff5iOiJSU";
		String trackingId = "455668";
		String customerId = "701006685";
		String siteId = "666762";
		String include = "";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(responseEntity);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId,customerId,siteId,include);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}
	
	@Test
	public void testGetBasicWorkorderFailure() {
		String orderNumber = "1222234530";
		String token = "eyJhbff5iOiJSU";
		String trackingId = "455668";
		String customerId = "701006685";
		String siteId = "666762";
		String include = "";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId,customerId,siteId,include);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}
	
	@Test
	public void testGetEnrichedWorkorderSuccess() {
		String orderNumber = "1222234530";
		String token = "eyJhbff5iOiJSU";
		String trackingId = "455668";
		String customerId = "701006685";
		String siteId = "666762";
		String include = "EnrichedWorkorderDetails";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(responseEntity);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId,customerId,siteId,include);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}
	
	@Test
	public void testGetEnrichedWorkorderFailure() {
		String orderNumber = "1222234530";
		String token = "eyJhbff5iOiJSU";
		String trackingId = "455668";
		String customerId = "701006685";
		String siteId = "666762";
		String include = "EnrichedWorkorderDetails";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId,customerId,siteId,include);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}
	
	@Test
	public void testGetEnrichedWorkorderFailure2() {
		String orderNumber = "1222234530";
		String token = "eyJhbff5iOiJSU";
		String trackingId = "455668";
		String customerId = "701006685";
		String siteId = "666762";
		String include = "EnrichedWorkorderDetails";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{ \"errors\": [ { \"code\": \"CONTRACT_VALIDATION_ERROR\", \"message\": \"serviceId or siteId or customerId are mandatory in the request\" } ] }",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		try {
			workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,token,trackingId,customerId,siteId,include);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(workorderResponse);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGetWorkorderFailure() throws OrionMiddlewareServiceException {
		String orderNumber = "11111134530";
		String token = "eyJhbGciOiJSU";
		String trackingId = "766767";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{    \"servicedetails\": {        \"customer\": {            \"customerName\": \"India 555\",            \"customerType\": \"Commercial Customer\",            \"customerAccountNumber\": \"150360488\",            \"lineOfBusiness\": \"\",            \"crmCustomerId\": \"150360488\",            \"customerCRMSystem\": \"Orion\",            \"characteristics\": [                {                    \"attributeName\": \"SUPPORT_ENTITY\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"CUSTOMERCODE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ACCOUNTNUMBERALIAS\",                    \"attributeValue\": \"100200778\"                },                {                    \"attributeName\": \"NAMEALIAS\",                    \"attributeValue\": \"One Digital*-100200778\"                }            ],            \"site\": [                {                    \"siteCLLI\": \"\",                    \"latitude\": \"42.355438\",                    \"longitude\": \"-71.057991\",                    \"siteAddress\": \"77 FRANKLIN ST STE 510 BOSTON MA 02110\",                    \"address1\": \"77 FRANKLIN ST\",                    \"address2\": \"\",                    \"city\": \"BOSTON\",                    \"state\": \"MA\",                    \"zip\": \"02110\",                    \"siteName\": \"77 FRANKLIN ST_STE 510_INDIA 555\",                    \"siteCRMSystem\": \"ORION\",                    \"crmSiteId\": \"OSite_1795905_1\",                    \"customerSiteName\": \"\",                    \"customerUNQID\": \"8712005\",                    \"characteristics\": [                        {                            \"attributeName\": \"PREFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTRYNAME\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LATDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"LONGDECIMAL\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"VERTCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"HORZCOORD\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"COUNTY\",                            \"attributeValue\": \"Suffolk\"                        },                        {                            \"attributeName\": \"TIMEZONE\",                            \"attributeValue\": \"Eastern Standard Time\"                        },                        {                            \"attributeName\": \"LONGITUDE\",                            \"attributeValue\": \"-71.057991\"                        },                        {                            \"attributeName\": \"LATITUDE\",                            \"attributeValue\": \"42.355438\"                        },                        {                            \"attributeName\": \"SUFFIX\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"ADDRESSNORMALIZED\",                            \"attributeValue\": \"Y\"                        },                        {                            \"attributeName\": \"HOUSENUM\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"POSTALCODE\",                            \"attributeValue\": \"\"                        },                        {                            \"attributeName\": \"REGION\",                            \"attributeValue\": \"TWIN CITIES MARKET\"                        },                        {                            \"attributeName\": \"DIVISION\",                            \"attributeValue\": \"WEST DIVISION\"                        }                    ],                    \"service\": [                        {                            \"serviceName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"serviceId\": \"20943790\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_101_87091\",                            \"serviceType\": \"IP Underlay Service\",                            \"serviceTopologyName\": \"IP Underlay STE 101_DIGITAL,ONE_20944297\",                            \"underlayIndicator\": \"True\",                            \"serviceStatus\": \"Planned\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [],                            \"characteristics\": [                                {                                    \"attributeName\": \"underlayType\",                                    \"attributeValue\": \"\"                                },                                {                                    \"attributeName\": \"underlayOwner\",                                    \"attributeValue\": \"Comcast\"                                },                                   {                                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                                    \"attributeValue\": \"BVE_101_87091\"                                    },                                     {                                    \"attributeName\": \"underlayProvider\",                                    \"attributeValue\": \"Comcast\"                                }                            ]                        },                         {                            \"serviceName\": \"Buesiness VoiceEdge_18457593\",                            \"serviceId\": \"18706886\",                            \"solutionId\": \"\",                            \"serviceInstanceId\": \"BVE_18706886\",                            \"serviceType\": \"Business VoiceEdge\",                            \"serviceTopologyName\": \"Buesiness VoiceEdge_18457593\",                            \"underlayIndicator\": \"\",                            \"serviceStatus\": \"Active\",                            \"customerUNQID\": \"8699084\",                            \"associtedServiceUNQID\": [                                \"20943790\"                            ],                            \"characteristics\": [                                 {                    \"attributeName\": \"COS3_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS3_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS2_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"COS1_SOLD_CIR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PTD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"MANAGEDENTERPRISESERVICE\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PNP_MANAGED\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SOLUTION_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"SERVICE_INSTANCE_ID\",                    \"attributeValue\": \"BVE_18706886\"                },                {                    \"attributeName\": \"ASSELECTION\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTGROUPID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"SIPUAREGISTRAR\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ASPASSWORD\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"BROADSOFTENTERPRISEID\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"PRIMARYBTN\",                    \"attributeValue\": \"\"                },                {                    \"attributeName\": \"ILD_PLAN\",                    \"attributeValue\": \"\"                },                 {                    \"attributeName\": \"IS_OTT\",                    \"attributeValue\": \"Yes\"                }                ]                                                       }                                         ]                }            ]        }    }}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(getWorkOrderMapper.mapAMILResponseToGetWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(workorderResponse);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);
		Mockito.when(getWorkOrderCommand.getWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(amilResponse);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(productCommand.getServiceDetails(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		workorderResponse = workorderServiceImpl.getWorkOrderDetails(orderNumber,trackingId,token);
		assertNotNull(workorderResponse);
	}

	@Test(expected = Exception.class)
	public void testUpdateWorkorderError() throws Exception {
		String orderNumber = "11111134530";
		String operationName = "UpdateWorkOrder";
		String token = "eyJhbGciOiJSU";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		ResponseEntity<WFXUpdateWorkOrderResponse> wfxRespone = new ResponseEntity<WFXUpdateWorkOrderResponse>(
				wFXUpdateWorkOrderResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		//Mockito.when(updateWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("26786899"))
				.thenReturn(locationServiceResponse);

		Mockito.when(updateWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(updateWorkorderRequest);
		Mockito.when(updateWorkOrderMapper.workOrderReqToWFXUpdateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxUpdateWorkOrderRequest);
		Mockito.when(
				updateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(newUpdateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(updateWorkOrderMapper.wfxUpdateWorkOrderResponseToWFXUpdateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(updateWorkorderResponse);
		Mockito.when(locationRequestCommand.getLocation("46464675"))
				.thenReturn(locationServiceResponse);
		UpdateWorkorderResponse updateWorkorderResponseNew = new UpdateWorkorderResponse();
		try {
			updateWorkorderResponseNew = workorderServiceImpl.updateWorkorder(updateWORequest, orderNumber,
					operationName, token);
		} catch (OrionMiddlewareServiceException e) {
			e.printStackTrace();
		}
		assertNotNull(updateWorkorderResponseNew);
	}

	@Test
	public void testgetAuthToken() {
		String operationName = "operationName";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"eyJhbGciOiJSU\",\"token_type\":\"Bearer\",\"expires_in\":7199}", HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		String auth = null;
		try {
			auth = workorderServiceImpl.getAuthToken(operationName);
		} catch (OrionMiddlewareServiceException e) {
		}
		assertNotNull(auth);
	}

	@Test(expected = Exception.class)
	public void testCreateWOWhenLocationIdIsInvalid() {
		String operationName = "createWorkOrder";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		/*LocationRequest locationReq = new LocationRequest();
		RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		locationReq.setRequestItems(requestItems);*/
		String token = "eyJhbGciOiJSU";
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationReq);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.BAD_REQUEST);
		Mockito.when(locationRequestCommand.getLocation("254354678"))
				.thenThrow(httpClientErrorException);
		try {
			createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, "orderNumber",
					operationName, "eyJhbGciOiJSU");
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(createWorkorderResponse);
	}

	@Test(expected = Exception.class)
	public void testCreateWOWhenLocationServiceIsDown() {
		String operationName = "createWorkOrder";
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		/*LocationRequest locationReq = new LocationRequest();
		RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		locationReq.setRequestItems(requestItems);*/

		String token = "eyJhbGciOiJSU";

		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationReq);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(locationRequestCommand.getLocation("27484894"))
				.thenThrow(httpClientErrorException);
		try {
			createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, "orderNumber",
					operationName, "eyJhbGciOiJSU");
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(createWorkorderResponse);
	}
	
	@Test(expected = Exception.class)
	public void testCreateWorkorderWhenWFXIsDown() throws OrionMiddlewareServiceException {
		String orderNumber = "11111134530";
		String operationName = "createWorkOrder";
		String token = "eyJhbGciOiJSU";
		boolean wfxFlag = true;
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("32332434"))
				.thenReturn(locationServiceResponse);
		Mockito.when(createWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(createWorkorderRequest);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);

		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(
				createWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		Mockito.when(nCreateWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		Mockito.when(createWorkOrderMapper.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(createWorkorderResponse);
		try {
			createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, orderNumber, operationName,
					token);
		} catch (OrionMiddlewareServiceException e) {

		}
		assertNotNull(createWorkorderResponse);
	}

	@Test(expected = Exception.class)
	public void testUpdateWorkorderWhenWFXIsDown() throws OrionMiddlewareServiceException {
		String orderNumber = "11111134530";
		String operationName = "UpdateWorkOrder";
		String token = "eyJhbGciOiJSU";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		//Mockito.when(updateWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("4342543534"))
				.thenReturn(locationServiceResponse);
		Mockito.when(updateWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(updateWorkorderRequest);
		Mockito.when(updateWorkOrderMapper.workOrderReqToWFXUpdateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxUpdateWorkOrderRequest);

		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(
				updateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		Mockito.when(newUpdateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		Mockito.when(updateWorkOrderMapper.wfxUpdateWorkOrderResponseToWFXUpdateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(updateWorkorderResponse);
		UpdateWorkorderResponse updateWorkorderResponseNew = new UpdateWorkorderResponse();
		try {
			updateWorkorderResponseNew = workorderServiceImpl.updateWorkorder(updateWORequest, orderNumber,
					operationName, token);
		} catch (OrionMiddlewareServiceException e) {
			e.printStackTrace();
		}

		assertNotNull(updateWorkorderResponseNew);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGETWorkorderWhenWFXIsDown() throws Exception {
		String orderNumber = "11111134530";
		String operationName = "GetWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		HttpClientErrorException httpClientErrorException = new HttpClientErrorException(HttpStatus.NOT_FOUND);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(httpClientErrorException);
		Mockito.when(getWorkOrderMapper.mapWFXResponseToWorkOrderResponse(Mockito.anyObject(), Mockito.anyObject()))
				.thenReturn(woResponse);
		GetWorkorderOMWResponse getWONew = workorderServiceImpl.getWFXWorkOrder(orderNumber);
		assertNotNull(getWONew);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGetWFXWOInvalidToken() throws Exception {
		String orderNumber = "11111134530";
		String operationName = "getWorkorder";
		ResponseEntity<GetWorkOrderWFXResponse> wfxResponse = new ResponseEntity<GetWorkOrderWFXResponse>(
				HttpStatus.OK);
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"Invalid\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyObject(), Mockito.anyString())).thenReturn(wfxResponse);
		Mockito.when(getWorkOrderMapper.mapWFXResponseToWorkOrderResponse(Mockito.anyObject(), Mockito.anyObject()))
				.thenReturn(woResponse);
		wfxResponse = wfxWOCommand.getWFXWorkorder(orderNumber, "authtoken");
		workorderServiceImpl.getWFXWorkOrder(orderNumber);

	}

	@Test
	public void testCancelWorkOrderToReschedyle() throws Exception {
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		workorderServiceImpl.cancelWorkorderToReschedule("1241244", "4534", siteResponse, rescheduleRequest);

	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testCancelWorkOrderToReschedule() throws Exception {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		workorderServiceImpl.cancelWorkorderToReschedule("1241244", "34233", siteResponse, rescheduleRequest);

	}

	@Test
	public void testCancelWorkOrder() throws Exception {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test
	public void testCancelAppointmentReschedule() throws Exception {
		UpdateAppointmentResponse updateAptResponse = new UpdateAppointmentResponse();
		updateAptResponse.setStatus("SUCCESS");
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		RescheduleWorkorderResponse rescheduleResponse = new RescheduleWorkorderResponse();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		ResponseEntity<UpdateAppointmentResponse> updateResponse = new ResponseEntity<>(HttpStatus.OK);
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.mapResponse(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(rescheduleResponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateResponse);
		workorderServiceImpl.cancelAppointmentForReschedule("23456666", rescheduleRequest, siteResponse, "34343242", referenceDataResponse);

	}

	@Test(expected = Exception.class)
	public void testreschdeuleWorkOrder() throws Exception {
		UpdateAppointmentResponse updateAptResponse = new UpdateAppointmentResponse();
		updateAptResponse.setStatus("SUCCESS");
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		ResponseEntity<UpdateAppointmentResponse> updateResponse = new ResponseEntity<>(HttpStatus.OK);
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		Mockito.when(workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest, "temp"))
				.thenReturn(siteResponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateResponse);
		workorderServiceImpl.bookAppointment(rescheduleRequest, "12121", "223123");
		workorderServiceImpl.cancelAppointmentForReschedule("2323", rescheduleRequest, siteResponse, "3432432", referenceDataResponse);
		workorderServiceImpl.updateAppointment(siteResponse, rescheduleRequest, "ererer", "34324", referenceDataResponse);
		workorderServiceImpl.rescheduleWOToNewTimeSlot("erewre", rescheduleRequest, siteResponse);

		RescheduleWorkorderResponse rescheduleaptResponse = workorderServiceImpl.rescheduleWOToNewTimeSlot("23456666",
				rescheduleRequest, siteResponse);
		assertNotNull(rescheduleaptResponse);

	}

	@Test(expected = Exception.class)
	public void testrescheduleWOToNewTimeSlot() throws Exception {
		String token = "eyJhbGciOiJSU";
		Mockito.when(updateWorkOrderMapper.maprequestToUpdateWORequest(Mockito.anyObject(), Mockito.anyObject()))
				.thenReturn(updateWORequest);
		String orderNumber = "11111134530";
		String operationName = "UpdateWorkOrder";
		ReflectionTestUtils.setField(workorderServiceImpl, "wfxFlag", true);
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<LocationServiceResponse> locationServiceResponse = new ResponseEntity<LocationServiceResponse>(
				locationResponse, HttpStatus.CREATED);
		ResponseEntity<WFXUpdateWorkOrderResponse> wfxRespone = new ResponseEntity<WFXUpdateWorkOrderResponse>(
				wFXUpdateWorkOrderResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);

		//Mockito.when(updateWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("2354454254"))
				.thenReturn(locationServiceResponse);
		Mockito.when(updateWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(updateWorkorderRequest);
		Mockito.when(updateWorkOrderMapper.workOrderReqToWFXUpdateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxUpdateWorkOrderRequest);
		Mockito.when(
				updateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(updateWorkOrderMapper.wfxUpdateWorkOrderResponseToWFXUpdateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(updateWorkorderResponse);
		UpdateWorkorderResponse updateWorkorderResponseNew = new UpdateWorkorderResponse();

		updateWorkorderResponseNew = workorderServiceImpl.updateWorkorder(updateWORequest, orderNumber, operationName,
				token);

		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);
		//Mockito.when(createWorkOrderMapper.workOrderRequestToLocationRequest(Mockito.anyObject()))
				//.thenReturn(locationRequest);
		Mockito.when(locationRequestCommand.getLocation("476876899"))
				.thenReturn(locationServiceResponse);
		Mockito.when(createWorkOrderMapper.locationResponseToWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(createWorkorderRequest);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);
		ResponseEntity<WFXCreateWorkOrderRespone> wfxsRespone = new ResponseEntity<WFXCreateWorkOrderRespone>(
				HttpStatus.OK);
		Mockito.when(
				createWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(wfxsRespone);
		Mockito.when(nCreateWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(wfxsRespone);
		Mockito.when(createWorkOrderMapper.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(createWorkorderResponse);

		createWorkorderResponse = workorderServiceImpl.createWorkorder(createWORequest, orderNumber, operationName,
				token);

		workorderServiceImpl.rescheduleWOToNewTimeSlot("23456666", rescheduleRequest, siteResponse);
		assertNotNull(updateWorkorderResponseNew);

	}

	@Test(expected = Exception.class)
	public void testCancelAppointmentRescheduleError() throws Exception {
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		workorderServiceImpl.cancelAppointmentForReschedule("23456666", rescheduleRequest, siteResponse, "23232", referenceDataResponse);
	}

	@Test(expected = Exception.class)
	public void testUpdateAppointmentError() throws Exception {
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		workorderServiceImpl.updateAppointment(siteResponse, rescheduleRequest, "old", "24312324", referenceDataResponse);

	}

	@Test(expected = Exception.class)
	public void testUpdateAppointmentResourceAccessError() throws Exception {
		ResourceAccessException e = new ResourceAccessException("SDF");
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString())).thenThrow(e);
		workorderServiceImpl.updateAppointment(siteResponse, rescheduleRequest, "old", "3432423", referenceDataResponse);

	}

	@Test
	public void testRechedule() throws Exception {
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		UpdateAppointmentResponse updateAptResponse = new UpdateAppointmentResponse();
		updateAptResponse.setStatus("SUCCESS");
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		RescheduleWorkorderResponse rescheduleResponse = new RescheduleWorkorderResponse();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		ResponseEntity<UpdateAppointmentResponse> updateResponse = new ResponseEntity<>(HttpStatus.OK);
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.mapResponse(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(rescheduleResponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateResponse);
		workorderServiceImpl.updateAppointment(siteResponse, rescheduleRequest, "old", "543534", referenceDataResponse);
		workorderServiceImpl.reschdeuleWorkOrder(rescheduleRequest, "1234");
		rescheduleResponse = scheduleWorkOrderMapper.mapResponse(updateWorkorderResponse, "899898");
		assertNotNull(rescheduleResponse);

	}

	@Test(expected = Exception.class)
	public void testRecheduleApt() throws Exception {
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		UpdateAppointmentResponse updateAptResponse = new UpdateAppointmentResponse();
		String operationName = "createWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ResponseEntity<WFXCreateWorkOrderRespone> wfxRespone = new ResponseEntity<WFXCreateWorkOrderRespone>(
				wFXCreateWorkOrderResponse, HttpStatus.CREATED);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		updateAptResponse.setStatus("SUCCESS");
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		RescheduleWorkorderResponse rescheduleResponse = new RescheduleWorkorderResponse();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		ResponseEntity<UpdateAppointmentResponse> updateResponse = new ResponseEntity<>(HttpStatus.OK);
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.mapResponse(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(rescheduleResponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateResponse);
		Mockito.when(updateWorkOrderMapper.maprequestToUpdateWORequest(Mockito.anyObject(), Mockito.anyObject()))
				.thenReturn(updateWORequest);
		ResponseEntity<LocationServiceResponse> locationRes = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(locationRequestCommand.getLocation( Mockito.anyObject()))
				.thenReturn(locationRes);
		ResponseEntity<WFXUpdateWorkOrderResponse> wfxwo = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(
				updateWorkOrderCommand.updateWorkorder(Mockito.anyObject(), Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(wfxwo);
		Mockito.when(createWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(Mockito.anyObject()))
				.thenReturn(wfxCreateWorkOrderRequest);
		Mockito.when(
				createWorkOrderCommand.createWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString()))
				.thenReturn(wfxRespone);
		Mockito.when(createWorkOrderMapper.wfxCreateWorkOrderResponeToCreateWorkOrderResponse(Mockito.anyObject()))
				.thenReturn(createWorkorderResponse);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		workorderServiceImpl.rescheduleWOToNewTimeSlot("old", rescheduleRequest, siteResponse);
		rescheduleResponse = scheduleWorkOrderMapper.mapResponse(updateWorkorderResponse, "899898");
		assertNotNull(rescheduleResponse);

	}

	@Test(expected = Exception.class)
	public void testRecheduleHttpError() throws Exception {
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		UpdateAppointmentResponse updateAptResponse = new UpdateAppointmentResponse();
		updateAptResponse.setStatus("SUCCESS");
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		RescheduleWorkorderResponse rescheduleResponse = new RescheduleWorkorderResponse();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.mapResponse(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(rescheduleResponse);
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		workorderServiceImpl.updateAppointment(siteResponse, rescheduleRequest, "old", "454353", referenceDataResponse);
		workorderServiceImpl.reschdeuleWorkOrder(rescheduleRequest, "1234");

	}

	@Test
	public void testUpdateAppointmentInvalid() throws Exception {
		ResponseEntity<UpdateAppointmentResponse> updateResponse = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(updateCommand.updateAppointment(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateResponse);
		updateCommand.updateAppointment(null, "33333");
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testRWorkOrder() throws Exception {
		ResponseEntity<GetWorkOrderWFXResponse> workOrderWFXResponse = new ResponseEntity<>(HttpStatus.OK);
		String operationName = "getWorkorder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin("getwo")).thenReturn(responseEntity);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(workOrderWFXResponse);
		GetWorkorderOMWResponse getWORespone = workorderServiceImpl.getWFXWorkOrder("1235");
		assertNotNull(getWORespone);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testRWorkOrderError() throws Exception {
		String operationName = "getWorkorder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin("getwo")).thenReturn(responseEntity);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));

		GetWorkorderOMWResponse getWORespone = workorderServiceImpl.getWFXWorkOrder("1235");
		assertNotNull(getWORespone);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testRWorkOrderBadRequestError() throws Exception {
		String operationName = "getWorkorder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin("getwo")).thenReturn(responseEntity);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_GATEWAY));

		GetWorkorderOMWResponse getWORespone = workorderServiceImpl.getWFXWorkOrder("1235");
		assertNotNull(getWORespone);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testRWorkOrderErrorNotFound() throws Exception {
		String operationName = "getWorkorder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin("getwo")).thenReturn(responseEntity);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

		GetWorkorderOMWResponse getWORespone = workorderServiceImpl.getWFXWorkOrder("1235");
		assertNotNull(getWORespone);
	}

	@Test(expected = Exception.class)
	public void testrescheduleWOFailure() throws Exception {
		ResponseEntity<GetWorkOrderWFXResponse> workOrderWFXResponse = new ResponseEntity<>(HttpStatus.OK);
		String operationName = "getWorkorder";

		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");

		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(String.class)))
				.thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
		workorderServiceImpl.createWorkorderForReschedule(rescheduleRequest, siteResponse, "1234", referenceDataResponse);
		workorderServiceImpl.setJobtypeCdAndJobUnits(rescheduleRequest);

		workorderServiceImpl.rescheduleWOFailure(siteResponse, rescheduleRequest, "1234", "453453", referenceDataResponse);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGetWorkorgetWFXWorkOrder() throws Exception {
		String operationName = WorkOrderConstants.GETWORKORDER;
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(String.class)))
				.thenReturn(responseEntity);

		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);

		ResponseEntity<GetWorkOrderWFXResponse> workOrderWFXResponse = new ResponseEntity<>(HttpStatus.OK);
		Mockito.when(wfxWOCommand.getWFXWorkorder(Mockito.anyString(), Mockito.anyString()))
				.thenReturn(workOrderWFXResponse);
		GetWorkorderOMWResponse getWORespone = workorderServiceImpl.getWFXWorkOrder("1235");
		assertNotNull(getWORespone);
	}

	@Test
	public void testBookAppointmentInvalid() throws Exception {
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		bookAppointmentCommand.bookAppointment(bookApmtRequest);
	}

	@Test
	public void testBookAppointment() throws Exception {
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		ResponseEntity<BookAppointmentResponseDetails> bookAmptResponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.mapBookAptRequest(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(bookApmtRequest);
		assertNotNull(bookAmptResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder1() throws CancelWorkOrderException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		doThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND)).when(siteCommand).getSiteDetail(any(), any());
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder2() throws CancelWorkOrderException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		doThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND)).when(cancelAppointmentCommand)
				.cancelAppointment(any());
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder3() throws CancelWorkOrderException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		doThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND)).when(cancelWorkOrderCommand).cancelWorkOrder(any(),
				any());
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder4() throws CancelWorkOrderException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		ResourceAccessException ex = new ResourceAccessException("5125125");
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenThrow(ex);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder5() throws CancelWorkOrderException {
		ResourceAccessException ex = new ResourceAccessException("5125125");
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject())).thenThrow(ex);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder6() throws CancelWorkOrderException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		ResourceAccessException ex = new ResourceAccessException("5125125");
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString())).thenThrow(ex);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder7()
			throws CancelWorkOrderException, JsonParseException, JsonMappingException, IOException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder8()
			throws CancelWorkOrderException, JsonParseException, JsonMappingException, IOException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenReturn(cancelAppointmentResponseDetails);
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test(expected = CancelWorkOrderException.class)
	public void testCancelWorkOrder9()
			throws CancelWorkOrderException, JsonParseException, JsonMappingException, IOException {
		Mockito.when(cancelAppointmentCommand.cancelAppointment(Mockito.anyObject()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest(Mockito.anyObject()))
				.thenReturn(cancelApmtRequest);
		Mockito.when(cancelWorkOrderCommand.cancelWorkOrder(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(updateWOResponse);
		Mockito.when(cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(Mockito.anyObject(), eq(null)))
				.thenReturn(updateWORequest);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString())).thenReturn(siteResponse);
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		CancelWorkorderResponse cancelWorkorderResponse = workorderServiceImpl.cancelWorkOrder("ORION-123123",
				"1241244", false, "CD");
		assertNotNull(cancelWorkorderResponse);
	}

	@Test
	public void testgetSiteDetailsToRescheduleAppointment() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString())).thenReturn(siteResponse);
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workorder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("5678902");
		workorder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workorder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
		assertNotNull(siteResponse);
	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testgetSiteDetailsToRescheduleAppointmentErrorScenario() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);

		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workorder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("5678902");
		workorder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workorder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
		assertNotNull(siteResponse);
	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testgetSiteDetailsToRescheduleAppointment500ErrorScenario() throws Exception {

		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);

		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workorder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("5678902");
		workorder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workorder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
		assertNotNull(siteResponse);
	}

	@Test
	public void testgetSiteDetailsToRescheduleAppointmentError() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString())).thenReturn(siteResponse);
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workOrder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("OSite_31535_1");
		workOrder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workOrder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
		assertNotNull(siteResponse);
	}

	@Test
	public void testgetSiteDetailsToRescheduleAppointmentHttpCancelError() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));

		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workOrder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("OSite_31535_1");
		workOrder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workOrder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
	}

	@Test
	public void testgetSiteDetailsToRescheduleAppointmentHttpError() throws Exception {
		HttpServerErrorException e = new HttpServerErrorException(HttpStatus.BAD_REQUEST);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString())).thenThrow(e);
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workOrder = new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.JobCustomer jobCustomer = new com.comcast.orion.workorder.domain.reschedule.request.JobCustomer();
		jobCustomer.setSiteId("OSite_31535_1");
		workOrder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workOrder);
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");

	}

	@Test(expected = Exception.class)
	public void testgetSiteDetailsToRescheduleAppointmentHttpException() throws Exception {
		ResponseEntity<SiteResponse> responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(responseEntity.getBody());
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		SiteResponse siteResponse = workorderServiceImpl.getSiteDetailsToRescheduleAppointment(rescheduleRequest,
				"2323232");
		assertNotNull(siteResponse);
	}

	@Test(expected = Exception.class)
	public void testScheduleWorkorder() throws Exception {
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		BookAppointmentRequest bookAppointmentRequest = new BookAppointmentRequest();
		bookAppointmentRequest.setAppointmentId("235235235");
		bookApmtRequest.setBookAppointmentRequest(bookAppointmentRequest);
		ResponseEntity<BookAppointmentResponseDetails> bookAmptresponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookAmptresponse);
		Mockito.when(scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(Mockito.anyObject(),
				Mockito.anyString())).thenReturn(bookApmtRequest);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder1() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		scheduleWorkOrder.getScheduleWorkorderRequest().setWorkOrderNumber("235235235");
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder2() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND));
		scheduleWorkOrder.getScheduleWorkorderRequest().setWorkOrderNumber("235235235");
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder3() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new ResourceAccessException("12314"));
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder4() throws Exception {
		Mockito.when(siteCommand.getSiteDetail(Mockito.anyString(), Mockito.anyString()))
				.thenThrow(new ResourceAccessException("12314"));
		scheduleWorkOrder.getScheduleWorkorderRequest().setRequestType(RequestType.RETRY_WORKORDER);
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder5() throws Exception {
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		Mockito.when(scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(Mockito.anyObject(),
				Mockito.anyString())).thenReturn(bookApmtRequest);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);

	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testBookAppointmentRescheduleError() throws Exception {
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new HttpServerErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);
		workorderServiceImpl.bookAppointment(rescheduleRequest, "2323", "23123");

	}

	@Test
	public void testBookAppointmentReschedule() throws Exception {
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		ResponseEntity<BookAppointmentResponseDetails> bookResponse = new ResponseEntity<BookAppointmentResponseDetails>(
				HttpStatus.OK);

		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject())).thenReturn(bookResponse);
		Mockito.when(scheduleWorkOrderMapper.mapBookAptRequest(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(bookApmtRequest);
		workorderServiceImpl.bookAppointment(rescheduleRequest, "2323", "342342342");
		assertNotNull(bookResponse);

	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testBookAppointmentRescheduleErrorRe() throws Exception {
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST));
		Mockito.when(scheduleWorkOrderMapper.mapBookAptRequest(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(bookApmtRequest);

		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);

		workorderServiceImpl.bookAppointment(rescheduleRequest, "2323", "343243");

	}

	@Test(expected = RescheduleWorkOrderException.class)
	public void testBookAppointmentRescheduleErrorNotFound() throws Exception {
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));
		Mockito.when(scheduleWorkOrderMapper.mapBookAptRequest(Mockito.anyObject(), Mockito.anyString()))
				.thenReturn(bookApmtRequest);

		Mockito.when(objectMapper.readValue(anyString(), eq(ErrorMessage.class))).thenReturn(errormessage);

		workorderServiceImpl.bookAppointment(rescheduleRequest, "2323", "33432");

	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder6() throws Exception {
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new HttpServerErrorException(HttpStatus.NOT_FOUND));
		Mockito.when(scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(Mockito.anyObject(),
				Mockito.anyString())).thenReturn(bookApmtRequest);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test(expected = ScheduleWorkOrderException.class)
	public void testScheduleWorkorder7() throws Exception {
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		Mockito.when(siteCommand.getSiteDetail("124", "scheduleworkorder")).thenReturn(siteResponse);
		BookApmtRequest bookApmtRequest = new BookApmtRequest();
		Mockito.when(bookAppointmentCommand.bookAppointment(Mockito.anyObject()))
				.thenThrow(new ResourceAccessException("12314"));
		Mockito.when(scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(Mockito.anyObject(),
				Mockito.anyString())).thenReturn(bookApmtRequest);
		ScheduleWorkorderResponse scheduleWorkorderResponse = workorderServiceImpl.scheduleWorkorder(scheduleWorkOrder);
		assertNotNull(scheduleWorkorderResponse);
	}

	@Test
	public void testScheduleWorkorder8() throws Exception {
		JobLocation jobLocation = new JobLocation();
		CreateWorkOrder createWorkOrder = new CreateWorkOrder();
		Address address = new Address();
		address.setAddrLine1("abcde");
		address.setAddrLine2("efgh");
		address.setCity("PA");
		address.setState("PA");
		address.setZipCode("12412");
		jobLocation.setAddress(address);
		createWorkOrder.setJobLocation(jobLocation);
		scheduleWorkorderRequest.setCreateWorkOrder(createWorkOrder);
		scheduleWorkOrder.getScheduleWorkorderRequest().setNoCrTicketIndicator(false);
		scheduleWorkOrder.setScheduleWorkorderRequest(scheduleWorkorderRequest);
		Mockito.when(scheduleWorkOrderMapper.siteResponseToWorkOrderRequest(any())).thenReturn(scheduleWorkOrder);
		scheduleWorkorderRequest = workorderServiceImpl.siteResponseToCreateWorkOrderRequest(siteResponseV2,
				scheduleWorkorderRequest);
		assertNotNull(scheduleWorkorderRequest);
	}
	
	
/**	@Test
	public void testfutureWorkOrder() throws Exception{
		
		GetWorkorderBySiteIdResponse bySiteIdResponse  = new GetWorkorderBySiteIdResponse();
		List<WorkOrderDetail> workOrderDetails = new ArrayList<WorkOrderDetail>();
		FutureWorkorderResponse response = new FutureWorkorderResponse();
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job job = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job();
		job.setBuId("112151");
		job.setJobNum("Job1");
		job.setJobTypeCd("GHdghh");
		job.setScheduleDate("2019-12-05");
		job.setWorkOrderNum("WO2569965");
		bySiteIdResponse.setJob(job);
		JobEquipmentList equipmentList = new JobEquipmentList();
		equipmentList.setSerialNum("5445454");
		List<JobEquipmentList> jobEquipmentList = new ArrayList<>();
		jobEquipmentList.add(equipmentList);
		bySiteIdResponse.setJobEquipmentList(jobEquipmentList );
		//futureWorkOrderWFXResponseList.equals(bySiteIdResponse);
		//ArrayUtils.add(futureWorkOrderWFXResponseList, bySiteIdResponse);
		GetWorkorderBySiteIdResponse[] futureWorkOrderWFXResponseList = new GetWorkorderBySiteIdResponse[] {bySiteIdResponse, bySiteIdResponse};
		Mockito.when(workorderService.getWorkOrderBySiteId(anyString(), any(), any())).thenReturn(futureWorkOrderWFXResponseList);
		WorkOrderDetail e = new WorkOrderDetail();
		e.setScheduleDate("2016-02-02");
		workOrderDetails.add(e);
		Mockito.when(workorderServiceGateway.getDeviceDetails(any())).thenReturn(workOrderDetails);
		response = workorderServiceImpl.getFutureWorkOrderBySiteId("12223323");
		assertNotNull(response);
	}
**/	
	@Test
	public void testWorkOrder() throws Exception{
		GetWorkorderBySiteIdResponse bySiteIdResponse  = new GetWorkorderBySiteIdResponse();
		GetWorkorderBySiteIdResponse[] workOrderWFXResponseList = null;
		List<WorkOrderDetail> workOrderDetails = new ArrayList<WorkOrderDetail>();
		FutureWorkorderResponse response = new FutureWorkorderResponse();
		String operationName = "getWorkorder";
		com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job job = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.Job();
		job.setBuId("112151");
		job.setJobNum("Job1");
		job.setJobTypeCd("GHdghh");
		job.setScheduleDate("2019-12-05");
		job.setWorkOrderNum("WO2569965");
		bySiteIdResponse.setJob(job);
		JobEquipmentList equipmentList = new JobEquipmentList();
		equipmentList.setSerialNum("5445454");
		List<JobEquipmentList> jobEquipmentList = new ArrayList<>();
		jobEquipmentList.add(equipmentList);
		bySiteIdResponse.setJobEquipmentList(jobEquipmentList );
		GetWorkorderBySiteIdResponse[] futureWorkOrderWFXResponseList = new GetWorkorderBySiteIdResponse[] {bySiteIdResponse, bySiteIdResponse};
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"V0dXLU9yaW9uVjBkWExVOXlhVzl1\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), anyObject(), eq(String.class)))
				.thenReturn(responseEntity);	
		Mockito.when(getWFXWorkOrderBySiteIdCommand.getWFXWorkorder(anyString(),anyString(),anyString(),anyString())).thenReturn(futureWorkOrderWFXResponseList);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
	//	Mockito.when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(authMap);
		try{
		    workOrderWFXResponseList = workorderServiceImpl.getWorkOrderBySiteId("hgaygayg", "abhjsjhgj", "ahjhsgfh");
		} catch (OrionMiddlewareServiceException e) {
			e.printStackTrace();
		}
		assertNull(workOrderWFXResponseList);
	}
	
	@Test
	public void testgetReferenceData() throws Exception {
		ReflectionTestUtils.setField(workorderServiceImpl, "referenceTemplateName", "JobReasonCodes");
		Mockito.when(referenceDataCommand.getReferenceData("JobReasonCodes")).thenReturn(referenceDataResponse);
		Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
				jobTypeCdReasonCdSolnDtlMap = workorderServiceImpl.getReferenceDataResponse();
		assertNotNull(jobTypeCdReasonCdSolnDtlMap);
	}
	
	@Test
	public void testgetReferenceDataResponse() throws Exception{
	
		referenceDataResponse = new ReferenceDataResponse();
		com.comcast.orion.workorder.domain.referencedata.AttributeSet attrSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSet();
		com.comcast.orion.workorder.domain.referencedata.AttributeSubSet attrSubSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSubSet();
		com.comcast.orion.workorder.domain.referencedata.Attribute attr = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey1 = "JOB_TYPE_CODE";
		String attrValue1 = "34";
		attr.setAttributeKey(attrKey1);
		attr.setAttributeValue(attrValue1);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr1 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey2 = "ORDER_TYPE";
		String attrValue2 = "TC";
		attr1.setAttributeKey(attrKey2);
		attr1.setAttributeValue(attrValue2);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr2 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey3 = "WEIGHT";
		String attrValue3 = "33";
		attr2.setAttributeKey(attrKey3);
		attr2.setAttributeValue(attrValue3);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr3 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey4 = "QUOTA_POINTS";
		String attrValue4 = "6";
		attr3.setAttributeKey(attrKey4);
		attr3.setAttributeValue(attrValue4);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr4 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey5 = "TRANSPORT_TYPE";
		String attrValue5 = "Coax";
		attr4.setAttributeKey(attrKey5);
		attr4.setAttributeValue(attrValue5);
		List<com.comcast.orion.workorder.domain.referencedata.Attribute> attrList = new ArrayList<>();
		attrList.add(attr);
		attrList.add(attr1);
		attrList.add(attr2);
		attrList.add(attr3);
		attrList.add(attr4);
		attrSubSet.setAttributes(attrList);
		attrSubSet.setAttributeSubSetValue("BI");
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSubSet> attrSubSetList = new ArrayList<>();
		attrSubSetList.add(attrSubSet);
		attrSet.setAttributeSubSets(attrSubSetList);
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSet> attrSetList = new ArrayList<>();
		attrSetList.add(attrSet);
		referenceDataResponse.setAttributeSets(attrSetList);
		referenceDataResponse.setReferenceTemplateId("9");
		referenceDataResponse.setReferenceTemplateName("JobReasonCodes");
	
		rescheduleRequest = new RescheduleRequest();

		List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail = new SolutionDetail();

		solutionDetail.setOrderType(WorkOrderConstants.ORDER_TYPE_TC);
		solutionDetail.setSolutionType("BI");
		solutionDetails.add(solutionDetail);
		rescheduleRequest.setSolutionDetails(solutionDetails);
		ReflectionTestUtils.setField(workorderServiceImpl, "referenceTemplateName", "JobReasonCodes");
		Mockito.when(referenceDataCommand.getReferenceData("JobReasonCodes")).thenReturn(referenceDataResponse);
		ReferenceDataResponse referenceDataResponsevalue=workorderServiceImpl.getReferenceDataResponse(rescheduleRequest,referenceDataResponse);
		assertNotNull(referenceDataResponsevalue);
		
	}
	
	@Test
	public void testsetOrderTypeAndQuotaPoints() throws Exception {

		referenceDataResponse = new ReferenceDataResponse();
		com.comcast.orion.workorder.domain.referencedata.AttributeSet attrSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSet();
		com.comcast.orion.workorder.domain.referencedata.AttributeSubSet attrSubSet = new com.comcast.orion.workorder.domain.referencedata.AttributeSubSet();
		com.comcast.orion.workorder.domain.referencedata.Attribute attr = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey1 = "JOB_TYPE_CODE";
		String attrValue1 = "34";
		attr.setAttributeKey(attrKey1);
		attr.setAttributeValue(attrValue1);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr1 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey2 = "ORDER_TYPE";
		String attrValue2 = "TC";
		attr1.setAttributeKey(attrKey2);
		attr1.setAttributeValue(attrValue2);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr2 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey3 = "WEIGHT";
		String attrValue3 = "33";
		attr2.setAttributeKey(attrKey3);
		attr2.setAttributeValue(attrValue3);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr3 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey4 = "QUOTA_POINTS";
		String attrValue4 = "6";
		attr3.setAttributeKey(attrKey4);
		attr3.setAttributeValue(attrValue4);
		com.comcast.orion.workorder.domain.referencedata.Attribute attr4 = new com.comcast.orion.workorder.domain.referencedata.Attribute();
		String attrKey5 = "TRANSPORT_TYPE";
		String attrValue5 = "Coax";
		attr4.setAttributeKey(attrKey5);
		attr4.setAttributeValue(attrValue5);
		List<com.comcast.orion.workorder.domain.referencedata.Attribute> attrList = new ArrayList<>();
		attrList.add(attr);
		attrList.add(attr1);
		attrList.add(attr2);
		attrList.add(attr3);
		attrList.add(attr4);
		attrSubSet.setAttributes(attrList);
		attrSubSet.setAttributeSubSetValue("BI");
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSubSet> attrSubSetList = new ArrayList<>();
		attrSubSetList.add(attrSubSet);
		attrSet.setAttributeSubSets(attrSubSetList);
		List<com.comcast.orion.workorder.domain.referencedata.AttributeSet> attrSetList = new ArrayList<>();
		attrSetList.add(attrSet);
		referenceDataResponse.setAttributeSets(attrSetList);
		referenceDataResponse.setReferenceTemplateId("9");
		referenceDataResponse.setReferenceTemplateName("JobReasonCodes");
	
		rescheduleRequest = new RescheduleRequest();

		List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail = new SolutionDetail();

		solutionDetail.setOrderType(WorkOrderConstants.ORDER_TYPE_TC);
		solutionDetail.setSolutionType("BI");
		solutionDetails.add(solutionDetail);
		rescheduleRequest.setSolutionDetails(solutionDetails);
		WorkOrder workOrder = new WorkOrder();
		Job job = new Job().withJobReasonCode("D0");
		rescheduleRequest.withWorkOrder(workOrder);
		rescheduleRequest.getWorkOrder().setJob(job);
		ReflectionTestUtils.setField(workorderServiceImpl, "referenceTemplateName", "JobReasonCodes");
		Mockito.when(referenceDataCommand.getReferenceData("JobReasonCodes")).thenReturn(referenceDataResponse);
		workorderServiceImpl.setOrderTypeAndQuotaPoints(referenceDataResponse,rescheduleRequest);
		
		
	}
	@Test
	public void testmapVMSTnFeatures() throws Exception {
		List<com.comcast.orion.workorder.domain.getworkorder.ServiceDetail> serviceDetails= new ArrayList<com.comcast.orion.workorder.domain.getworkorder.ServiceDetail>();
		ServiceDetail serviceDetail=new ServiceDetail();
		serviceDetail.setServiceId("1234");
		serviceDetail.setServiceType("BV");
		serviceDetails.add(serviceDetail);
		List<String> serviceTypeList= new ArrayList();
		serviceTypeList.add("BV");
		ReflectionTestUtils.setField(workorderServiceImpl, "tnFeatureServiceTypeList", serviceTypeList);
		
		Mockito.when(workorderServiceGateway.getVMSTnFeatures(any())).thenReturn(serviceDetails);
		workorderServiceImpl.mapVMSTnFeatures(workorderResponse);
	}
	
	
	@Test
	public void testDeletePointOfInterestCustomer() throws Exception {
		DeletePointOfRequest deletePointOfRequest = new DeletePointOfRequest();
		deletePointOfRequest.setId("123456");
		ResultBase resultBase = new ResultBase();
		Mockito.when(otDeletePointOfInterestCommand.deletePointOfInterest("123456")).thenReturn(resultBase);
		DeletePointOfResponse deletePointOfResponse = workorderServiceImpl.deletePointOfInterest(deletePointOfRequest);
		assertNotNull(deletePointOfResponse);
	}
	
	@Test
	public void testDeletePointOfInterestSite() throws Exception {
		DeletePointOfRequest deletePointOfRequest = new DeletePointOfRequest();
		deletePointOfRequest.setId("123456");
		ResultBase resultBase = new ResultBase();
		Mockito.when(otDeletePointOfInterestCommand.deletePointOfInterest("123456")).thenReturn(resultBase);
		DeletePointOfResponse deletePointOfResponse = workorderServiceImpl.deletePointOfInterest(deletePointOfRequest);
		assertNotNull(deletePointOfResponse);
	}
}
