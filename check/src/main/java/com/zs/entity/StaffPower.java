package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StaffPower {
    private BigDecimal stpId;

    private String stpName;

    private Date createTime;

    private String stpUrl;

    private String stpMethod;

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
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStpUrl() {
        return stpUrl;
    }

    public void setStpUrl(String stpUrl) {
        this.stpUrl = stpUrl == null ? null : stpUrl.trim();
    }

    public String getStpMethod() {
        return stpMethod;
    }

    public void setStpMethod(String stpMethod) {
        this.stpMethod = stpMethod == null ? null : stpMethod.trim();
    }
}