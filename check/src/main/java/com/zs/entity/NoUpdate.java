package com.zs.entity;

import java.util.Date;

public class NoUpdate extends NoUpdateKey {
    private String noUpdateValue;

    private Date createDate;

    private String stuNum;

    public String getNoUpdateValue() {
        return noUpdateValue;
    }

    public void setNoUpdateValue(String noUpdateValue) {
        this.noUpdateValue = noUpdateValue == null ? null : noUpdateValue.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }
}