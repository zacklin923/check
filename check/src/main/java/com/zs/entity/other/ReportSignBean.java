package com.zs.entity.other;

import java.math.BigDecimal;

public class ReportSignBean {
	
	private String beginCity;
	private String ctmName;
	private String ctmBarCode;
    private String province;
    private Double costHour;
    private Double ratioSign;
    private Double ratioTimeout;
	public String getBeginCity() {
		return beginCity;
	}
	public void setBeginCity(String beginCity) {
		this.beginCity = beginCity;
	}
	public String getCtmName() {
		return ctmName;
	}
	public void setCtmName(String ctmName) {
		this.ctmName = ctmName;
	}
	public String getCtmBarCode() {
		return ctmBarCode;
	}
	public void setCtmBarCode(String ctmBarCode) {
		this.ctmBarCode = ctmBarCode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Double getCostHour() {
		return costHour;
	}
	public void setCostHour(Double costHour) {
		this.costHour = costHour;
	}
	public Double getRatioSign() {
		return ratioSign;
	}
	public void setRatioSign(Double ratioSign) {
		this.ratioSign = ratioSign;
	}
	public Double getRatioTimeout() {
		return ratioTimeout;
	}
	public void setRatioTimeout(Double ratioTimeout) {
		this.ratioTimeout = ratioTimeout;
	}

	
}
