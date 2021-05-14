package com.comcast.orion.workorder.domain.rule;

public class DeviceRuleVO {

	private String lob;
	private String deviceType;
	private String deviceAction;
	private String acquisitionType;
	private String wfxCode;
	private int estimationPoint;
	private String actionCode;

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceAction() {
		return deviceAction;
	}

	public void setDeviceAction(String deviceAction) {
		this.deviceAction = deviceAction;
	}

	public String getAcquisitionType() {
		return acquisitionType;
	}

	public void setAcquisitionType(String acquisitionType) {
		this.acquisitionType = acquisitionType;
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
