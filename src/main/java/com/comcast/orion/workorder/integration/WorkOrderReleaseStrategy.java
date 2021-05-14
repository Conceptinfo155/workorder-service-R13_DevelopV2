package com.comcast.orion.workorder.integration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ReleaseStrategy;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;


@Component
public class WorkOrderReleaseStrategy {
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@ReleaseStrategy
    public boolean canMessagesBeReleased(List<Message> messages) {
		LOG.info("WorkOrderReleaseStrategy");
		return true;
	}

}
