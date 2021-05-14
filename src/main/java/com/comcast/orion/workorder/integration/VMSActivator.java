package com.comcast.orion.workorder.integration;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.UnknownHttpStatusCodeException;

import com.comcast.orion.workorder.command.VMSTnFeaturesCommand;
import com.comcast.orion.workorder.domain.ErrorMessage;
import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.GetWorkOrderMapper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@Component
public class VMSActivator {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private VMSTnFeaturesCommand vmsTnFeaturesCommand;
	
	@Autowired
	GetWorkOrderMapper getWorkOrderMapper;
	
	@Value("${vms.tnFeatures.tnno}")
	private String tnno;
	
	@Value("${vms.tnFeatures.tntype}")
	private String tntype;
	
	@Value("${vms.tnFeatures.primary}")
	private String primary;

	@ServiceActivator(inputChannel = "vmsChannel", outputChannel = "aggregatorVmsChannel")
	public Object getVMSTnFeatures(String designId) throws OrionMiddlewareServiceException, JsonParseException, JsonMappingException, IOException {
		DTTNFeaturesResponse dtTNFeaturesResponse = null;
		try {			
			dtTNFeaturesResponse = vmsTnFeaturesCommand.getVMSTnFeatures(designId);			
		} catch (HttpServerErrorException | HttpClientErrorException | UnknownHttpStatusCodeException ex) {
			if (ex.getRawStatusCode() == HttpStatus.NOT_FOUND.value()
					|| ex.getRawStatusCode() == HttpStatus.SERVICE_UNAVAILABLE.value()
					|| (ex.getResponseBodyAsString() != null && ex
					.getResponseBodyAsString().contains("ZuulException"))) {
				if(!StringUtils.isEmpty(ex.getResponseBodyAsString())){
					ErrorMessage errorMessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
					List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage.getErrors();
					if (errorList != null && errorList.size() > 0) {
						com.comcast.orion.workorder.domain.Error error = errorList.get(0);
						throw new OrionMiddlewareServiceException(OrionErrorCode.VMS_CONNECTIVITY_ERR, error.getMessage());
					}	
				}
				throw new OrionMiddlewareServiceException(OrionErrorCode.VMS_CONNECTIVITY_ERROR);
			} else {
				ErrorMessage errorMessage = objectMapper.readValue(ex.getResponseBodyAsString(), ErrorMessage.class);
				List<com.comcast.orion.workorder.domain.Error> errorList = errorMessage.getErrors();
				if (errorList != null && errorList.size() > 0) {
					com.comcast.orion.workorder.domain.Error error = errorList.get(0);
					throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_VMS, error.getMessage());
				}
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_VMS_ERR);
			}
		} catch (OrionMiddlewareServiceException e) {
			throw e;
		} catch (RestClientException e) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.VMS_CONNECTIVITY_ERROR);
		} catch (Exception e) {
			log.error("Exception Occurred in InstallbaseActivator#getInstallbaseTnFeatures --- Exception - Message: {}",e);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR,e);			
		}
		return getWorkOrderMapper.mapVMSTnFeatureResponse(dtTNFeaturesResponse,tnno,tntype,primary);        
	}

}
