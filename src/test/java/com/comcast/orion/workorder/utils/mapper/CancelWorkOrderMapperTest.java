package com.comcast.orion.workorder.utils.mapper;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.runners.MockitoJUnitRunner;

import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;

@RunWith(MockitoJUnitRunner.class)
public class CancelWorkOrderMapperTest {

	private CancelWorkOrderMapper cancelWorkOrderMapper;
	private com.comcast.orion.workorder.domain.siteResponse.SiteResponse siteResponse;


	@Before
	public void setUp(){
		cancelWorkOrderMapper = Mappers.getMapper(CancelWorkOrderMapper.class);
		siteResponse=new com.comcast.orion.workorder.domain.siteResponse.SiteResponse();
		com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo locationIdentifierInfo=new com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo();
		locationIdentifierInfo.setELocId("1234");
		siteResponse.setLocationIdentifierInfo(locationIdentifierInfo);

	}	

	@Test
	public void testCancelWOReqToWFXUpdateWorkOrderRequest() throws Exception {

		UpdateWORequest updateWORequest= cancelWorkOrderMapper.cancelWOReqToWFXUpdateWorkOrderRequest(siteResponse, null);
		assertNotNull(updateWORequest);	
	}
	
	@Test
	public void testScheduleWORequestToCancelAppointmentRequest() throws Exception {

		CancelApmtRequest cancelApmtRequest= cancelWorkOrderMapper.scheduleWORequestToCancelAppointmentRequest("ORION-12345");
		assertNotNull(cancelApmtRequest);	
	}

}