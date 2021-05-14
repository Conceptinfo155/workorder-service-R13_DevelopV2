package com.comcast.orion.workorder.utils.mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.comcast.orion.workorder.domain.pointofinterest.response.DeletePointOfResponse;
import com.comcast.orion.workorder.domain.pointofinterest.response.Error;
import com.comcast.orion.workorder.utils.WorkOrderConstants;

import net.logstash.logback.encoder.org.apache.commons.lang.StringUtils;
import services.web.trackem.ArrayOfString;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PointOfInterestMapper {
	PointOfInterestMapper INSTANCE = Mappers.getMapper(PointOfInterestMapper.class);


	default DeletePointOfResponse mapOmwToOTResponse(services.web.trackem.ResultBase resultBase) {
		DeletePointOfResponse deletePointOfResponse = new DeletePointOfResponse();
		String resultMessage = resultBase.getResultCode().value();
		String resultCode = String.valueOf(resultBase.getResultCodeAsInt());
		ArrayOfString resultMessageArray = resultBase.getResultMessages();
		String resultMessageString = "";
		//construct resultMessageArray if present
		if(null != resultMessageArray &&
				null != resultMessageArray.getString() &&
				resultMessageArray.getString().size() > 0) {
			resultMessageString = resultMessageArray.getString().toString();
		}
		if(StringUtils.isNotEmpty(resultMessage)
			&& WorkOrderConstants.OK.equalsIgnoreCase(resultMessage)) {
			deletePointOfResponse.setStatus(WorkOrderConstants.SUCCESS);
		}else {
			List<Error> errors = new ArrayList<Error>();
			Error error = new Error();
			error.setCode(WorkOrderConstants.BUSINESS_ERROR_OT);
			error.setMessage("code="+resultCode+"&message="+resultMessage+"."+resultMessageString);
			errors.add(error);
			deletePointOfResponse.setErrors(errors);
			deletePointOfResponse.setStatus(WorkOrderConstants.FAILURE);
		}
		return deletePointOfResponse;
	}
}

