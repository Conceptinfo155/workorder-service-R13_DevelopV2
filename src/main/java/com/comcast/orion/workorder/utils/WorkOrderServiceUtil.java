package com.comcast.orion.workorder.utils;


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


/**
 * WorkOrderServiceUtil
 *
 */
@Service("workOrderServiceUtil")
public class WorkOrderServiceUtil {

	/**
	 * Logger
	 */
	private static final Logger LOG = LoggerFactory.getLogger(WorkOrderServiceUtil.class);

	private static final int FIRST_NAME_START_INDEX = 0;
	private static final int FIRST_NAME_END_INDEX = 50;
	private static final int LAST_NAME_START_INDEX = 50;
	private static final int MAX_LENGTH = 50;
	private static final String SPACE = " ";

	@Value("${wfxjobcomments.contact}")
	private String contactName;

	@Value("${wfxjobcomments.concat}")
	private String concatOperator;

	@Value("${wfxjobcomments.maxLength}")
	private Integer jobCommentMaxLength;

	/**
	 * Populate First Name and Last Name in WFX request from Site Signage Name
	 * @param siteSignageName String
	 * @param wfxCreateRequest WFXCreateWorkOrderRequest
	 */
	public void populateWFXFirstNameLastName(String siteSignageName,
											  com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest wfxCreateRequest) {
		String firstName = null;
		String lastName = null;
		if(StringUtils.isEmpty(siteSignageName)) {
			wfxCreateRequest.getJobCustomer().setFirstName(SPACE);
			wfxCreateRequest.getJobCustomer().setLastName(SPACE);
			return;
		}
		firstName = StringUtils.substring(siteSignageName,FIRST_NAME_START_INDEX, FIRST_NAME_END_INDEX);
		lastName = StringUtils.substring(siteSignageName,LAST_NAME_START_INDEX);
		if(firstName.endsWith(" ") || siteSignageName.length()<= MAX_LENGTH || lastName.startsWith(SPACE)) {
			LOG.info("Site SIgnage Name : "+ siteSignageName + " -> WFX First Name : "+firstName
					+ " -> WFX Last Name : "+lastName);
			lastName = StringUtils.isEmpty(lastName) ? SPACE : lastName;
			wfxCreateRequest.getJobCustomer().setFirstName(firstName);
			wfxCreateRequest.getJobCustomer().setLastName(lastName);
			return;
		} else {
			String[] firstNameArray = firstName.split(SPACE);
			String firstNameLastToken = firstNameArray[firstNameArray.length - 1];
			int lastNameRemainingLength = MAX_LENGTH - lastName.length();
			if(firstNameLastToken.length() <= lastNameRemainingLength) {
				lastName = firstNameLastToken + lastName;
				firstName = StringUtils.substring(firstName,FIRST_NAME_START_INDEX, firstName.lastIndexOf(firstNameLastToken));
			}
		}
		LOG.info("Site SIgnage Name : "+ siteSignageName + " -> WFX First Name : "+firstName
				+ " -> WFX Last Name : "+lastName);
		wfxCreateRequest.getJobCustomer().setFirstName(firstName);
		wfxCreateRequest.getJobCustomer().setLastName(lastName);
	}

	/**
	 * Populate First Name and Last Name in WFX request from Site Signage Name
	 * @param siteSignageName String
	 * @param jobCustomer JobCustomer
	 */
	public void populateWFXFirstNameLastName(String siteSignageName,
											 com.comcast.orion.workorder.domain.nWFX.create.JobCustomer jobCustomer) {
		LOG.info("WorkOrderServiceUtil::populateWFXFirstNameLastName::enters");
		String firstName = StringUtils.substring(siteSignageName,FIRST_NAME_START_INDEX, FIRST_NAME_END_INDEX);
		String lastName = StringUtils.substring(siteSignageName,LAST_NAME_START_INDEX);
		if(firstName.endsWith(" ") || siteSignageName.length()<= MAX_LENGTH || lastName.startsWith(SPACE)) {
			LOG.info("Site Signage Name : {} -> WFX First Name : {} -> WFX Last Name : {}",siteSignageName,firstName,lastName);
			lastName = StringUtils.isEmpty(lastName) ? SPACE : lastName;
		} else {
			String[] firstNameArray = firstName.split(SPACE);
			String firstNameLastToken = firstNameArray[firstNameArray.length - 1];
			int lastNameRemainingLength = MAX_LENGTH - lastName.length();
			if(firstNameLastToken.length() <= lastNameRemainingLength) {
				lastName = firstNameLastToken + lastName;
				firstName = StringUtils.substring(firstName,FIRST_NAME_START_INDEX, firstName.lastIndexOf(firstNameLastToken));
			}

		}
		jobCustomer.setFirstName(firstName);
		jobCustomer.setLastName(lastName);
		LOG.info("Site Signage Name : {} -> WFX First Name : {} -> WFX Last Name : {}",siteSignageName,firstName,lastName);
		LOG.info("WorkOrderServiceUtil::populateWFXFirstNameLastName::exits");
	}


	/**
	 * This method will be used to format Job comments
	 * @param firstName String
	 * @param lastName String
	 * @param jobComment String
	 * @return String
	 */
	public String formatJobComment(String firstName, String lastName, String jobComment) {
		StringBuilder sb = new StringBuilder();
		sb.append(contactName);
		if(StringUtils.isNotEmpty(firstName)) {
			sb.append(firstName).append(SPACE);
		}
		if(StringUtils.isNotEmpty(lastName)) {
			sb.append(lastName).append(SPACE);
		}
		sb.append(concatOperator);
		if(StringUtils.isNotEmpty(jobComment)) {
			sb.append(SPACE).append(jobComment);
		}
		if(sb.length() > jobCommentMaxLength) {
			return StringUtils.substring(sb.toString(),0, jobCommentMaxLength);
		}
		return sb.toString();
	}

}
