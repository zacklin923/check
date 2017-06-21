package com.zs.entity;

import java.math.BigDecimal;

public class ReportSign extends ReportSignKey {
    private String beginCity;

    private String ctmName;

    private String province;

    private BigDecimal costHour;

    private BigDecimal totalSend;

    private BigDecimal totalSucc;

    private BigDecimal totalSuccTimeout;

    private String waitCourierNumber;

    public String getBeginCity() {
        return beginCity;
    }

    public void setBeginCity(String beginCity) {
        this.beginCity = beginCity == null ? null : beginCity.trim();
    }

    public String getCtmName() {
        return ctmName;
    }

    public void setCtmName(String ctmName) {
        this.ctmName = ctmName == null ? null : ctmName.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public BigDecimal getCostHour() {
        return costHour;
    }

    public void setCostHour(BigDecimal costHour) {
        this.costHour = costHour;
    }

    public BigDecimal getTotalSend() {
        return totalSend;
    }

    public void setTotalSend(BigDecimal totalSend) {
        this.totalSend = totalSend;
    }

    public BigDecimal getTotalSucc() {
        return totalSucc;
    }

    public void setTotalSucc(BigDecimal totalSucc) {
        this.totalSucc = totalSucc;
    }

    public BigDecimal getTotalSuccTimeout() {
        return totalSuccTimeout;
    }

    public void setTotalSuccTimeout(BigDecimal totalSuccTimeout) {
        this.totalSuccTimeout = totalSuccTimeout;
    }

    public String getWaitCourierNumber() {
        return waitCourierNumber;
    }

    public void setWaitCourierNumber(String waitCourierNumber) {
        this.waitCourierNumber = waitCourierNumber == null ? null : waitCourierNumber.trim();
    }
}