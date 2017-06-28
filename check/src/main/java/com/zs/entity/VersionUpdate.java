package com.zs.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class VersionUpdate {
    private String verNum;

    private String verDesc;

    private String verStuNums;

    private Date createTime;

    public String getVerNum() {
        return verNum;
    }

    public void setVerNum(String verNum) {
        this.verNum = verNum == null ? null : verNum.trim();
    }

    public String getVerDesc() {
        return verDesc;
    }

    public void setVerDesc(String verDesc) {
        this.verDesc = verDesc == null ? null : verDesc.trim();
    }

    public String getVerStuNums() {
        return verStuNums;
    }

    public void setVerStuNums(String verStuNums) {
        this.verStuNums = verStuNums == null ? null : verStuNums.trim();
    }
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}