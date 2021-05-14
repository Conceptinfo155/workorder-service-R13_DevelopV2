package com.comcast.orion.workorder.command;

import java.net.UnknownHostException;

import javax.xml.ws.soap.SOAPFaultException;

import org.jboss.logging.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.UnknownHttpStatusCodeException;
import org.springframework.ws.WebServiceException;

import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import services.web.trackem.ResultBase;
import services.web.trackem.WebServicesSoap;

/**
 * The Class OTDeletePointOfInterestCommand.
 */
@Component
public class OTDeletePointOfInterestCommand {

	/** The log. */
	private final Logger log = LoggerFactory.getLogger(OTDeletePointOfInterestCommand.class);

	@Autowired
	private WebServicesSoap getOTServicePort;
	
	@Value("${officetrack.pointofdelete.endpoint}")
	String endpoint;
	
	@Value("${officetrack.pointofdelete.username}")
	String officeTrackUserName;
	
	@Value("${officetrack.pointofdelete.password}")
	String officeTrackPassword;
	/**
	 * @param workOrderId 
	 * @param deleteCustomer
	 * @return
	 */
	@HystrixCommand(groupKey = "deletePointOfInterestHystrix", commandKey = "deletePointOfInterestHystrix", fallbackMethod = "deletePointOfInterestHystrixFallback", ignoreExceptions = {
			SOAPFaultException.class, WebServiceException.class })
	public ResultBase deletePointOfInterest(String customerNumber) throws OrionMiddlewareServiceException
	{
		log.info("Inside OTDeletePointOfInterestCommand##deleteCustomer--Start",
				customerNumber);
		MDC.put("downstreamName", "OfficeTrack");
		MDC.put("downstreamUrl", endpoint); 
		try {
			ResultBase resultBase = getOTServicePort.deletePointOfInterest(officeTrackUserName, officeTrackPassword, customerNumber);
			return resultBase;
		} catch (HttpServerErrorException | HttpClientErrorException ex) {
			log.error("HttpServerErrorException  {}", ex);
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,
					ex.getMessage());
		} catch (SOAPFaultException ex) {
			log.error("SOAPFaultException from OFFICETRACK::deletePointOfInterest :: " +ex.getCause());
			if(ex.getCause() !=null && ex.getCause().toString().contains("MarshalException")) {
				log.error("SOAPFaultException from OFFICETRACK::deletePointOfInterest :: ", ex.getCause().toString());
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,ex.getMessage());
			}
			else if(null!= ex.getFault()) {
				String fault= ex.getFault().getFaultCode()+":" + ex.getFault().getDetail();
				log.error("SOAPFaultException from OFFICETRACK::deletePointOfInterest :: ", fault);
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,fault);
			}else {
				log.error("SOAPFaultException from OFFICETRACK::deletePointOfInterest::", ex.getMessage());
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,ex.getMessage());
			}
		}  catch (WebServiceException ex) {
			log.error("WebServiceException from OFFICETRACK::deletePointOfInterest::", ex.getMessage());
			throw new OrionMiddlewareServiceException(OrionErrorCode.OTT_CONNECTIVITY_ERROR,ex.getMessage());
		} catch (Exception ex) {
			if(ex.getCause() instanceof UnknownHostException) {
				log.error("WebServiceException from OFFICETRACK::deletePointOfInterest::", ex.getMessage());
				throw new OrionMiddlewareServiceException(OrionErrorCode.OTT_CONNECTIVITY_ERROR);	
			}else {
				log.error("WebServiceException from OFFICETRACK::deletePointOfInterest::", ex.getMessage());
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,ex.getMessage());
			}
			
		}
	}

	/**
	 * @param deleteCustomer
	 * @param e
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	@HystrixCommand(groupKey = "deletePointOfInterestHystrix")
	public ResultBase deletePointOfInterestHystrixFallback(String customerNumber, Throwable e) throws OrionMiddlewareServiceException {
		throw new OrionMiddlewareServiceException(OrionErrorCode.OTT_CONNECTIVITY_ERROR);
	}

}
