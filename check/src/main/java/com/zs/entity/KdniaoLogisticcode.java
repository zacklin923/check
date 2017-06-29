package com.zs.entity;

import java.util.Date;

public class KdniaoLogisticcode {
    private String logisticcode;

    private String issign;

    private Date createTime;

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode == null ? null : logisticcode.trim();
    }

    public String getIssign() {
        return issign;
    }

    public void setIssign(String issign) {
        this.issign = issign == null ? null : issign.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}