package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;

import java.util.ArrayList;
import java.util.List;

import com.comcast.orion.workorder.utils.WorkOrderConstants;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.reschedule.request.Appointment;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail;
import com.comcast.orion.workorder.domain.reschedule.request.WorkOrder;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.Address;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.BookAppointment;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.CreateWorkOrder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.Job;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.Job.TroubleCallIndicator;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.JobCustomer;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.JobLocation;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorder;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.ScheduleWorkorderRequest;
import com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo;
import com.comcast.orion.workorder.domain.siteResponse.SiteAddress;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;

@RunWith(MockitoJUnitRunner.class)
public class ScheduleWorkOrderMapperTest {

	private ScheduleWorkOrderMapper scheduleWorkOrderMapper;
	private ScheduleWorkorder scheduleWorkOrder;
	private ScheduleWorkorderRequest scheduleWorkorderRequest;
	private com.comcast.orion.workorder.domain.siteResponse.SiteResponse siteResponse;
	private com.comcast.orion.workorder.domain.sitev2.SiteResponse siteResponseV2;
	private GetWorkOrderRule rule;
	private String jobtype;
	private String quotapoints;

	@Before
	public void setUp(){
		scheduleWorkOrderMapper = Mappers.getMapper(ScheduleWorkOrderMapper.class);
		
		scheduleWorkOrder =new ScheduleWorkorder();
		scheduleWorkorderRequest=new ScheduleWorkorderRequest();
		BookAppointment bookAppointment=new BookAppointment();
		bookAppointment.setReservationId("12414");
		bookAppointment.setOptionId("1234");
		bookAppointment.setForceBookInd(true);
		scheduleWorkorderRequest.setBookAppointment(bookAppointment);
		CreateWorkOrder createWorkOrder=new CreateWorkOrder();
		Job job =new Job();
		job.setScheduleDate("12-21-2018");
		job.setTimeSlotCd("Z");
		job.setCallFirstPhoneNum("21");
		job.setJobComment("ORION");
		job.setOrderComment("ORION");
		job.setTroubleCallIndicator(TroubleCallIndicator.R);
		createWorkOrder.setJob(job);
		JobCustomer jobCustomer=new JobCustomer();
		jobCustomer.setCustomerId("235235");
		jobCustomer.setEmailAddr("124512");
		jobCustomer.setFirstName("orion");
		jobCustomer.setHomePhoneNum("124124");
		jobCustomer.setLastName("middleware");
		jobCustomer.setSiteId("234234");
		createWorkOrder.setJobCustomer(jobCustomer);
		JobLocation jobLocation=new JobLocation();
		Address address=new Address();
		address.setAddrLine1("abcde");
		address.setAddrLine2("efgh");
		address.setCity("PA");
		address.setState("PA");
		address.setZipCode("12412");
		jobLocation.setAddress(address);
		createWorkOrder.setJobLocation(jobLocation);
		List<com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail> solutionDetailList = new ArrayList<com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail>();
		com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail solutionDtl = new com.comcast.orion.workorder.domain.scheduleWorkOrder.SolutionDetail();
		solutionDtl.setOrderType("TC");
		solutionDtl.setSolutionType("BVE");
		solutionDetailList.add(solutionDtl);
		scheduleWorkorderRequest.setSolutionDetails(solutionDetailList);
		scheduleWorkorderRequest.setCreateWorkOrder(createWorkOrder);
		scheduleWorkOrder.setScheduleWorkorderRequest(scheduleWorkorderRequest);
		
		rule=new GetWorkOrderRule();
		rule.setJobTypeCd("M5");
		rule.setJobUnits("18");
		siteResponse=new com.comcast.orion.workorder.domain.siteResponse.SiteResponse();
		com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo locationIdentifierInfo=new com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo();
		locationIdentifierInfo.setELocId("1234");
		siteResponse.setLocationIdentifierInfo(locationIdentifierInfo);
		siteResponseV2 = new com.comcast.orion.workorder.domain.sitev2.SiteResponse();
		com.comcast.orion.workorder.domain.sitev2.LocationIdentifierInfo locationIdentifierInfoV2 = new com.comcast.orion.workorder.domain.sitev2.LocationIdentifierInfo();
		locationIdentifierInfoV2.setELocId("1234");
		siteResponseV2.setLocationIdentifierInfo(locationIdentifierInfoV2);
	}	

	@Test
	public void testScheduleWORequestToBookAppointmentRequest() throws Exception {

		BookApmtRequest bookApmtRequest= scheduleWorkOrderMapper.scheduleWORequestToBookAppointmentRequest(scheduleWorkOrder, "124343");
		assertNotNull(bookApmtRequest);	
	}
		
	@Test
	public void testSchWorkOrderReqToWFXCreateWorkOrderRequest() throws Exception {
		WFXCreateWorkOrderRequest wfxCreateWORequest =new WFXCreateWorkOrderRequest();
		wfxCreateWORequest.setWFXDispatchLogin("ORION");
		siteResponseV2.setLocationIdentifierInfo(null);
		Boolean scheduleSite =true;
		wfxCreateWORequest= scheduleWorkOrderMapper.workOrderReqToWFXCreateWorkOrderRequest(scheduleWorkorderRequest, siteResponseV2, rule);
		wfxCreateWORequest= scheduleWorkOrderMapper.schWorkOrderReqToWFXCreateWorkOrderRequest(scheduleWorkorderRequest, siteResponseV2, rule,scheduleSite,"C");
		assertNotNull(wfxCreateWORequest);	
	}
	
