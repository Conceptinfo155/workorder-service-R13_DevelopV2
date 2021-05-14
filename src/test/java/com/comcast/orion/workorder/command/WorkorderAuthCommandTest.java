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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class WorkorderAuthCommandTest {
	
	@InjectMocks
	private WorkorderAuthCommand workorderAuthCommand;
	
	@Mock
	RestTemplate woRestTemplate;
	
	
	private ResponseEntity<String> responseEntity;
	
	@Test
	public void testWorkOrder()	{			
	   responseEntity = new ResponseEntity<String>("{\"token\":\"eyJhbGciOiJSU\",\"token_type\":\"Bearer\",\"expires_in\":7199}" 
				, HttpStatus.CREATED);
		
//		Mockito.when(workOrderPropertyConfig.getWfxOauthServerUrl()).thenReturn("url");
		Mockito.when(woRestTemplate.exchange(anyString(),eq(HttpMethod.GET), anyObject(),
				eq(String.class))).thenReturn(responseEntity);
		ResponseEntity<String> response = workorderAuthCommand.workorderLogin("operationname");
		assertNotNull(response);
	}
	
	@Test
	public void testWorkOrderFallBack() {
		Exception e = new Exception();
		try {
			workorderAuthCommand.woAuthHystrixFallback("createWorkOrder", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}
}
