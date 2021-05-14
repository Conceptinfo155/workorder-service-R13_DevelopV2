package com.comcast.orion.workorder.command;

import static org.junit.Assert.*;
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
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.GetWorkOrderWFXResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
@RunWith(MockitoJUnitRunner.class)
public class GetWFXWorkOrderCommandTest {
	@InjectMocks
	private GetWFXWorkOrderCommand getWorkOrderCommand;
		
	private ResponseEntity<GetWorkOrderWFXResponse> responseEntity;
	
	@Mock
	RestTemplate woRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	@Before
	public void setUp() {
		ReflectionTestUtils.setField(getWorkOrderCommand, "getWorkOrderUrl", "https://order1_2-qa.g1.app.cloud.comcast.net/workorders/");
	}
	
	@Test
	public void testGetWFXWorkorder() {
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(woRestTemplate.exchange(anyString(), eq(HttpMethod.GET),anyObject(), eq( GetWorkOrderWFXResponse.class))).thenReturn(responseEntity);
		ResponseEntity<GetWorkOrderWFXResponse> response = getWorkOrderCommand.getWFXWorkorder("WO-4567", "appl");
		assertNull(response);
	}

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGetWFXWorkorderHystrixFallback() throws OrionMiddlewareServiceException {
		Exception e = new Exception();
		getWorkOrderCommand.getWFXWOHystrix("orderNumber", "authToken", e);
	}

}
