package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import java.util.ArrayList;
import java.util.List;

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

import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.domain.vms.Service;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class VMSTnFeaturesCommandTest {
	@InjectMocks
	private VMSTnFeaturesCommand vmsTnFeaturesCommand;
	
	@Mock
	RestTemplate vmsRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	private ResponseEntity<DTTNFeaturesResponse> responseEntity;
	

	@Test
	public void testGetVMSTnFeatures() throws Exception {

		DTTNFeaturesResponse dtTNFeaturesResponse= new DTTNFeaturesResponse();
		Service service= new Service();
		service.setServiceID("1234");
		List<Service> services= new ArrayList<Service>();
		services.add(service);
		dtTNFeaturesResponse.setServices(services);
		responseEntity = new ResponseEntity<>(dtTNFeaturesResponse, HttpStatus.OK);			
		//Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(vmsRestTemplate.exchange(anyObject(), eq(HttpMethod.GET),anyObject(), eq( DTTNFeaturesResponse.class))).thenReturn(responseEntity);
		ReflectionTestUtils.setField(vmsTnFeaturesCommand, "vmsEndpoint", "https://localhost:8080/test/v1/");
		DTTNFeaturesResponse response = vmsTnFeaturesCommand.getVMSTnFeatures("designId");
		assertNotNull(responseEntity);
	}
	
	@Test
	public void testCreateWorkOrderFallBack() throws Throwable  {
		Exception e = new Exception();

		try {
			vmsTnFeaturesCommand.vmsTnFeaturesHystrixFallback("designId", e);
		} catch (OrionMiddlewareServiceException e1) {

		}
		assertNotNull("FAILURE");

	}
	
}
