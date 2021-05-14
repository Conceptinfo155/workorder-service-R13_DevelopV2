package com.comcast.orion.workorder.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.config.java.ServiceScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@Profile("cloud")
@ServiceScan
public class CloudConfiguration extends AbstractCloudConfig {
	private String serviceInstanceId = "OMW-RabbitMQ";
	


	private static final Logger log = LoggerFactory.getLogger(CloudConfiguration.class);

	@Bean(name = "cachingConnectionFactory")
	@Primary
	public ConnectionFactory rabbitConnectionFactory() {
		log.info("Creating the Cloud Connection Factory for Orion RabbitMQ Service --- serviceInstanceId : "
				+ serviceInstanceId);

		System.out.println("Creating the Cloud Connection Factory for Orion RabbitMQ Service --- serviceInstanceId : "
				+ serviceInstanceId);

		if (serviceInstanceId == null) {
			serviceInstanceId = "omw-rabbitmq";
			log.info("Overriding the Default Service Instance for Orion RabbitMQ Service --- serviceInstanceId : "
					+ serviceInstanceId);
		}
		return connectionFactory().rabbitConnectionFactory();
	}

	@Bean(name = "rabbitTemplate")
	@Primary
	public RabbitTemplate rabbitTemplate() {

		final RabbitTemplate rabbitTemplate = new RabbitTemplate(rabbitConnectionFactory());
		rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
		log.info("Bean --- rabbitTemplate - created");

		log.info(" rabbitConnectionFactory() " + rabbitConnectionFactory().getHost());
		log.info(" rabbitConnectionFactory() " + rabbitConnectionFactory().getPort());
		log.info(" rabbitConnectionFactory() " + rabbitConnectionFactory().getUsername());
		log.info(" rabbitConnectionFactory() " + rabbitConnectionFactory().getVirtualHost());
		return rabbitTemplate;
	}

	@Bean
	public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
		return new MappingJackson2MessageConverter();
	}

	@Bean
	public DefaultMessageHandlerMethodFactory myRabbitHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setMessageConverter(consumerJackson2MessageConverter());
		return factory;
	}

	@Bean
	public SimpleRabbitListenerContainerFactory myRabbitListenerContainerFactory() {
		SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
		factory.setConnectionFactory(rabbitConnectionFactory());
		factory.setMaxConcurrentConsumers(5);
		factory.setConcurrentConsumers(1);
		factory.setPrefetchCount(1);
		return factory;
	}

	@Bean
	public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
		return new Jackson2JsonMessageConverter();
	}

	@Bean
	public PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}