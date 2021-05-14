package com.comcast.orion.workorder.utils.mapper;

import com.comcast.orion.data.vo.*;
import com.comcast.orion.wfx.domain.workorder.WFXCreateWorkOrderRespone;
import com.comcast.orion.workorder.domain.getorderdetails.ContactMethod;
import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountContact;
import com.comcast.orion.workorder.domain.getorderdetails.CustomerAccountResponse;
import com.comcast.orion.workorder.domain.nWFX.create.*;
import com.comcast.orion.workorder.domain.rule.DeviceRuleVO;
import com.comcast.orion.workorder.domain.rule.ServiceJobTypeRuleVO;
import com.comcast.orion.workorder.domain.rule.ServiceRuleVO;
import com.comcast.orion.workorder.domain.sitev2.SiteResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWO;
import com.comcast.orion.workorder.domain.sqoschedulewo.SQOScheduleWoResponse;
import com.comcast.orion.workorder.domain.sqoschedulewo.ScheduleWorkorderRequest;
import com.comcast.orion.workorder.utils.Constants;
import com.comcast.orion.workorder.utils.DroolsUtil;
import com.comcast.orion.workorder.utils.WorkOrderServiceUtil;
import org.mapstruct.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
@ConfigurationProperties(prefix = "sqo")
public abstract class SQOScheduleWOMapper implements CommonMapper{

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Value("${sqo.scheduleWo.orderManagementSystem}")
    private String orderManagementSystem;

    @Autowired
    private DroolsUtil droolsUtil;

    @Autowired
    private WorkOrderServiceUtil workOrderServiceUtil;

    @Value("${sqo.scheduleWo.jobNumPrefix}")
    private String jobNumPrefix;

    @Value("${sqo.scheduleWo.defaultJobClassCode}")
    private String defaultJobClassCode;

    @Value("${sqo.scheduleWo.defaultDispatcherStatusCode}")
    private String defaultDispatcherStatusCode;

    @Value("${sqo.scheduleWo.serviceTypeAction}")
    private List<String> serviceTypeActionList;

    private Map<String,String> productLobMap;

    @Mappings({
            @Mapping(target = "WFXDispatchLogin", constant = "ORION"),
            @Mapping(target = "codeSrc", constant = "WFX"),
            @Mapping(target = "job", expression = "java(mapJob(scheduleWorkorderRequest.getCreateWorkOrder().getJob(),siteResponse))"),
            //@Mapping(target = "jobLocation", expression = "java(mapJobLocation(siteResponse))"),
            @Mapping(target = "jobCustomer", expression = "java(mapJobCustomer(customerAccountResponse,scheduleWorkorderRequest.getCreateWorkOrder().getJobCustomer().getCustomerId(),scheduleWorkorderRequest.getCreateWorkOrder().getJobCustomer().getSiteId(),siteResponse.getSiteSignageName()))"),
            @Mapping(target = "jobLocation.address",  source = "siteResponse", qualifiedByName = { "mapJobLocationAddress" }),
            @Mapping(target = "jobLocation.addrId", source = "siteResponse", qualifiedByName = { "mapAddrId" }),
            @Mapping(target = "jobLocation.routeCriteria", source = "siteResponse.billingDetailsInfo.csgDetails.technicianArea"),
            @Mapping(target = "jobLocation.node", source = "siteResponse.networkConnectivityInfo.fiberNodeName"),
        	@Mapping(target = "jobLocation.dropType", source = "siteResponse.billingDetailsInfo.csgDetails.dropType"),
        	@Mapping(target = "jobLocation.managementArea", source = "siteResponse.billingDetailsInfo.csgDetails.technicianArea"),
        	@Mapping(target = "jobLocation.hookupType", source = "siteResponse.billingDetailsInfo.csgDetails.hookupType"),
        	@Mapping(target = "jobLocation.bridgerAddress", source = "siteResponse", qualifiedByName = { "mapBridgerAddress" }),
        	@Mapping(target = "jobLocation.dropTag1", source = "siteResponse", qualifiedByName = { "mapDropTag1" }),
        	@Mapping(target = "jobLocation.dropTag2", source = "siteResponse", qualifiedByName = { "mapDropTag2" }),
        	@Mapping(target = "jobLocation.dropTag3", source = "siteResponse", qualifiedByName = { "mapDropTag3" })
    })
    public abstract WFXCreateWorkOrderRequest mapSqoScheduleWORequest(ScheduleWorkorderRequest scheduleWorkorderRequest,
                                                                      SiteResponse siteResponse, CustomerAccountResponse customerAccountResponse, CustomerVO customerVO);
    @Mappings({
            @Mapping(target = "status", source = "response"),
            @Mapping(target = "workorderNumber", source = "workOrderNum")
    })
    public abstract SQOScheduleWoResponse mapSqoScheduleWOResponse(WFXCreateWorkOrderRespone body);

