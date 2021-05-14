package com.comcast.orion.workorder.integration;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import com.comcast.orion.workorder.command.VMSTnFeaturesCommand;
import com.comcast.orion.workorder.domain.vms.DTTNFeaturesResponse;
import com.comcast.orion.workorder.utils.mapper.GetWorkOrderMapper;

@RunWith(MockitoJUnitRunner.class)
public class VMSActivatorTest {
	
	@InjectMocks
	VMSActivator vmsActivator;
	
	@Mock
	VMSTnFeaturesCommand vmsTnFeaturesCommand;
	
	@Mock
	GetWorkOrderMapper getWorkOrderMapper;
	

	@Test
	public void testGetVMSTnFeatures() throws Exception {

		DTTNFeaturesResponse dtTNFeaturesResponse= new DTTNFeaturesResponse();
		com.comcast.orion.workorder.domain.vms.Service service= new com.comcast.orion.workorder.domain.vms.Service();
		com.comcast.orion.workorder.domain.vms.Service_ service_= new com.comcast.orion.workorder.domain.vms.Service_();
		List<com.comcast.orion.workorder.domain.vms.Service_> services_= new ArrayList<com.comcast.orion.workorder.domain.vms.Service_>();
		List<com.comcast.orion.workorder.domain.vms.Service> services= new ArrayList<com.comcast.orion.workorder.domain.vms.Service>();
		com.comcast.orion.workorder.domain.vms.Feature feature= new com.comcast.orion.workorder.domain.vms.Feature();
		List<com.comcast.orion.workorder.domain.vms.Feature> features= new ArrayList<com.comcast.orion.workorder.domain.vms.Feature>();
		service.setServiceID("1234");
		service.setType("test");
		service_.setAction("action");
		service_.setIsPrimary("isPrimary");
		service_.setTnNo("tnNo");
		service_.setTnType("tnType");
		feature.setName("name");
		feature.setValue("value");
		features.add(feature);
		service_.setFeatures(features);
		service.setService(services_);
		services.add(service);
		dtTNFeaturesResponse.setServices(services);
		Mockito.when(vmsTnFeaturesCommand.getVMSTnFeatures(anyString())).thenReturn(dtTNFeaturesResponse);
		ReflectionTestUtils.setField(vmsActivator, "tnno", "tnno");
		ReflectionTestUtils.setField(vmsActivator, "tntype", "tntype");
		ReflectionTestUtils.setField(vmsActivator, "primary", "primary");
		Object response = vmsActivator.getVMSTnFeatures("designId");
		assertNotNull(dtTNFeaturesResponse);
	}
	

}
