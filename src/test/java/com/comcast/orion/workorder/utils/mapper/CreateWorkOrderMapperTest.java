package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.domain.createwo.ChildProductsList;
import com.comcast.orion.workorder.domain.createwo.ChildProductsList.ActionCd;
import com.comcast.orion.workorder.domain.createwo.ChildProductsList.ProductLOB;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.Job.DispatcherStatusCd;
import com.comcast.orion.workorder.domain.createwo.Job.JobClassCd;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.createwo.JobProductList;
import com.comcast.orion.workorder.domain.locationResponse.BillingDetailsInfo;
import com.comcast.orion.workorder.domain.locationResponse.CSGDetailsType;
import com.comcast.orion.workorder.domain.locationResponse.CSGMarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.CsgDetails;
import com.comcast.orion.workorder.domain.locationResponse.LegacyMarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.MarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.PostalAddress;
@RunWith(MockitoJUnitRunner.class)
public class CreateWorkOrderMapperTest {

	private CreateWorkOrderMapper createWorkOrderMapper;
	private CreateWorkorderResponse createWorkorderResponse;
	private CreateWORequest createWORequest;
	private CreateWorkorderRequest createWorkorderRequest;

	@Before
	public void setUp(){
		createWorkOrderMapper = Mappers.getMapper(CreateWorkOrderMapper.class);
		
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
	}	

	@Test
	public void testWorkOrderReqToWFXCreateRequest() throws Exception {
		com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest wFXCreateWorkOrderRequest = new com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest();
		CreateWorkorderRequest workOrderRequest = new CreateWorkorderRequest();
		workOrderRequest.setBusinessUnit("BusinessUnit");
		wFXCreateWorkOrderRequest = createWorkOrderMapper.workOrderReqToWFXCreateRequest(workOrderRequest);
		assertNotNull(wFXCreateWorkOrderRequest);	
	}
	
	@Test
	public void testtoList() throws Exception {
		List<JobProductList> jobProductListVo= new ArrayList<JobProductList>();
		JobProductList jobProductLt= new JobProductList();
		List<ChildProductsList> childProductsList = new ArrayList<ChildProductsList>();
		ChildProductsList childProducts= new ChildProductsList();
		childProducts.setOutlet("test");
		childProducts.setSiteId("1234");
		childProducts.setActionCd(ActionCd.ADD);
		childProducts.setProductLOB(ProductLOB.C);
		childProducts.setVoicePhoneNum("98765432");
		childProducts.setQuantity(1);
		childProductsList.add(childProducts);		
		jobProductLt.setChildProductsList(childProductsList);
		jobProductLt.setActionCd(com.comcast.orion.workorder.domain.createwo.JobProductList.ActionCd.ADD);
		jobProductLt.setQuantity(1);
		jobProductLt.setProductLOB(com.comcast.orion.workorder.domain.createwo.JobProductList.ProductLOB.C);
		jobProductListVo.add(jobProductLt);
		List<com.comcast.orion.wfx.domain.workorder.JobProductList> jobProductList= new ArrayList<com.comcast.orion.wfx.domain.workorder.JobProductList>();
		jobProductList = createWorkOrderMapper.toList(jobProductListVo);
		assertNotNull(jobProductList);	
	}

	@Test
	public void testtoString() throws Exception {
		PostalAddress postalAddress = new PostalAddress ();
		String addressLine1=null;
		postalAddress.setHouseNumberPrefix("A1");
		postalAddress.setHouseNumber("4");
		postalAddress.setHouseNumberSuffix("Spring");
		postalAddress.setStreetPreDirection("WEST COAST");
		postalAddress.setStreetName("Conrad");
		postalAddress.setStreetSuffix("42");
		postalAddress.setStreetPostDirection("WEST");
		addressLine1 = createWorkOrderMapper.toString(postalAddress);
		assertNotNull(addressLine1);	
	}
	
	@Test
	public void testtoString1() throws Exception {
		MarketInfo marketInfo  = new MarketInfo ();
		String businessUnit=null;
		LegacyMarketInfo legacyMarketInfo= new LegacyMarketInfo();
		CSGMarketInfo cSGMarketInfo= new CSGMarketInfo();
		cSGMarketInfo.setAgent("Test");
		cSGMarketInfo.setCSGSystem("Test123");
		cSGMarketInfo.setPrinciple("Test");
		legacyMarketInfo.setCSGMarketInfo(cSGMarketInfo);
		marketInfo.setLegacyMarketInfo(legacyMarketInfo);
		//businessUnit = createWorkOrderMapper.toString(marketInfo);
		//assertNotNull(businessUnit);	
	}
	
	@Test
	public void testtoString2() throws Exception {
		BillingDetailsInfo billingDetailsInfo= new BillingDetailsInfo();
		String technicianArea=null;
		CsgDetails csgDetails = new CsgDetails();
		CSGDetailsType cSGDetailsType= new CSGDetailsType();
		cSGDetailsType.setTechnicianArea("test123");		
		csgDetails.setCSGDetailsType(cSGDetailsType);
		billingDetailsInfo.setCsgDetails(csgDetails);
		//technicianArea = createWorkOrderMapper.toString(billingDetailsInfo);
		//assertNotNull(technicianArea);	
	}
	@Test
	public void testJobProductListListToJobProductListList() throws Exception {				
		List<JobProductList> jobProductListVo= new ArrayList<JobProductList>();
		JobProductList jobProductLt= new JobProductList();
		List<ChildProductsList> childProductsList = new ArrayList<ChildProductsList>();
		ChildProductsList childProducts= new ChildProductsList();
		childProducts.setOutlet("test");
		childProducts.setSiteId("1234");
		childProducts.setActionCd(ActionCd.ADD);
		childProducts.setProductLOB(ProductLOB.C);
		childProducts.setVoicePhoneNum("98765432");
		childProducts.setQuantity(1);
		childProductsList.add(childProducts);	
		jobProductLt.setChildProductsList(childProductsList);		
		jobProductLt.setProductLOB(com.comcast.orion.workorder.domain.createwo.JobProductList.ProductLOB.C);
		jobProductLt.setActionCd(com.comcast.orion.workorder.domain.createwo.JobProductList.ActionCd.ADD);
		jobProductListVo.add(jobProductLt);
		List<com.comcast.orion.workorder.domain.nWFX.create.JobProductList> jobProductList= new ArrayList<com.comcast.orion.workorder.domain.nWFX.create.JobProductList>();
		jobProductList = createWorkOrderMapper.jobProductListListToJobProductListList(jobProductListVo);
		assertNotNull(childProductsList);	
	}
}