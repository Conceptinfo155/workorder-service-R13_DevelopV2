package com.comcast.orion.workorder.integration.createwo;

import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.MessageEndpoint;

@MessageEndpoint
public class CreateWorkorderFilter {

	/**
	 * As part of US1759729 introduced new filter to determine the flow which
	 * should go to tokenized api or standardized api based on the flag
	 * isOnNetFlow
	 */
	@Filter(inputChannel = "createworkorderFilterIn", outputChannel = "locationChannel", discardChannel = "createworkorderAggregatorChannel")
	public boolean routeChannel(CreateWorkorderWrapper createWorkorderWrapper) {
		return createWorkorderWrapper.isSiteErrorExists();
	}

}
