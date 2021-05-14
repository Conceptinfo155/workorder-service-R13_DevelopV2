package com.comcast.orion.workorder.bean;

import java.util.List;

public class GetWorkOrderRule {
	
	private List<SolutionDetail> solutionDetails;
	private String solutionType;
	private String orderType;
	private int weightAge;
	private String jobTypeCd;
	private String jobUnits;
	private String jobReasonCd;
	
	
	public String getSolutionType() {
		return solutionType;
	}

	public void setSolutionType(String solutionType) {
		this.solutionType = solutionType;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	 
	public int getWeightAge() {
		return weightAge;
	}
	public void setWeightAge(int weightAge) {
		this.weightAge = weightAge;
	}
	public String getJobTypeCd() {
		return jobTypeCd;
	}
	public void setJobTypeCd(String jobTypeCd) {
		this.jobTypeCd = jobTypeCd;
	}
	public String getJobUnits() {
		return jobUnits;
	}
	public void setJobUnits(String jobUnits) {
		this.jobUnits = jobUnits;
	}

	public List<SolutionDetail> getSolutionDetails() {
		return solutionDetails;
	}

	public void setSolutionDetails(List<SolutionDetail> solutionDetails) {
		this.solutionDetails = solutionDetails;
	}

	public String getJobReasonCd() {
		return jobReasonCd;
	}

	public void setJobReasonCd(String jobReasonCd) {
		this.jobReasonCd = jobReasonCd;
	}
	
	

}
