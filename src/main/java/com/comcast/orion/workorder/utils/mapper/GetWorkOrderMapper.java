package com.comcast.orion.workorder.utils.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.JobReasonCdList;
import org.apache.commons.collections.CollectionUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.domain.amil.getworkorder.AMILWorkorderResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getworkorder.ServiceDetail;
import com.comcast.orion.workorder.domain.getworkorder.Resource;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.GetWorkorderOMWResponse;
import com.comcast.orion.workorder.domain.omw.getwfxworkorder.SolutionDetail;
import com.comcast.orion.workorder.domain.referencedata.Attribute;
import com.comcast.orion.workorder.domain.referencedata.AttributeSet;
import com.comcast.orion.workorder.domain.referencedata.AttributeSubSet;
import com.comcast.orion.workorder.domain.referencedata.ReferenceDataResponse;
import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.domain.vms.Feature;
import com.comcast.orion.workorder.domain.vms.Service;
import com.comcast.orion.workorder.domain.vms.Service_;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.GetWorkOrderWFXResponse;
import com.comcast.orion.workorder.domain.wfx.getworkorder.request.JobCommentTypeCdList;
import com.comcast.orion.workorder.utils.Constants;
import com.comcast.orion.workorder.utils.JobTypeMappingConstants;


import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/*
To map AMIL response to OMW get workorder response

*/

