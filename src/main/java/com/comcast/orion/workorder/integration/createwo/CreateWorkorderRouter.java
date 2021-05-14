package com.comcast.orion.workorder.integration.createwo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class CreateWorkorderRouter {

	private static final String LOCATION_CHANNEL = "locationChannel";
	private static final String SITE_CHANNEL = "siteChannel";
    
	@Router(inputChannel = "createWorkorderRouterChannel")
	public List<String> routeWorkOrder(@Header("INVOKE_SERVICE") String service) {
		List<String> channels = new ArrayList<>();		
		if (WorkOrderConstants.SITE.getValue().equalsIgnoreCase(service)) {
			channels.add(SITE_CHANNEL);
		}
		if (WorkOrderConstants.LOCATION.getValue().equalsIgnoreCase(service)) {
			channels.add(LOCATION_CHANNEL);
		}
		return channels;
	}
	
}
