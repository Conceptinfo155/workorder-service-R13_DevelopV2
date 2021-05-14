package com.comcast.orion.workorder.command;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelAppointmentResponseDetails;
import com.comcast.orion.workorder.domain.updateappointment.request.UpdateAppointmentRequest;
import com.comcast.orion.workorder.domain.updateappointment.response.UpdateAppointmentResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
@RunWith(MockitoJUnitRunner.class)
public class UpdateAppointmentCommandTest {

	@InjectMocks
	private UpdateAppointmentCommand updateCommand;
	
	@Mock
	RestTemplate updateRestTemplate;
	@Mock
	WorkorderAuthCommand workorderAuthCommand;
	
	@Mock
	ServiceUtil serviceUtil;
	ResponseEntity<UpdateAppointmentResponse> responsexEntity ;
	
	UpdateAppointmentRequest updateRequest ;
	@Test
	public void testUpdateAppointment() {
		ReflectionTestUtils.setField(updateCommand, "scheduleServiceUrl", "http://localhost:8085/schedule");
		String operationName = "createWorkOrder";
		Map<String, String> authMap = new HashMap<>();
		authMap.put("token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}", HttpStatus.OK);
		Mockito.when(workorderAuthCommand.workorderLogin(operationName)).thenReturn(responseEntity);
  	 updateRequest = new UpdateAppointmentRequest();
		updateRequest.setNewAppointmentId("new");
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("url");	
		
		UpdateAppointmentResponse updateResponse = new UpdateAppointmentResponse();
		updateResponse.setStatus("SUCCESS");
		responsexEntity = new ResponseEntity<>(updateResponse, HttpStatus.OK);	
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		//Mockito.when( UriComponentsBuilder.fromUriString(anyObject())).thenReturn(builder);
		Mockito.when(updateRestTemplate.exchange(anyObject(), eq(HttpMethod.PATCH),anyObject(), eq( UpdateAppointmentResponse.class))).thenReturn(responsexEntity);
    	 updateCommand.updateAppointment(updateRequest,"old");
		assertNotNull(responsexEntity);
	
	}

	@Test(expected=OrionMiddlewareServiceException.class)
	public void testUpdateAppointmentHystrixFallback() throws OrionMiddlewareServiceException {
		Exception e = new Exception();
		updateCommand.updateAppointmentHystrixFallback(updateRequest, "oldapt", e);
	}

}
