package com.comcast.orion.workorder.integration;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.integration.annotation.Aggregator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.config.OdsPropertyConfig;
import com.comcast.orion.workorder.domain.Error;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.installbase.tnFeature.Service;
import com.comcast.orion.workorder.domain.installbase.tnFeature.TNFeaturesResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.domain.getworkorder.Equipment;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.ods.customer.ODSCustomerResponse;
import com.comcast.orion.workorder.domain.product.response.ServiceDetailsResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

@Component
public class WorkOrderServiceAggregator {

	private final Logger log = LoggerFactory.getLogger(this.getClass());


	@Value("${ods.customer.serviceType}")
	private String serviceType;
	@Autowired
	private OdsPropertyConfig prop;

	@Aggregator(inputChannel = "aggregatorChannel", outputChannel = "deviceIpOut")
	public Object aggregate(List<Message> messages) throws OrionMiddlewareServiceException {
		log.info("WorkOrderServiceAggregator::aggregate::Enters");
		List<WorkOrderDetail> response = new ArrayList<WorkOrderDetail>();
		Set<Error> errors = new HashSet<>();
		for (Message message : messages) {
			if (message.getPayload() != null) {
				if (message.getPayload() instanceof Error) {
					errors.add((Error) message.getPayload());
				} else {
					WorkOrderDetail deviceDetailsresponse = (WorkOrderDetail) message.getPayload();
					if (deviceDetailsresponse != null) {
						response.add(deviceDetailsresponse);
					}
				}
			}
		}

		if (!errors.isEmpty()) {
			log.info("WorkOrderServiceAggregator::Error::Exists");
			return errors.stream().findFirst().get();
		}
		log.info("WorkOrderServiceAggregator::aggregate::Exists");
		return response;
	}
	
	@Aggregator(inputChannel = "aggregatorInstallbaseChannel", outputChannel = "installbaseOut")
    public List<ServiceDetail> aggregateInstallbaseTnFeatures(List<Message> messages) {
        log.info("aggregateInstallbaseTnFeatures::Enters");
        List<ServiceDetail> serviceDetails = new ArrayList<ServiceDetail>();
        if (!CollectionUtils.isEmpty(messages)) {
            for (Message message : messages) {
                if (message.getPayload() != null) {
                	ServiceDetail payload = (ServiceDetail) message.getPayload();
                	serviceDetails.add(payload);
                }
            }
        }
        log.info("aggregateInstallbaseTnFeatures::Exists");
        
        return serviceDetails;
    }

@Aggregator(inputChannel = "aggregatorVmsChannel", outputChannel = "vmsOut")
    public List<ServiceDetail> aggregateVMSTnFeatures(List<Message> messages) {
        log.info("aggregateVMSTnFeatures::Enters");
        List<ServiceDetail> serviceDetails = new ArrayList<ServiceDetail>();
        if (!CollectionUtils.isEmpty(messages)) {
            for (Message message : messages) {
                if (message.getPayload() != null) {
                	List<ServiceDetail> serviceDetailList = (List<ServiceDetail>) message.getPayload();
                	serviceDetails.addAll(serviceDetailList);
                }
            }
        }
        log.info("aggregateVMSTnFeatures::Exists");
        
        return serviceDetails;
    }

}
