package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponseDetails;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class CancelAppointmentCommandTest {

	@InjectMocks
	private CancelAppointmentCommand cancelAppointmentCommand;
		
	private ResponseEntity<CancelAppointmentResponseDetails> responseEntity;
	
	@Mock
	RestTemplate scheduleRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	@Test
	public void testgetCancelAppointment() throws Exception {		
		CancelApmtRequest cancelApmtRequest = new CancelApmtRequest();
		CancelAppointmentResponseDetails cancelAppointmentResponseDetails=new CancelAppointmentResponseDetails();
		CancelAppointmentResponse cancelAppointmentResponse=new CancelAppointmentResponse();
		cancelAppointmentResponse.setMessage("SUCCESS");
		cancelAppointmentResponseDetails.setCancelAppointmentResponse(cancelAppointmentResponse);
		responseEntity = new ResponseEntity<>(cancelAppointmentResponseDetails, HttpStatus.OK);	
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(scheduleRestTemplate.postForEntity(anyString(), anyObject(), eq( CancelAppointmentResponseDetails.class))).thenReturn(responseEntity);
		cancelAppointmentResponseDetails = cancelAppointmentCommand.cancelAppointment(cancelApmtRequest);
		assertNotNull(cancelAppointmentResponseDetails);
	}
	
	@Test(expected = OrionMiddlewareServiceException.class)
	public void testCreateWorkOrderFallBack() throws Exception {
		Exception e = new Exception();
		CancelApmtRequest cancelApmtRequest = new CancelApmtRequest();	
		cancelAppointmentCommand.cancelAppointmentHystrixFallback(cancelApmtRequest, e);
		assertNotNull("FAILURE");
	}
	
	
}
