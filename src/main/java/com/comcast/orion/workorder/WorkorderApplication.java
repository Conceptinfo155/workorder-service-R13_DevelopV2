package com.comcast.orion.workorder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PreDestroy;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;


import com.comcast.orion.workorder.config.MDCHystrixConcurrencyStrategy;
import com.comcast.xsp.security.interceptors.PlatformAuthenticationClientInterceptor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.strategy.HystrixPlugins;

import brave.sampler.Sampler;
import ch.qos.logback.classic.LoggerContext;

/**
 * The Class WorkorderApplication.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableHystrixDashboard
@EnableIntegration
@EnableRetry
public class WorkorderApplication {

	private static final Logger LOG = LoggerFactory.getLogger(WorkorderApplication.class);

	@Autowired
	private PlatformAuthenticationClientInterceptor xspInterceptor;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		HystrixPlugins.getInstance().registerConcurrencyStrategy(new MDCHystrixConcurrencyStrategy());
		try {
			SpringApplication.run(WorkorderApplication.class, args);
		}catch(Exception e){
			System.out.println(e);
		}
	}

	/**
	 * Default sampler.
	 *
	 * @return the always sampler
	 */
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
	
	@Bean
	public FilterRegistrationBean loggingOutFilter() {
	com.comcast.orion.logging.interceptor.RestLoggingOutFilter filter
	= new com.comcast.orion.logging.interceptor.RestLoggingOutFilter();
	filter.setSleuthEnabled(Boolean.valueOf(true));
	FilterRegistrationBean frb = new FilterRegistrationBean();
	frb.setFilter(filter);
	frb.setUrlPatterns(Arrays.asList("/workorder/v2/*"));
	return frb;
	}

	/**
	 * New intercepting template.
	 *
	 * @param restTemplateBuilder the rest template builder
	 * @return the rest template
	 */
	@Bean(name = "woRestTemplate")
	public static RestTemplate newInterceptingTemplate(RestTemplateBuilder restTemplateBuilder) {
		// Buffer the stream
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	/**
	 * New intercepting template.
	 *
	 * @param restTemplateBuilder the rest template builder
	 * @return the rest template
	 */
	@Bean(name = "nWoRestTemplate")
	public RestTemplate nWoRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		// Buffer the stream
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "locationRestTemplate")
	public RestTemplate locationRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		// Buffer the stream
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "scheduleRestTemplate")
	public RestTemplate scheduleRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		// Buffer the stream
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "siteRestTemplate")
	public RestTemplate siteRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "productRestTemplate")
	public RestTemplate productRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "odsRestTemplate")
	public RestTemplate odsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "installbaseRestTemplate")
	public RestTemplate installbaseRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	
	@Bean(name = "vmsRestTemplate")
	public RestTemplate vmsRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	

	@Bean(name = "cancelRestTemplate")
	public RestTemplate cancelRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "saveNotesRestTemplate")
	public RestTemplate saveNotesRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}
	
	@Bean(name = "referenceDataRestTemplate")
	public RestTemplate referenceDataRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "accountRestTemplate")
	public RestTemplate accountRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "dataRestTemplate")
	public RestTemplate dataRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	@Bean(name = "onpRestTemplate")
	public RestTemplate onpRestTemplate(RestTemplateBuilder restTemplateBuilder) {
		RestTemplate restTemplate = restTemplateBuilder.build();
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		restTemplate.setRequestFactory(new BufferingClientHttpRequestFactory(requestFactory));
		List<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new com.comcast.orion.logging.interceptor.RestTemplateLoggingInterceptor());
		interceptors.add(xspInterceptor);
		restTemplate.setInterceptors(interceptors);
		return restTemplate;
	}

	/**
	 * Destroy.
	 *
	 * @throws Exception the exception
	 */
	@PreDestroy
	public void destroy() {
		LOG.info("Invoking PreDestroy method to stop the LoggerFactory Context.");
		ILoggerFactory loggerFactory = LoggerFactory.getILoggerFactory();
		if (loggerFactory instanceof LoggerContext) {
			LoggerContext context = (LoggerContext) loggerFactory;
			context.stop();
		}
	}

	@Bean
	public KieContainer kieContainer() {
		return KieServices.Factory.get().getKieClasspathContainer();
	}

	@Bean("sqoScheduleWorkOrderKieContainer")
	public KieContainer scheduleAllowedKieContainer() {
		KieServices kieServices = KieServices.Factory.get();
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("rules/JobTypeRule.xls"));
		kieFileSystem.write(ResourceFactory.newClassPathResource("rules/DeviceRule.xls"));
		kieFileSystem.write(ResourceFactory.newClassPathResource("rules/ServiceRule.xls"));
		KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
		kieBuilder.buildAll();
		KieModule kieModule = kieBuilder.getKieModule();
		return kieServices.newKieContainer(kieModule.getReleaseId());
	}

	/**
	 * Object mapper.
	 *
	 * @return the object mapper
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return objectMapper;
	}

}
