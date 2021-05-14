package com.comcast.orion.workorder.utils; 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.JobProductList;
import com.comcast.orion.workorder.utils.exceptions.OrionErrorCode;
import com.comcast.orion.workorder.utils.exceptions.OrionMiddlewareServiceException;

/**
 * CreateWOValidation
 *
 */
@Component
public class CreateWOValidation {

	/**
	 * DATE_PATTERN
	 */
	private String DATE_PATTERN = "yyyy-MM-dd";
	
	/** The log. */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 */
	@Value("${jobTypeCode.list}")
	private String jobTypeCodeList;
	
	/**
	 * @param request
	 * @throws OrionMiddlewareServiceException
	 */
	public void validateCreateWorkOrderRequest(CreateWORequest request) throws OrionMiddlewareServiceException {
		
		//validate productList not empty
		validateProductList(request.getCreateWorkorderRequest().getJobProductList(),request.getCreateWorkorderRequest().getJob().getJobTypeCd());
		
		// validateScheduleDate format
		validateScheduleDate(request.getCreateWorkorderRequest().getJob().getScheduleDate());
	}
	
	/**
	 * @param scheduleDate
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	public boolean validateScheduleDate(String scheduleDate) throws OrionMiddlewareServiceException {
		logger.info("Validating the scheduledate");		
		if (scheduleDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);
			dateFormat.setLenient(false);
			try {
				dateFormat.parse(scheduleDate);
			} catch (ParseException ex) {
				throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, "Invalid Schedule Date format");
			}
		} else {
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, "Invalid Schedule Date format");
		}
		return true;
	}

	/**
	 * @param jobProductList
	 * @param jobTypeCd
	 * @return
	 * @throws OrionMiddlewareServiceException
	 */
	private boolean validateProductList(List<JobProductList> jobProductList,String jobTypeCd) throws OrionMiddlewareServiceException {
				
		if(CollectionUtils.isEmpty(jobProductList)) {		
			if(jobTypeCodeList.contains(jobTypeCd)) {
				return true;
			}
			throw new OrionMiddlewareServiceException(OrionErrorCode.CONTRACT_VALIDATION_ERROR, "jobProductList - Mandatory Field is missing in the request");
		}else {
			return true;
		}
	}
}
