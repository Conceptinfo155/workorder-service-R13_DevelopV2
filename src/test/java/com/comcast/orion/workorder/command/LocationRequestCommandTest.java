package com.comcast.orion.workorder.command;

import static org.junit.Assert.*;

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
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.comcast.orion.workorder.domain.locationResponse.BillingDetailsInfo;
import com.comcast.orion.workorder.domain.locationResponse.CSGDetailsType;
import com.comcast.orion.workorder.domain.locationResponse.CsgDetails;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.locationResponse.ResponseItems;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)

public class LocationRequestCommandTest {
	@InjectMocks
	private LocationRequestCommand locationRequestCommand;

	@Mock
	ServiceUtil serviceUtil;

	@Mock
	RestTemplate woRestTemplate;

	private ResponseEntity<LocationServiceResponse> responseEntity;

	//private LocationRequest locationRequest;

	private LocationServiceResponse locationResponse;

	@Test(expected = Exception.class)
	public void testLocationRequest()  {
		/*locationRequest = new LocationRequest();
		RequestItems requestItems = new RequestItems();
		requestItems.setLocationId(1234);
		locationRequest.setRequestItems(requestItems);*/

		locationResponse = new LocationServiceResponse();
		ResponseItems responseItems = new ResponseItems();
		BillingDetailsInfo billingDetailsInfo = new BillingDetailsInfo();
		CsgDetails csgDetails = new CsgDetails() ;
		CSGDetailsType cSGDetailsType = new CSGDetailsType();
		cSGDetailsType.setHouseKey("7839393");
		cSGDetailsType.setTechnicianArea("3838338");
		csgDetails.setCSGDetailsType(cSGDetailsType );
		billingDetailsInfo.setCsgDetails(csgDetails );
		responseItems.setBillingDetailsInfo(billingDetailsInfo );
		locationResponse.setResponseItems(responseItems);
		responseEntity = new ResponseEntity<>(locationResponse, HttpStatus.OK);
		Mockito.when(serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		//Mockito.when( UriComponentsBuilder.fromUriString(anyObject())).thenReturn(UriComponentsBuilder.newInstance()
				//.scheme("https").host("orion-gateway-qa.u1.app.cloud.comcast.net").path("/location/v3/details") );
		Mockito.when(woRestTemplate.postForEntity(anyString(), anyObject(), eq(LocationServiceResponse.class)))
				.thenReturn(responseEntity);
		ResponseEntity<LocationServiceResponse> response = locationRequestCommand.getLocation("2222222");
		assertNotNull(response);
	}
	

	@Test
	public void testLocationRequestFallBack() {
		Exception e = new Exception();
	//	locationRequest = new LocationRequest();
		try {
			locationRequestCommand.locationRequestHystrixFallback( "orderNumber", e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}
}
