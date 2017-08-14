package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class reportSignNew {
    private String identify;

    private String flag;

    private Date countDate;

    private BigDecimal succCount;

    private BigDecimal allCount;

    private BigDecimal timeOutCount;

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify == null ? null : identify.trim();
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
    }

    public BigDecimal getSuccCount() {
        return succCount;
    }

    public void setSuccCount(BigDecimal succCount) {
        this.succCount = succCount;
    }

    public BigDecimal getAllCount() {
        return allCount;
    }

    public void setAllCount(BigDecimal allCount) {
        this.allCount = allCount;
    }

    public BigDecimal getTimeOutCount() {
        return timeOutCount;
    }

    public void setTimeOutCount(BigDecimal timeOutCount) {
        this.timeOutCount = timeOutCount;
    }
}