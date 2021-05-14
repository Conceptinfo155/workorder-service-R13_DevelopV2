package com.comcast.orion.workorder.integration;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

@Component
@MessagingGateway(defaultRequestChannel = "splitterChannel", defaultReplyChannel = "deviceIpOut")
public interface WorkorderServiceGateway {

	@Gateway(requestChannel = "splitterChannel", replyChannel = "deviceIpOut")
	public Object getDeviceDetails(
			@Payload List<GetWorkorderBySiteIdResponse> futureWorkOrderWFXResponseList) throws OrionMiddlewareServiceException;
	
	@Gateway(requestChannel = "installbaseSplitterChannel", replyChannel = "installbaseOut")
	public List<ServiceDetail> getInstallbaseTnFeatures(@Payload Set<com.comcast.orion.workorder.domain.installbase.tnFeature.Service> serviceList, @Header(name = "trackingId", required = false) String trackingId) throws OrionMiddlewareServiceException;

	@Gateway(requestChannel = "workOrderDetailsSplitterChannel", replyChannel = "workOrderOut")
	public Map<WorkorderResponse, Object> getWorkOrderDetails(@Payload String workOrderNumber, @Header(name = "mapOfVariables", required = false) Map<String,String> mapOfVariables) throws OrionMiddlewareServiceException;

	@Gateway(requestChannel = "vmsSplitterChannel", replyChannel = "vmsOut")
	public List<ServiceDetail> getVMSTnFeatures(@Payload Set<String> designIdList) throws OrionMiddlewareServiceException;
}