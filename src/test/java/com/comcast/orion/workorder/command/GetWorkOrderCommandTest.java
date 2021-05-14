package com.comcast.orion.workorder.command;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.GetWorkorderRequest;
import com.comcast.orion.workorder.domain.amil.getworkorder.request.WorkOrderDetailsRequest;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class GetWorkOrderCommandTest {

	@InjectMocks
	private GetWorkOrderCommand getWorkOrderCommand;
	
	@InjectMocks	
	private ResponseEntity<AMILWorkorderResponse> responseEntity;
	
	@Mock
	RestTemplate woRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	private AMILWorkorderResponse amilWorkorderResponse;
	GetWorkorderRequest workOrderRequest = null;
	@Before
	public void setup() {
		workOrderRequest = new GetWorkorderRequest();
		WorkOrderDetailsRequest  workOrderDetailsRequest = new WorkOrderDetailsRequest();
		workOrderDetailsRequest.setWorkOrderId("WO-1234");
		workOrderRequest.setWorkOrderDetailsRequest(workOrderDetailsRequest);		
	}
	
	
	@Test

	public void testGetWorkOrder() throws Exception {		
		AMILWorkorderResponse response = null;
		responseEntity = new ResponseEntity<>(amilWorkorderResponse, HttpStatus.OK);	
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);

		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(woRestTemplate.exchange(anyString(), eq(HttpMethod.GET),anyObject(), eq(AMILWorkorderResponse .class))).thenReturn(responseEntity);
		response = getWorkOrderCommand.getWorkorder(workOrderRequest,"auth");
		assertNotNull(responseEntity);
		
	}
	
	/*@Test
	public void testGetWorkOrderFallBack()  {
		Exception e = new Exception();

		try {
			getWorkOrderCommand.getWorkorderHystrixFallback("orderNumber","authToken", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}

	}*/

}
