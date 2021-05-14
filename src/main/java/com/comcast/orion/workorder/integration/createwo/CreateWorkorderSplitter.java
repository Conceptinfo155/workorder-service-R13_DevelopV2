package com.comcast.orion.workorder.integration.createwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.Splitter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import com.comcast.orion.workorder.controller.WorkorderController;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class CreateWorkorderSplitter {

	private static final Logger LOG = LoggerFactory.getLogger(WorkorderController.class);
	
	@Value("${createworkorder.allowtolocationcall}")
	boolean allowtolocationcall;
	
    @Splitter(inputChannel = "createWorkorderSplitterChannel", outputChannel = "createWorkorderRouterChannel")
    public List<Message> splitCreateWfxWorkorderMessage(@Payload CreateWorkorderWrapper createWorkorderWrapper) throws com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException {
        List<Message> messageList = new ArrayList<>();
        //Invoke site service when SiteSignageName is empty as part of US1851017
        		if(StringUtils.isEmpty(createWorkorderWrapper.getWorkorderRequest().getCreateWorkorderRequest().getJobCustomer().getSiteSignageName())){
    		        messageList.add(MessageBuilder.withPayload(createWorkorderWrapper)
    		      		   .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.SITE.getValue()).build());
        		}
        //Invoke Location service when SiteSignageName is not empty or allowtolocationcall (config) is true as part of US1851017		
        		if(StringUtils.isNotEmpty(createWorkorderWrapper.getWorkorderRequest().getCreateWorkorderRequest().getJobCustomer().getSiteSignageName()) || allowtolocationcall){
                    messageList.add(MessageBuilder.withPayload(createWorkorderWrapper)
                            .setHeader(WorkOrderConstants.INVOKE_SERVICE.getValue(), WorkOrderConstants.LOCATION.getValue()).build());
        		}

        return messageList;
    }

}
