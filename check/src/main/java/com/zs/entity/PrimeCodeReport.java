package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class PrimeCodeReport {
    private BigDecimal id;

    private String ctmName;

    private String ctmBarCode;

    private String ctmType;

    private String largeArea;

    private BigDecimal countJd;

    private BigDecimal hourJd;

    private BigDecimal countCj;

    private BigDecimal hourCj;

    private BigDecimal countLy;

    private BigDecimal hourLy;

    private BigDecimal countGd;

    private BigDecimal hourGd;

    private BigDecimal countLpcl;

    private BigDecimal hourLpcl;

    private BigDecimal countKscl;

    private BigDecimal hourKscl;

    private BigDecimal countQsb;

    private BigDecimal hourQsb;

    private BigDecimal countTjcl;

    private BigDecimal hourTjcl;

    private BigDecimal countSd;

    private BigDecimal hourSd;

    private BigDecimal countDd;

    private BigDecimal hourDd;

    private BigDecimal dayCount;

    private String stuNum;

    private Date createDate;

    private Date createTime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

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

    public BigDecimal getCountJd() {
        return countJd;
    }

    public void setCountJd(BigDecimal countJd) {
        this.countJd = countJd;
    }

    public BigDecimal getHourJd() {
        return hourJd;
    }

    public void setHourJd(BigDecimal hourJd) {
        this.hourJd = hourJd;
    }

    public BigDecimal getCountCj() {
        return countCj;
    }

    public void setCountCj(BigDecimal countCj) {
        this.countCj = countCj;
    }

    public BigDecimal getHourCj() {
        return hourCj;
    }

    public void setHourCj(BigDecimal hourCj) {
        this.hourCj = hourCj;
    }

    public BigDecimal getCountLy() {
        return countLy;
    }

    public void setCountLy(BigDecimal countLy) {
        this.countLy = countLy;
    }

    public BigDecimal getHourLy() {
        return hourLy;
    }

    public void setHourLy(BigDecimal hourLy) {
        this.hourLy = hourLy;
    }

    public BigDecimal getCountGd() {
        return countGd;
    }

    public void setCountGd(BigDecimal countGd) {
        this.countGd = countGd;
    }

    public BigDecimal getHourGd() {
        return hourGd;
    }

    public void setHourGd(BigDecimal hourGd) {
        this.hourGd = hourGd;
    }

    public BigDecimal getCountLpcl() {
        return countLpcl;
    }

    public void setCountLpcl(BigDecimal countLpcl) {
        this.countLpcl = countLpcl;
    }

    public BigDecimal getHourLpcl() {
        return hourLpcl;
    }

    public void setHourLpcl(BigDecimal hourLpcl) {
        this.hourLpcl = hourLpcl;
    }

    public BigDecimal getCountKscl() {
        return countKscl;
    }

    public void setCountKscl(BigDecimal countKscl) {
        this.countKscl = countKscl;
    }

    public BigDecimal getHourKscl() {
        return hourKscl;
    }

    public void setHourKscl(BigDecimal hourKscl) {
        this.hourKscl = hourKscl;
    }

    public BigDecimal getCountQsb() {
        return countQsb;
    }

    public void setCountQsb(BigDecimal countQsb) {
        this.countQsb = countQsb;
    }

    public BigDecimal getHourQsb() {
        return hourQsb;
    }

    public void setHourQsb(BigDecimal hourQsb) {
        this.hourQsb = hourQsb;
    }

    public BigDecimal getCountTjcl() {
        return countTjcl;
    }

    public void setCountTjcl(BigDecimal countTjcl) {
        this.countTjcl = countTjcl;
    }

    public BigDecimal getHourTjcl() {
        return hourTjcl;
    }

    public void setHourTjcl(BigDecimal hourTjcl) {
        this.hourTjcl = hourTjcl;
    }

    public BigDecimal getCountSd() {
        return countSd;
    }

    public void setCountSd(BigDecimal countSd) {
        this.countSd = countSd;
    }

    public BigDecimal getHourSd() {
        return hourSd;
    }

    public void setHourSd(BigDecimal hourSd) {
        this.hourSd = hourSd;
    }

    public BigDecimal getCountDd() {
        return countDd;
    }

    public void setCountDd(BigDecimal countDd) {
        this.countDd = countDd;
    }

    public BigDecimal getHourDd() {
        return hourDd;
    }

    public void setHourDd(BigDecimal hourDd) {
        this.hourDd = hourDd;
    }

    public BigDecimal getDayCount() {
        return dayCount;
    }

    public void setDayCount(BigDecimal dayCount) {
        this.dayCount = dayCount;
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

	public PrimeCodeReport(BigDecimal id, String ctmName, String ctmBarCode, String ctmType, String largeArea,
			BigDecimal countJd, BigDecimal hourJd, BigDecimal countCj, BigDecimal hourCj, BigDecimal countLy,
			BigDecimal hourLy, BigDecimal countGd, BigDecimal hourGd, BigDecimal countLpcl, BigDecimal hourLpcl,
			BigDecimal countKscl, BigDecimal hourKscl, BigDecimal countQsb, BigDecimal hourQsb, BigDecimal countTjcl,
			BigDecimal hourTjcl, BigDecimal countSd, BigDecimal hourSd, BigDecimal countDd, BigDecimal hourDd,
			BigDecimal dayCount, String stuNum, Date createDate, Date createTime) {
		super();
		this.id = id;
		this.ctmName = ctmName;
		this.ctmBarCode = ctmBarCode;
		this.ctmType = ctmType;
		this.largeArea = largeArea;
		this.countJd = countJd;
		this.hourJd = hourJd;
		this.countCj = countCj;
		this.hourCj = hourCj;
		this.countLy = countLy;
		this.hourLy = hourLy;
		this.countGd = countGd;
		this.hourGd = hourGd;
		this.countLpcl = countLpcl;
		this.hourLpcl = hourLpcl;
		this.countKscl = countKscl;
		this.hourKscl = hourKscl;
		this.countQsb = countQsb;
		this.hourQsb = hourQsb;
		this.countTjcl = countTjcl;
		this.hourTjcl = hourTjcl;
		this.countSd = countSd;
		this.hourSd = hourSd;
		this.countDd = countDd;
		this.hourDd = hourDd;
		this.dayCount = dayCount;
		this.stuNum = stuNum;
		this.createDate = createDate;
		this.createTime = createTime;
	}

	public PrimeCodeReport() {
		super();
	}
    
    
}