package com.comcast.orion.workorder.command;

import java.net.MalformedURLException;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.config.OTEndpointConfig;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import services.web.trackem.InsertOrUpdatePointOfInterest;
import services.web.trackem.ResultBase;
import services.web.trackem.WebServicesSoap;

@Component
public class CreateUpdateOTTCommand {
	/** The log. */
	private static final Logger log = LoggerFactory.getLogger(CreateUpdateOTTCommand.class);

	@Autowired
	private WebServicesSoap getOTServicePort;
	
	private String decodedUserName;
	
	private String decodedPassword;
	
	private String endpoint;
	
	@Autowired
	private OTEndpointConfig OTEndpointConfig;

	public CreateUpdateOTTCommand() {
		super();
	}
	

	public CreateUpdateOTTCommand(String username, String password, String endpoint) {
		super();
		this.decodedUserName =  username;
		this.decodedPassword = password;
		this.endpoint = endpoint;
	}

	@HystrixCommand(groupKey = "ottCustomersiteHystrix", commandKey = "ottCustomersiteHystrix", fallbackMethod = "ottCustomersiteHystrixFallback", ignoreExceptions = {
			SOAPFaultException.class, WebServiceException.class })
	public ResultBase insertOrUpdate(InsertOrUpdatePointOfInterest request,String enterpriseFeild) throws MalformedURLException {
		MDC.put("downstreamName", "OfficeTrack");
		log.info("invoke the CreateUpdateOTTCommand#insertOrUpdate-- start");
		MDC.put("downstreamName", "OfficeTrack");
		Map<String, String> credentialsInfo  = null;
		if (enterpriseFeild != null) {
			credentialsInfo = OTEndpointConfig.getCustomerType().get(enterpriseFeild.toLowerCase());
		}
		//US1882592: if its an enterprise use different credentials from configurations
		if (credentialsInfo != null) {
			endpoint = credentialsInfo.get(WorkOrderConstants.ENDPOINT);
			decodedUserName = new String(Base64.getDecoder().decode(credentialsInfo.get(WorkOrderConstants.USERNAME)));
			decodedPassword = new String(Base64.getDecoder().decode(credentialsInfo.get(WorkOrderConstants.PASSWORD)));
		} else {
			// If customerType is not there in property file, send default credentials
			Map<String, String> defaultCredentialsInfo = OTEndpointConfig.getCustomerType()
					.get("default");
			endpoint = defaultCredentialsInfo.get(WorkOrderConstants.ENDPOINT);
			decodedUserName = new String(
					Base64.getDecoder().decode(defaultCredentialsInfo.get(WorkOrderConstants.USERNAME)));
			decodedPassword = new String(
					Base64.getDecoder().decode(defaultCredentialsInfo.get(WorkOrderConstants.PASSWORD)));
		}
		MDC.put("downstreamUrl", endpoint); 
		return getOTServicePort.insertOrUpdatePointOfInterest(decodedUserName, decodedPassword, request.getOperation(),
				request.getName(), request.getStreet(), request.getHouseNum(), request.getCity(), request.getState(),
				request.getZip(), request.getY(), request.getX(), request.getPhone1(), request.getPhone2(),
				request.getFax(), request.getType(), request.getCustomerNumber(), request.getParentPoi(),
				request.getCategories(), request.getPointData(), request.getEmail(), request.getData1(),
				request.getData2(), request.getData3(), request.getData4(), request.getData5(), request.getData6(),
				request.getData7(), request.getData8(), request.getData9(), request.getData10(), request.getData11(),
				request.getData12(), request.getData13(), request.getData14(), request.getData15(), request.getData16(),
				request.getData17(), request.getData18(), request.getData19(), request.getData20(), request.getData21(),
				request.getData22(), request.getData23(), request.getData24(), request.getData25(), request.getData26(),
				request.getData27(), request.getData28(), request.getData29(), request.getData30(),
				request.isIsParent());
		
	}

	@HystrixCommand(groupKey = "ottCustomersiteHystrix")
	public ResultBase ottCustomersiteHystrixFallback(InsertOrUpdatePointOfInterest request,String enterpriseFeild, Throwable e)
			throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.OTT_CONNECTIVITY_ERROR);
	}
}
