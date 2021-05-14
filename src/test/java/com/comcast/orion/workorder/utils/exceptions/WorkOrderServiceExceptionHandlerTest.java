package com.comcast.orion.workorder.utils.exceptions;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.comcast.orion.workorder.controller.WorkorderController;

public class WorkOrderServiceExceptionHandlerTest {

	@InjectMocks
	WorkOrderServiceExceptionHandler workOrderServiceExceptionHandler;

	@InjectMocks
	WorkorderController workorderController;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);

	}

//	@Test
//	public void testHandleMethodArgumentNotValid(){
//		MethodArgumentNotValidException ex = new MethodArgumentNotValidException(new MethodParameter(Object.class.getMethods()[0], 1), new BindException(new BeanPropertyBindingResult(new Object(), "")));
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		headers.set("Accept", "application/json");
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		WebRequest request = null;
//		MDC.put("operationName", "updatestatus");
//		ResponseEntity<Object> responseEntity = workOrderServiceExceptionHandler.handleMethodArgumentNotValid(ex, headers, status, request);
//		assertNotNull(responseEntity.getBody());
//	}

	/*
	 * @Test public void testHandleHttpMessageNotReadable() {
	 * HttpMessageNotReadableException exception = new
	 * HttpMessageNotReadableException("testData"); HttpHeaders headers = new
	 * HttpHeaders(); headers.setContentType(MediaType.APPLICATION_JSON);
	 * headers.set("Accept", "application/json"); HttpStatus status =
	 * HttpStatus.BAD_REQUEST; WebRequest request = null; ResponseEntity<Object>
	 * responseEntity =
	 * workOrderServiceExceptionHandler.handleHttpMessageNotReadable(exception,
	 * headers,status,request); assertNotNull(responseEntity); }
	 */

}
