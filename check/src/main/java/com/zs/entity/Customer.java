package com.zs.entity;

import java.util.Date;

public class Customer {
    private String barCode;

    private String cteName;

    private String barCodeParent;

    private String barCodeParentName;

    private String scliceArea;

    private String largeArea;

    private Date createTime;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode == null ? null : barCode.trim();
    }

    public String getCteName() {
        return cteName;
    }

    public void setCteName(String cteName) {
        this.cteName = cteName == null ? null : cteName.trim();
    }

    public String getBarCodeParent() {
        return barCodeParent;
    }

    public void setBarCodeParent(String barCodeParent) {
        this.barCodeParent = barCodeParent == null ? null : barCodeParent.trim();
    }

    public String getBarCodeParentName() {
        return barCodeParentName;
    }

    public void setBarCodeParentName(String barCodeParentName) {
        this.barCodeParentName = barCodeParentName == null ? null : barCodeParentName.trim();
    }

    public String getScliceArea() {
        return scliceArea;
    }

    public void setScliceArea(String scliceArea) {
        this.scliceArea = scliceArea == null ? null : scliceArea.trim();
    }

    public String getLargeArea() {
        return largeArea;
    }

    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea == null ? null : largeArea.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}