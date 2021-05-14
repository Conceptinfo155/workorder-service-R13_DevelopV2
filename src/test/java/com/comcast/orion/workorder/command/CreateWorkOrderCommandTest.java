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
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class CreateWorkOrderCommandTest {

	@InjectMocks
	private CreateWorkOrderCommand createWorkOrderCommand;
		
	private ResponseEntity<WFXCreateWorkOrderRespone> responseEntity;
	
	@Mock
	RestTemplate woRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	
	private WFXCreateWorkOrderRequest WFXCreateWorkOrderRequest;
	
	@Test
	public void testCreateWorkOrder()  {		
		WFXCreateWorkOrderRequest WFXCreateWorkOrderRequest = new WFXCreateWorkOrderRequest();
		WFXCreateWorkOrderRequest.setWFXDispatchLogin("login");		
		WFXCreateWorkOrderRespone WFXCreateWorkOrderRespone = new WFXCreateWorkOrderRespone();
		
		responseEntity = new ResponseEntity<>(WFXCreateWorkOrderRespone, HttpStatus.OK);		
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
//		Mockito.when(workOrderPropertyConfig.getCreateWorkOrderUrl()).thenReturn("url");
		Mockito.when(woRestTemplate.exchange(anyString(), eq(HttpMethod.PUT),anyObject(), eq( WFXCreateWorkOrderRespone.class))).thenReturn(responseEntity);
		ResponseEntity<WFXCreateWorkOrderRespone> response = createWorkOrderCommand.createWorkorder(WFXCreateWorkOrderRequest,"orderNumber","auth");
		assertNotNull(response);
	}
	
	@Test
	public void testCreateWorkOrderFallBack(){
		Exception e = new Exception();
		try {
			createWorkOrderCommand.createWOHystrixFallback(WFXCreateWorkOrderRequest, "orderNumber","authToken", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}
	
	
}