	@Test
	public void testSiteResponseToWorkOrderRequest() throws Exception {
		com.comcast.orion.workorder.domain.sitev2.SiteAddress siteAddress=new com.comcast.orion.workorder.domain.sitev2.SiteAddress();
		siteAddress.setAddressLine1("abcde");
		siteAddress.setAddressLine2("efgh");
		siteAddress.setCity("PA");
		siteAddress.setState("PA");
		siteAddress.setZipCode("124124");
		siteResponseV2.setSiteAddress(siteAddress);
		ScheduleWorkorder scheduleWorkorder= scheduleWorkOrderMapper.siteResponseToWorkOrderRequest(siteResponseV2);
		assertNotNull(scheduleWorkorder);	
	}

	@Test
	public void testRescheduleWOToWFXCreateWorkOrderRequest() throws Exception {
		jobtype="EY";
		quotapoints="18";
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		List<SolutionDetail> solutionDetails = new ArrayList<SolutionDetail>();
		SolutionDetail solutionDetail = new SolutionDetail();
		solutionDetail.setOrderType(WorkOrderConstants.ORDER_TYPE_TC);
		solutionDetail.setSolutionType("BVE");
		solutionDetails.add(solutionDetail);
		rescheduleRequest.setSolutionDetails(solutionDetails);
		Appointment appointment= new Appointment();
		appointment.setOptionId("1234");
		rescheduleRequest.setAppointment(appointment);
        GetWorkOrderRule rule = new GetWorkOrderRule(); 		
		SiteAddress siteAddress=new SiteAddress();
		siteAddress.setAddressLine1("abcde");
		siteAddress.setAddressLine2("efgh");
		siteAddress.setCity("PA");
		siteAddress.setState("PA");
		siteAddress.setZipCode("124124");
		siteResponse.setSiteAddress(siteAddress);
		LocationIdentifierInfo locationIdentifierInfo= new LocationIdentifierInfo();
		locationIdentifierInfo.setELocId("123456");
		siteResponse.setLocationIdentifierInfo(locationIdentifierInfo);
		
		CreateWORequest createWORequest= scheduleWorkOrderMapper.rescheduleWOToWFXCreateWorkOrderRequest(rescheduleRequest,jobtype,quotapoints,siteResponse);
		assertNotNull(createWORequest);	
	}
	
	@Test
	public void testConstructNewWOFailureResponse() throws Exception {
		String workOrderNumber="ORION-000000001079"; 
		String newWONumber="ORION-000000001080";
        String errorCode="500";
        String message="InternalServerError"; 
        String status="Failure";
		RescheduleWorkorderResponse rescheduleWorkorderResponse= scheduleWorkOrderMapper.constructNewWOFailureResponse(workOrderNumber,newWONumber,errorCode,message,status);
		assertNotNull(rescheduleWorkorderResponse);	
	}
	

	@Test
	public void testMapOptionalParametersForReschedule() throws Exception {
		RescheduleRequest rescheduleRequest= new RescheduleRequest(); 
		Appointment appointment= new Appointment();
		appointment.setOptionId("123");
		rescheduleRequest.setAppointment(appointment);
		WorkOrder workOrder= new WorkOrder();
		com.comcast.orion.workorder.domain.reschedule.request.Job job= new com.comcast.orion.workorder.domain.reschedule.request.Job();
		job.setJobComment("test");
		workOrder.setJob(job);
		rescheduleRequest.setWorkOrder(workOrder);
		String optionId="1234"; 
		String reservationId="243553";
		String scheduleDate="1342432";
		String timeSlotCd="4364576";
		       
		scheduleWorkOrderMapper.mapOptionalParametersForReschedule(rescheduleRequest, optionId, reservationId,scheduleDate, timeSlotCd);
		assertNotNull(rescheduleRequest);	
	}
	
	@Test
	public void testmapOptionalParametersForSchedule() throws Exception {
		ScheduleWorkorderRequest scheduleWorkorderRequest= new ScheduleWorkorderRequest(); 
		com.comcast.orion.workorder.domain.scheduleWorkOrder.BookAppointment appointment= new com.comcast.orion.workorder.domain.scheduleWorkOrder.BookAppointment();
		appointment.setOptionId("123");
		scheduleWorkorderRequest.setBookAppointment(appointment);
		CreateWorkOrder createWorkOrder= new CreateWorkOrder();
		com.comcast.orion.workorder.domain.scheduleWorkOrder.Job job= new com.comcast.orion.workorder.domain.scheduleWorkOrder.Job();
		job.setJobComment("test");
		createWorkOrder.setJob(job);
		scheduleWorkorderRequest.setCreateWorkOrder(createWorkOrder);
		String optionId="1234"; 
		String reservationId="243553";
		String scheduleDate="1342432";
		String timeSlotCd="4364576";
		       
		scheduleWorkOrderMapper.mapOptionalParametersForSchedule(scheduleWorkorderRequest, optionId, reservationId,scheduleDate, timeSlotCd);
		assertNotNull(scheduleWorkorderRequest);	
	}
	
	
}
