package com.zs.entity.other;

import java.sql.Timestamp;

public class Traces {
	private Timestamp AcceptTime;
	private String AcceptStation;
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
	public Traces(Timestamp acceptTime, String acceptStation) {
		super();
		AcceptTime = acceptTime;
		AcceptStation = acceptStation;
	}
	public Traces() {
		super();
	}
	
}
