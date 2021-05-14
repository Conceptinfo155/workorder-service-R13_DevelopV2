package com.comcast.orion.workorder.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;

import com.comcast.orion.workorder.domain.cancelworkorder.CancelWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWOResponse;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.Job.DispatcherStatusCd;
import com.comcast.orion.workorder.domain.createwo.Job.JobClassCd;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getfutureworkorder.FutureWorkorderResponse;
import com.comcast.orion.workorder.domain.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.getworkorder.WorkOrderDetails;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.pointofinterest.request.DeletePointOfRequest;
import com.comcast.orion.workorder.domain.pointofinterest.response.DeletePointOfResponse;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.service.WordorderService;
import com.comcast.orion.workorder.utils.CreateWOValidation;
import com.comcast.orion.workorder.utils.ValidationUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.exceptions.ValidationException;

@RunWith(MockitoJUnitRunner.class)
public class WorkorderControllerTest {

	@InjectMocks
	private WorkorderController workorderController;

	@Mock
	Logger logger;

	@Mock
	WordorderService workorderService;
	
	@Mock
	ValidationUtil validationUtil;
	
	@Mock
	CreateWOValidation woValidation;

	private CreateWORequest createWORequest;

	private CreateWorkorderResponse createWorkorderResponse;

	private CreateWorkorderRequest createWorkorderRequest;
	private UpdateWorkorderResponse updateWorkorderResponse;
	private UpdateWORequest updateWORequest;
	private UpdateWorkorderRequest updateWorkorderRequest;
	private CancelWorkorderResponse cancelWorkorderResponse;

	 private WorkorderResponse workorderResponse ;

	@Before
	public void setUp() throws Exception {
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
		jobCustomer.setLastName("Doe");
		jobLocation.setAddress(address);
		jobLocation.setAddrId("205192378");
		//com.comcast.orion.workorder.domain.createwo.JobProductList jobProductList = new com.comcast.orion.workorder.domain.createwo.JobProductList();
		
		
		createWorkorderRequest.setJobCustomer(jobCustomer);
		createWorkorderRequest.setJobLocation(jobLocation);
		createWorkorderRequest.setWfxDispatchLogin("ORION");
		createWORequest = new CreateWORequest();
		createWORequest.setCreateWorkorderRequest(createWorkorderRequest);
		createWorkorderResponse = new CreateWorkorderResponse();
		createWorkorderResponse.setResponse("Successfully created WorkOrder");
		createWorkorderResponse.setWorkOrderNum("ORION-1111113453000");

		updateWorkorderRequest = new UpdateWorkorderRequest();
		
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
		
		updateWorkorderRequest.setJob(updatewoJob);
		updateWorkorderRequest.setJobCustomer(updatewoJobCustomer);
		updateWorkorderRequest.setJobLocation(updatewoJobLocation);
		updateWorkorderRequest.setWfxDispatchLogin("ORION");
		updateWORequest = new UpdateWORequest();

		updateWORequest.setUpdateWorkorderRequest(updateWorkorderRequest);
		updateWorkorderResponse = new UpdateWorkorderResponse();
		updateWorkorderResponse.setResponse("test");
		updateWorkorderResponse.setWorkOrderNum("ORION-11111134530");
		
		WorkOrderDetails workorderDetails = new WorkOrderDetails();
		workorderDetails.setCustomerId("929978670");
		workorderDetails.setSiteId("929978670");
		workorderDetails.setAgreementId("IFrameworkAgreementID_00110");
		workorderDetails.setWorkOrderId("ORION-0000000000001079");
		Equipment equipment = new Equipment();
		equipment.setAction("Add");
		equipment.setArmObjectName("10012");
		equipment.setServiceId("EQP17686578");
		equipment.setEquipmentType( "Comcast Business Router");
		List<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(equipment);		
		workorderDetails.setEquipment(equipmentList);
		workorderResponse = new WorkorderResponse();
		
		workorderResponse.setWorkOrderDetails(workorderDetails);
		
	}

