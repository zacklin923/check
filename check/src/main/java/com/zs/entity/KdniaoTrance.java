package com.zs.entity;

import java.util.Date;

public class KdniaoTrance {
    private Date acceptTime;

    private String acceptStation;

    private String logisticcode;

    public Date getAcceptTime() {
        return acceptTime;
    }

    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    public String getAcceptStation() {
        return acceptStation;
    }

    public void setAcceptStation(String acceptStation) {
        this.acceptStation = acceptStation == null ? null : acceptStation.trim();
    }

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode == null ? null : logisticcode.trim();
    }

	public KdniaoTrance(Date acceptTime, String acceptStation, String logisticcode) {
		super();
		this.acceptTime = acceptTime;
		this.acceptStation = acceptStation;
		this.logisticcode = logisticcode;
	}

	public KdniaoTrance() {
		super();
	}
    
    
}