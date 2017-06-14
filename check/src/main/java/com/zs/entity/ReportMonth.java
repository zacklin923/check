package com.zs.entity;

import java.math.BigDecimal;

public class ReportMonth {
    private String ctmName;

    private String ctmBarCode;

    private String ctmType;

    private String largeArea;

    private String sliceArea;

    private String fenBu;

    private BigDecimal countAll;

    private BigDecimal flag;

    private String years;

    public String getCtmName() {
        return ctmName;
    }

    public void setCtmName(String ctmName) {
        this.ctmName = ctmName == null ? null : ctmName.trim();
    }

    public String getCtmBarCode() {
        return ctmBarCode;
    }

    public void setCtmBarCode(String ctmBarCode) {
        this.ctmBarCode = ctmBarCode == null ? null : ctmBarCode.trim();
    }

    public String getCtmType() {
        return ctmType;
    }

    public void setCtmType(String ctmType) {
        this.ctmType = ctmType == null ? null : ctmType.trim();
    }

    public String getLargeArea() {
        return largeArea;
    }

    public void setLargeArea(String largeArea) {
        this.largeArea = largeArea == null ? null : largeArea.trim();
    }

    public String getSliceArea() {
        return sliceArea;
    }

    public void setSliceArea(String sliceArea) {
        this.sliceArea = sliceArea == null ? null : sliceArea.trim();
    }

    public String getFenBu() {
        return fenBu;
    }

    public void setFenBu(String fenBu) {
        this.fenBu = fenBu == null ? null : fenBu.trim();
    }

    public BigDecimal getCountAll() {
        return countAll;
    }

    public void setCountAll(BigDecimal countAll) {
        this.countAll = countAll;
    }

    public BigDecimal getFlag() {
        return flag;
    }

    public void setFlag(BigDecimal flag) {
        this.flag = flag;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years == null ? null : years.trim();
    }
}