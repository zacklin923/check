package com.zs.entity;

import java.util.Date;

public class ReportSignKey {
    private String ctmBarCode;

    private Date sendTime;

    public String getCtmBarCode() {
        return ctmBarCode;
    }

    public void setCtmBarCode(String ctmBarCode) {
        this.ctmBarCode = ctmBarCode == null ? null : ctmBarCode.trim();
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}