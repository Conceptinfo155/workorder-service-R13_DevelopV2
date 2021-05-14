package com.comcast.orion.workorder.domain.rule;

public class ServiceJobTypeRuleVO {

	private String lob;
	private String serviceAction;
	private String transportType;
	private int weight;
	private String jobType;
	private int estimationPoint;

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getServiceAction() {
		return serviceAction;
	}

	public void setServiceAction(String serviceAction) {
		this.serviceAction = serviceAction;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setTransportType(String transportType) {
		this.transportType = transportType;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public int getEstimationPoint() {
		return estimationPoint;
	}

	public void setEstimationPoint(int estimationPoint) {
		this.estimationPoint = estimationPoint;
	}

}
