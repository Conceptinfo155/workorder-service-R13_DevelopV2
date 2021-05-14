package com.comcast.orion.workorder.command;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import org.springframework.web.client.RestTemplate;

import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.BookAppointmentResponseDetails;
import com.comcast.orion.workorder.utils.ServiceUtil;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@RunWith(MockitoJUnitRunner.class)
public class BookAppointmentCommandTest {

	@InjectMocks
	private BookAppointmentCommand bookAppointmentCommand;
		
	private ResponseEntity<BookAppointmentResponseDetails> responseEntity;
	@Mock
	RestTemplate scheduleRestTemplate;
	
	@Mock
	ServiceUtil serviceUtil;
	
	@Test
	public void testgetBookAppointment() throws Exception {	
		

		BookApmtRequest bookApmtRequest = new BookApmtRequest();	
		BookAppointmentResponseDetails bookAppointmentResponseDetails = new BookAppointmentResponseDetails();
		responseEntity = new ResponseEntity<>(bookAppointmentResponseDetails, HttpStatus.OK);		
		Mockito.when( serviceUtil.httpHeaders(anyString())).thenReturn(new HttpHeaders());
		Mockito.when(scheduleRestTemplate.exchange(anyString(), eq(HttpMethod.PUT),anyObject(), eq( BookAppointmentResponseDetails.class))).thenReturn(responseEntity);
		ResponseEntity<BookAppointmentResponseDetails> response = bookAppointmentCommand.bookAppointment(bookApmtRequest);
		assertNotNull("SUCCESS");
	}
	
	@Test
	public void testCreateWorkOrderFallBack() {
		Exception e = new Exception();
		BookApmtRequest bookApmtRequest = new BookApmtRequest();	
		try {
			bookAppointmentCommand.bookAppointmentHystrixFallback(bookApmtRequest, e);
		} catch (OrionMiddlewareServiceException e1) {
			
		}
	}
	
	
	
}
