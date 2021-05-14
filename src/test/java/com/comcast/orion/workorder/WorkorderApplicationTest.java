package com.comcast.orion.workorder;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import com.fasterxml.jackson.databind.ObjectMapper;

import brave.sampler.Sampler;

@RunWith(MockitoJUnitRunner.class)
public class WorkorderApplicationTest {

	@InjectMocks
	private WorkorderApplication workorderApplication;

	@Test
	public void testDefaultSampler() throws Exception {
		Sampler alwaysSampler = workorderApplication.defaultSampler();
		assertNotNull(alwaysSampler);
	}

	@Test
	public void contextLoads() {
		WorkorderApplication remedyApplication = new WorkorderApplication();
		assertNotNull(remedyApplication);
	}
	
	@Test
	public void testObjectMapper_1()
		throws Exception {
		WorkorderApplication deviceVoiceAppln = new WorkorderApplication();

		ObjectMapper result = deviceVoiceAppln.objectMapper();
		assertNotNull(result);
	}
}
