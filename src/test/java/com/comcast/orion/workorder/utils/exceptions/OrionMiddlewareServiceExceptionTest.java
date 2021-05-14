package com.comcast.orion.workorder.utils.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class OrionMiddlewareServiceExceptionTest {

	@Test
	public void testGetErrorMessage() {
		OrionMiddlewareServiceException errorResponse = new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_WFX, "");

		String result = errorResponse.getErrorMessage();
		int result1 = errorResponse.getHttpStatus();

		assertEquals("", result);
		assertEquals(590, result1);
	}

}
