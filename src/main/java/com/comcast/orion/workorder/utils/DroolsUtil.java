package com.comcast.orion.workorder.utils;

import com.comcast.orion.data.vo.*;
import com.comcast.orion.workorder.domain.rule.DeviceRuleVO;
import com.comcast.orion.workorder.domain.rule.ServiceJobTypeRuleVO;
import com.comcast.orion.workorder.domain.rule.ServiceRuleVO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.discovery.converters.Auto;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@ConfigurationProperties(prefix = "sqo")
public class DroolsUtil {

    @Autowired
    KieContainer sqoScheduleWorkOrderKieContainer;

    @Autowired
    ObjectMapper objectMapper;

    private Map<String,String> lobMap;

    private final Logger log = LoggerFactory.getLogger(this.getClass());


    public ServiceJobTypeRuleVO getJobType(Set<com.comcast.orion.data.vo.ServiceVO> serviceVOList) {
        log.info("DroolsUtil::getJobType::enters");
        SortedMap<Integer, ServiceJobTypeRuleVO> jobTypeSortedMap = new TreeMap<>();
        KieSession kieSession = sqoScheduleWorkOrderKieContainer.newKieSession();
        for(com.comcast.orion.data.vo.ServiceVO serviceVO: serviceVOList) {
            ServiceJobTypeRuleVO rule = new ServiceJobTypeRuleVO();
            rule.setLob(lobMap.get(serviceVO.getServiceType()));
            rule.setServiceAction(serviceVO.getServiceAction());
            rule.setTransportType(serviceVO.getTransportType());
            try {
                String message = objectMapper.writeValueAsString(rule);
                log.info("GetJobtypeRule : Request {} ", message);
            } catch (Exception e) {
                log.error("Error printing getJobTypeRule", e);
            }
            kieSession.insert(rule);
            kieSession.fireAllRules();
            if (rule.getWeight() != 0) {
                jobTypeSortedMap.put(rule.getWeight(), rule);
            }
            try {
                String message = objectMapper.writeValueAsString(rule);
                log.info("GetJobtypeRule : Response {} ", message);
            } catch (Exception e) {
                log.error("Error printing getJobTypeRule", e);
            }
        }
        kieSession.dispose();
        if (MapUtils.isNotEmpty(jobTypeSortedMap)) {
            int lastkey = jobTypeSortedMap.lastKey();
            ServiceJobTypeRuleVO rule = jobTypeSortedMap.get(lastkey);
            log.info("DroolsUtil::getJobType::exits");
            return rule;
        }
        return null;
    }

    public DeviceRuleVO getEquipment(DeviceVO deviceVO, Set<ServiceVO> serviceVOSet, List<ProductVO> productVOList) {
        log.info("DroolsUtil::getEquipment::enters");
        KieSession kieSession = sqoScheduleWorkOrderKieContainer.newKieSession();
        DeviceRuleVO devicevo = new DeviceRuleVO();

        Integer serviceId = null;
        String serviceType = null;
        Set<DeviceServiceMappingsVO> deviceServiceMappingsvo = deviceVO.getDeviceServiceMappings();
        if (CollectionUtils.isNotEmpty(deviceServiceMappingsvo)) {
            for (DeviceServiceMappingsVO deviceServiceMapping : deviceServiceMappingsvo) {
                serviceId = deviceServiceMapping.getServiceId();
                break;
            }
        }
        if (null != serviceId && CollectionUtils.isNotEmpty(serviceVOSet)) {
            for (ServiceVO service : serviceVOSet) {
                if (serviceId.equals(service.getId())) {
                    serviceType = service.getServiceType();
                    break;
                }
            }
        }
        if (StringUtils.isNotBlank(serviceType)) {
            Set<String> acquisitionTypeList = new HashSet<>();
            if(!serviceType.equalsIgnoreCase("BI")) {
                acquisitionTypeList.add("Rental");
            } else {
                if (CollectionUtils.isNotEmpty(productVOList)) {
                    for (ProductVO productvo : productVOList) {
                        if ("Business Internet".equalsIgnoreCase(productvo.getProductOfferingName())) {
                            if (null != productvo.getProductAttributes()) {
                                for (ProductAttributeVO attribute : productvo.getProductAttributes()) {
                                    if ("deviceAcquisitionType".equalsIgnoreCase(attribute.getAttrName())) {
                                        acquisitionTypeList.add(attribute.getAttrValue());
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if(CollectionUtils.isNotEmpty(acquisitionTypeList)) {
                for(String acquisitionType : acquisitionTypeList) {
                    // Construct the List<EquipmentVO>/List<DeviceVO> to invoke the EquipmentRule/DeviceRule

                    devicevo.setLob(lobMap.get(serviceType));
                    devicevo.setDeviceAction(deviceVO.getDeviceAction());
                    devicevo.setDeviceType(deviceVO.getDeviceType());
                    devicevo.setAcquisitionType(acquisitionType);
                    try {
                        String message = objectMapper.writeValueAsString(devicevo);
                        log.info("getEquipmentRule : Request {} ", message);
                    } catch (Exception e) {
                        log.error("Error printing getEquipmentRule", e);
                    }
                    kieSession.insert(devicevo);
                    kieSession.fireAllRules();
                    try {
                        String message = objectMapper.writeValueAsString(devicevo);
                        log.info("getEquipmentRule : Response {} ", message);
                    } catch (Exception e) {
                        log.error("Error printing getEquipmentRule", e);
                    }
                }
            }
        }

        kieSession.dispose();
        log.info("DroolsUtil::getEquipment::exits");
        return devicevo;
    }

    public List<ServiceRuleVO> getService(Set<com.comcast.orion.data.vo.ServiceVO> serviceVOList) {
        log.info("DroolsUtil::getService::enters");
        List<ServiceRuleVO> servicesList = new ArrayList<>();
        KieSession kieSession = sqoScheduleWorkOrderKieContainer.newKieSession();
        for(com.comcast.orion.data.vo.ServiceVO serviceVO: serviceVOList) {
            ServiceRuleVO rule = new ServiceRuleVO();
            rule.setLob(lobMap.get(serviceVO.getServiceType()));
            rule.setServiceType(serviceVO.getServiceType());
            rule.setServiceAction(serviceVO.getServiceAction());
            rule.setTransportType(serviceVO.getTransportType());
            try {
                String message = objectMapper.writeValueAsString(rule);
                log.info("getServiceRule : Request {} ", message);
            } catch (Exception e) {
                log.error("Error printing getServiceRule", e);
            }
            kieSession.insert(rule);
            kieSession.fireAllRules();
            servicesList.add(rule);
            try {
                String message = objectMapper.writeValueAsString(rule);
                log.info("getServiceRule : Response {} ", message);
            } catch (Exception e) {
                log.error("Error printing getServiceRule", e);
            }
        }
        kieSession.dispose();
        log.info("DroolsUtil::getServiceRule::exits");
        return servicesList;
    }

    public Map<String, String> getLobMap() {
        return lobMap;
    }

    public void setLobMap(Map<String, String> lobMap) {
        this.lobMap = lobMap;
    }
}
