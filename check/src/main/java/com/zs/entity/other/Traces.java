package com.zs.entity.other;

import java.sql.Timestamp;

public class Traces {
	private Timestamp AcceptTime;
	private String AcceptStation;
	private String Remark;
	public Timestamp getAcceptTime() {
		return AcceptTime;
	}
	public void setAcceptTime(Timestamp acceptTime) {
		AcceptTime = acceptTime;
	}
	public String getAcceptStation() {
		return AcceptStation;
	}
	public void setAcceptStation(String acceptStation) {
		AcceptStation = acceptStation;
	}
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public Traces(Timestamp acceptTime, String acceptStation, String remark) {
		super();
		AcceptTime = acceptTime;
		AcceptStation = acceptStation;
		Remark = remark;
	}
	public Traces() {
		super();
	}
	
}
