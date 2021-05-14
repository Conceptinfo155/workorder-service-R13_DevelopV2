package com.comcast.orion.workorder.integration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.getworkorder.Resource;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.command.GetInstallbaseTnFeaturesCommand;
import com.comcast.orion.workorder.domain.installbase.tnFeature.TNFeaturesResponse;
import com.comcast.orion.workorder.utils.OmwInstallbaseConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class InstallbaseActivator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private GetInstallbaseTnFeaturesCommand getInstallbaseTnFeaturesCommand;

	@ServiceActivator(inputChannel = "installbaseChannel", outputChannel = "aggregatorInstallbaseChannel")
    public Object getInstallbaseTnFeatures(com.comcast.orion.workorder.domain.installbase.tnFeature.Service service, @Header(name = "trackingId", required = false) String trackingId) throws OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		TNFeaturesResponse installbaseTnFeatureResponse = null;
		try {			
			installbaseTnFeatureResponse = getInstallbaseTnFeaturesCommand.getInstallbaseTnFeatures(service.getServiceId(), service.getServiceType(), trackingId);			
		} catch (HttpServerErrorException | HttpClientErrorException | UnknownHttpStatusCodeException ex) {
				if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
					|| (ex.getResponseBodyAsString() != null && ex
							.getResponseBodyAsString().contains("ZuulException"))) {
					throw new OrionMiddlewareServiceException(OrionErrorCode.INSTALLBASE_SERVICE_CONNECTIVITY_ERROR);
				} else {
					ErrorMessage errorMessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage.getErrors();
					if (errorList != null && errorList.size() > 0) {
						com.comcast.orion.workorder.domain.Error error = errorList.get(0);
						throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_INSTALLBASE, error.getMessage());
					}
				}
		} catch (OrionMiddlewareServiceException e) {
			throw e;
		} catch (RestClientException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.INSTALLBASE_SERVICE_CONNECTIVITY_ERROR);
		} catch (Exception e) {
			log.error("Exception Occurred in InstallbaseActivator#getInstallbaseTnFeatures --- Exception - Message: {}",e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR);			
		}
		return mapInstallbaseTnFeatureResponse(service, installbaseTnFeatureResponse);        
    }
	
	private ServiceDetail mapInstallbaseTnFeatureResponse(com.comcast.orion.workorder.domain.installbase.tnFeature.Service service, TNFeaturesResponse installbaseTnFeatureResponse) {
			ServiceDetail serviceDetail = new ServiceDetail();
            serviceDetail.setServiceId(service.getServiceId());
            serviceDetail.setServiceType(service.getServiceType());
            List<Resource> resources = new ArrayList<Resource>();
            if(installbaseTnFeatureResponse.getTNS() != null && !installbaseTnFeatureResponse.getTNS().isEmpty()) {            	
            	for(com.comcast.orion.workorder.domain.installbase.tnFeature.TN tn: installbaseTnFeatureResponse.getTNS()) {
            		Resource resource = new Resource();
                	resource.setType(tn.getType());
                	if(OmwInstallbaseConstants.PLANNED.equals(tn.getStatus())) {
                		resource.setAction(OmwInstallbaseConstants.ADD);
                	} else if(OmwInstallbaseConstants.PENDING_DECOMMISSION.equals(tn.getStatus())) {
                		resource.setAction(OmwInstallbaseConstants.REMOVE);
                	} else {
                		resource.setAction(OmwInstallbaseConstants.NO_CHANGE);
                	}
                	if(tn.getAttributes() != null && !tn.getAttributes().isEmpty()) {
            			List<com.comcast.orion.workorder.domain.getworkorder.Attribute> omwAttributes = new ArrayList<com.comcast.orion.workorder.domain.getworkorder.Attribute>();
            			for(com.comcast.orion.workorder.domain.installbase.tnFeature.Attribute attribute: tn.getAttributes()) {
            				com.comcast.orion.workorder.domain.getworkorder.Attribute omwAttribute = new com.comcast.orion.workorder.domain.getworkorder.Attribute();
            				omwAttribute.setName(attribute.getName());
            				omwAttribute.setValue(attribute.getValue());
            				
            				omwAttributes.add(omwAttribute);
            			}
            			resource.setAttributes(omwAttributes);
            		}
            		if(tn.getFeatures() != null && !tn.getFeatures().isEmpty()) {
            			List<com.comcast.orion.workorder.domain.getworkorder.Feature> omwFeatures = new ArrayList<com.comcast.orion.workorder.domain.getworkorder.Feature>();
            			for(com.comcast.orion.workorder.domain.installbase.tnFeature.Feature feature: tn.getFeatures()) {
            				com.comcast.orion.workorder.domain.getworkorder.Feature omwFeature = new com.comcast.orion.workorder.domain.getworkorder.Feature();
            				if(OmwInstallbaseConstants.PLANNED.equals(feature.getStatus())) {
            					omwFeature.setAction(OmwInstallbaseConstants.ADD);
                        	} else if(OmwInstallbaseConstants.PENDING_DECOMMISSION.equals(feature.getStatus())) {
                        		omwFeature.setAction(OmwInstallbaseConstants.REMOVE);
                        	} else {
                        		omwFeature.setAction(OmwInstallbaseConstants.NO_CHANGE);
                        	}            				
            				omwFeature.setName(feature.getName());
            				omwFeature.setValue(feature.getValue());
            				
            				omwFeatures.add(omwFeature);
            			}
            			resource.setFeatures(omwFeatures);
            		}
            		
            		resources.add(resource);
            	}            	            	
            }
            
            serviceDetail.setResources(resources); 
            
            return serviceDetail;
	}
	
}