/**
 * GetWorkOrderMapper
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GetWorkOrderMapper {
	/**
	 * Logger
	 */
	static final Logger LOG = LoggerFactory.getLogger(GetWorkOrderMapper.class);

	
	// Map AMIL Response to OMW response
	/**
	 * @param source
	 * @return WorkorderResponse
	 */
	@Mappings({ @Mapping(target = "workOrderDetails.workOrderId", source = "workOrderDetails.workOrderId"),
			@Mapping(target = "workOrderDetails.agreementId", source = "workOrderDetails.agreementId"),
			@Mapping(target = "workOrderDetails.customerId", source = "workOrderDetails.customerId"),
			@Mapping(target = "workOrderDetails.siteId", source = "workOrderDetails.siteId"),
			@Mapping(target = "workOrderDetails.equipment", source = "workOrderDetails.equipment"), })
	WorkorderResponse mapAMILResponseToGetWorkOrderResponse(AMILWorkorderResponse source);

	@Mappings({ @Mapping(target = "workOrder.jobCustomer", source = "jobCustomer"),
			@Mapping(target = "workOrder.jobLocation", source = "jobLocation"),
			@Mapping(target = "workOrder.job", source = "job"),
			@Mapping(target = "workOrder.job.workOrderNumber", source = "job.workOrderNum"),
			@Mapping(target = "workOrder.job.sysPrinAgent", source = "job.businessUnit"),
			@Mapping(target = "workOrder.job.timeslotDescription", source = "job.timeSlotDesc"),
			@Mapping(target = "workOrder.jobCustomer.siteId", source = "jobCustomer.accountNum"),
			@Mapping(target = "workOrder.jobLocation.ELocId", source = "jobLocation.address.addrId")

	})
	GetWorkorderOMWResponse mapWFXResponseJobToWorkOrderResponse(GetWorkOrderWFXResponse wfxResponse);

	/**
	 * US1761689 - get sol details from ref data
	 */
	default GetWorkorderOMWResponse mapWFXResponseToWorkOrderResponse(GetWorkOrderWFXResponse wfxResponse,
			ReferenceDataResponse referenceDataResponse) {
		if (wfxResponse == null)
			return null;
		GetWorkorderOMWResponse workOrderResponse = mapWFXResponseJobToWorkOrderResponse(wfxResponse);
		if (wfxResponse.getJob().getTechId() != null)
			workOrderResponse.getWorkOrder().getJob().setTechnicianId(wfxResponse.getJob().getTechId().toString());
		if (wfxResponse.getJob().getJobCommentTypeCdList().size() > 0) {
			for (JobCommentTypeCdList jobComment : wfxResponse.getJob().getJobCommentTypeCdList()) {
				if (jobComment.getJobCommentTypeCd().equals("JOB"))
					workOrderResponse.getWorkOrder().getJob().setJobComment(jobComment.getJobComment());
				if (jobComment.getJobCommentTypeCd().equals("ORDER"))
					workOrderResponse.getWorkOrder().getJob().setOrderComment(jobComment.getJobComment());
			}
		}
//		workOrderResponse.getWorkOrder().setSolutionDetails(mapSolutionDetail(referenceDataResponse,wfxResponse.getJob().getJobTypeCd()));
		//US1769239 - Start
//		List<Object> jobReasonCodeList = wfxResponse.getJob().getJobReasonCdList();
//		String jobReasonCode = (CollectionUtils.isNotEmpty(jobReasonCodeList) && jobReasonCodeList.size() > 0) ?
//				((Map<String, String>) jobReasonCodeList.get(0)).get("JobReasonCd") : "" ;
//		LOG.info("GetWorkorder - Job Reason Code from WFX response :: "+jobReasonCode);
//		workOrderResponse.getWorkOrder().getJob().setJobReasonCode(jobReasonCode);
		//Added below changes as part of US1819571
		if(!StringUtils.isEmpty(wfxResponse.getJob().getTechnicianNum())){
			workOrderResponse.getWorkOrder().getJob().setTechnicianNum(wfxResponse.getJob().getTechnicianNum().toString());
		}
//		isJobReasonCodeMatch(referenceDataResponse,jobReasonCode, workOrderResponse.getWorkOrder().getSolutionDetails(),
//				wfxResponse.getJob().getJobTypeCd());
		//US1769239 - End
		return workOrderResponse;
	}

	/**
	 * //Created for #US1761689
	 * @param jobTypeMapping
	 * @param jobTypeCd
	 * @return
	 */
	default List<SolutionDetail> mapSolutionDetail(ReferenceDataResponse jobTypeMapping, String jobTypeCd) {
		LOG.info("get WFX wo - get solution details for the job type code :: "+jobTypeCd);
		if(jobTypeMapping==null || jobTypeCd.isEmpty())return null;
		List<SolutionDetail> solutionDetailsList = new ArrayList<>();
		SolutionDetail solutionDetails = null;
		// break forloop from attributes to next attribute subset
		exitattributeset:		
		for(AttributeSet attributeSet:jobTypeMapping.getAttributeSets()){
			boolean found=false;
			//exitattributesubset:
			for(AttributeSubSet attributeSubSet:attributeSet.getAttributeSubSets()){
				Map<String, String> map = new HashMap<String, String>();
				exitattribute:
				for(Attribute attribute:attributeSubSet.getAttributes()){
					String key=StringUtils.isEmpty(attribute.getAttributeKey())?"":attribute.getAttributeKey();
					String value=StringUtils.isEmpty(attribute.getAttributeValue())?"":attribute.getAttributeValue();							
					map.put(key,value );
					LOG.info("get WFX wo - job type code in reference data :: "+value+" for the key " + attribute.getAttributeKey());
					if(JobTypeMappingConstants.JOB_TYPE_CODE.getValue().equalsIgnoreCase(key)){
						if(jobTypeCd.equalsIgnoreCase(value))  	found=true;
						else {
							LOG.info("get WFX wo - no match job type code in wo "+jobTypeCd+" with job type code in reference data :: "+value);
							break exitattribute;
						}
					}
				}
				if(found==false) {
					//LOG.info("get WFX wo - no match job type code in wo with job type code in reference data :: "+jobTypeCd);
					//break exitattributesubset;
					continue;
				}
				solutionDetails = new SolutionDetail();
				for (Map.Entry<String, String> entry : map.entrySet()) {
					String key=entry.getKey();
					String value=entry.getValue();
				    LOG.debug("Key : " + key + " Value : " + value);
				    	
				    if(JobTypeMappingConstants.SOLUTION_TYPE.equalsIgnoreCase(attributeSubSet.getAttributeSubSetKey())){
						solutionDetails.setSolutionType(attributeSubSet.getAttributeSubSetValue());
					}
					if(JobTypeMappingConstants.ORDER_TYPE.equalsIgnoreCase(key)){
						solutionDetails.setOrderType(value);
					}
					if(JobTypeMappingConstants.TRANSPORT_TYPE.equalsIgnoreCase(key) 
							&& !JobTypeMappingConstants.TRANSPORT_TYPE_NA.equalsIgnoreCase(value)){
						solutionDetails.setTransportType(value);
					}
				}
				solutionDetailsList.add(solutionDetails);
				LOG.info("Solution detail found for the given job type code "+jobTypeCd+" is "+solutionDetails);
				break exitattributeset;
			}
			
		}
		
		return solutionDetailsList;

	}
	
	
	default List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> mapSolutionDetails(GetWorkOrderRule ruleValue) {

		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> solutionDetailsList = new ArrayList<>();
		if (ruleValue.getSolutionDetails() != null) {
			for (com.comcast.orion.workorder.bean.SolutionDetail solutionDetail : ruleValue.getSolutionDetails()) {
				com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail solutionDetails = new com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail();
				solutionDetails.setOrderType(solutionDetail.getOrderType());
				solutionDetails.setSolutionType(solutionDetail.getSolutionType());
				solutionDetailsList.add(solutionDetails);
			}
		}
		return solutionDetailsList;

	}

	default List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail> mapSolutionDetailsfromJobTypeCode(
			Map<String, Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>>
				jobTypeCdReasonCdSolnDtlMap, GetWorkorderBySiteIdResponse getWorkorderBySiteIdResponse) {
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>
			solutionDetailsList = new ArrayList<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>();
		List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>
				solnDtlsTempList = null;
		String jobReasonCodeWFX = getWorkorderBySiteIdResponse.getJob().getJobReasonCode();
		String jobTypeCodeWFX = getWorkorderBySiteIdResponse.getJob().getJobTypeCd();//It never be empty
		Map<String, List<com.comcast.orion.workorder.domain.getWorkorderBySiteId.SolutionDetail>>
				jobReasonCdSolnDtlMap = jobTypeCdReasonCdSolnDtlMap.get(jobTypeCodeWFX);
		if (jobReasonCdSolnDtlMap != null && jobReasonCdSolnDtlMap.size() > 0) {
			if (jobReasonCodeWFX != null && jobReasonCdSolnDtlMap.containsKey(jobReasonCodeWFX)) {
				solnDtlsTempList = jobReasonCdSolnDtlMap.get(jobReasonCodeWFX);
				if(!CollectionUtils.isEmpty(solnDtlsTempList) && solnDtlsTempList.size() > 0) {
					solutionDetailsList.add(solnDtlsTempList.get(0));
				}
			} else {
				for(String key : jobReasonCdSolnDtlMap.keySet()) {
					solnDtlsTempList = jobReasonCdSolnDtlMap.get(key);
					break;
				}
				if(!CollectionUtils.isEmpty(solnDtlsTempList) && solnDtlsTempList.size() > 0) {
					solutionDetailsList.add(solnDtlsTempList.get(0));
				}
			}
		}
		return solutionDetailsList;
	}

	/**
	 * //Created for #US1769239
	 * This method will be used to check whether WFX job reason code is match with Reference data job reason code value or not
	 * @param jobTypeMapping
	 * @param jobReasonCode
	 * return boolean
	 */
	default boolean isJobReasonCodeMatch(ReferenceDataResponse jobTypeMapping, String jobReasonCode,
										 List<SolutionDetail> solutionDetailsList, String jobTypeCode) {
		LOG.info("get WFX wo - To check job reason code present or not :: "+jobReasonCode);
		if(jobTypeMapping == null || StringUtils.isEmpty(jobReasonCode)
				|| CollectionUtils.isEmpty(solutionDetailsList) || StringUtils.isEmpty(jobTypeCode)) {
			LOG.info("GetWorkorder - WFX job reason code :: "+jobReasonCode+" does not match with reference data");
			return false;
		}
		for(AttributeSet attributeSet:jobTypeMapping.getAttributeSets()){
			if(jobReasonCode.equalsIgnoreCase(attributeSet.getAttributeSetValue())) {
				for (AttributeSubSet attributeSubSet : attributeSet.getAttributeSubSets()) {
					for (SolutionDetail solutionDetail : solutionDetailsList) {
						if (JobTypeMappingConstants.SOLUTION_TYPE.equalsIgnoreCase(attributeSubSet.getAttributeSubSetKey())
								&& attributeSubSet.getAttributeSubSetValue().equalsIgnoreCase(solutionDetail.getSolutionType())) {
							if ((isAttributeKeyValueMatch(attributeSubSet.getAttributes(),
									JobTypeMappingConstants.JOB_TYPE_CODE.getValue(), jobTypeCode))
								&& (isAttributeKeyValueMatch(attributeSubSet.getAttributes(),
									JobTypeMappingConstants.ORDER_TYPE, solutionDetail.getOrderType()))) {
								LOG.info("GetWorkorder - WFX job reason code :: " + jobReasonCode + " is matched with reference data");
								return true;
							}
						}
					}
				}
			}
		}
		LOG.info("GetWorkorder - WFX job reason code :: "+jobReasonCode+" does not match with reference data");
		return false;
	}

	/**
	 * Checks whether key value matches in Attribute
	 * @param attributeList
	 * @param key String
	 * @param value String
	 * @return boolean
	 */
	default boolean isAttributeKeyValueMatch(List<Attribute> attributeList, String key, String value) {
		if (CollectionUtils.isEmpty(attributeList)) {
			return false;
		}
		for (Attribute attribute : attributeList) {
			if (key.equalsIgnoreCase(attribute.getAttributeKey())
					&& value.equalsIgnoreCase(attribute.getAttributeValue())) {
				return true;
			}
		}
		return false;
	}
    //***************VMS TnFeature Response mapping starts*******************************************
	/**
	 * maps VMS TnFeature Response to OMW response
	 * @param designId
	 * @param dtTNFeaturesResponse
	 * @param primary 
	 * @param tntype 
	 * @param tnno 
	 * @return serviceDetailList
	 */
	default List<ServiceDetail> mapVMSTnFeatureResponse(DTTNFeaturesResponse dtTNFeaturesResponse, String tnno, String tntype, String primary) {
		List<ServiceDetail> serviceDetailList = new ArrayList<ServiceDetail>();	
		if(!ObjectUtils.isEmpty(dtTNFeaturesResponse)){
			if(!CollectionUtils.isEmpty(dtTNFeaturesResponse.getServices())){ 	      		 
				for(Service services : dtTNFeaturesResponse.getServices()) {
					if(!CollectionUtils.isEmpty(services.getService())){
						ServiceDetail serviceDetail = new ServiceDetail();
						List<Resource> resources = new ArrayList<Resource>();
						if(!StringUtils.isEmpty(services.getServiceID())){
							serviceDetail.setServiceId(services.getServiceID());
						}
						if(!StringUtils.isEmpty(services.getType())){
							serviceDetail.setServiceType(services.getType());
						}
						for(Service_ service : services.getService()) {
							Resource resource = new Resource();
							if(null!=service.getType()) {
								resource.setType(service.getType());
								if(null!=service.getAction()) {
									resource.setAction(service.getAction());
								}
								List<com.comcast.orion.workorder.domain.getworkorder.Attribute> omwAttributes = new ArrayList<com.comcast.orion.workorder.domain.getworkorder.Attribute>();
								if(!StringUtils.isEmpty(service.getTnNo())) {
									omwAttributes=mapOMWAttribute(tnno,service.getTnNo(),omwAttributes);
								}
								if(!StringUtils.isEmpty(service.getTnType())) {
									omwAttributes=mapOMWAttribute(tntype,service.getTnType(),omwAttributes);						
								}
								if(!StringUtils.isEmpty(service.getIsPrimary())) {
									omwAttributes=mapOMWAttribute(primary,service.getIsPrimary(), omwAttributes);					
								}
								resource.setAttributes(omwAttributes);
							}
							if(!CollectionUtils.isEmpty(service.getFeatures())) {
								List<com.comcast.orion.workorder.domain.getworkorder.Feature> omwFeatures = new ArrayList<com.comcast.orion.workorder.domain.getworkorder.Feature>();
								for(Feature feature: service.getFeatures()) {
									if(!ObjectUtils.isEmpty(feature)){
										com.comcast.orion.workorder.domain.getworkorder.Feature omwFeature = new com.comcast.orion.workorder.domain.getworkorder.Feature();
										if(!StringUtils.isEmpty(feature.getAction())){
											omwFeature.setAction(feature.getAction());  
										}
										if(!StringUtils.isEmpty(feature.getName())){
											omwFeature.setName(feature.getName());
										}
										if(!StringUtils.isEmpty(feature.getValue())){
											omwFeature.setValue(feature.getValue());
										}
										omwFeatures.add(omwFeature);
									}
								}
								resource.setFeatures(omwFeatures);
							}

							resources.add(resource);
						}  
						serviceDetail.setResources(resources); 
						serviceDetailList.add(serviceDetail);
					}

				}


			}
		}

		return serviceDetailList;
	}

	default List<com.comcast.orion.workorder.domain.getworkorder.Attribute> mapOMWAttribute(String key, String value, List<com.comcast.orion.workorder.domain.getworkorder.Attribute> omwAttributes) {
		com.comcast.orion.workorder.domain.getworkorder.Attribute omwAttribute = new com.comcast.orion.workorder.domain.getworkorder.Attribute();
		omwAttribute.setName(key);
		omwAttribute.setValue(value);
		omwAttributes.add(omwAttribute);
		return omwAttributes;		
	}
	//********VMS TnFeature Response mapping ends*******************************************

	default List<SolutionDetail> mapSolutionDetailsForGetWO(Map<String, Map<String, List<SolutionDetail>>>
			jobTypeCdReasonCdSolnDtlMap, GetWorkorderOMWResponse getWorkOrderResponse) {
		List<SolutionDetail> solutionDetailsList = new ArrayList<SolutionDetail>();
		List<SolutionDetail> solnDtlsTempList = null;
		String jobReasonCodeWFX = getWorkOrderResponse.getWorkOrder().getJob().getJobReasonCode();
		String jobTypeCodeWFX = getWorkOrderResponse.getWorkOrder().getJob().getJobTypeCd();//It never be empty
		Map<String, List<SolutionDetail>> jobReasonCdSolnDtlMap = jobTypeCdReasonCdSolnDtlMap.get(jobTypeCodeWFX);
		if (jobReasonCdSolnDtlMap != null && jobReasonCdSolnDtlMap.size() > 0) {
			if (jobReasonCodeWFX != null && jobReasonCdSolnDtlMap.containsKey(jobReasonCodeWFX)) {
				solnDtlsTempList = jobReasonCdSolnDtlMap.get(jobReasonCodeWFX);
				if(!CollectionUtils.isEmpty(solnDtlsTempList) && solnDtlsTempList.size() > 0) {
					solutionDetailsList.add(solnDtlsTempList.get(0));
				}
			} else {
				for(String key : jobReasonCdSolnDtlMap.keySet()) {
					solnDtlsTempList = jobReasonCdSolnDtlMap.get(key);
					break;
				}
				if(!CollectionUtils.isEmpty(solnDtlsTempList) && solnDtlsTempList.size() > 0) {
					solutionDetailsList.add(solnDtlsTempList.get(0));
				}
			}
		}
		return solutionDetailsList;
	}

}
