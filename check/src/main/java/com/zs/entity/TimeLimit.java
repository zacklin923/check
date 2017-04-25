package com.zs.entity;

import java.math.BigDecimal;

public class TimeLimit {
    private BigDecimal orderNumber;

    private String beginProvince;

    private String endProvince;

    private BigDecimal hourCost;

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getBeginProvince() {
        return beginProvince;
    }

    public void setBeginProvince(String beginProvince) {
        this.beginProvince = beginProvince == null ? null : beginProvince.trim();
    }

    public String getEndProvince() {
        return endProvince;
    }

    public void setEndProvince(String endProvince) {
        this.endProvince = endProvince == null ? null : endProvince.trim();
    }

    public BigDecimal getHourCost() {
        return hourCost;
    }

    public void setHourCost(BigDecimal hourCost) {
        this.hourCost = hourCost;
    }
}