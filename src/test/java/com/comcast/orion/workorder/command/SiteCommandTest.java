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
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class SiteCommandTest {

	@InjectMocks
	private SiteCommand siteCommand;
	
	@Mock
	RestTemplate siteRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	private ResponseEntity<SiteResponse> responseEntity;
	

	@Test
	public void testCreateWorkOrder() throws Exception {

		SiteResponse siteResponse= new SiteResponse();
		siteResponse.setSiteId("52235");
		responseEntity = new ResponseEntity<>(siteResponse, HttpStatus.OK);			
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(siteRestTemplate.exchange(anyObject(), eq(HttpMethod.GET),anyObject(), eq( SiteResponse.class))).thenReturn(responseEntity);
		ReflectionTestUtils.setField(siteCommand, "siteEndpoint", "https://orion-gateway-qa.u1.app.cloud.comcast.net/site/v1/");
		SiteResponse response = siteCommand.getSiteDetail("124124", "cancelworkorder");
		assertNotNull(response);
	}
	
	@Test
	public void testCreateWorkOrder1() throws Exception {
		SiteResponse siteResponse= new SiteResponse();
		siteResponse.setSiteId("52235");
		responseEntity = new ResponseEntity<>(siteResponse, HttpStatus.OK);			
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(siteRestTemplate.exchange(anyObject(), eq(HttpMethod.GET),anyObject(), eq( SiteResponse.class))).thenReturn(responseEntity);
		ReflectionTestUtils.setField(siteCommand, "siteEndpoint", "https://orion-gateway-qa.u1.app.cloud.comcast.net/site/v1/");
		SiteResponse response = siteCommand.getSiteDetail("124124", "scheduleworkorder");
		assertNotNull(response);
	}
	
	@Test
	public void testCreateWorkOrderFallBack()  {
		Exception e = new Exception();

		try {
			siteCommand.siteHystrixFallback("235235","site", e);
		} catch (OrionMiddlewareServiceException e1) {

		}
		assertNotNull("FAILURE");

	}
	
	
}
