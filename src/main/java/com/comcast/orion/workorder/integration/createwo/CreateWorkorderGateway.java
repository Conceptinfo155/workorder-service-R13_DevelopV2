package com.comcast.orion.workorder.integration.createwo;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@Component
@MessagingGateway(defaultRequestChannel = "createWorkorderSplitterChannel", defaultReplyChannel = "createWorkorderOut")
public interface CreateWorkorderGateway {

	@Gateway(requestChannel = "createWorkorderSplitterChannel", replyChannel = "createWorkorderOut")
	public Object createWfxWorkorder(@Payload CreateWorkorderWrapper createWorkorderWrapper) throws OrionMiddlewareServiceException;
	
}