package com.comcast.orion.workorder.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.classify.Classifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.ExceptionClassifierRetryPolicy;
import org.springframework.retry.policy.NeverRetryPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

@Configuration
public class RetryTemplatesConfiguration {

	private static final Logger RTC_LOGGER = LoggerFactory.getLogger(RetryTemplatesConfiguration.class);

	@Value("${retrytemplate.siteRetryBackOffPeriod}")
	private long siteRetryBackOffPeriod;

	@Value("${retrytemplate.siteRetryMaxAttempts}")
	private Integer siteRetryMaxAttempts;

	@Bean
	public RetryTemplate siteRetryTemplate() {
		RTC_LOGGER.info("Inside onpCallbackRetryTemplate >> ");
		RTC_LOGGER.info("siteRetryBackOffPeriod >> {}", siteRetryBackOffPeriod);
		RTC_LOGGER.info("siteRetryMaxAttempts >> {}", siteRetryMaxAttempts);
		//SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(3, Collections.singletonMap(Exception.class, true));
		//retryPolicy.setMaxAttempts(siteRetryMaxAttempts);

		FixedBackOffPolicy fixedBackOffPolicy = new FixedBackOffPolicy();
		fixedBackOffPolicy.setBackOffPeriod(siteRetryBackOffPeriod);

		RetryTemplate retryTemplate = new RetryTemplate();
		retryTemplate.setBackOffPolicy(fixedBackOffPolicy);
		retryTemplate.setRetryPolicy(new HandleRetryPolicy());

		return retryTemplate;
	}
	
	public class HandleRetryPolicy extends ExceptionClassifierRetryPolicy {
		public HandleRetryPolicy() {
			final SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
			simpleRetryPolicy.setMaxAttempts(siteRetryMaxAttempts);

			this.setExceptionClassifier(new Classifier<Throwable, RetryPolicy>() {
				@Override
				public RetryPolicy classify(Throwable classifiable) {
					// Retry only when HttpClientErrorException or HttpServerErrorException
					// thrown
					if (classifiable instanceof HttpClientErrorException || classifiable instanceof HttpServerErrorException) {
						return simpleRetryPolicy;
					}
					// Do not retry for other exceptions
					return new NeverRetryPolicy();
				}
			});
		}
	}

}
