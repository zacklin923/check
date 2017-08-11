package com.zs.entity.other;

public class ReportSignBean {
	
	private String beginArea;
	
	private String identify;
	
	private String identifyDescribe;
	
	private String largeArea;
	
	private String signRate;
	
	private String timeOutRate;
	
	private String notTimeOUtRate;

	public String getBeginArea() {
		return beginArea;
	}

	public void setBeginArea(String beginArea) {
		this.beginArea = beginArea;
	}

	public String getIdentify() {
		return identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	public String getIdentifyDescribe() {
		return identifyDescribe;
	}

	public void setIdentifyDescribe(String identifyDescribe) {
		this.identifyDescribe = identifyDescribe;
	}

	public String getSignRate() {
		return signRate;
	}

	public void setSignRate(String signRate) {
		this.signRate = signRate;
	}

	public String getTimeOutRate() {
		return timeOutRate;
	}

	public void setTimeOutRate(String timeOutRate) {
		this.timeOutRate = timeOutRate;
	}


	public String getNotTimeOUtRate() {
		return notTimeOUtRate;
	}

	public void setNotTimeOUtRate(String notTimeOUtRate) {
		this.notTimeOUtRate = notTimeOUtRate;
	}

	public ReportSignBean() {
		super();
	}

	public String getLargeArea() {
		return largeArea;
	}

	public void setLargeArea(String largeArea) {
		this.largeArea = largeArea;
	}

	public ReportSignBean(String beginArea, String identify, String identifyDescribe, String largeArea, String signRate,
			String timeOutRate, String notTimeOUtRate) {
		super();
		this.beginArea = beginArea;
		this.identify = identify;
		this.identifyDescribe = identifyDescribe;
		this.largeArea = largeArea;
		this.signRate = signRate;
		this.timeOutRate = timeOutRate;
		this.notTimeOUtRate = notTimeOUtRate;
	}

	
	
	
}
