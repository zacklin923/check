package com.zs.entity;

import java.util.Date;

public class KdniaoReturn {
    private String logisticcode;

    private String state;

    private Date createTime;

    private String isdraw;

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode == null ? null : logisticcode.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsdraw() {
        return isdraw;
    }

    public void setIsdraw(String isdraw) {
        this.isdraw = isdraw == null ? null : isdraw.trim();
    }

	public KdniaoReturn(String logisticcode, String state, Date createTime, String isdraw) {
		super();
		this.logisticcode = logisticcode;
		this.state = state;
		this.createTime = createTime;
		this.isdraw = isdraw;
	}

	public KdniaoReturn() {
		super();
	}
    
}