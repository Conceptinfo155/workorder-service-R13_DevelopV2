package com.comcast.orion.workorder.command;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.SessionUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)

public class NewUpdateWorkOrderCommandTest {

	@InjectMocks
	private NewUpdateWorkOrderCommand nUpdateWorkOrderCommand;

	@Mock
	ServiceUtil serviceUtil;

	@Mock
	private WebSecAuthCommand authCommand;

	@Mock
	private ObjectMapper objectMapper;

	@Mock
	RestTemplate nWoRestTemplate;

	private ResponseEntity<String> resEntity = null;

	private ResponseEntity<WFXUpdateWorkOrderResponse> responseEntity;

	private WFXNewUpdateWorkOrderRequest wfxUpdateWorkOrderRequest;

	@Test
	public void testUpdateWorkOrder() throws OrionMiddlewareServiceException {
		wfxUpdateWorkOrderRequest = new WFXNewUpdateWorkOrderRequest();
		wfxUpdateWorkOrderRequest.setWFXDispatchLogin("login");

		WFXUpdateWorkOrderResponse wFXUpdateWorkOrderResponse = new WFXUpdateWorkOrderResponse();
		wFXUpdateWorkOrderResponse.setResponse("success");
		Map<String, String> authMap = new HashMap<>();
		authMap.put("access_token", "MTE4YWFmMGUtN2U0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4");
		SessionUtil.getAuthorization();
		responseEntity = new ResponseEntity<>(wFXUpdateWorkOrderResponse, HttpStatus.OK);
		Mockito.when(serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		resEntity = new ResponseEntity<String>(
				"{\"access_token\":\"eyJhbGciOiJSU\",\"token_type\":\"Bearer\",\"expires_in\":7199}", HttpStatus.OK);
		Mockito.when(authCommand.getAuthToken()).thenReturn(resEntity);
		try {
			Mockito.when(objectMapper.readValue(Mockito.anyString(), eq(Map.class))).thenReturn(authMap);
		} catch (IOException e) {
		}
		Mockito.when(nWoRestTemplate.postForEntity(anyString(), anyObject(), eq(WFXUpdateWorkOrderResponse.class)))
				.thenReturn(responseEntity);
		ResponseEntity<WFXUpdateWorkOrderResponse> response = nUpdateWorkOrderCommand
				.updateWorkorder(wfxUpdateWorkOrderRequest, "orderNumber");
		// assertNotNull(response);

	}

	@Test
	public void testUpdateWorkOrderFallBack() {
		Exception e = new Exception();
		try {
			nUpdateWorkOrderCommand.newUpdateWOHystrixFallback(wfxUpdateWorkOrderRequest, "orderNumber", e);
		} catch (OrionMiddlewareServiceException e1) {

		}
	}

}
