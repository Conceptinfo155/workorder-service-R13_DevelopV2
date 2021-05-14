package com.comcast.orion.workorder.utils.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import com.comcast.orion.workorder.domain.getWorkorderBySiteId.GetWorkorderBySiteIdResponse;
import com.comcast.orion.workorder.domain.getWorkorderBySiteId.JobCommentTypeCdList;
import com.comcast.orion.workorder.domain.getfutureworkorder.Characteristic;
import com.comcast.orion.workorder.domain.getfutureworkorder.Characteristic_;
import com.comcast.orion.workorder.domain.getfutureworkorder.DependentService;
import com.comcast.orion.workorder.domain.getfutureworkorder.Equipment;
import com.comcast.orion.workorder.domain.getfutureworkorder.Service;
import com.comcast.orion.workorder.domain.getfutureworkorder.WorkOrderDetail;
import com.comcast.orion.workorder.domain.getworkorder.WorkorderResponse;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface GetFutureWorkOrderMapper {

	@Mapping(target = "workOrderId", source = "futureWorkOrderOdoResponse.workOrderDetails.workOrderId")
	@Mapping(target = "agreementId", source = "futureWorkOrderOdoResponse.workOrderDetails.agreementId")
	@Mapping(target = "customerId", source = "futureWorkOrderOdoResponse.workOrderDetails.customerId")
	@Mapping(target = "siteId", source = "futureWorkOrderOdoResponse.workOrderDetails.siteId")
	@Mapping(target = "equipment", source = "futureWorkOrderOdoResponse.workOrderDetails.equipment", qualifiedByName = {
			"mapEquipmentList" })
	// @Mapping(target = "techId", source = "futureWorkOrderWFXResponse.Job.TechId")
	@Mapping(target = "jobNum", source = "futureWorkOrderWFXResponse.job.jobNum")
	@Mapping(target = "jobUnits", source = "futureWorkOrderWFXResponse.job.jobUnits")
	@Mapping(target = "scheduleDate", source = "futureWorkOrderWFXResponse.job.scheduleDate")
	WorkOrderDetail odoToFutureWorkOrder(GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse,
			WorkorderResponse futureWorkOrderOdoResponse);

	@Named("mapEquipmentList")
	List<Equipment> mapEquipmentList(List<com.comcast.orion.workorder.domain.getworkorder.Equipment> source);

	@Mapping(target = "action", source = "action")
	@Mapping(target = "serviceId", source = "serviceId")
	@Mapping(target = "armObjectName", source = "armObjectName")
	@Mapping(target = "equipmentType", source = "equipmentType")
	@Mapping(target = "services", source = "services", qualifiedByName = { "mapServicesList" })
	Equipment mapEquipment(com.comcast.orion.workorder.domain.getworkorder.Equipment source);

	@Named("mapServicesList")
	List<Service> mapServicesList(List<com.comcast.orion.workorder.domain.getworkorder.Service> source);

	@Mapping(target = "action", source = "action")
	@Mapping(target = "serviceId", source = "serviceId")
	@Mapping(target = "armObjectName", source = "armObjectName")
	@Mapping(target = "serviceType", source = "serviceType")
	//@Mapping(target = "name", source = "name")
	@Mapping(target = "characteristics", source = "characteristics", qualifiedByName = { "mapCharacteristicsList" })
	@Mapping(target = "dependentServices", source = "dependentServices", qualifiedByName = {
			"mapDependentServicesList" })
	Service mapServices(com.comcast.orion.workorder.domain.getworkorder.Service source);

	@Named("mapCharacteristicsList")
	List<Characteristic> mapCharacteristicsList(
			List<com.comcast.orion.workorder.domain.getworkorder.Characteristic> source);

	@Mapping(target = "characteristicName", source = "characteristicName")
	@Mapping(target = "characteristicValue", source = "characteristicValue")
	Characteristic mapCharacteristics(com.comcast.orion.workorder.domain.getworkorder.Characteristic source);

	@Named("mapDependentServicesList")
	List<DependentService> mapDependentServicesList(
			List<com.comcast.orion.workorder.domain.getworkorder.DependentService> source);

	@Mapping(target = "characteristics", source = "characteristics", qualifiedByName = { "mapCharacteristicssList" })
	DependentService mapDependentServices(com.comcast.orion.workorder.domain.getworkorder.DependentService source);

	@Named("mapCharacteristicssList")
	List<Characteristic_> mapCharacteristicssList(
			List<com.comcast.orion.workorder.domain.getworkorder.Characteristic_> source);

	@Mapping(target = "characteristicName", source = "characteristicName")
	@Mapping(target = "characteristicValue", source = "characteristicValue")
	Characteristic_ mapCharacteristicss(com.comcast.orion.workorder.domain.getworkorder.Characteristic_ source);

	default WorkOrderDetail mapWorkOrderResponseToFutureWorkOrderResponse(
			GetWorkorderBySiteIdResponse futureWorkOrderWFXResponse, WorkorderResponse futureWorkOrderOdoResponse) {
		WorkOrderDetail workOrderResponse = odoToFutureWorkOrder(futureWorkOrderWFXResponse,
				futureWorkOrderOdoResponse);
		// if (futureWorkOrderWFXResponse.getJob().getTechId() != null)
		// workOrderResponse.getWorkOrder().getJob().setTechnicianId(wfxResponse.getJob().getTechId().toString());
		if (futureWorkOrderWFXResponse.getJob().getJobCommentTypeCdList().size() > 0) {
			for (JobCommentTypeCdList jobComment : futureWorkOrderWFXResponse.getJob().getJobCommentTypeCdList()) {
				if (jobComment.getJobCommentTypeCd().equals("ORDER"))
					workOrderResponse.setOrderComments(jobComment.getJobComment());
				if (jobComment.getJobCommentTypeCd().equals("JOB"))
					workOrderResponse.setJobComments(jobComment.getJobComment());
			}
		}
		return workOrderResponse;
	}

}
