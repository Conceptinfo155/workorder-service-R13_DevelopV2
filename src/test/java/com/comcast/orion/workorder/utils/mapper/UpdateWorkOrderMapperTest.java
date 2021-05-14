package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;



import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.domain.locationResponse.BillingDetailsInfo;
import com.comcast.orion.workorder.domain.locationResponse.CSGDetailsType;
import com.comcast.orion.workorder.domain.locationResponse.CSGMarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.CsgDetails;
import com.comcast.orion.workorder.domain.locationResponse.LegacyMarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.MarketInfo;
import com.comcast.orion.workorder.domain.locationResponse.PostalAddress;
import com.comcast.orion.workorder.domain.reschedule.request.Job;
import com.comcast.orion.workorder.domain.reschedule.request.JobCustomer;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.request.WorkOrder;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderRequest;

@RunWith(MockitoJUnitRunner.class)
public class UpdateWorkOrderMapperTest {

	private UpdateWorkOrderMapper updateWorkOrderMapper;

	@Before
	public void setUp() {
		updateWorkOrderMapper = Mappers.getMapper(UpdateWorkOrderMapper.class);

	}

	@Test
	public void testWorkOrderReqToWFXUpdateRequest() throws Exception {
		com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest wFXUpdateRequest = new com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest();
		UpdateWorkorderRequest workOrderRequest = new UpdateWorkorderRequest();
		workOrderRequest.setBusinessUnit("BusinessUnit");
		wFXUpdateRequest = updateWorkOrderMapper.workOrderReqToWFXUpdateRequest(workOrderRequest);
		assertNotNull(wFXUpdateRequest);
	}

	@Test
	public void testtoString() throws Exception {
		PostalAddress postalAddress = new PostalAddress();
		String addressLine1 = null;
		postalAddress.setHouseNumberPrefix("A1");
		postalAddress.setHouseNumber("4");
		postalAddress.setHouseNumberSuffix("Spring");
		postalAddress.setStreetPreDirection("WEST COAST");
		postalAddress.setStreetName("Conrad");
		postalAddress.setStreetSuffix("42");
		postalAddress.setStreetPostDirection("WEST");
		addressLine1 = updateWorkOrderMapper.toString(postalAddress);
		assertNotNull(addressLine1);
	}

	@Test
	public void testtoString1() throws Exception {
		MarketInfo marketInfo = new MarketInfo();
		String businessUnit = null;
		LegacyMarketInfo legacyMarketInfo = new LegacyMarketInfo();
		CSGMarketInfo cSGMarketInfo = new CSGMarketInfo();
		cSGMarketInfo.setAgent("Test");
		cSGMarketInfo.setCSGSystem("Test123");
		cSGMarketInfo.setPrinciple("Test");
		legacyMarketInfo.setCSGMarketInfo(cSGMarketInfo);
		marketInfo.setLegacyMarketInfo(legacyMarketInfo);
		//businessUnit = updateWorkOrderMapper.toString(marketInfo);
		//assertNotNull(businessUnit);
	}

	@Test
	public void testtoString2() throws Exception {
		BillingDetailsInfo billingDetailsInfo = new BillingDetailsInfo();
		String technicianArea = null;
		CsgDetails csgDetails = new CsgDetails();
		CSGDetailsType cSGDetailsType = new CSGDetailsType();
		cSGDetailsType.setTechnicianArea("test123");
		csgDetails.setCSGDetailsType(cSGDetailsType);
		billingDetailsInfo.setCsgDetails(csgDetails);
		//technicianArea = updateWorkOrderMapper.toString(billingDetailsInfo);
		//assertNotNull(technicianArea);
	}

	@Test
	public void testMaprequestToUpdateWORequest() throws Exception {
		RescheduleRequest rescheduleRequest = new RescheduleRequest();
		WorkOrder workOrder = new WorkOrder();
		Job job = new Job();
		job.setScheduleDate("19/9/2000");
		job.setTimeSlotCd("12:15");
		workOrder.setJob(job);
		JobCustomer jobCustomer = new JobCustomer();
		jobCustomer.setCustomerId("12345");
		jobCustomer.setEmailAddr("abc@abc.com");
		workOrder.setJobCustomer(jobCustomer);
		rescheduleRequest.setWorkOrder(workOrder);
		SiteResponse siteResponse = new SiteResponse();
		UpdateWORequest updateWORequest = new UpdateWORequest();
		updateWORequest = updateWorkOrderMapper.maprequestToUpdateWORequest(rescheduleRequest, siteResponse);
		assertNotNull(updateWORequest);
	}
}