package com.comcast.orion.workorder.service;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

import javax.xml.ws.WebServiceException;
import javax.xml.ws.soap.SOAPFaultException;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.comcast.orion.workorder.command.CreateUpdateOTTCommand;
import com.comcast.orion.workorder.config.OttAttributesConfig;
import com.comcast.orion.workorder.domain.poi.POIRequest;
import com.comcast.orion.workorder.domain.poi.POIResponse;
import com.comcast.orion.workorder.utils.WorkOrderConstants;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;
import com.comcast.orion.workorder.utils.mapper.CustomerSiteMapper;

import services.web.trackem.InsertOrUpdatePointOfInterest;
import services.web.trackem.ResultBase;

@Component
public class PointOfInterestImpl {
	private final Logger log = LoggerFactory.getLogger(PointOfInterestImpl.class);

	@Autowired
	private CreateUpdateOTTCommand createUpdateOTTCommand;

	@Autowired
	CustomerSiteMapper customerSiteMapper;
	
	@Value("${ott.customersite.enterpriseField}")
	private String enterpriseField;
	
	@Value("${ott.customersite.childAttributes}")
	private List<String> childAttributes;

	@Autowired
	private OttAttributesConfig prop;

	public POIResponse insertOrUpdateCustomerSite(POIRequest request) throws OrionMiddlewareServiceException {
		log.info("Enter PointOfInterestImpl :: insertOrUpdateCustomerSite - start");
		validateRequest(request);
		InsertOrUpdatePointOfInterest poiReq = new InsertOrUpdatePointOfInterest();
		POIResponse response = null;
		ResultBase poiResponse = null;
		Map<String, String> dataAtr = prop.getAttributes();
		String enterpriseFeild = null;
		try {
			poiReq = customerSiteMapper.mapSite(request.getSite());
			InsertOrUpdatePointOfInterest poiReq1 = customerSiteMapper.mapCustomer(request.getCustomer());
			poiReq = customerSiteMapper.mergeSite(poiReq, poiReq1);
			InsertOrUpdatePointOfInterest poiReq2 = customerSiteMapper.mapContact(request.getContact());
			poiReq = customerSiteMapper.mergeContact(poiReq, poiReq2);
			poiReq = customerSiteMapper.mapOther(poiReq, request);
			poiReq = customerSiteMapper.mapAttributes(poiReq, request, dataAtr);
			poiReq = mapChildAttributes(poiReq, request);
			List<com.comcast.orion.workorder.domain.poi.Attribute> attributes = request.getAttributes();
			for (com.comcast.orion.workorder.domain.poi.Attribute attribute : attributes) {
				if(null != attribute.getName() && attribute.getName().equalsIgnoreCase(enterpriseField)) {
					enterpriseFeild = attribute.getValue();
				}
				
			}
			poiResponse = createUpdateOTTCommand.insertOrUpdate(poiReq,enterpriseFeild);
			if (poiResponse != null) {
				log.info("  Response Status code: {} ", poiResponse.getResultCode());
				log.info("  Response Status Message: {}", poiResponse.getResultMessages());
				response = customerSiteMapper.mapResponse(poiResponse);
			}
			
			if(!WorkOrderConstants.SUCCESS.equalsIgnoreCase(response.getStatus())) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.BUSINESS_ERROR_OT,response.getErrors().get(0).getMessage());
			}
		} catch (SOAPFaultException ex) {
			log.error("SOAPFaultException from OFFICETRACK::InsertOrUpdatePointOfInterest :: " +ex.getCause());
			if (null != ex.getFault()) {
				String fault = ex.getFault().getFaultCode() + ":" + ex.getFault().getFaultString();
				log.error("SOAPFaultException from OFFICETRACK::InsertOrUpdatePointOfInterest :: ", fault);
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK, fault);
			} else if (ex.getCause() != null && ex.getCause().toString().contains("MarshalException")) {
				log.error("SOAPFaultException from OFFICETRACK::InsertOrUpdatePointOfInterest :: ",
						ex.getCause().toString());
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK, ex.getMessage());
			}
			else{
				log.error("SOAPFaultException from OFFICETRACK::InsertOrUpdatePointOfInterest::", ex.getMessage());
				throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,ex.getMessage());
			}
		} catch (WebServiceException ex) {
			log.error("WebServiceException from TTS :: {} ", ex.getMessage());
			throw new OrionMiddlewareServiceException(OrionErrorCode.OTT_CONNECTIVITY_ERROR);
		} catch (MalformedURLException ex) {
			log.error("MalformedURLException from OFFICETRACK::InsertOrUpdatePointOfInterest::", ex.getMessage());
			throw new OrionMiddlewareServiceException(OrionErrorCode.TECHNICAL_ERROR_OFFICETRACK,ex.getMessage());
		}
		return response;
	}

	//US1882592: OMW-POST - workorder/v2/POI Enhancement
	private InsertOrUpdatePointOfInterest mapChildAttributes(InsertOrUpdatePointOfInterest poiReq, POIRequest request) {
		//configure the values in All caps and now convert type to all caps for comparision
		if (childAttributes.contains(request.getType().toUpperCase())) {
			poiReq.setIsParent(false);
		} else {
			poiReq.setIsParent(true);
		}
		poiReq.getType().add("Customer");
		// if type is SITE,, customerId should be set to data5 on poi request
		if("SITE".equalsIgnoreCase(request.getType())) {
			poiReq.setData5(poiReq.getParentPoi());
		}
		 
		return poiReq;
	}

	private void validateRequest(POIRequest request) throws OrionMiddlewareServiceException {
		// validate request parameters for not empty
		if (StringUtils.isBlank(request.getType())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"type - Mandatory Field is missing in the request");
		}
		validateCustomer(request);
		validateSite(request);
	}

	private void validateCustomer(POIRequest request) throws OrionMiddlewareServiceException {
		if (ObjectUtils.isEmpty(request.getCustomer())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"customer - Mandatory Field is missing in the request");
		}
		if (StringUtils.isEmpty(request.getCustomer().getId())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"customer id - Mandatory Field is missing in the request");
		}
		if ("CUSTOMER".equalsIgnoreCase(request.getType()) && StringUtils.isEmpty(request.getCustomer().getName())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"customer name - Mandatory Field is missing in the request");
		}
	}

	private void validateSite(POIRequest request) throws OrionMiddlewareServiceException {
		if ("SITE".equalsIgnoreCase(request.getType()) && ObjectUtils.isEmpty(request.getSite())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"site - Mandatory Field is missing in the request");
		}
		if ("SITE".equalsIgnoreCase(request.getType()) && StringUtils.isEmpty(request.getSite().getId())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"site id - Mandatory Field is missing in the request");
		}
		if ("SITE".equalsIgnoreCase(request.getType()) && StringUtils.isEmpty(request.getSite().getName())) {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR,
					"site name - Mandatory Field is missing in the request");
		}
	}
}
