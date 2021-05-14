package com.comcast.orion.workorder.utils;

import java.net.URI;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;


@Component
public class DiscoveryClientUtil {
	
	private final Logger logger = LoggerFactory.getLogger(DiscoveryClientUtil.class);
	
	@Autowired
	private DiscoveryClient discoveryClient;
	
	public String getUriFromEureka(String serviceName) throws OrionMiddlewareServiceException {
		logger.info("DiscoveryClientUtil::getUriFromEureka");
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
		URI uri = null;
		if (CollectionUtils.isEmpty(serviceInstances)) {
			logger.error("DiscoveryClientUtil::getUriFromEureka::No service instance found in Eureka for the service name {}", serviceName);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,
					"No service instance found in Eureka for the service name " + serviceName);

		}
		uri = serviceInstances.get(0).getUri();
		if (null == uri) {
			logger.error("DiscoveryClientUtil::getUriFromEureka::Failed to get URL from Eureka for the service name {}", serviceName);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,
					"Failed to get URL from Eureka for the service name " + serviceName);

		}
		logger.info("DiscoveryClientUtil::getUriFromEureka::serviceInstances >> {}", serviceInstances);
		return uri.toString();
	}
}
