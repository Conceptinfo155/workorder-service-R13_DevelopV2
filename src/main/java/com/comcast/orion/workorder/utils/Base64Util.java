package com.comcast.orion.workorder.utils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64Util {

	private Base64Util() {
	}
 
	// Encode value using BASE64
	public static String encode(String value) throws Exception {
		byte[] encodedValue = value.getBytes(StandardCharsets.UTF_8);
		return Base64.getEncoder().encodeToString(encodedValue);
	}

	// Decode value using BASE64
	public static String decode(String value) throws Exception {
		byte[] decodedValue = Base64.getDecoder().decode(value);
		return new String(decodedValue, StandardCharsets.UTF_8);
	}

}
