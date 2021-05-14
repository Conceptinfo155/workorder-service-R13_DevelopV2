package com.comcast.orion.workorder.integration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.integration.annotation.ReleaseStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


import com.comcast.orion.workorder.config.OdsPropertyConfig;
import com.comcast.orion.workorder.domain.getworkorder.Characteristic;
import com.comcast.orion.workorder.domain.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.ods.customer.ODSCustomerResponse;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class GetWorkOrderAggregator {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Value("${ods.customer.serviceType}")
	private String serviceType;
	@Autowired
	private OdsPropertyConfig prop;
	
	@Aggregator(inputChannel = "aggregatorWorkorderChannel", outputChannel = "workOrderOut")
    public Object aggregateWorkorder(List<Message> messages) {
        log.info("aggregatorWorkorderChannel::Enters");
        String serviceHeader = null;
        WorkorderResponse  workorderResponse = null;
        Map<String, String> odsCustomerType = prop.getOdsCustomerType();
        Map<WorkorderResponse, Object> responseMap = new HashMap<>();
        String customerType=null;
        //ServiceDetailsResponse serviceDetailsResponse = null;
        Object serviceDetailsResponse = null;
        boolean isBVEorBI = false;
    
       
        if (!CollectionUtils.isEmpty(messages)) {
        	for (Message message : messages) {
    			if (message.getPayload() != null) {
    				serviceHeader = (String) message.getHeaders().get(WorkOrderConstants.INVOKE_SERVICE.getValue());
    				if (WorkOrderConstants.WORKORDER.getValue().equalsIgnoreCase(serviceHeader)) {
						workorderResponse = (WorkorderResponse) message.getPayload();
						isBVEorBI = checkBIorBVE(workorderResponse);
						for (Equipment equipment : workorderResponse.getWorkOrderDetails().getEquipment()) {
							if (CollectionUtils.isNotEmpty(equipment.getServices())) {
								for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment
										.getServices()) {
									if (service.getServiceType() != null) {
										/** For BI set DisplayServiceType as per configuration if serviceId start with "CNCV" 
										 *  others set the same ServiceType as DisplayServiceType 
										 */
										if (serviceType.equalsIgnoreCase(service.getServiceType()) && !StringUtils.isBlank(service.getServiceId())) {
											for(Map.Entry<String, String> obj: prop.getDisplayServiceType().entrySet()){
												if(service.getServiceId().startsWith(obj.getKey())){
													service.setDisplayServiceType(obj.getValue());
												}else{
													service.setDisplayServiceType(service.getServiceType());
												}
											}
										}else{
											service.setDisplayServiceType(service.getServiceType());
										}
										//OMW will  retrieve characteristics  'SDWAN_Management  from equipment[i]/services[j] 
										//if equipment[i]/services[j]/serviceType='SD-WAN'. 
										//OMW will append the characteristics with serviceType [ SD-WAN Advanced]
										//// added for R11-US1858164
										if(WorkOrderConstants.SDWAN.equalsIgnoreCase(service.getServiceType())) {
											Map<String, String> sdwanMap = prop.getServiceType();
											String sdwanDisplayServiceType = null;
											List<Characteristic> characteristics = service.getCharacteristics();
											if(null != characteristics && characteristics.size() > 0) {
												for(Characteristic characteristic : characteristics) {
													if(null != characteristic.getCharacteristicName()
															&& characteristic.getCharacteristicName().equalsIgnoreCase(sdwanMap.get(WorkOrderConstants.SDWAN))) {
														sdwanDisplayServiceType = WorkOrderConstants.SDWAN + " " + characteristic.getCharacteristicValue();
													}
													
												}
											}
											if(null != sdwanDisplayServiceType) {
												service.setDisplayServiceType(sdwanDisplayServiceType);
											}
										}
									}
								}
							}
						}
					}
    				if (WorkOrderConstants.PRODUCT.getValue().equalsIgnoreCase(serviceHeader)) {
    					if (message.getPayload() instanceof ErrorMessage) {
    						serviceDetailsResponse = (ErrorMessage) message.getPayload();
							  
						  } else {
							  serviceDetailsResponse = (ServiceDetailsResponse) message.getPayload();
						  }
    				}
    				if (WorkOrderConstants.ODS.getValue().equalsIgnoreCase(serviceHeader)) {
						ODSCustomerResponse odsCustomerResponse = (ODSCustomerResponse) message.getPayload();
						String type = odsCustomerResponse.getOdsCustomerTypeDesc();
						if (odsCustomerType.containsKey(type)) {
							customerType=odsCustomerType.get(type);
						}else{
							customerType=type;
						}

					}
    			}
    								
    		}
        	if(customerType !=null){
        		workorderResponse.getWorkOrderDetails().setCustomerType(customerType);
        	}
        	
    		}
        
        
        if (isBVEorBI ) {
        	responseMap.put(workorderResponse, serviceDetailsResponse);
        } else {
        	if (serviceDetailsResponse instanceof  ErrorMessage) {
        		responseMap.put(workorderResponse, null);
        	}else{
        		responseMap.put(workorderResponse, serviceDetailsResponse);
        	}
        }
        
        log.info("aggregatorWorkorderChannel::Exists");
        return responseMap;
        
    }
	

	@ReleaseStrategy
    public boolean canRelease(List<Message> messages) {
		log.info("WorkOrderReleaseStrategy");
		String serviceHeader = null;
		WorkorderResponse  workOrderResponse = null;
		
		boolean release = false;
		boolean isWorkOrderRespRecvd = false;
		boolean isProdRespRecvd = false;
		boolean isOdsRespRecvd=false;
		boolean isBIorBVE =false;
		if (!CollectionUtils.isEmpty(messages)) {
        	for (Message message : messages) {
    			if (message.getPayload() != null) {
    				serviceHeader = (String) message.getHeaders().get(WorkOrderConstants.INVOKE_SERVICE.getValue());
    				if (WorkOrderConstants.WORKORDER.getValue().equalsIgnoreCase(serviceHeader)) {
						isWorkOrderRespRecvd = true;
    					workOrderResponse = (WorkorderResponse) message.getPayload();
    					if (null != workOrderResponse.getWorkOrderDetails()) {
    							for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse
    									.getWorkOrderDetails().getEquipment()) {
    									for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment
    											.getServices()) {
    										
    										if (service.getServiceType() != null && (service.getServiceType().equals("BI") ||  service.getServiceType().equals("BVE"))) {
    												isBIorBVE=true;
    											 if(isProdRespRecvd && isOdsRespRecvd) release = true;
    											} else {
    												if(isOdsRespRecvd) release = true;
												}

    									}
    							}
    					}
    					
					}else if(WorkOrderConstants.PRODUCT.getValue().equalsIgnoreCase(serviceHeader)) {
							  isProdRespRecvd = true;
						  if(isWorkOrderRespRecvd && isOdsRespRecvd) release = true;
						 
				    }else if (WorkOrderConstants.ODS.getValue().equalsIgnoreCase(serviceHeader)) {
				    	 isOdsRespRecvd=true;
				    	 if(isWorkOrderRespRecvd){
				    		 if(isBIorBVE){
				    			 if(isProdRespRecvd) release = true;
				    		 }else{
				    			 release = true;
				    		 }
				    		 
				    	 }
				    }
    			 }
    								
    			}
    		}
		return release;
	}	
	
	
	private  boolean checkBIorBVE(WorkorderResponse workOrderResponse ) {
		boolean isBVEorBI = false;
	
		if (null != workOrderResponse.getWorkOrderDetails()) {
			
			for (com.comcast.orion.workorder.domain.getworkorder.Equipment equipment : workOrderResponse
					.getWorkOrderDetails().getEquipment()) {
					for (com.comcast.orion.workorder.domain.getworkorder.Service service : equipment
							.getServices()) {
						if (!StringUtils.isBlank(service.getServiceType())) {
							if (service.getServiceType().equals("BVE") ||  service.getServiceType().equals("BI")) {
								
								isBVEorBI = true;
						
							
						}

					}

			}
		
	}
	}
 return isBVEorBI;

}
	
}
