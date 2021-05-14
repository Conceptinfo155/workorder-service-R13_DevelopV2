package com.comcast.orion.workorder.integration.createwo;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

import com.comcast.orion.workorder.domain.createwo.CreateWORequest;
import com.comcast.orion.workorder.domain.createwo.CreateWorkorderRequest;
import com.comcast.orion.workorder.domain.nWFX.create.WFXCreateWorkOrderRequest;

@Component
@RefreshScope
public class CreateWorkorderWrapper {
	
	private CreateWORequest workorderRequest;

	private CreateWorkorderRequest createWorkorderRequest;
	
	private String siteSignageName;
	
	private boolean siteErrorExists;
	
	private String orderNumber;
	
	private WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest;

	

	public WFXCreateWorkOrderRequest getWfxCreateWorkOrderRequest() {
		return wfxCreateWorkOrderRequest;
	}

	public void setWfxCreateWorkOrderRequest(WFXCreateWorkOrderRequest wfxCreateWorkOrderRequest) {
		this.wfxCreateWorkOrderRequest = wfxCreateWorkOrderRequest;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public CreateWORequest getWorkorderRequest() {
		return workorderRequest;
	}

	public void setWorkorderRequest(CreateWORequest workorderRequest) {
		this.workorderRequest = workorderRequest;
	}

	public CreateWorkorderRequest getCreateWorkorderRequest() {
		return createWorkorderRequest;
	}

	public void setCreateWorkorderRequest(CreateWorkorderRequest createWorkorderRequest) {
		this.createWorkorderRequest = createWorkorderRequest;
	}

	public String getSiteSignageName() {
		return siteSignageName;
	}

	public void setSiteSignageName(String siteSignageName) {
		this.siteSignageName = siteSignageName;
	}

	public boolean isSiteErrorExists() {
		return siteErrorExists;
	}

	public void setSiteErrorExists(boolean siteErrorExists) {
		this.siteErrorExists = siteErrorExists;
	}

	
	
	

}
