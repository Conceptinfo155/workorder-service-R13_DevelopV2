package com.comcast.orion.workorder.utils;

import com.comcast.orion.data.vo.ServiceVO;
import com.comcast.orion.workorder.domain.rule.ServiceJobTypeRuleVO;
import com.comcast.orion.workorder.domain.rule.ServiceRuleVO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.internal.io.ResourceFactory;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
public class DroolsUtilTest {

    @InjectMocks
    DroolsUtil droolsUtil;

    @Before
    public void setUp() {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/JobTypeRule.xls"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/EquipmentRule.xls"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("rules/ServiceRule.xls"));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
        ReflectionTestUtils.setField(droolsUtil, "sqoScheduleWorkOrderKieContainer", kieServices.newKieContainer(kieModule.getReleaseId()));
        Map<String,String> lobMap = new HashMap<>();
        lobMap.put("EDI","Ethernet");
        ReflectionTestUtils.setField(droolsUtil,"lobMap", lobMap);
	}

	@Test
    public void testGetService(){
        Set<ServiceVO> serviceVOSet = new HashSet<>();
        ServiceVO serviceVO = new ServiceVO();
        serviceVO.setServiceAction("ADD");
        serviceVO.setServiceType("EDI");
        serviceVO.setTransportType("COAX");
        serviceVOSet.add(serviceVO);
        List<ServiceRuleVO> ruleServiceVO = droolsUtil.getService(serviceVOSet);
        ServiceRuleVO serviceRuleVO = ruleServiceVO.get(0);
        assertTrue("HSCAR".equalsIgnoreCase(serviceRuleVO.getWfxCode()));
        assertEquals(16, serviceRuleVO.getEstimationPoint());
        assertTrue("ADD".equalsIgnoreCase(serviceRuleVO.getActionCode()));
    }

    @Test
    public void testGetJobType(){
        Set<ServiceVO> serviceVOSet = new HashSet<>();
        ServiceVO serviceVO = new ServiceVO();
        serviceVO.setServiceAction("ADD");
        serviceVO.setServiceType("EDI");
        serviceVO.setTransportType("COAX");
        serviceVOSet.add(serviceVO);
        ServiceJobTypeRuleVO serviceJobTypeRuleVO = droolsUtil.getJobType(serviceVOSet);
        assertEquals(7, serviceJobTypeRuleVO.getWeight());
        assertTrue("8M".equalsIgnoreCase(serviceJobTypeRuleVO.getJobType()));
        assertEquals(14, serviceJobTypeRuleVO.getEstimationPoint());
    }

    /*@Test
    public void testGetEquipment(){
        Set<DeviceVO> deviceVOSet = new HashSet<>();
        DeviceVO deviceVO = new DeviceVO();
        deviceVO.setSiteId();
        Set<ServiceVO> serviceVOSet = new HashSet<>();
        ServiceVO serviceVO = new ServiceVO();
        serviceVO.setServiceAction("ADD");
        serviceVO.setServiceType("EDI");
        serviceVO.setTransportType("COAX");
        serviceVOSet.add(serviceVO);
        SortedMap<Integer, JobTypeVO> jobTypeVOMap = droolsUtil.getEquipment(serviceVOSet);
        System.out.println(jobTypeVOMap);
        JobTypeVO jobTypeVO = jobTypeVOMap.get(jobTypeVOMap.firstKey());
        assertEquals(7, jobTypeVO.getWeight());
        assertTrue("8M".equalsIgnoreCase(jobTypeVO.getJobType()));
        assertEquals(14, jobTypeVO.getEstimationPoint());
    }*/


}
