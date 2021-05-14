package com.comcast.orion.workorder.utils.mapper;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.StringUtils;
import org.springframework.util.ObjectUtils;
import org.apache.commons.beanutils.BeanUtils;

import com.comcast.orion.workorder.domain.poi.*;
import com.comcast.orion.workorder.domain.poi.Error;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

import net.logstash.logback.encoder.org.apache.commons.lang.ArrayUtils;
import services.web.trackem.InsertOrUpdatePointOfInterest;
import services.web.trackem.Operations;
import services.web.trackem.ResultBase;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomerSiteMapper {

	@Mappings({ @Mapping(target = "customerNumber", source = "id") })
	public abstract InsertOrUpdatePointOfInterest mapCustomer(Customer customer);

	@Mappings({ @Mapping(target = "houseNum", source = "houseNumber") })
	public abstract InsertOrUpdatePointOfInterest mapSite(Site site);

	public abstract InsertOrUpdatePointOfInterest mapContact(Contact contact);

	public InsertOrUpdatePointOfInterest mergeSite(InsertOrUpdatePointOfInterest siteRequest,
			InsertOrUpdatePointOfInterest custRequest) {
		if (ObjectUtils.isEmpty(siteRequest)) {
			return custRequest;
		}
		siteRequest.setName(custRequest.getName());
		siteRequest.setCustomerNumber(custRequest.getCustomerNumber());
		return siteRequest;
	}

	public InsertOrUpdatePointOfInterest mergeContact(InsertOrUpdatePointOfInterest poiRequest,
			InsertOrUpdatePointOfInterest ctRequest) {
		if (ObjectUtils.isEmpty(poiRequest) || ObjectUtils.isEmpty(ctRequest))
			return poiRequest;
		poiRequest.setEmail(ctRequest.getEmail());
		poiRequest.setFax(ctRequest.getFax());
		return poiRequest;
	}

	public InsertOrUpdatePointOfInterest mapOther(InsertOrUpdatePointOfInterest poiRequest, POIRequest request) {
		if (ObjectUtils.isEmpty(poiRequest))
			return poiRequest;
		poiRequest.setCategories(request.getCategories());
		poiRequest.setOperation(Operations.AUTO_SELECT);

		if (!ObjectUtils.isEmpty(request.getSite())) {
			if (!StringUtils.isEmpty(request.getSite().getId())) {
				poiRequest.setCustomerNumber(request.getSite().getId());
				poiRequest.setParentPoi(request.getCustomer().getId());
				poiRequest.setName(request.getSite().getName());
			}
			poiRequest.setY(convertStringToFloat(request.getSite().getLatitude()));
			poiRequest.setX(convertStringToFloat(request.getSite().getLongitude()));
		}
		if (!ObjectUtils.isEmpty(request.getContact()) && !ObjectUtils.isEmpty(request.getContact().getPhones())) {
			Object[] objects = request.getContact().getPhones().toArray();
			if(ArrayUtils.isNotEmpty(objects)) {
			if (objects[0] instanceof String && objects[0]!=null) {
				poiRequest.setPhone1((String) objects[0]);
			}
			if(objects.length>1 && objects[1]!=null && objects[1] instanceof String) {
			
				poiRequest.setPhone2((String) objects[1]);
			}
		}}
		return poiRequest;
	}

	private Float convertStringToFloat(String str) {
		Float floatValue = null;
		if (StringUtils.isEmpty(str)) {
			return floatValue;
		}
		try {
			floatValue = Float.parseFloat(str);
		} catch (NumberFormatException e) {
			floatValue = null;
		}
		return floatValue;
	}

	public InsertOrUpdatePointOfInterest mapAttributes(InsertOrUpdatePointOfInterest poiRequest, POIRequest request,
			Map<String, String> dataAtr) {
		List<Attribute> attr = request.getAttributes();
		if (ObjectUtils.isEmpty(attr) || ObjectUtils.isEmpty(poiRequest) || ObjectUtils.isEmpty(dataAtr))
			return poiRequest;
		for (Map.Entry<String, String> entry : dataAtr.entrySet()) {
			Attribute element = attr.stream().filter(obj -> entry.getKey().equals(obj.getName())).findAny()
					.orElse(null);
			if (element != null) {
				try {
					BeanUtils.setProperty(poiRequest, entry.getValue(), element.getValue());
				} catch (IllegalAccessException e) {
				} catch (InvocationTargetException e) {
				}
			}
		}
		return poiRequest;
	}

	public POIResponse mapResponse(ResultBase poiResponse) {
		POIResponse res = new POIResponse();
		if (!ObjectUtils.isEmpty(poiResponse)) {
			if (poiResponse.getResultCodeAsInt() == 0)
				res.setStatus("SUCCESS");
			else {
				res.setStatus("FAILURE");
				List<Error> errors = new ArrayList<Error>();
				Error err = new Error().withCode("BUSINESS_ERROR_OT");
				err.setMessage("code=" + String.valueOf(poiResponse.getResultCodeAsInt()) + "&message="
						+ String.valueOf(poiResponse.getResultCode().value()));
				errors.add(err);
				res.setErrors(errors);
			}
		}
		return res;
	}
}
