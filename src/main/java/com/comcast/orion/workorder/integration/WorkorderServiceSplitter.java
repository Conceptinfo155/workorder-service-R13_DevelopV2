package com.comcast.orion.workorder.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import com.comcast.orion.workorder.controller.WorkorderController;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class WorkorderServiceSplitter {

	private static final Logger LOG = LoggerFactory.getLogger(WorkorderController.class);

	@Splitter(inputChannel = "splitterChannel", outputChannel = "routerChannel")
	public List<Message> splitMessage(@Payload List<GetWorkorderBySiteIdResponse> futureWorkOrderWFXResponseList) {
		List<Message> messageList = new ArrayList<>();
		for (GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse : futureWorkOrderWFXResponseList) {
			messageList.add(MessageBuilder.withPayload(futureWorkOrderWFXResponse)
					.setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.WORKORDER.getValue())
					.build());
			LOG.debug("futureWorkOrderWFXResponse : ", futureWorkOrderWFXResponse);
		}
		return messageList;
	}

	@Splitter(inputChannel="installbaseSplitterChannel", outputChannel="installbaseRouterChannel")
	public List<Message> salesContactSplitMessage(@Payload Set<com.comcast.orion.workorder.domain.installbase.tnFeature.Service> serviceList, @Header(name = "trackingId", required = false) String trackingId) {
        List<Message> messageList = new ArrayList<>();
        for(com.comcast.orion.workorder.domain.installbase.tnFeature.Service service: serviceList) {
        	messageList.add(MessageBuilder.withPayload(service)
        			.setHeader(WorkOrderConstants.INVOKE_INSTALL_BASE_SERVICE.getValue(), WorkOrderConstants.INSTALL_BASE.getValue())
        			.setHeader(WorkOrderConstants.TRACKING_ID.getValue(), trackingId)
                    .build());
        }
        
        return messageList;
	}
	
    @Splitter(inputChannel = "workOrderDetailsSplitterChannel", outputChannel = "workOrderDetailsRouterChannel")
    public List<Message> splitWorkOrderDetailsMessage(@Payload String workOrderNumber, @Header(name = "mapOfVariables", required = false) Map<String,String> mapOfVariables) throws com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException {
        List<Message> messageList = new ArrayList<>();
        String customerId = mapOfVariables.get("customerId");
        String siteId = mapOfVariables.get("siteId");
		        messageList.add(MessageBuilder.withPayload(workOrderNumber)
     		   .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.ODS.getValue())
     		   .setHeader(WorkOrderConstants.FIELD_CUSTOMER_ID.getValue(), customerId)
     		   .build());

               messageList.add(MessageBuilder.withPayload(workOrderNumber)
                        .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.WORKORDER.getValue())
                        .build());
               
               messageList.add(MessageBuilder.withPayload(workOrderNumber)
                       .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.PRODUCT.getValue())
                       .setHeader(WorkOrderConstants.FIELD_CUSTOMER_ID.getValue(), customerId)
                       .setHeader(WorkOrderConstants.SITE_ID.getValue(), siteId)
                       .setHeader(MessageHeaders.ERROR_CHANNEL, "errorChannel")
                       .build());
            
        return messageList;
    }
    
    @Splitter(inputChannel="vmsSplitterChannel", outputChannel="vmsRouterChannel")
	public List<Message> vmsSplitMessage(@Payload Set<String> designIdList) {
        List<Message> messageList = new ArrayList<>();
        for(String designId: designIdList) {
        	messageList.add(MessageBuilder.withPayload(designId)
        			.setHeader(WorkOrderConstants.INVOKE_VMS_SERVICE.getValue(), WorkOrderConstants.VMS.getValue())
                    .build());
        }        
        return messageList;
	}

}