	@Test
	public void testCreateWorkorder() {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		try {
			Mockito.doNothing().when(woValidation).validateCreateWorkOrderRequest(Mockito.anyObject());
		} catch (OrionMiddlewareServiceException e1) {	
		}
		try {
			Mockito.when(workorderService.createWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString(),
					Mockito.anyString())).thenReturn(createWorkorderResponse);
		} catch (OrionMiddlewareServiceException e) {		
		}
		ResponseEntity<CreateWOResponse> responseEntity = null;
		try {
			responseEntity = workorderController.createWorkorder(httpRequest,
					createWORequest, "ORION-1111113453000", "1234", httpResponse);
		} catch (OrionMiddlewareServiceException e) {		
		}
		CreateWOResponse createWOResponse = responseEntity.getBody();
		assertEquals(createWOResponse.getCreateWorkorderResponse().getWorkOrderNum(),this.createWorkorderResponse.getWorkOrderNum());
	}

	
	
	@Test
	public void testGetWorkOrder() {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		try {
			Mockito.when(workorderService.getWorkOrderDetails(Mockito.anyObject(), Mockito.anyString(),Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(workorderResponse);
		} catch (OrionMiddlewareServiceException e) {
			
		}
		ResponseEntity<WorkorderResponse> responseEntity = null;
		try {
			responseEntity = workorderController.getWorkorderDetails(httpRequest,"1234", "6566", "6665", "6771", "token", "124", httpResponse);
		} catch (ValidationException e) {
			
		} catch (OrionMiddlewareServiceException e) {
			
		}
		WorkorderResponse workOrderResponse = responseEntity.getBody();
		assertNotNull(workOrderResponse.getWorkOrderDetails().getWorkOrderId());
	}
	
	@Test

	public void testGetWorkOrderOrderNumber() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		Mockito.when(workorderService.getWorkOrderDetails(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString(), Mockito.anyString())).thenReturn(workorderResponse);
		ResponseEntity<WorkorderResponse> responseEntity = workorderController.getWorkorderDetails(httpRequest,"1234", "6566", "6665", "6771", "token", "124", httpResponse);
		assertNotNull(responseEntity);


	}
	
	
	
	@Test
	public void updateWorkorder(){
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		try {
			Mockito.when(workorderService.updateWorkorder(Mockito.anyObject(), Mockito.anyString(), Mockito.anyString(),
					Mockito.anyString())).thenReturn(updateWorkorderResponse);
		} catch (OrionMiddlewareServiceException e) {
			
		}
		try {
			Mockito.doNothing().when(validationUtil).validateUpdateWORequest(Mockito.anyObject());
		} catch (ValidationException e) {
			
		}		
		ResponseEntity<UpdateWOResponse> responseEntity = null;
		try {
			responseEntity = workorderController.updateWorkorder(httpRequest,
					 updateWORequest, "ORION-11111134530", "1234", httpResponse);
		} catch (ValidationException | OrionMiddlewareServiceException e) {
			
		}
		UpdateWOResponse updateWorkorderResponseDetails = responseEntity.getBody();
		assertEquals(updateWorkorderResponseDetails.getUpdateWorkorderResponse().getWorkOrderNum(),
				this.updateWorkorderResponse.getWorkOrderNum());
	}
	
	@Test
	public void testscheduleWorkorder() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		ScheduleWorkorder request =new ScheduleWorkorder();
		ScheduleWorkorderResponse scheduleWorkorderResponse=new ScheduleWorkorderResponse();
		Mockito.when(workorderService.scheduleWorkorder(Mockito.anyObject())).thenReturn(scheduleWorkorderResponse);
		ResponseEntity<ScheduleWorkorderResponse> responseEntity = workorderController.scheduleWorkorder(httpRequest, request, "141424", httpResponse);
		assertNotNull(responseEntity);
	}
	/**
	 * testreScheduleWorkorder
	 */
	@Test
	public void testreScheduleWorkorder() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		RescheduleRequest rescheduleRequest= new RescheduleRequest();
		RescheduleWorkorderResponse rescheduleWorkorderResponse=new RescheduleWorkorderResponse();
		Mockito.when(workorderService.reschdeuleWorkOrder(Mockito.anyObject(),any())).thenReturn(rescheduleWorkorderResponse);
		ResponseEntity<RescheduleWorkorderResponse> responseEntity = workorderController.reScheduleAppointment(httpRequest, "1234", rescheduleRequest, "test", httpResponse);
		assertNotNull(responseEntity);
	}
	/**
	 * testgetWFXWorkorder
	 */
	@Test
	public void testgetWFXWorkorder() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		GetWorkorderOMWResponse getWorkorderOMWResponse=new GetWorkorderOMWResponse();
		Mockito.when(workorderService.getWFXWorkOrder(any())).thenReturn(getWorkorderOMWResponse);
		ResponseEntity<GetWorkorderOMWResponse> responseEntity = workorderController.getWFXWorkorder(httpRequest, "1234","test", httpResponse);
		assertNotNull(responseEntity);
	}
	/**
	 * testgetWorkOrderBySiteId
	 */
	@Test
	public void testgetWorkOrderBySiteId() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		GetWorkorderBySiteIdResponse[] getWorkorderBySiteIdResponse=null;
		Mockito.when(workorderService.getWorkOrderBySiteId(any(),any(),any())).thenReturn(getWorkorderBySiteIdResponse);
		ResponseEntity<GetWorkorderBySiteIdResponse[]> responseEntity = workorderController.getWorkOrderBySiteId(httpRequest, "1234","JOB","19/12/2016","test123", httpResponse);
		assertNotNull(responseEntity);
	}
	/**
	 * testcancelWorkOrder
	 */
	@Test
	public void testcancelWorkOrder() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		cancelWorkorderResponse = new CancelWorkorderResponse();
		cancelWorkorderResponse.setStatus("SUCCESS");
		Mockito.when(workorderService.cancelWorkOrder(Mockito.anyString(), Mockito.anyString(), eq(false), Mockito.anyString())).thenReturn(cancelWorkorderResponse);	
		ResponseEntity<CancelWorkorderResponse> responseEntity = workorderController.cancelWorkOrder(httpRequest, "ORION-11111134530", "141424", false,"CD", "1234", httpResponse);
		assertNotNull(responseEntity);
	}
	
	/**
	 * testgetWorkOrderBySiteId
	 */
	@Test
	public void testgetFutureWorkOrderBySiteId() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		FutureWorkorderResponse getWorkorderBySiteIdResponse=null;
		Mockito.when(workorderService.getFutureWorkOrderBySiteId(any())).thenReturn(getWorkorderBySiteIdResponse);
		ResponseEntity<FutureWorkorderResponse> responseEntity = workorderController.getFutureWorkorderDetails(httpRequest, "O_site87111", "BHB11221", httpResponse);
		assertNotNull(responseEntity);
	}
	
	/**
	 * testDeletePointOfInterest
	 */
	@Test
	public void testDeletePointOfInterest() throws Exception {
		HttpServletRequest httpRequest = null;
		HttpServletResponse httpResponse = null;
		DeletePointOfResponse deletePointOfResponse=new DeletePointOfResponse();
		DeletePointOfRequest deletePointOfRequest = new DeletePointOfRequest();
		deletePointOfRequest.setId("123456");
		Mockito.when(workorderService.deletePointOfInterest(deletePointOfRequest)).thenReturn(deletePointOfResponse);
		ResponseEntity<DeletePointOfResponse> responseEntity = workorderController.deletePointOfInterest(httpRequest, deletePointOfRequest, "123456", httpResponse);
		assertNotNull(responseEntity);
	}

}
