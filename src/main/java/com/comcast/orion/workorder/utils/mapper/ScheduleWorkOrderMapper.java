package com.comcast.orion.workorder.utils.mapper;

import com.comcast.orion.wfx.domain.workorder.JobReasonCdList;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRequest;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.bean.GetWorkOrderRule;
import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.Job;
import com.comcast.orion.workorder.domain.reschedule.request.RescheduleRequest;
import com.comcast.orion.workorder.domain.reschedule.response.RescheduleWorkorderResponse;
import com.comcast.orion.workorder.domain.scheduleDomain.BookApmtRequest;
import com.comcast.orion.workorder.domain.scheduleDomain.CancelApmtRequest;
import com.comcast.orion.workorder.domain.scheduleWorkOrder.*;
import com.comcast.orion.workorder.domain.siteResponse.SiteResponse;
import com.comcast.orion.workorder.domain.updateappointment.request.UpdateAppointmentRequest;
import com.comcast.orion.workorder.domain.updatewo.UpdateWorkorderResponse;
import com.comcast.orion.workorder.utils.exceptions.ScheduleWorkOrderException;
import org.apache.commons.lang.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ScheduleWorkOrderMapper extends CommonMapper{
	String O_SITE = "OSite_";
	ScheduleWorkOrderMapper INSTANCE = Mappers.getMapper(ScheduleWorkOrderMapper.class);

	/**
	 * @param request
	 * @param workOrderNumber
	 * @return
	 */
	@Mapping(target = "bookAppointmentRequest.appointmentId", source = "workOrderNumber")
	@Mapping(target = "bookAppointmentRequest.appointmentOption.optionId", source = "request.scheduleWorkorderRequest.bookAppointment.optionId")
	@Mapping(target = "bookAppointmentRequest.forceBookInd", source = "request.scheduleWorkorderRequest.bookAppointment.forceBookInd")
	@Mapping(target = "bookAppointmentRequest.reservationId", source = "request.scheduleWorkorderRequest.bookAppointment.reservationId")
	@Mapping(target = "bookAppointmentRequest.requesterId", constant = "ORION")
	BookApmtRequest scheduleWORequestToBookAppointmentRequest(ScheduleWorkorder request, String workOrderNumber);

	/**
	 * @param scheduleWorkorderRequest
	 * @return
	 */
	@Mapping(target = "bookAppointmentRequest.appointmentId", source = "scheduleWorkorderRequest.workOrderNumber")
	@Mapping(target = "bookAppointmentRequest.appointmentOption.optionId", source = "scheduleWorkorderRequest.bookAppointment.optionId")
	@Mapping(target = "bookAppointmentRequest.forceBookInd", source = "scheduleWorkorderRequest.bookAppointment.forceBookInd")
	@Mapping(target = "bookAppointmentRequest.reservationId", source = "scheduleWorkorderRequest.bookAppointment.reservationId")
	@Mapping(target = "bookAppointmentRequest.requesterId", constant = "ORION")
	BookApmtRequest scheduleSQOWORequestToBookAppointmentRequest(com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest scheduleWorkorderRequest);

	@Mapping(target = "bookAppointmentRequest.appointmentId", source = "newAppointmentId")
	@Mapping(target = "bookAppointmentRequest.appointmentOption.optionId", source = "rescheduleRequest.appointment.optionId")
	@Mapping(target = "bookAppointmentRequest.forceBookInd", source = "rescheduleRequest.appointment.forceBookInd")
	@Mapping(target = "bookAppointmentRequest.reservationId", source = "rescheduleRequest.appointment.reservationId")
	@Mapping(target = "bookAppointmentRequest.requesterId", constant = "ORION")
	BookApmtRequest mapBookAptRequest(RescheduleRequest rescheduleRequest, String newAppointmentId);

	@Mapping(target = "status", constant = "SUCCESS")
	@Mapping(target = "workOrderNumber", source = "workOrderNumber")
	RescheduleWorkorderResponse mapResponse(UpdateWorkorderResponse updateResponse, String workOrderNumber);

	@Mapping(target = "createWorkorderRequest.wfxDispatchLogin", constant = "ORION")
	@Mapping(target = "createWorkorderRequest.job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "createWorkorderRequest.job.scheduleDate", source = "rescheduleRequest.workOrder.job.scheduleDate")
	@Mapping(target = "createWorkorderRequest.job.timeSlotCd", source = "rescheduleRequest.workOrder.job.timeSlotCd")
	@Mapping(target = "createWorkorderRequest.job.callFirstPhoneNum", source = "rescheduleRequest.workOrder.job.callFirstPhoneNum")
	@Mapping(target = "createWorkorderRequest.job.troubleCallIndicator", source = "rescheduleRequest.workOrder.job.troubleCallIndicator")
	@Mapping(target = "createWorkorderRequest.job.jobComment", source = "rescheduleRequest.workOrder.job.jobComment")
	@Mapping(target = "createWorkorderRequest.job.orderComment", source = "rescheduleRequest.workOrder.job.orderComment")
	@Mapping(target = "createWorkorderRequest.jobCustomer.customerId", source = "rescheduleRequest.workOrder.jobCustomer.customerId")
	@Mapping(target = "createWorkorderRequest.job.dispatcherStatusCd", constant = "R")
	@Mapping(target = "createWorkorderRequest.jobCustomer.firstName", source = "rescheduleRequest.workOrder.jobCustomer.firstName")
	@Mapping(target = "createWorkorderRequest.jobCustomer.siteId", source = "rescheduleRequest.workOrder.jobCustomer.siteId")
	@Mapping(target = "createWorkorderRequest.jobCustomer.lastName", source = "rescheduleRequest.workOrder.jobCustomer.lastName")
	@Mapping(target = "createWorkorderRequest.jobCustomer.homePhoneNum", source = "rescheduleRequest.workOrder.jobCustomer.homePhoneNum")
	@Mapping(target = "createWorkorderRequest.jobCustomer.workPhoneNum", source = "rescheduleRequest.workOrder.jobCustomer.workPhoneNum")
	@Mapping(target = "createWorkorderRequest.jobCustomer.emailAddr", source = "rescheduleRequest.workOrder.jobCustomer.emailAddr")
	@Mapping(target = "createWorkorderRequest.job.jobTypeCd", source = "jobtypecd")
	@Mapping(target = "createWorkorderRequest.job.jobUnits", source = "quotapoints")
	@Mapping(target = "createWorkorderRequest.job.reasonCodes", source = "rescheduleRequest.workOrder.job.reasonCodes", qualifiedByName = "mapReasonCodes")
	@Mapping(target = "createWorkorderRequest.job.technicianNum", source = "rescheduleRequest.workOrder.job.technicianNum")
	CreateWORequest createWOToWFXCreateWorkOrderRequest(RescheduleRequest rescheduleRequest, String jobtypecd,String quotapoints);

	/**
	 * @param reasonCodes
	 * @return
	 */
	@Named("mapReasonCodes")
	public abstract List<String> mapJobReasonCodes(Collection<String> reasonCodes);

	default CreateWORequest rescheduleWOToWFXCreateWorkOrderRequest(RescheduleRequest rescheduleRequest,
																	String jobtypecd,String quotapoints, SiteResponse siteResponse) {
		CreateWORequest wfxCreateWorkOrderRequest = null;

		if (rescheduleRequest != null) {
			wfxCreateWorkOrderRequest = createWOToWFXCreateWorkOrderRequest(rescheduleRequest, jobtypecd,quotapoints);
			if (wfxCreateWorkOrderRequest.getCreateWorkorderRequest() != null) {
				wfxCreateWorkOrderRequest.getCreateWorkorderRequest().getJob()
						.setJobNum(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US)));
			}
			if (siteResponse != null) {
				com.comcast.orion.workorder.domain.createwo.JobLocation jobLocation = new com.comcast.orion.workorder.domain.createwo.JobLocation();
				if (siteResponse.getLocationIdentifierInfo() != null) {
					jobLocation.setAddrId(siteResponse.getLocationIdentifierInfo().getELocId());
				}
				wfxCreateWorkOrderRequest.getCreateWorkorderRequest().setJobLocation(jobLocation);
			}
			if (rescheduleRequest.getSolutionDetails() != null) {
				for (com.comcast.orion.workorder.domain.reschedule.request.SolutionDetail solution : rescheduleRequest
						.getSolutionDetails()) {
					if (wfxCreateWorkOrderRequest.getCreateWorkorderRequest().getJob() != null) {
						if (solution.getOrderType().toString().equalsIgnoreCase("TC"))
							wfxCreateWorkOrderRequest.getCreateWorkorderRequest().getJob()
									.setJobClassCd(Job.JobClassCd.T);
						else if (solution.getOrderType().toString().equalsIgnoreCase("SRO"))
							wfxCreateWorkOrderRequest.getCreateWorkorderRequest().getJob()
									.setJobClassCd(Job.JobClassCd.Z);
					}
				}
			}
		}

		return wfxCreateWorkOrderRequest;

	}

	@Mapping(target = "cancelAppointmentRequest.appointmentId", source = "appointId")
	CancelApmtRequest mapCancelRequest(String appointId);

	@Mapping(target = "newAppointmentId", source = "appointId")
	UpdateAppointmentRequest mapUpdateRequest(String appointId);

	/**
	 * @param scheduleWorkorderRequest
	 * @param siteDetail
	 * @param rule
	 * @return
	 */
	@Mapping(target = "WFXDispatchLogin", constant = "ORION")
	@Mapping(target = "job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "job.scheduleDate", source = "scheduleWorkorderRequest.createWorkOrder.job.scheduleDate")
	@Mapping(target = "job.timeSlotCd", source = "scheduleWorkorderRequest.createWorkOrder.job.timeSlotCd")
	@Mapping(target = "job.jobTypeCd", source = "rule.jobTypeCd")
	@Mapping(target = "job.jobUnits", source = "rule.jobUnits")
	@Mapping(target = "job.callFirstPhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.job.callFirstPhoneNum")
	@Mapping(target = "job.troubleCallIndicator", source = "scheduleWorkorderRequest.createWorkOrder.job.troubleCallIndicator")
	@Mapping(target = "job.jobComment", source = "scheduleWorkorderRequest.createWorkOrder.job.jobComment")
	@Mapping(target = "job.orderComment", source = "scheduleWorkorderRequest.createWorkOrder.job.orderComment")
	@Mapping(target = "job.dispatcherStatusCd", constant = "O")
	// jobCustomer mapping
	@Mapping(target = "jobCustomer.customerId", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.customerId")
	@Mapping(target = "jobCustomer.firstName", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.firstName")
	@Mapping(target = "jobCustomer.lastName", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.lastName")
	@Mapping(target = "jobCustomer.homePhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.homePhoneNum")
	@Mapping(target = "jobCustomer.workPhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.workPhoneNum")
	@Mapping(target = "jobCustomer.emailAddr", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.emailAddr")

	@Mapping(target = "jobLocation.address.addrLine1", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine1")
	@Mapping(target = "jobLocation.address.addrLine2", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine2")
	@Mapping(target = "jobLocation.address.city", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.city")
	@Mapping(target = "jobLocation.address.state", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.state")
	@Mapping(target = "jobLocation.address.zipCode", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.zipCode")

	//@Mapping(target = "job.businessUnit", source = "siteDetail.marketInfo.DSTMarketID.franchiseTaxArea") // sitedetails
	//@Mapping(target = "jobLocation.routeCriteria", source = "siteDetail.billingDetailsInfo.csgDetails.technicianArea") // sitedetails
	@Mapping(target = "job.businessUnit", source = "siteDetail", qualifiedByName = { "mapBusinessUnit" })
	@Mapping(target = "jobLocation.routeCriteria", source = "siteDetail", qualifiedByName = { "mapRouteCriteria" })
	WFXCreateWorkOrderRequest workOrderReqToWFXCreateWorkOrderRequest(ScheduleWorkorderRequest scheduleWorkorderRequest,
																	  com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail, GetWorkOrderRule rule);

	/**
	 * @param body
	 * @return
	 */
	@Mapping(target = "status", source = "response")
	@Mapping(target = "workorderNumber", source = "workOrderNum")
	ScheduleWorkorderResponse wfxCreateWorkOrderResponeToCreateWorkOrderResponse(WFXCreateWorkOrderRespone body);

	/**
	 * @param siteDetail
	 * @return
	 */
	@Mapping(target = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine1", source = "siteAddress.addressLine1")
	@Mapping(target = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine2", source = "siteAddress.addressLine2")
	@Mapping(target = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.city", source = "siteAddress.city")
	@Mapping(target = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.state", source = "siteAddress.state")
	@Mapping(target = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.zipCode", source = "siteAddress.zipCode")

	ScheduleWorkorder siteResponseToWorkOrderRequest(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail);

	/**
	 * @throws ScheduleWorkOrderException
	 * @return RescheduleWorkorderResponse
	 */
	default RescheduleWorkorderResponse constructNewWOFailureResponse(String workOrderNumber, String newWONumber,
																	  String errorCode, String message, String status) {
		RescheduleWorkorderResponse rescheduleWorkorderResponse = new RescheduleWorkorderResponse();
		if (newWONumber != null && !newWONumber.equals("")) {
			rescheduleWorkorderResponse.setNewWorkOrderNumber(newWONumber);
		}
		rescheduleWorkorderResponse.setWorkOrderNumber(workOrderNumber);
		rescheduleWorkorderResponse.setStatus(status);
		com.comcast.orion.workorder.domain.reschedule.response.Error error = new com.comcast.orion.workorder.domain.reschedule.response.Error();
		error.setCode(errorCode);
		error.setMessage(message);
		List<com.comcast.orion.workorder.domain.reschedule.response.Error> errors = new ArrayList<com.comcast.orion.workorder.domain.reschedule.response.Error>();
		errors.add(error);
		rescheduleWorkorderResponse.setErrors(errors);
		return rescheduleWorkorderResponse;

	}

	/**
	 * @param scheduleRequest
	 * @param siteDetail
	 * @param rule
	 * @param scheduleSite
	 * @param jobNumPrefix
	 * @return
	 */
	default WFXCreateWorkOrderRequest schWorkOrderReqToWFXCreateWorkOrderRequest(
			ScheduleWorkorderRequest scheduleRequest, com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail, GetWorkOrderRule rule,
			boolean scheduleSite, String jobNumPrefix) {
		WFXCreateWorkOrderRequest wfxCreateWORequest = workOrderReqToWFXCreateWorkOrderRequest(scheduleRequest,
				siteDetail, rule);
		if (siteDetail.getLocationIdentifierInfo() != null) {
			wfxCreateWORequest.getJobLocation().setAddrId(siteDetail.getLocationIdentifierInfo().getELocId());
		}
		if (scheduleRequest.getSolutionDetails() != null) {
			for (SolutionDetail solution : scheduleRequest.getSolutionDetails()) {
				if (wfxCreateWORequest.getJob() != null) {
					if (solution.getOrderType().toString().equalsIgnoreCase("TC"))
						wfxCreateWORequest.getJob().setJobClassCd("T");
					else if (solution.getOrderType().toString().equalsIgnoreCase("SRO"))
						wfxCreateWORequest.getJob().setJobClassCd("Z");
				}
			}
		}

		Integer jobNum = Integer.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US)));
		wfxCreateWORequest.getJob().setJobNum(String.join("", jobNumPrefix,Integer.toHexString(jobNum).toUpperCase()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		wfxCreateWORequest.getJob().setCreateDateTime(sdt);
		wfxCreateWORequest.getJobCustomer().setAccountId(scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteId());

		if (StringUtils.isNotBlank(rule.getJobReasonCd())) {
			wfxCreateWORequest.getJob().getJobReasonCdList().add(new JobReasonCdList().withJobReasonCd(rule.getJobReasonCd()));
		}


		//Disabling siteId transormation
		/*if (scheduleSite) {
			String siteId = scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteId();
			wfxCreateWORequest.getJobCustomer()
					.setAccountId(siteId != null && siteId.length() > 15 && siteId.startsWith(O_SITE)
							? siteId.replaceFirst(O_SITE, "")
							: siteId);
		}*/
		return wfxCreateWORequest;

	}

	/**
	 * @param rescheduleRequest
	 * @param optionId
	 * @param reservationId
	 * @param scheduleDate
	 * @param timeSlotCd
	 */
	default void mapOptionalParametersForReschedule(RescheduleRequest rescheduleRequest, String optionId, String reservationId,
													String scheduleDate, String timeSlotCd) {
		rescheduleRequest.getAppointment().setOptionId(optionId);
		rescheduleRequest.getAppointment().setReservationId(reservationId);
		rescheduleRequest.getWorkOrder().getJob().setScheduleDate(scheduleDate);
		rescheduleRequest.getWorkOrder().getJob().setTimeSlotCd(timeSlotCd);
	}

	/**
	 * @param scheduleRequest
	 * @param optionId
	 * @param reservationId
	 * @param scheduleDate
	 * @param timeSlotCd
	 */
	default void mapOptionalParametersForSchedule(ScheduleWorkorderRequest scheduleRequest, String optionId, String reservationId,
												  String scheduleDate, String timeSlotCd) {
		BookAppointment bookApt = scheduleRequest.getBookAppointment() != null ? scheduleRequest.getBookAppointment() : new BookAppointment();
		bookApt.setReservationId(reservationId);
		bookApt.setOptionId(optionId);
		scheduleRequest.getCreateWorkOrder().getJob().setScheduleDate(scheduleDate);
		scheduleRequest.getCreateWorkOrder().getJob().setTimeSlotCd(timeSlotCd);
		scheduleRequest.setBookAppointment(bookApt);
	}

	/**
	 * @param scheduleWorkorderRequest
	 * @param siteDetail
	 * @param rule
	 * @return
	 */
	@Mapping(target = "WFXDispatchLogin", constant = "ORION")
	@Mapping(target = "job.orderMgtSystem", constant = "ORION")
	@Mapping(target = "codeSrc", constant = "WFX")
	@Mapping(target = "job.scheduleDate", source = "scheduleWorkorderRequest.createWorkOrder.job.scheduleDate")
	@Mapping(target = "job.timeSlotCd", source = "scheduleWorkorderRequest.createWorkOrder.job.timeSlotCd")
	@Mapping(target = "job.jobTypeCd", source = "rule.jobTypeCd")
	@Mapping(target = "job.jobUnits", source = "rule.jobUnits")
	@Mapping(target = "job.callFirstPhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.job.callFirstPhoneNum")
	@Mapping(target = "job.troubleCallIndicator", source = "scheduleWorkorderRequest.createWorkOrder.job.troubleCallIndicator")
	@Mapping(target = "job.jobComment", source = "scheduleWorkorderRequest.createWorkOrder.job.jobComment")
	@Mapping(target = "job.orderComment", source = "scheduleWorkorderRequest.createWorkOrder.job.orderComment")
	@Mapping(target = "job.technicianNum", source = "scheduleWorkorderRequest.createWorkOrder.job.technicianNum")
	@Mapping(target = "job.dispatcherStatusCd", constant = "O")
	// jobCustomer mapping
	@Mapping(target = "jobCustomer.customerId", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.customerId")
	@Mapping(target = "jobCustomer.firstName", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.firstName")
	@Mapping(target = "jobCustomer.lastName", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.lastName")
	@Mapping(target = "jobCustomer.homePhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.homePhoneNum")
	@Mapping(target = "jobCustomer.workPhoneNum", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.workPhoneNum")
	@Mapping(target = "jobCustomer.emailAddr", source = "scheduleWorkorderRequest.createWorkOrder.jobCustomer.emailAddr")

	@Mapping(target = "jobLocation.address.addrLine1", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine1")
	@Mapping(target = "jobLocation.address.addrLine2", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.addrLine2")
	@Mapping(target = "jobLocation.address.city", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.city")
	@Mapping(target = "jobLocation.address.state", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.state")
	@Mapping(target = "jobLocation.address.zipCode", source = "scheduleWorkorderRequest.createWorkOrder.jobLocation.address.zipCode")
	//@Mapping(target = "job.businessUnit", source = "siteDetail.marketInfo.DSTMarketID.franchiseTaxArea") // sitedetails
	//@Mapping(target = "jobLocation.routeCriteria", source = "siteDetail.billingDetailsInfo.csgDetails.technicianArea") // sitedetails
	@Mapping(target = "job.businessUnit", source = "siteDetail", qualifiedByName = { "mapBusinessUnit" })
	@Mapping(target = "jobLocation.routeCriteria", source = "siteDetail", qualifiedByName = { "mapRouteCriteria" }) // sitedetails
	@Mapping(target = "jobLocation.node", source = "siteDetail.networkConnectivityInfo.fiberNodeName")
	@Mapping(target = "jobLocation.dropType", source = "siteDetail.billingDetailsInfo.csgDetails.dropType")
	@Mapping(target = "jobLocation.managementArea", source = "siteDetail.billingDetailsInfo.csgDetails.technicianArea")
	@Mapping(target = "jobLocation.hookupType", source = "siteDetail.billingDetailsInfo.csgDetails.hookupType")
	@Mapping(target = "jobLocation.bridgerAddress", source = "siteDetail", qualifiedByName = { "mapBridgerAddress" })
	@Mapping(target = "jobLocation.dropTag1", source = "siteDetail", qualifiedByName = { "mapDropTag1" })
	@Mapping(target = "jobLocation.dropTag2", source = "siteDetail", qualifiedByName = { "mapDropTag2" })
	@Mapping(target = "jobLocation.dropTag3", source = "siteDetail", qualifiedByName = { "mapDropTag3" })
	com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest workOrderReqToWFXCreateRequest(ScheduleWorkorderRequest scheduleWorkorderRequest,
																											com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail, GetWorkOrderRule rule);

	/**
	 * @param scheduleRequest
	 * @param siteDetail
	 * @param rule
	 * @param scheduleSite
	 * @param jobNumPrefix
	 * @return
	 */
	default com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest schWorkOrderReqToWFXCreateRequest(
			ScheduleWorkorderRequest scheduleRequest, com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail, GetWorkOrderRule rule,
			boolean scheduleSite, String jobNumPrefix) {
		com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest wfxCreateWORequest = workOrderReqToWFXCreateRequest(scheduleRequest,
				siteDetail, rule);
		if (siteDetail.getLocationIdentifierInfo() != null && wfxCreateWORequest.getJobLocation() != null) {
			wfxCreateWORequest.getJobLocation().setAddrId(siteDetail.getLocationIdentifierInfo().getELocId());
		}
		if (scheduleRequest.getSolutionDetails() != null) {
			for (SolutionDetail solution : scheduleRequest.getSolutionDetails()) {
				if (wfxCreateWORequest.getJob() != null) {
					if (solution.getOrderType().toString().equalsIgnoreCase("TC"))
						wfxCreateWORequest.getJob().setJobClassCd("T");
					else if (solution.getOrderType().toString().equalsIgnoreCase("SRO"))
						wfxCreateWORequest.getJob().setJobClassCd("Z");
				}
			}
		}

		Integer jobNum = Integer.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US)));
		wfxCreateWORequest.getJob().setJobNum(String.join("", jobNumPrefix, Integer.toHexString(jobNum).toUpperCase()));
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
		String sdt = df.format(new Date(System.currentTimeMillis()));
		wfxCreateWORequest.getJob().setCreateDateTime(sdt);
		wfxCreateWORequest.getJobCustomer()
				.setAccountId(scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteId());
		if(StringUtils.isNotBlank(rule.getJobReasonCd())) {
			List<com.comcast.orion.workorder.domain.nWFX.create.JobReasonCdList> list = wfxCreateWORequest.getJob().getJobReasonCdList();
			com.comcast.orion.workorder.domain.nWFX.create.JobReasonCdList reasonCdList  = new com.comcast.orion.workorder.domain.nWFX.create.JobReasonCdList();
			reasonCdList.setJobReasonCd(rule.getJobReasonCd());
			list.add(reasonCdList);
		}


		// Disabling siteId transormation
		/*
		 * if (scheduleSite) { String siteId =
		 * scheduleRequest.getCreateWorkOrder().getJobCustomer().getSiteId();
		 * wfxCreateWORequest.getJobCustomer() .setAccountId(siteId != null &&
		 * siteId.length() > 15 && siteId.startsWith(O_SITE) ?
		 * siteId.replaceFirst(O_SITE, "") : siteId); }
		 */
		return wfxCreateWORequest;

	}
	
	@Named("mapRouteCriteria")
	default String mapRouteCriteria(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail){
		String technicianArea=null;
		if(siteDetail.getBillingDetailsInfo() !=null && siteDetail.getBillingDetailsInfo().getCsgDetails() !=null && 
				siteDetail.getBillingDetailsInfo().getCsgDetails().getTechnicianArea() !=null){
			technicianArea = siteDetail.getBillingDetailsInfo().getCsgDetails().getTechnicianArea();
		}
		return technicianArea;
	}
	
	@Named("mapBusinessUnit")
	default String mapBusinessUnit(com.comcast.orion.workorder.domain.sitev2.SiteResponse siteDetail){
		String franchiseTaxArea=null;
		if(siteDetail.getMarketInfo() !=null && siteDetail.getMarketInfo().getDSTMarketID() !=null && 
				siteDetail.getMarketInfo().getDSTMarketID().getFranchiseTaxArea() !=null){
			franchiseTaxArea = siteDetail.getMarketInfo().getDSTMarketID().getFranchiseTaxArea();
		}
		return franchiseTaxArea;
	}
}
