package com.comcast.orion.workorder.utils.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;

public class OrionErrorCodeTest {

	@Test
	public void testToString() {
		OrionErrorCode errorCode = OrionErrorCode.BUS_AMIL_ERR;

		String result = errorCode.toString();

		assertEquals("OrionErrorCode{errorCode=BUS_AMIL_ERR, errorDescription='ERR003?workOrderId not found', httpStatus='590'}", result);
	}
	}


