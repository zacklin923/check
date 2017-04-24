package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class StaffPower {
    private BigDecimal stpId;

    private String stpName;

    private Date createTime;

    public BigDecimal getStpId() {
        return stpId;
    }

    public void setStpId(BigDecimal stpId) {
        this.stpId = stpId;
    }

    public String getStpName() {
        return stpName;
    }

    public void setStpName(String stpName) {
        this.stpName = stpName == null ? null : stpName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}