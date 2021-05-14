package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import com.comcast.orion.workorder.utils.SessionUtil;


import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.SessionUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class NewCreateWorkOrderCommandTest {

	@InjectMocks
	private NewCreateWorkOrderCommand nCreateWorkOrderCommand;
	
	@Mock
	private WebSecAuthCommand authCommand;
	
	@Mock
	private ObjectMapper objectMapper;
		
	private ResponseEntity<WFXCreateWorkOrderRespone> responseEntity;
	
	private ResponseEntity<String> resEntity = null;
	
	@Mock
	RestTemplate nWoRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	
	private WFXCreateWorkOrderRequest WFXCreateWorkOrderRequest;
	
	@Test
	public void testCreateWorkOrder() throws OrionMiddlewareServiceException  {		
		WFXCreateWorkOrderRequest WFXCreateWorkOrderRequest = new WFXCreateWorkOrderRequest();
		WFXCreateWorkOrderRequest.setWFXDispatchLogin("login");		
		WFXCreateWorkOrderRespone WFXCreateWorkOrderRespone = new WFXCreateWorkOrderRespone();
		Map<String, String> authMap = new HashMap<>();
		authMap.put("access_token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		SessionUtil.getAuthorization();
		responseEntity = new ResponseEntity<>(WFXCreateWorkOrderRespone, HttpStatus.OK);
		resEntity = new ResponseEntity<String>("{\"access_token\":\"eyJhbGciOiJSU\",\"token_type\":\"Bearer\",\"expires_in\":7199}",HttpStatus.OK);
		Mockito.when(authCommand.getAuthToken()).thenReturn(resEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(),eq(Map.class)))
					.thenReturn(authMap);
		} catch (IOException e) {
		}
		Mockito.when(nWoRestTemplate.exchange(anyString(), eq(HttpMethod.PUT),anyObject(), eq( WFXCreateWorkOrderRespone.class))).thenReturn(responseEntity);
		ResponseEntity<WFXCreateWorkOrderRespone> response = nCreateWorkOrderCommand.createWorkorder(WFXCreateWorkOrderRequest,"orderNumber");
		//assertNotNull(response);
	}
	
	@Test
	public void testCreateWorkOrderFallBack(){
		Exception e = new Exception();
		try {
			nCreateWorkOrderCommand.newCreateWOHystrixFallback(WFXCreateWorkOrderRequest, "orderNumber", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}
	
	
}
