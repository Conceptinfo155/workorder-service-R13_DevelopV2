package com.comcast.orion.workorder.command;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class GetWFXWorkOrderBySiteIdCommandTest {
	@InjectMocks
	private GetWFXWorkOrderBySiteIdCommand getWFXWorkOrderBySiteIdCommand;
		
	private ResponseEntity<String> responseEntity= new ResponseEntity<>(HttpStatus.OK);	
	
	private GetWorkorderBySiteIdResponse[] getWorkorderBySiteIdResponse;
	
	@Mock
	RestTemplate woRestTemplate;
	
	@Mock
	ObjectMapper objectMapper;
	
	@Mock
	ServiceUtil serviceUtil;
	
	@Before
	public void setUp() {
			}
	
	
	/*
	 * @Test public void testGetWFXWorkOrderBySiteId() throws
	 * OrionMiddlewareServiceException, JsonParseException, JsonMappingException,
	 * IOException { ReflectionTestUtils.setField(getWFXWorkOrderBySiteIdCommand,
	 * "getWorkorderBySiteIdUrl",
	 * "https://order1_2-qa.g1.app.cloud.comcast.net/workorders/"); JobLocation
	 * jobLocation= new JobLocation(); jobLocation.setAddrId("123"); for
	 * (GetWorkorderBySiteIdResponse
	 * getWorkorderBySiteIdResponse1:getWorkorderBySiteIdResponse) {
	 * getWorkorderBySiteIdResponse1 = new GetWorkorderBySiteIdResponse();
	 * getWorkorderBySiteIdResponse1.setJobLocation(jobLocation); }
	 * Mockito.when(serviceUtil.httpHeaders(anyString())).thenReturn(new
	 * HttpHeaders());
	 * Mockito.when(woRestTemplate.exchange(anyString(),eq(HttpMethod.GET),
	 * anyObject(), eq(String.class))).thenReturn(responseEntity);
	 * Mockito.when(objectMapper.readValue(anyString(),eq(
	 * GetWorkorderBySiteIdResponse[].class))).thenReturn(
	 * getWorkorderBySiteIdResponse); getWorkorderBySiteIdResponse =
	 * getWFXWorkOrderBySiteIdCommand.getWFXWorkorder("Test", "1234", "Test123",
	 * "12/10/20"); assertNull(getWorkorderBySiteIdResponse); }
	 */
	 

	@Test(expected = OrionMiddlewareServiceException.class)
	public void testGetWFXWorkorderHystrixFallback() throws OrionMiddlewareServiceException {
		Exception e = new Exception();
		getWFXWorkOrderBySiteIdCommand.getWFXWoBySiteHystrix("siteId", "authToken", "dispatcherStatusCd", "scheduleDate", e);
	}

}
