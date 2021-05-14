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

import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;



@RunWith(MockitoJUnitRunner.class)

public class UpdateWorkOrderCommandTest {
	
	@InjectMocks
	private UpdateWorkOrderCommand updateWorkOrderCommand;
	
	@Mock
	ServiceUtil serviceUtil;
	
	@Mock
	RestTemplate woRestTemplate;
	
	private ResponseEntity<WFXUpdateWorkOrderResponse> responseEntity;

	private WFXUpdateWorkOrderRequest wfxUpdateWorkOrderRequest;
	
	@Test
	public void testUpdateWorkOrder()  {
		wfxUpdateWorkOrderRequest=new WFXUpdateWorkOrderRequest();		
		wfxUpdateWorkOrderRequest.setWFXDispatchLogin("login");
		
		WFXUpdateWorkOrderResponse wFXUpdateWorkOrderResponse=new WFXUpdateWorkOrderResponse();
		wFXUpdateWorkOrderResponse.setResponse("success");
		
		responseEntity = new ResponseEntity<>(wFXUpdateWorkOrderResponse, HttpStatus.OK);		
		Mockito.when(serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
//		Mockito.when(workOrderPropertyConfig.getUpdateWorkOrderUrl()).thenReturn("url");
		Mockito.when(woRestTemplate.postForEntity(anyString(), anyObject(), eq(WFXUpdateWorkOrderResponse.class))).thenReturn(responseEntity);		
		ResponseEntity<WFXUpdateWorkOrderResponse> response=updateWorkOrderCommand.updateWorkorder( wfxUpdateWorkOrderRequest, "orderNumber", "authToken");			
		assertNotNull(response);
		
	}
	
	@Test
	public void testUpdateWorkOrderFallBack() {
		Exception e = new Exception();
		try {
			updateWorkOrderCommand.updateWOHystrixFallback(wfxUpdateWorkOrderRequest, "orderNumber","authToken", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}

}


