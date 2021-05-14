package com.comcast.orion.workorder.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * OdsPropertyConfig
 *
 */
@Component
@ConfigurationProperties(prefix="ods")
@Configuration
@RefreshScope
public class OdsPropertyConfig {

	private Map<String, String> odsCustomerType;

	private Map<String, String> displayServiceType;
	
	private Map<String, String> serviceType;
	

	public Map<String, String> getServiceType() {
		return serviceType;
	}

	public void setServiceType(Map<String, String> serviceType) {
		this.serviceType = serviceType;
	}

	public Map<String, String> getOdsCustomerType() {
		return odsCustomerType;
	}

	public void setOdsCustomerType(Map<String, String> odsCustomerType) {
		this.odsCustomerType = odsCustomerType;
	}

	public Map<String, String> getDisplayServiceType() {
		return displayServiceType;
	}

	public void setDisplayServiceType(Map<String, String> displayServiceType) {
		this.displayServiceType = displayServiceType;
	}

	

	

}
