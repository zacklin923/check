package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SourceImportFailed {
    private BigDecimal sifId;

    private String stuNum;

    private Date createTime;

    private String failInfo;

    private String failType;
    
    private SourceImport sourceImport;

    public BigDecimal getSifId() {
        return sifId;
    }

    public void setSifId(BigDecimal sifId) {
        this.sifId = sifId;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getFailInfo() {
        return failInfo;
    }

    public void setFailInfo(String failInfo) {
        this.failInfo = failInfo == null ? null : failInfo.trim();
    }

    public String getFailType() {
        return failType;
    }

    public void setFailType(String failType) {
        this.failType = failType == null ? null : failType.trim();
    }

	public SourceImport getSourceImport() {
		return sourceImport;
	}

	public void setSourceImport(SourceImport sourceImport) {
		this.sourceImport = sourceImport;
	}
    
    
}