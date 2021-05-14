package com.comcast.orion.workorder.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfigurationTest {

	@Test
	public void testApi() {
		SwaggerConfiguration fixture = new SwaggerConfiguration();

		Docket result = fixture.api();

		// add additional test code here
		assertNotNull(result);
		assertNotNull(result.isEnabled());
		assertEquals("default", result.getGroupName());
	}

//	@Test
//	public void testAddResourceHandlersResourceHandlerRegistry() {
//		SwaggerConfiguration fixture = new SwaggerConfiguration();
//		ResourceHandlerRegistry registry = new ResourceHandlerRegistry(new ClassPathXmlApplicationContext(), new ThreadLocalServletContext());
//
//		fixture.addResourceHandlers(registry);
//		assertNotNull(fixture);
//	}

	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(SwaggerConfigurationTest.class);
	}

}