    public String  mapCreateDateTime() {
        log.info("SQOScheduleWoMapper::mapCreateDateTime::Enters");
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        String sdt = df.format(new Date(System.currentTimeMillis()));
        log.info("createWorkOrderMapper::mapCreateDateTime::Exits");
        return sdt;
    }

    public List<JobReasonCdList> mapJobReasonCodeList(String jobReasonCode) {
        log.info("SQOScheduleWoMapper::getJobReasonCodeList::Enters");
        if(StringUtils.isEmpty(jobReasonCode))
            return new ArrayList<>();
        JobReasonCdList jobReasonCdList = new JobReasonCdList();
        jobReasonCdList.setJobReasonCd(jobReasonCode);
        return Arrays.asList(jobReasonCdList);
    }

    /*public JobLocation mapJobLocation(SiteResponse siteResponse){
        JobLocation jobLocation = new JobLocation();
        if(siteResponse.getSiteAddress() != null) {
            Address address = new Address();
            address.setAddrLine1(siteResponse.getSiteAddress().getAddressLine1());
            address.setAddrLine2(siteResponse.getSiteAddress().getAddressLine2());
            address.setCity(siteResponse.getSiteAddress().getCity());
            address.setState(siteResponse.getSiteAddress().getState());
            address.setZipCode(siteResponse.getSiteAddress().getZipCode());
            jobLocation.setAddress(address);
        }
        if(siteResponse.getLocationIdentifierInfo() != null)
            jobLocation.setAddrId(siteResponse.getLocationIdentifierInfo().getELocId());
        if(siteResponse.getBillingDetailsInfo() != null && siteResponse.getBillingDetailsInfo().getCsgDetails() != null)
            jobLocation.setRouteCriteria(siteResponse.getBillingDetailsInfo().getCsgDetails().getTechnicianArea());
        return  jobLocation;
    }*/
    
    @Named("mapJobLocationAddress")
    public Address mapJobLocationAddress(SiteResponse siteResponse){
    	Address address = null;
        if(siteResponse.getSiteAddress() != null) {
            address = new Address();
            address.setAddrLine1(siteResponse.getSiteAddress().getAddressLine1());
            address.setAddrLine2(siteResponse.getSiteAddress().getAddressLine2());
            address.setCity(siteResponse.getSiteAddress().getCity());
            address.setState(siteResponse.getSiteAddress().getState());
            address.setZipCode(siteResponse.getSiteAddress().getZipCode());
        }
        return address;
    }
    
    @Named("mapAddrId")
    public String mapAddrId(SiteResponse siteResponse){
    	String addrId = null;
        if(siteResponse.getLocationIdentifierInfo() != null)
        	addrId = siteResponse.getLocationIdentifierInfo().getELocId();
        return  addrId;
    }
    
