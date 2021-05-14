package com.comcast.orion.workorder.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * ErrorPropertyConfig
 *
 */
@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("")
public class ErrorPropertyConfig {

	/**
	 * cwo
	 */
	private final Map<String, String> cwo = new HashMap<>();
	
	
	/**
	 * uwo
	 */
	private final Map<String, String> uwo = new HashMap<>();

	/**
	 * @return cwo
	 */
	public Map<String, String> getCwo() {
		return cwo;
	}

	/**
	 * @return uwo
	 */
	public Map<String, String> getUwo() {
		return uwo;
	}

}
