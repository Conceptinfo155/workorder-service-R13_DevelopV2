package com.comcast.orion.workorder.domain.rule;

public class ServiceRuleVO {

	private String lob;
	private String serviceType;
	private String serviceAction;
	private String transportType;
	private String wfxCode;
	private int estimationPoint;
	private String actionCode;

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getServiceAction() {
		return serviceAction;
	}

	public void setServiceAction(String serviceAction) {
		this.serviceAction = serviceAction;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getWfxCode() {
		return wfxCode;
	}

	public void setWfxCode(String wfxCode) {
		this.wfxCode = wfxCode;
	}

	public int getEstimationPoint() {
		return estimationPoint;
	}

	public void setEstimationPoint(int estimationPoint) {
		this.estimationPoint = estimationPoint;
	}

	public String getActionCode() {
		return actionCode;
	}

	public void setActionCode(String actionCode) {
		this.actionCode = actionCode;
	}

}
