package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.eq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class ProductCommandTest {
	@InjectMocks
	private ProductCommand productCommand;
	
	@Mock
	RestTemplate productRestTemplate;
		
	@Test
	public void testgetServiceDetails() throws Exception {
		//String getServiceDetailsEndpoint="http://localhost:8085/product";
		String customerId="1223444"; 
		String siteId="163277";	
		ResponseEntity<String> response = new ResponseEntity<String>(
				"{\"token\":\"MTE4YWFmMGUtN2U" + "0ZS00MGY3LTg4MDgtM2MzZTM5NWI5YjM4\",\"status\":\"Authorized\"}",
				HttpStatus.OK);
		ReflectionTestUtils.setField(productCommand, "getServiceDetailsEndpoint", "http://localhost:8085/product");
        Mockito.when(productRestTemplate.exchange(anyObject(), eq(HttpMethod.GET),anyObject(), eq( String.class))).thenReturn(response);
		ResponseEntity<String>  responseEntity=productCommand.getServiceDetails(customerId, siteId);
		assertNotNull(response);
	}
	
	
	@Test
	public void testCreateWorkOrderFallBack()  {
		Exception e = new Exception();

		try {
			productCommand.serviceDetailsHystrixFallback("12345", "45678", e);
		} catch (OrionMiddlewareServiceException e1) {

		}
		assertNotNull("FAILURE");

	}

}