    public Job mapJob(com.comcast.orion.workorder.domain.sqoschedulewo.Job source, SiteResponse siteResponse){
        log.info("SQOScheduleWoMapper::mapJob::Enters");
        Job job = new Job();
        job.setOrderMgtSystem(orderManagementSystem);
        job.setCreateDateTime(mapCreateDateTime());
        job.setScheduleDate(source.getScheduleDate());
        job.setTimeSlotCd(source.getTimeSlotCd());
        job.setCallFirstPhoneNum(source.getCallFirstPhoneNum());
        if(null != source.getTroubleCallIndicator())
            job.setTroubleCallIndicator(source.getTroubleCallIndicator().value());
        job.setJobComment(source.getJobComment());
        job.setOrderComment(source.getOrderComment());
        job.setJobReasonCdList(mapJobReasonCodeList(source.getJobReasonCode()));
        job.setJobClassCd(defaultJobClassCode);
        job.setDispatcherStatusCd(defaultDispatcherStatusCode);
        if(siteResponse.getMarketInfo() != null && siteResponse.getMarketInfo().getDSTMarketID() != null)
            job.setBusinessUnit(siteResponse.getMarketInfo().getDSTMarketID().getFranchiseTaxArea());
        Integer jobNum = Integer.valueOf(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss", Locale.US)));
        job.setJobNum(String.join("", jobNumPrefix,Integer.toHexString(jobNum).toUpperCase()));
        log.info("SQOScheduleWoMapper::mapJob::Exits");
        return job;
    }

    public JobCustomer mapJobCustomer(CustomerAccountResponse customerAccountResponse, String customerId, String siteId, String siteSignageName) {
        log.info("SQOScheduleWoMapper::mapJobCustomer::Enters");
        JobCustomer jobCustomer = new JobCustomer();
        jobCustomer.setCustomerId(customerId);
        jobCustomer.setAccountId(siteId);
        if(!CollectionUtils.isEmpty(customerAccountResponse.getCustomerAccountContacts())) {
            CustomerAccountContact customerAccountContact;
            Optional<CustomerAccountContact> optionalCustomerAccountContact = customerAccountResponse.getCustomerAccountContacts().stream().filter(c -> Constants.PRIMARY_CONTACT.equalsIgnoreCase(c.getRole())).findAny();
            customerAccountContact = optionalCustomerAccountContact.orElseGet(() -> customerAccountResponse.getCustomerAccountContacts().get(0));
            if(!StringUtils.isEmpty(siteSignageName)){
                workOrderServiceUtil.populateWFXFirstNameLastName(siteSignageName,jobCustomer);
            }else{
                jobCustomer.setLastName(customerAccountContact.getLastName());
                jobCustomer.setFirstName(customerAccountContact.getFirstName());
            }
            if(!CollectionUtils.isEmpty(customerAccountContact.getContactMethods())){
                Optional<ContactMethod> optionalEmailContactMethod = customerAccountContact.getContactMethods().stream()
                        .filter(contactMethod -> Constants.CONTACT_METHOD_EMAIL.equalsIgnoreCase(contactMethod.getContactMethodKey())).findFirst();
                optionalEmailContactMethod.ifPresent(contactMethod -> jobCustomer.setEmailAddr(contactMethod.getEmailAddress()));
                Optional<ContactMethod> optionalMobileContactMethod = customerAccountContact.getContactMethods().stream()
                        .filter(contactMethod -> Constants.CONTACT_METHOD_MOBILE.equalsIgnoreCase(contactMethod.getContactMethodKey())).findFirst();
                if(optionalMobileContactMethod.isPresent()){
                    jobCustomer.setHomePhoneNum(optionalMobileContactMethod.get().getNumber());
                    jobCustomer.setWorkPhoneNum(optionalMobileContactMethod.get().getNumber());
                }
            }
        }
        log.info("SQOScheduleWoMapper::mapJobCustomer::Exits");
        return jobCustomer;
    }

    public void mapRuleResults(WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest, CustomerVO customerVO, SQOScheduleWO sqoScheduleWO){
        log.info("SQOScheduleWOAggregator::mapRuleResults::enters");
        AgreementVO agreementVO = customerVO.getAgreements().iterator().next();
        Optional<SiteVO> siteVO = agreementVO.getSites().stream().filter(vo ->
                vo.getProducts().stream().anyMatch(productVO ->
                        sqoScheduleWO.getScheduleWorkorderRequest().getSolutionDetails().get(0).getProductOfferInstanceId().equalsIgnoreCase(productVO.getProductOfferInstanceId()))).findFirst();
        if(siteVO.isPresent() && !CollectionUtils.isEmpty(siteVO.get().getServices())) {
            ServiceJobTypeRuleVO serviceJobTypeRuleVO = droolsUtil.getJobType(siteVO.get().getServices());
            Integer jobUnits;
            jobUnits = serviceJobTypeRuleVO.getEstimationPoint();
            wfxCreateWorkOrderRequest.getJob().setJobTypeCd(serviceJobTypeRuleVO.getJobType());
            List<JobProductList> jobProductList = new ArrayList<>();
            List<ServiceRuleVO> serviceRuleVOList = droolsUtil.getService(siteVO.get().getServices());
            for (ServiceRuleVO serviceRuleVO : serviceRuleVOList) {
                JobProductList jobProduct = new JobProductList();
                jobUnits += serviceRuleVO.getEstimationPoint();
                if(serviceRuleVO.getServiceType() != null)
                    jobProduct.setProductLOB(productLobMap.get(serviceRuleVO.getServiceType()));
                jobProduct.setParentProductCd(serviceRuleVO.getWfxCode());
                jobProduct.setActionCd(serviceRuleVO.getActionCode());
                jobProductList.add(jobProduct);
            }
            wfxCreateWorkOrderRequest.setJobProductList(jobProductList);
            List<JobEquipmentList> jobEquipmentList = new ArrayList<>();
            JobEquipmentList jobEquipment = new JobEquipmentList();

            if (!CollectionUtils.isEmpty(siteVO.get().getDevices())) {
                for(DeviceVO deviceVO : siteVO.get().getDevices()){
                    DeviceRuleVO deviceRuleVO = droolsUtil.getEquipment(deviceVO, siteVO.get().getServices(), siteVO.get().getProducts());
                    jobEquipment.setEquipTypeCd(deviceRuleVO.getWfxCode());
                    jobUnits += deviceRuleVO.getEstimationPoint();
                    if (Constants.DEVICE_ACTION_ADD.equalsIgnoreCase(deviceRuleVO.getDeviceAction())) {
                        jobEquipment.setSerialNum(Constants.DEVICE_ACTION_ADD_SERIAL_NUMBER);
                    } else {
                        jobEquipment.setSerialNum(deviceVO.getDeviceSerialNum());
                    }
                    if (Constants.DEVICE_ACQUISITION_TYPE_RENTAL.equalsIgnoreCase(deviceRuleVO.getAcquisitionType())) {
                        jobEquipment.setOwnerCd(Constants.RENTAL_OWNER_CODE);
                    } else if (Constants.DEVICE_ACQUISITION_TYPE_CUSTOMER_OWNED.equalsIgnoreCase(deviceRuleVO.getAcquisitionType())) {
                        jobEquipment.setOwnerCd(Constants.CUSTOMER_PROVIDED_OWNER_CODE);
                    }
                    jobEquipment.setActionCd(deviceRuleVO.getActionCode());
                    jobEquipmentList.add(jobEquipment);
                }
            }
            wfxCreateWorkOrderRequest.setJobEquipmentList(jobEquipmentList);
            wfxCreateWorkOrderRequest.getJob().setJobUnits(jobUnits);

        }
        log.info("SQOScheduleWOAggregator::mapRuleResults::exits");
    }

    public Map<String, String> getProductLobMap() {
        return productLobMap;
    }

    public void setProductLobMap(Map<String, String> productLobMap) {
        this.productLobMap = productLobMap;
    }
}
