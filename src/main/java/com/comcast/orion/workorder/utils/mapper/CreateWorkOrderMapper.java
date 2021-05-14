package com.comcast.orion.workorder.utils.mapper;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.comcast.orion.wfx.domain.workorder.JobReasonCdList;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.domain.createwo.ChildProductsList;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderResponse;
import com.comcast.orion.workorder.domain.createwo.JobProductList;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.locationResponse.PostalAddress;
import com.comcast.orion.workorder.domain.locationResponse.ResponseItems;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;

/**
 * CreateWorkOrderMapper
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreateWorkOrderMapper {
	CreateWorkOrderMapper INSTANCE = Mappers.getMapper(CreateWorkOrderMapper.class);
	public static final String O_SITE = "OSite_";


	/**
	 * @param locationServiceResponse
	 * @return CreateWorkorderRequest
	 * 
	 */
	//US1715624 changes
	
	    //businessUnit mapping
	@Mappings({ @Mapping(target = "businessUnit", source = "responseItems.marketInfo.legacyMarketInfo.DSTMarketID.franchiseTaxArea"),
		//routeCriteria mapping
		@Mapping(target = "routeCriteria", source = "responseItems.billingDetailsInfo.csgDetails.CSGDetailsType.technicianArea"),
		//jobLocation mapping
		@Mapping(target = "jobLocation.address.addrLine1", source = "responseItems.postalAddress"),
		@Mapping(target = "jobLocation.address.city", source = "responseItems.postalAddress.city"),
		@Mapping(target = "jobLocation.address.state", source = "responseItems.postalAddress.state"),
		@Mapping(target = "jobLocation.address.zipCode", source = "responseItems.postalAddress.zipCode.zip5") ,
	
	@Mapping(target = "jobLocation.node", source = "responseItems.networkConnectivityInfo.fiberNodeName"),
	@Mapping(target = "jobLocation.dropType", source = "responseItems.billingDetailsInfo.csgDetails.dropType"),
	@Mapping(target = "jobLocation.hookupType", source = "responseItems.billingDetailsInfo.csgDetails.hookupType"),
	@Mapping(target = "jobLocation.managementArea", source = "responseItems.billingDetailsInfo.csgDetails.CSGDetailsType.technicianArea"),
	
	@Mapping(target = "jobLocation.bridgerAddress", source = "responseItems", qualifiedByName = { "mapBridgerAddressFromLocation" }),
	@Mapping(target = "jobLocation.dropTag1", source = "responseItems", qualifiedByName = { "mapDropTag1FromLocation" }),
	@Mapping(target = "jobLocation.dropTag2", source = "responseItems", qualifiedByName = { "mapDropTag2FromLocation" }),
	@Mapping(target = "jobLocation.dropTag3", source = "responseItems", qualifiedByName = { "mapDropTag3FromLocation" })})
	CreateWorkorderRequest locationResponseToWorkOrderRequest(LocationServiceResponse locationServiceResponse);
	
	/**
	 * @param postalAddress
	 * @return addressLine
	 */
	       //this method postal address in string format
	default String toString(PostalAddress postalAddress) {
		StringBuilder addressLine1 = new StringBuilder();
		if (postalAddress != null) {
			if (postalAddress.getHouseNumberPrefix() != null) {
				addressLine1.append(postalAddress.getHouseNumberPrefix() + " ");
			}
			if (postalAddress.getHouseNumber() != null) {
				addressLine1.append(postalAddress.getHouseNumber() + " ");
			}
			if (postalAddress.getHouseNumberSuffix() != null) {
				addressLine1.append(postalAddress.getHouseNumberSuffix() + " ");
			}
			if (postalAddress.getStreetPreDirection() != null) {
				addressLine1.append(postalAddress.getStreetPreDirection() + " ");
			}
			if (postalAddress.getStreetName() != null) {
				addressLine1.append(postalAddress.getStreetName() + " ");
			}
			if (postalAddress.getStreetSuffix() != null) {
				addressLine1.append(postalAddress.getStreetSuffix() + " ");
			}
			if (postalAddress.getStreetPostDirection() != null) {
				addressLine1.append(postalAddress.getStreetPostDirection());
			}
		}
		return addressLine1.toString();
	}

	
	/**
	 * @param source
	 * @return WFXCreateWorkOrderRequest
	 */
	@Mappings({ 
			@Mapping(target = "WFXDispatchLogin", source = "wfxDispatchLogin"),
			// job mapping
			@Mapping(target = "job.businessUnit", source = "businessUnit"),
			@Mapping(target = "job.dispatcherStatusCd", source = "job.dispatcherStatusCd"),
			@Mapping(target = "job.createDateTime", dateFormat = "YYYY-MM-DDTHH:MM:SS", source = "createDateTime"),
			@Mapping(target = "job.jobNum", source = "job.jobNum"),
			@Mapping(target = "job.scheduleDate", source = "job.scheduleDate"),
			@Mapping(target = "job.timeSlotCd", source = "job.timeSlotCd"),
			@Mapping(target = "job.jobTypeCd", source = "job.jobTypeCd"),
			@Mapping(target = "job.jobUnits", source = "job.jobUnits"),
			@Mapping(target = "job.callFirstPhoneNum", source = "job.callFirstPhoneNum"),
			@Mapping(target = "job.troubleCallIndicator", source = "job.troubleCallIndicator"),
			@Mapping(target = "job.jobComment", source = "job.jobComment"),
			@Mapping(target = "job.orderComment", source = "job.orderComment"),
			@Mapping(target = "job.orderMgtSystem", source = "job.orderMgtSystem"),
			@Mapping(target = "job.jobReasonCdList", source = "job.reasonCodes"),
			// jobCustomer mapping
			@Mapping(target = "jobCustomer.customerId", source = "jobCustomer.customerId"),
			@Mapping(target = "jobCustomer.lastName", source = "jobCustomer.lastName"),
			@Mapping(target = "jobCustomer.firstName", source = "jobCustomer.firstName"),
			@Mapping(target = "jobCustomer.workPhoneNum", source = "jobCustomer.workPhoneNum"),
			@Mapping(target = "jobCustomer.emailAddr", source = "jobCustomer.emailAddr"),
			@Mapping(target = "jobCustomer.homePhoneNum", source = "jobCustomer.homePhoneNum"),
			//@Mapping(target = "jobCustomer.accountId", expression = "java(jobCustomer.getSiteId() != null && jobCustomer.getSiteId().length()>16 && jobCustomer.getSiteId().startsWith(\"OSite_\") ? jobCustomer.getSiteId().replaceFirst(\"OSite_\", \"\") : jobCustomer.getSiteId())"),
			@Mapping(target = "jobCustomer.accountId", source = "jobCustomer.siteId"),
			// jobLocation Mapping
			@Mapping(target = "jobLocation.address.addrLine1", source = "jobLocation.address.addrLine1"),
			@Mapping(target = "jobLocation.address.city", source = "jobLocation.address.city"),
			@Mapping(target = "jobLocation.address.state", source = "jobLocation.address.state"),
			@Mapping(target = "jobLocation.address.zipCode", source = "jobLocation.address.zipCode"),
			@Mapping(target = "jobLocation.routeCriteria", source = "routeCriteria"),
			@Mapping(target = "jobLocation.addrId", source = "jobLocation.addrId"),
			// JobProductList Mapping
			@Mapping(target = "jobProductList", source = "jobProductList"),
			// JobEquipmentList Mapping
			@Mapping(target = "jobEquipmentList", source = "jobEquipmentList"), })
	WFXCreateWorkOrderRequest workOrderReqToWFXCreateWorkOrderRequest(CreateWorkorderRequest source);

	
	
	@Mapping(target = "jobReasonCd", source = "reasonCodes")
	// @Mapping(target = "jobReasonCd", expression = "java((reasonCodes != null &&
	// !reasonCodes.isEmpty()) ? java.util.Arrays.asList(reasonCodes) : \"\" )" )
	JobReasonCdList mapJobReasonCode(String reasonCodes);

	//@Named("getReasonCodeList")
	//public abstract List<String> getReasonCodeList(Collection<String> reasonCodes);
	 
	/**
	 * @param jobProductList
	 * @return wfxList
	 */
	default List<com.comcast.orion.wfx.domain.workorder.JobProductList> toList(List<JobProductList> jobProductList) {
		List<com.comcast.orion.wfx.domain.workorder.JobProductList> wfxList = new ArrayList<>();
		com.comcast.orion.wfx.domain.workorder.JobProductList wfxJobProdList = new com.comcast.orion.wfx.domain.workorder.JobProductList();
		for (JobProductList jobProd : jobProductList) {
			wfxJobProdList.setParentProductCd(jobProd.getParentProductCd());
			wfxJobProdList.setParentProductDesc(jobProd.getParentProductDesc());
			wfxJobProdList.setActionCd(jobProd.getActionCd().value());
			wfxJobProdList.setQuantity(jobProd.getQuantity().toString());
			wfxJobProdList.setProductLOB(jobProd.getProductLOB().value());
			wfxJobProdList.setVoicePhoneNum(jobProd.getVoicePhoneNum());
			wfxJobProdList.setVoipPortNum(jobProd.getVoipPortNum());
			wfxJobProdList.setAccountId(jobProd.getSiteId() != null && jobProd.getSiteId().length()>16 && jobProd.getSiteId().startsWith(O_SITE) ? jobProd.getSiteId().replaceFirst(O_SITE, "") : jobProd.getSiteId());
			wfxJobProdList.setOutlet(jobProd.getOutlet());
			List<com.comcast.orion.wfx.domain.workorder.ChildProductList> wfxchildProductsList = new ArrayList<>();
			List<ChildProductsList> childProductsList = jobProd.getChildProductsList();
			if (childProductsList != null) {
				for (ChildProductsList list : childProductsList) {
					com.comcast.orion.wfx.domain.workorder.ChildProductList wfxChildProduct = new com.comcast.orion.wfx.domain.workorder.ChildProductList();
					wfxChildProduct.setChildProductCd(list.getChildProductCd());
					wfxChildProduct.setChildProductDesc(list.getChildProductDesc());
					wfxChildProduct.setActionCd(list.getActionCd().value());
					wfxChildProduct.setQuantity(list.getQuantity().toString());
					if(list.getProductLOB()!=null) {
						wfxChildProduct.setProductLOB(list.getProductLOB().value());
					}
					
					wfxChildProduct.setVoicePhoneNum(list.getVoicePhoneNum());
					wfxChildProduct.setVoipPortNum(list.getVoipPortNum());
					wfxChildProduct.setAccountId(list.getSiteId() != null && list.getSiteId().length()>16&&  list.getSiteId().startsWith(O_SITE) ? list.getSiteId().replaceFirst(O_SITE, "") : list.getSiteId());
					wfxChildProduct.setOutlet(list.getOutlet());
					wfxchildProductsList.add(wfxChildProduct);
				}
				wfxJobProdList.setChildProductList(wfxchildProductsList);
			}
			wfxList.add(wfxJobProdList);
		}
		return wfxList;

	}

	/**
	 * @param source
	 * @return CreateWorkorderResponse
	 */
	      //response mapping
	@Mappings({ @Mapping(target = "response", source = "response"),
		     //workOrderNum mapping
			@Mapping(target = "workOrderNum", source = "workOrderNum"), })
	CreateWorkorderResponse wfxCreateWorkOrderResponeToCreateWorkOrderResponse(WFXCreateWorkOrderRespone source);
	
	/**
	 * @param source
	 * @return newWFXCreateWorkOrderRequest
	 */
	@Mappings({ 
			@Mapping(target = "WFXDispatchLogin", source = "wfxDispatchLogin"),
			@Mapping(target = "codeSrc", constant = "WFX"),
			// job mapping
			@Mapping(target = "job.businessUnit", source = "businessUnit"),
			@Mapping(target = "job.dispatcherStatusCd", source = "job.dispatcherStatusCd"),
			@Mapping(target = "job.createDateTime", dateFormat = "YYYY-MM-DDTHH:MM:SS", source = "createDateTime"),
			@Mapping(target = "job.jobNum", source = "job.jobNum"),
			@Mapping(target = "job.scheduleDate", source = "job.scheduleDate"),
			@Mapping(target = "job.timeSlotCd", source = "job.timeSlotCd"),
			@Mapping(target = "job.jobTypeCd", source = "job.jobTypeCd"),
			@Mapping(target = "job.jobUnits", source = "job.jobUnits"),
			@Mapping(target = "job.callFirstPhoneNum", source = "job.callFirstPhoneNum"),
			@Mapping(target = "job.troubleCallIndicator", source = "job.troubleCallIndicator"),
//			@Mapping(target = "job.jobComment", source = "job.jobComment"),
			@Mapping(target = "job.orderComment", source = "job.orderComment"),
			@Mapping(target = "job.orderMgtSystem", source = "job.orderMgtSystem"),
			@Mapping(target = "job.jobReasonCdList", source = "job.reasonCodes"),
			@Mapping(target = "job.technicianNum", source = "job.technicianNum"),
			// jobCustomer mapping
			@Mapping(target = "jobCustomer.customerId", source = "jobCustomer.customerId"),
			@Mapping(target = "jobCustomer.lastName", source = "jobCustomer.lastName"),
			@Mapping(target = "jobCustomer.firstName", source = "jobCustomer.firstName"),
			@Mapping(target = "jobCustomer.workPhoneNum", source = "jobCustomer.workPhoneNum"),
			@Mapping(target = "jobCustomer.emailAddr", source = "jobCustomer.emailAddr"),
			@Mapping(target = "jobCustomer.homePhoneNum", source = "jobCustomer.homePhoneNum"),
			//@Mapping(target = "jobCustomer.accountId", expression = "java(jobCustomer.getSiteId() != null && jobCustomer.getSiteId().length()>16 && jobCustomer.getSiteId().startsWith(\"OSite_\") ? jobCustomer.getSiteId().replaceFirst(\"OSite_\", \"\") : jobCustomer.getSiteId())"),
			@Mapping(target = "jobCustomer.accountId", source = "jobCustomer.siteId"),
			// jobLocation Mapping
			@Mapping(target = "jobLocation.address.addrLine1", source = "jobLocation.address.addrLine1"),
			@Mapping(target = "jobLocation.address.city", source = "jobLocation.address.city"),
			@Mapping(target = "jobLocation.address.state", source = "jobLocation.address.state"),
			@Mapping(target = "jobLocation.address.zipCode", source = "jobLocation.address.zipCode"),
			@Mapping(target = "jobLocation.routeCriteria", source = "routeCriteria"),
			@Mapping(target = "jobLocation.addrId", source = "jobLocation.addrId"),
			// JobProductList Mapping
			@Mapping(target = "jobProductList", source = "jobProductList"),
			// JobEquipmentList Mapping
			@Mapping(target = "jobEquipmentList", source = "jobEquipmentList"), 
			
			@Mapping(target = "jobLocation.node", source = "jobLocation.node"),
			@Mapping(target = "jobLocation.dropType", source = "jobLocation.dropType"),
			@Mapping(target = "jobLocation.hookupType", source = "jobLocation.hookupType"),
			@Mapping(target = "jobLocation.managementArea", source = "jobLocation.managementArea"),
			@Mapping(target = "jobLocation.bridgerAddress", source = "jobLocation.bridgerAddress"),
			@Mapping(target = "jobLocation.dropTag1", source = "jobLocation.dropTag1"),
			@Mapping(target = "jobLocation.dropTag2", source = "jobLocation.dropTag2"),
			@Mapping(target = "jobLocation.dropTag3", source = "jobLocation.dropTag3")})
	com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest workOrderReqToWFXCreateRequest(
			CreateWorkorderRequest workOrderRequest);
	
	@Mapping(target = "jobReasonCd", source = "reasonCodes")
	com.comcast.orion.workorder.domain.nWFX.create.JobReasonCdList mapJobReasonCode1(String reasonCodes);
	
	/**
	 * @param jobProductList
	 * @return wfxList
	 */
	default List<com.comcast.orion.workorder.domain.nWFX.create.JobProductList> jobProductListListToJobProductListList(List<JobProductList> jobProductList) {
		List<com.comcast.orion.workorder.domain.nWFX.create.JobProductList> wfxList = new ArrayList<>();
		com.comcast.orion.workorder.domain.nWFX.create.JobProductList wfxJobProdList = new com.comcast.orion.workorder.domain.nWFX.create.JobProductList();
		for (JobProductList jobProd : jobProductList) {
			wfxJobProdList.setParentProductCd(jobProd.getParentProductCd());
			wfxJobProdList.setParentProductDesc(jobProd.getParentProductDesc());
			wfxJobProdList.setActionCd(jobProd.getActionCd().value());
			//wfxJobProdList.setQuantity(jobProd.getQuantity().toString());
			wfxJobProdList.setProductLOB(jobProd.getProductLOB().value());
			wfxJobProdList.setVoicePhoneNum(jobProd.getVoicePhoneNum());
			wfxJobProdList.setVoipPortNum(jobProd.getVoipPortNum());
			wfxJobProdList.setAccountId(jobProd.getSiteId() != null && jobProd.getSiteId().length()>16 && jobProd.getSiteId().startsWith(O_SITE) ? jobProd.getSiteId().replaceFirst(O_SITE, "") : jobProd.getSiteId());
			wfxJobProdList.setOutlet(jobProd.getOutlet());
			List<com.comcast.orion.workorder.domain.nWFX.create.ChildProductsList> wfxchildProductsList = new ArrayList<>();
			List<ChildProductsList> childProductsList = jobProd.getChildProductsList();
			if (childProductsList != null) {
				for (ChildProductsList list : childProductsList) {
					com.comcast.orion.workorder.domain.nWFX.create.ChildProductsList wfxChildProduct = new com.comcast.orion.workorder.domain.nWFX.create.ChildProductsList();
					wfxChildProduct.setChildProductCd(list.getChildProductCd());
					wfxChildProduct.setChildProductDesc(list.getChildProductDesc());
					wfxChildProduct.setActionCd(list.getActionCd().value());
					//wfxChildProduct.setQuantity(list.getQuantity().toString());
					if(list.getProductLOB()!=null) {
						wfxChildProduct.setProductLOB(list.getProductLOB().value());
					}
					
					wfxChildProduct.setVoicePhoneNum(list.getVoicePhoneNum());
					wfxChildProduct.setVoipPortNum(list.getVoipPortNum());
					wfxChildProduct.setAccountId(list.getSiteId() != null && list.getSiteId().length()>16&&  list.getSiteId().startsWith(O_SITE) ? list.getSiteId().replaceFirst(O_SITE, "") : list.getSiteId());
					wfxChildProduct.setOutlet(list.getOutlet());
					wfxchildProductsList.add(wfxChildProduct);
				}
				wfxJobProdList.setChildProductsList(wfxchildProductsList);
			}
			wfxList.add(wfxJobProdList);
		}
		return wfxList;

	}

	@Mappings({ 
	@Mapping(target = "businessUnit", source = "marketInfo.DSTMarketID.franchiseTaxArea"),
	@Mapping(target = "routeCriteria", source = "billingDetailsInfo.csgDetails.technicianArea"),
	@Mapping(target = "jobLocation.address.addrLine1", source = "siteAddress.addressLine1"),
	@Mapping(target = "jobLocation.address.city", source = "siteAddress.city"),
	@Mapping(target = "jobLocation.address.state", source = "siteAddress.state"),
	@Mapping(target = "jobLocation.address.zipCode",ignore = true) })
	CreateWorkorderRequest siteResponseToWorkOrderRequest(SiteResponse siteDetail);
	default CreateWorkorderRequest mappingSiteResponseToWorkorderRequest(SiteResponse siteDetail){
		CreateWorkorderRequest createWorkorderRequest = siteResponseToWorkOrderRequest(siteDetail);
		if(siteDetail.getTimeZoneInfo() !=null && siteDetail.getTimeZoneInfo().getZip5() !=null){
			createWorkorderRequest.getJobLocation().getAddress().setZipCode(siteDetail.getTimeZoneInfo().getZip5());
		}
		return createWorkorderRequest;
	}
	
	@Named("mapBridgerAddressFromLocation")
	default String mapBridgerAddressFromLocation(ResponseItems responseItems) {
		String bridgerAddress = null;
		if (responseItems != null && responseItems.getBillingDetailsInfo() != null
				&& responseItems.getBillingDetailsInfo().getCsgDetails() != null
				&& responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress() != null
				&& (responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
						.getBridgerBidirectional() != null
						|| responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
								.getBridgerGateControl() != null
						|| responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
								.getBridgerPrivate() != null)) {
			String emptyString = "";
			String bidirect = responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerBidirectional() == null ? emptyString
							: responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerBidirectional();
			String gateCtrl = responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerGateControl() == null ? emptyString
							: responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerGateControl();
			String pvt = responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
					.getBridgerPrivate() == null ? emptyString
							: responseItems.getBillingDetailsInfo().getCsgDetails().getBridgerAddress()
									.getBridgerPrivate();
			bridgerAddress = bidirect + gateCtrl + pvt;
		}
		return bridgerAddress;
	}
	
	@Named("mapDropTag1FromLocation")
	default String mapDropTag1FromLocation(ResponseItems responseItems){
		return mapDropTagFromLocation("1",responseItems);
	}
	
	@Named("mapDropTag2FromLocation")
	default String mapDropTag2FromLocation(ResponseItems responseItems){
		return mapDropTagFromLocation("2",responseItems);
	}
	
	@Named("mapDropTag3FromLocation")
	default String mapDropTag3FromLocation(ResponseItems responseItems){
		return mapDropTagFromLocation("3",responseItems);
	}

	default String mapDropTagFromLocation(String index, ResponseItems responseItems) {
		if (responseItems != null && responseItems.getBillingDetailsInfo() != null
				&& responseItems.getBillingDetailsInfo().getCsgDetails() != null
				&& responseItems.getBillingDetailsInfo().getCsgDetails().getLineTagList() != null) {
			com.comcast.orion.workorder.domain.locationResponse.LineTagList lineTag = responseItems.getBillingDetailsInfo().getCsgDetails().getLineTagList().stream()
					.filter(ltl -> ltl != null && ltl.getIndex().equals(index)).findFirst().orElse(null);
			if(lineTag != null) {
				return lineTag.getValue();
			}
		}
		return null;
	}
}
