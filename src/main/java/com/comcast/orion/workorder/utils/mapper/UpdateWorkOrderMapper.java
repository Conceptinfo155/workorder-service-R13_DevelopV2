package com.comcast.orion.workorder.utils.mapper;

import java.util.Collection;


import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import com.comcast.orion.wfx.domain.workorder.JobReasonCdList;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXUpdateWorkOrderResponse;
import com.comcast.orion.workorder.domain.locationResponse.LocationServiceResponse;
import com.comcast.orion.workorder.domain.locationResponse.PostalAddress;
import com.comcast.orion.workorder.domain.reschedule.request.Job;
import com.comcast.orion.workorder.domain.reschedule.request.JobCustomer;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.request.WorkOrder;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;

/**
 * UpdateWorkOrderMapper
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UpdateWorkOrderMapper {

	

	/**
	 * @param locationResponse
	 * @return UpdateWorkorderRequest
	 */
	
	//US1715624 changes
	@Mappings({ @Mapping(target = "businessUnit", source = "responseItems.marketInfo.legacyMarketInfo.DSTMarketID.franchiseTaxArea"),
			@Mapping(target = "routeCriteria", source = "responseItems.billingDetailsInfo.csgDetails.CSGDetailsType.technicianArea"),
			@Mapping(target = "jobLocation.address.addrLine1", source = "responseItems.postalAddress"),
			@Mapping(target = "jobLocation.address.city", source = "responseItems.postalAddress.city"),
			@Mapping(target = "jobLocation.address.state", source = "responseItems.postalAddress.state"),
			@Mapping(target = "jobLocation.address.zipCode", source = "responseItems.postalAddress.zipCode.zip5") })

	UpdateWorkorderRequest locationResponseToWorkOrderRequest(LocationServiceResponse locationResponse);

	/* Override toString method */
	/**
	 * @param postalAddress
	 * @return address
	 */
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
	 * @return WFXUpdateWorkOrderRequest
	 */
	@Mappings({
			// job mapping
			@Mapping(target = "WFXDispatchLogin", source = "wfxDispatchLogin"),
			@Mapping(target = "job.businessUnit", source = "businessUnit"),
			@Mapping(target = "job.dispatcherStatusCd", source = "job.dispatcherStatusCd"),
			// @Mapping(target =
			// "job.createDateTime",dateFormat="YYYY-MM-DDTHH:MM:SS",source="job.createDateTime"),
			//@Mapping(target = "job.jobNum", source = "job.jobNum"),
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
			//@Mapping(target = "jobCustomer.customerId", source = "jobCustomer.customerId"),
			@Mapping(target = "jobCustomer.lastName", source = "jobCustomer.lastName"),
			@Mapping(target = "jobCustomer.firstName", source = "jobCustomer.firstName"),
			@Mapping(target = "jobCustomer.workPhoneNum", source = "jobCustomer.workPhoneNum"),
			@Mapping(target = "jobCustomer.emailAddr", source = "jobCustomer.emailAddr"),
			@Mapping(target = "jobCustomer.homePhoneNum", source = "jobCustomer.homePhoneNum"),
			// jobLocation Mapping
			@Mapping(target = "jobLocation.address.addrLine1", source = "jobLocation.address.addrLine1"),
			@Mapping(target = "jobLocation.address.city", source = "jobLocation.address.city"),
			@Mapping(target = "jobLocation.address.state", source = "jobLocation.address.state"),
			@Mapping(target = "jobLocation.address.zipCode", source = "jobLocation.address.zipCode"),
			@Mapping(target = "jobLocation.addrId", source = "jobLocation.addrId"), })
	WFXUpdateWorkOrderRequest workOrderReqToWFXUpdateWorkOrderRequest(UpdateWorkorderRequest source);

	@Mapping(target = "jobReasonCd", source = "reasonCodes")
	JobReasonCdList mapJobReasonCode(String reasonCodes);

	@Mapping(target = "updateWorkorderRequest.wfxDispatchLogin", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.job.dispatcherStatusCd", constant = "R")
	@Mapping(target = "updateWorkorderRequest.job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.job.reasonCodes", source = "workOrder.job.reasonCodes", qualifiedByName = "mapReasonCodes")
	@Mapping(target = "updateWorkorderRequest.job.scheduleDate", source = "workOrder.job.scheduleDate")
	@Mapping(target = "updateWorkorderRequest.job.timeSlotCd", source = "workOrder.job.timeSlotCd")
	@Mapping(target = "updateWorkorderRequest.job.jobComment", source = "workOrder.job.jobComment")
	@Mapping(target = "updateWorkorderRequest.job.troubleCallIndicator", source = "workOrder.job.troubleCallIndicator")
	@Mapping(target = "updateWorkorderRequest.job.callFirstPhoneNum", source = "workOrder.job.callFirstPhoneNum")
	@Mapping(target = "updateWorkorderRequest.job.orderComment", source = "workOrder.job.orderComment")
	@Mapping(target = "updateWorkorderRequest.jobCustomer.firstName", source = "workOrder.jobCustomer.firstName")
	@Mapping(target = "updateWorkorderRequest.jobCustomer.lastName", source = "workOrder.jobCustomer.lastName")
	@Mapping(target = "updateWorkorderRequest.jobCustomer.homePhoneNum", source = "workOrder.jobCustomer.homePhoneNum")
	@Mapping(target = "updateWorkorderRequest.jobCustomer.workPhoneNum", source = "workOrder.jobCustomer.workPhoneNum")
	@Mapping(target = "updateWorkorderRequest.jobCustomer.emailAddr", source = "workOrder.jobCustomer.emailAddr")
	UpdateWORequest wfxRequestToUpdateWorkOrderRequest(RescheduleRequest rescheduleRequest);

	/**
	 * @param reasonCodes
	 * @return
	 */
	@Named("mapReasonCodes")
	public abstract List<String> mapJobReasonCodes(Collection<String> reasonCodes);

	default UpdateWORequest maprequestToUpdateWORequest(RescheduleRequest rescheduleRequest,
			SiteResponse siteResponse) {

		RescheduleRequest rescheduleUpdate = new RescheduleRequest();
		Job job = new Job();
		WorkOrder workOrder = new WorkOrder();
		rescheduleUpdate.setWorkOrder(workOrder);
		job.setScheduleDate(rescheduleRequest.getWorkOrder().getJob().getScheduleDate());
		job.setTimeSlotCd(rescheduleRequest.getWorkOrder().getJob().getTimeSlotCd());
		job.setJobComment(rescheduleRequest.getWorkOrder().getJob().getJobComment());
		job.setTroubleCallIndicator(rescheduleRequest.getWorkOrder().getJob().getTroubleCallIndicator());
		job.setCallFirstPhoneNum(rescheduleRequest.getWorkOrder().getJob().getCallFirstPhoneNum());
		job.setOrderComment(rescheduleRequest.getWorkOrder().getJob().getOrderComment());
		job.setReasonCodes(rescheduleRequest.getWorkOrder().getJob().getReasonCodes());
		////Added below code as part of US1819565
		job.setTechnicianNum(rescheduleRequest.getWorkOrder().getJob().getTechnicianNum());
		if (rescheduleRequest.getWorkOrder().getJobCustomer() != null) {
			JobCustomer jobCustomer = new JobCustomer();
			jobCustomer.setFirstName(rescheduleRequest.getWorkOrder().getJobCustomer().getFirstName());
			jobCustomer.setLastName(rescheduleRequest.getWorkOrder().getJobCustomer().getLastName());
			jobCustomer.setHomePhoneNum(rescheduleRequest.getWorkOrder().getJobCustomer().getHomePhoneNum());
			jobCustomer.setWorkPhoneNum(rescheduleRequest.getWorkOrder().getJobCustomer().getWorkPhoneNum());
			jobCustomer.setEmailAddr(rescheduleRequest.getWorkOrder().getJobCustomer().getEmailAddr());
			rescheduleUpdate.getWorkOrder().setJobCustomer(jobCustomer);
		}
		rescheduleUpdate.getWorkOrder().setJob(job);

		UpdateWORequest workOrderUpdateRequest = wfxRequestToUpdateWorkOrderRequest(rescheduleUpdate);
		if (siteResponse != null) {
			com.comcast.orion.workorder.domain.updatewo.JobLocation jobLocation = new com.comcast.orion.workorder.domain.updatewo.JobLocation();
			if (siteResponse.getLocationIdentifierInfo() != null) {
				jobLocation.setAddrId(siteResponse.getLocationIdentifierInfo().getELocId());
			}
			if (workOrderUpdateRequest.getUpdateWorkorderRequest() != null) {
				workOrderUpdateRequest.getUpdateWorkorderRequest().setJobLocation(jobLocation);
			}
		}
		return workOrderUpdateRequest;
	}

	/**
	 * @param source
	 * @return UpdateWorkorderResponse
	 */
	@Mappings({ @Mapping(target = "response", source = "response"),
			@Mapping(target = "workOrderNum", source = "workOrderNum"), })
	UpdateWorkorderResponse wfxUpdateWorkOrderResponseToWFXUpdateWorkOrderResponse(WFXUpdateWorkOrderResponse source);

	/**
	 * @param source
	 * @return WFXUpdateWorkOrderRequest
	 */
	@Mappings({
			// job mapping
			@Mapping(target = "WFXDispatchLogin", source = "wfxDispatchLogin"),
			@Mapping(target = "codeSrc", constant = "WFX"),
			@Mapping(target = "job.businessUnit", source = "businessUnit"),
			@Mapping(target = "job.dispatcherStatusCd", source = "job.dispatcherStatusCd"),
			// @Mapping(target =
			// "job.createDateTime",dateFormat="YYYY-MM-DDTHH:MM:SS",source="job.createDateTime"),
			//@Mapping(target = "job.jobNum", source = "job.jobNum"),
			@Mapping(target = "job.scheduleDate", source = "job.scheduleDate"),
			@Mapping(target = "job.timeSlotCd", source = "job.timeSlotCd"),
			@Mapping(target = "job.jobTypeCd", source = "job.jobTypeCd"),
			@Mapping(target = "job.jobUnits", source = "job.jobUnits"),
			@Mapping(target = "job.callFirstPhoneNum", source = "job.callFirstPhoneNum"),
			@Mapping(target = "job.troubleCallIndicator", source = "job.troubleCallIndicator"),
			@Mapping(target = "job.jobComment", source = "job.jobComment"),
			@Mapping(target = "job.orderComment", source = "job.orderComment"),
			@Mapping(target = "job.technicianNum", source = "job.technicianNum"),
			@Mapping(target = "job.orderMgtSystem",ignore=true),
			@Mapping(target = "job.jobReasonCdList", source = "job.reasonCodes"),
			// jobCustomer mapping
			//@Mapping(target = "jobCustomer.customerId", source = "jobCustomer.customerId"),
			@Mapping(target = "jobCustomer.lastName", source = "jobCustomer.lastName"),
			@Mapping(target = "jobCustomer.firstName", source = "jobCustomer.firstName"),
			@Mapping(target = "jobCustomer.workPhoneNum", source = "jobCustomer.workPhoneNum"),
			@Mapping(target = "jobCustomer.emailAddr", source = "jobCustomer.emailAddr"),
			@Mapping(target = "jobCustomer.homePhoneNum", source = "jobCustomer.homePhoneNum"),
			// jobLocation Mapping
			@Mapping(target = "jobLocation.address.addrLine1", source = "jobLocation.address.addrLine1"),
			@Mapping(target = "jobLocation.address.city", source = "jobLocation.address.city"),
			@Mapping(target = "jobLocation.address.state", source = "jobLocation.address.state"),
			@Mapping(target = "jobLocation.address.zipCode", source = "jobLocation.address.zipCode"),
			@Mapping(ignore = true, target = "jobLocation.address") })

	com.comcast.orion.workorder.domain.nWFX.update.WFXNewUpdateWorkOrderRequest workOrderReqToWFXUpdateRequest(
			UpdateWorkorderRequest workOrderRequest);

	@Mapping(target = "jobReasonCd", source = "reasonCodes")
	com.comcast.orion.workorder.domain.nWFX.update.JobReasonCdList mapJobReasonCode1(String reasonCodes);

}