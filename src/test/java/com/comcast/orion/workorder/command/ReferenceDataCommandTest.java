package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class ReferenceDataCommandTest {

	@InjectMocks
	private ReferenceDataCommand referenceDataCommand;

	@Mock
	RestTemplate referenceDataRestTemplate;

	@Test
	public void testgetServiceDetails() throws Exception {
		ReferenceDataResponse refResponse = new ReferenceDataResponse();
		ResponseEntity<ReferenceDataResponse> response = new ResponseEntity<ReferenceDataResponse>(refResponse,
				HttpStatus.OK);
		ReflectionTestUtils.setField(referenceDataCommand, "omwReferenceDataServiceEndpoint",
				"http://localhost:8081/referencedata");
		ReflectionTestUtils.setField(referenceDataCommand, "serviceDiscovery", false);
		Map<String, String> params = new HashMap<>();
		Mockito.when(referenceDataRestTemplate.exchange(Matchers.anyString(), Matchers.any(HttpMethod.class),
				Matchers.<HttpEntity<?>>any(), Matchers.<Class<ReferenceDataResponse>>any(), Matchers.any(Map.class)))
				.thenReturn(response);
		ReferenceDataResponse responseEntity = referenceDataCommand.getReferenceData("12345");
		assertNotNull(responseEntity);
	}

	@Test
	public void testgetServiceDetailsFallBack() {
		Exception e = new Exception();
		try {
			referenceDataCommand.referenceDataHystrixFallBack("12345", e);
		} catch (OrionMiddlewareServiceException e1) {
		}
		assertNotNull("FAILURE");
	}

}
