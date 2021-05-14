package com.comcast.orion.workorder.utils.mapper;

import java.util.Collection;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.siteResponse.LocationIdentifierInfo;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.domain.updatewo.Job;
import com.comcast.orion.workorder.domain.updatewo.JobLocation;
import com.comcast.orion.workorder.domain.updatewo.UpdateWORequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWOResponse;

/**
 * CancelWorkOrderMapper
 *
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CancelWorkOrderMapper {
	CancelWorkOrderMapper INSTANCE = Mappers.getMapper(CancelWorkOrderMapper.class);

	/**
	 * @param siteResponse
	 * @param reasonCodeList
	 * @return
	 */
	@Mapping(target = "updateWorkorderRequest.wfxDispatchLogin", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.job.dispatcherStatusCd", constant = "X")
	@Mapping(target = "updateWorkorderRequest.job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.jobLocation", source = "siteResponse.locationIdentifierInfo")
	@Mapping(target = "updateWorkorderRequest.job.reasonCodes", source = "reasonCodes", qualifiedByName = "mapReasonCodes")
	UpdateWORequest cancelWOReqToWFXUpdateWorkOrderRequest(SiteResponse siteResponse, List<String> reasonCodes);

	/**
	 * @param reasonCodes
	 * @return
	 */
	@Named("mapReasonCodes")
	public abstract List<String> mapJobReasonCodes(Collection<String> reasonCodes);

	/**
	 * @param siteResponse
	 * @param rescheduleRequest
	 * @return UpdateWORequest
	 */
	@Mapping(target = "updateWorkorderRequest.wfxDispatchLogin", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.job.dispatcherStatusCd", constant = "X")
	@Mapping(target = "updateWorkorderRequest.job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "updateWorkorderRequest.jobLocation", source = "siteResponse.locationIdentifierInfo")
	@Mapping(target = "updateWorkorderRequest.job.reasonCodes", source = "rescheduleRequest.workOrder.job.reasonCodes", qualifiedByName = "mapReasonCodes")
	UpdateWORequest cancelWOReqToWFXRescheduleUpdateWorkOrderRequest(SiteResponse siteResponse,
			RescheduleRequest rescheduleRequest);

	@Mapping(target = "status", source = "updateWOResponse.updateWorkorderResponse.response")
	@Mapping(target = "workOrderNumber", source = "updateWOResponse.updateWorkorderResponse.workOrderNum")
	RescheduleWorkorderResponse mapUpdateWOResponseToRescheduleResponse(UpdateWOResponse updateWOResponse);

	/**
	 * @param locationIdentifierInfo
	 * @return
	 */
	@Mapping(target = "addrId", source = "ELocId")
	JobLocation locationIdentifierInfoToJobLocation(LocationIdentifierInfo locationIdentifierInfo);

	/**
	 * @param workOrderNumber
	 * @return
	 */
	@Mapping(target = "cancelAppointmentRequest.appointmentId", source = "workOrderNumber")
	CancelApmtRequest scheduleWORequestToCancelAppointmentRequest(String workOrderNumber);

}
