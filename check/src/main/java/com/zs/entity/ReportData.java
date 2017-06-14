package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ReportData {
    private Date countDate;

    private String largeArea;

    private String sliceArea;

    private String fenBu;

    private String customType;

    private String ctmBarCode;

    private String ctmName;

    private BigDecimal electronicSheet;

    private BigDecimal genericSheet;

    private BigDecimal otherSheet;

    private BigDecimal countAll;

    private BigDecimal flag;

    public Date getCountDate() {
        return countDate;
    }

    public void setCountDate(Date countDate) {
        this.countDate = countDate;
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

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
    }

    public String getCtmBarCode() {
        return ctmBarCode;
    }

    public void setCtmBarCode(String ctmBarCode) {
        this.ctmBarCode = ctmBarCode == null ? null : ctmBarCode.trim();
    }

    public String getCtmName() {
        return ctmName;
    }

    public void setCtmName(String ctmName) {
        this.ctmName = ctmName == null ? null : ctmName.trim();
    }

    public BigDecimal getElectronicSheet() {
        return electronicSheet;
    }

    public void setElectronicSheet(BigDecimal electronicSheet) {
        this.electronicSheet = electronicSheet;
    }

    public BigDecimal getGenericSheet() {
        return genericSheet;
    }

    public void setGenericSheet(BigDecimal genericSheet) {
        this.genericSheet = genericSheet;
    }

    public BigDecimal getOtherSheet() {
        return otherSheet;
    }

    public void setOtherSheet(BigDecimal otherSheet) {
        this.otherSheet = otherSheet;
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
}