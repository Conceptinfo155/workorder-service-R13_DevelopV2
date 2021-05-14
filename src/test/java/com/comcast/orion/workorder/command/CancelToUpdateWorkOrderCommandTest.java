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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class CancelToUpdateWorkOrderCommandTest {

	@InjectMocks
	private CancelWorkOrderCommand cancelUpdateWorkOrderCommand;
	
	@Mock
	RestTemplate cancelRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	ResponseEntity<UpdateWOResponse> responseEntity = null;
	
	@Test
	public void testCreateWorkOrder() throws Exception {
		UpdateWORequest updateWORequest= new UpdateWORequest();
		UpdateWOResponse response =new UpdateWOResponse();
		UpdateWorkorderResponse updateWorkorderResponse=new UpdateWorkorderResponse();
		updateWorkorderResponse.setResponse("SUCCESS");
		response.setUpdateWorkorderResponse(updateWorkorderResponse);
		responseEntity = new ResponseEntity<>(response, HttpStatus.OK);			
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(cancelRestTemplate.postForEntity(anyObject(),anyObject(), eq(UpdateWOResponse.class))).thenReturn(responseEntity);
		ReflectionTestUtils.setField(cancelUpdateWorkOrderCommand, "updateworkorderUrl", "https://orion-gateway-qa.u1.app.cloud.comcast.net/workorder/v2/updateworkorder/ORION-232323");
		response = cancelUpdateWorkOrderCommand.cancelWorkOrder(updateWORequest, "ORION-232323");
		assertNotNull(response);
	}
	
	
	@Test(expected = OrionMiddlewareServiceException.class)
	public void testCreateWorkOrderFallBack() throws Exception {
		UpdateWORequest updateWORequest= new UpdateWORequest();
		Exception e = new Exception();
		cancelUpdateWorkOrderCommand.cancelWorkOrderHystrixFallback(updateWORequest, "ORION-232323", e);
		assertNotNull("FAILURE");
	}
	
	
}
