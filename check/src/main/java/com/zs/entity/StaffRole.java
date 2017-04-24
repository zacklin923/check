package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StaffRole {
    private BigDecimal strId;

    private String strName;

    private String strDesc;

    private String powers;

    private Date createTime;

    public BigDecimal getStrId() {
        return strId;
    }

    public void setStrId(BigDecimal strId) {
        this.strId = strId;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String strName) {
        this.strName = strName == null ? null : strName.trim();
    }

    public String getStrDesc() {
        return strDesc;
    }

    public void setStrDesc(String strDesc) {
        this.strDesc = strDesc == null ? null : strDesc.trim();
    }

    public String getPowers() {
        return powers;
    }

    public void setPowers(String powers) {
        this.powers = powers == null ? null : powers.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}