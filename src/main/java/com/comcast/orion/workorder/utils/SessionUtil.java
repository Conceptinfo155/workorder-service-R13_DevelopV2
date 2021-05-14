package com.comcast.orion.workorder.utils;

public class SessionUtil {

	private static String authorization = null;

	public static String getAuthorization() {
		return authorization;
	}

	public static void setAuthorization(String authorization) {
		SessionUtil.authorization = authorization;
	}

	

}
