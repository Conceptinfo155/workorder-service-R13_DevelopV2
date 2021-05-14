package com.comcast.orion.workorder.integration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;


import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class WorkorderServiceRouter {

	private static final String FUTUREWORKORDER_CHANNEL = "futureWorkOrderChannel";
	private static final String INSTALL_BASE_CHANNEL = "installbaseChannel";
	private static final String PROUDUCT_CHANNEL = "productChannel";
	private static final String WORKORDER_CHANNEL = "workOrderDetailsChannel";
	private static final String ODS_CHANNEL = "odsChannel";
    private static final String VMS_CHANNEL = "vmsChannel";
    
	@Router(inputChannel = "routerChannel")
	public List<String> route(@Header("INVOKE_SERVICE") String service) {
		List<String> channels = new ArrayList<>();
		if (WorkOrderConstants.WORKORDER.getValue().equalsIgnoreCase(service)) {
			channels.add(FUTUREWORKORDER_CHANNEL);
		}
		return channels;
	}
	
	@Router(inputChannel = "installbaseRouterChannel")
    public List<String> installbaseRoute(@Header("INVOKE_INSTALL_BASE_SERVICE") String service) {
        List<String> channels = new ArrayList<>();
        if(WorkOrderConstants.INSTALL_BASE.getValue().equalsIgnoreCase(service)) {
            channels.add(INSTALL_BASE_CHANNEL);
        }

        return channels;
    }
	
	/**
	 * Routing to WORKORDER and PRODUCT channel
	 */
	@Router(inputChannel = "workOrderDetailsRouterChannel")
	public List<String> routeWorkOrder(@Header("INVOKE_SERVICE") String service) {
		List<String> channels = new ArrayList<>();		
		if (WorkOrderConstants.WORKORDER.getValue().equalsIgnoreCase(service)) {
			channels.add(WORKORDER_CHANNEL);
		}
		if (WorkOrderConstants.PRODUCT.getValue().equalsIgnoreCase(service)) {
			channels.add(PROUDUCT_CHANNEL);
		}
		if (WorkOrderConstants.ODS.getValue().equalsIgnoreCase(service)) {
			channels.add(ODS_CHANNEL);
		}
		return channels;
	}
	
	@Router(inputChannel = "vmsRouterChannel")
    public List<String> vmsRoute(@Header("INVOKE_VMS_SERVICE") String designId) {
        List<String> channels = new ArrayList<>();
        if(WorkOrderConstants.VMS.getValue().equalsIgnoreCase(designId)) {
            channels.add(VMS_CHANNEL);
        }

        return channels;
    }
}
