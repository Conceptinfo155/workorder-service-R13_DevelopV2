package com.comcast.orion.workorder.config;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "ott")
public class OTEndpointConfig {

	private Map<String, Map<String, String>> customerType;

	public Map<String, Map<String, String>> getCustomerType() {
		return customerType;
	}

	public void setCustomerType(Map<String, Map<String, String>> customerType) {
		this.customerType = customerType;
	}



}
