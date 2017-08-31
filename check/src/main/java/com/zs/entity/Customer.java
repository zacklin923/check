package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Customer extends CustomerKey {
    private String cteName;

    private String customServiceCenter;

    private String customServiceTop;

    private String customServiceLast;

    private String customType;

    private String largeArea;

    private String sliceArea;

    private String fenbu;

    private Date openDate;

    private Date outDate;

    private String business;

    private String accountsType;

    private String pageType;

    private BigDecimal dailyDelivery;

    private String goodsDetail;

    private String carryGoodsType;

    private String packetPoint;

    private String returnPiece;

    private String matter;

    private String complainRebate;

    private String optionFine;

    private String feeCompensate;

    private String note;

    private String state;

    private Date createTime;
    
    private String dailyDeliveryNew;
    
    public String getCteName() {
        return cteName;
    }

    public void setCteName(String cteName) {
        this.cteName = cteName == null ? null : cteName.trim();
    }

    public String getCustomServiceCenter() {
        return customServiceCenter;
    }

    public void setCustomServiceCenter(String customServiceCenter) {
        this.customServiceCenter = customServiceCenter == null ? null : customServiceCenter.trim();
    }

    public String getCustomServiceTop() {
        return customServiceTop;
    }

    public void setCustomServiceTop(String customServiceTop) {
        this.customServiceTop = customServiceTop == null ? null : customServiceTop.trim();
    }

    public String getCustomServiceLast() {
        return customServiceLast;
    }

    public void setCustomServiceLast(String customServiceLast) {
        this.customServiceLast = customServiceLast == null ? null : customServiceLast.trim();
    }

    public String getCustomType() {
        return customType;
    }

    public void setCustomType(String customType) {
        this.customType = customType == null ? null : customType.trim();
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

    public String getFenbu() {
        return fenbu;
    }

    public void setFenbu(String fenbu) {
        this.fenbu = fenbu == null ? null : fenbu.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd",timezone = "GMT+8")
    public Date getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    @JsonFormat(pattern="yyyy/MM/dd",timezone = "GMT+8")
    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public String getAccountsType() {
        return accountsType;
    }

    public void setAccountsType(String accountsType) {
        this.accountsType = accountsType == null ? null : accountsType.trim();
    }

    public String getPageType() {
        return pageType;
    }

    public void setPageType(String pageType) {
        this.pageType = pageType == null ? null : pageType.trim();
    }

    public BigDecimal getDailyDelivery() {
        return dailyDelivery;
    }

    public void setDailyDelivery(BigDecimal dailyDelivery) {
        this.dailyDelivery = dailyDelivery;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail == null ? null : goodsDetail.trim();
    }

    public String getCarryGoodsType() {
        return carryGoodsType;
    }

    public void setCarryGoodsType(String carryGoodsType) {
        this.carryGoodsType = carryGoodsType == null ? null : carryGoodsType.trim();
    }

    public String getPacketPoint() {
        return packetPoint;
    }

    public void setPacketPoint(String packetPoint) {
        this.packetPoint = packetPoint == null ? null : packetPoint.trim();
    }

    public String getReturnPiece() {
        return returnPiece;
    }

    public void setReturnPiece(String returnPiece) {
        this.returnPiece = returnPiece == null ? null : returnPiece.trim();
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter == null ? null : matter.trim();
    }

    public String getComplainRebate() {
        return complainRebate;
    }

    public void setComplainRebate(String complainRebate) {
        this.complainRebate = complainRebate == null ? null : complainRebate.trim();
    }

    public String getOptionFine() {
        return optionFine;
    }

    public void setOptionFine(String optionFine) {
        this.optionFine = optionFine == null ? null : optionFine.trim();
    }

    public String getFeeCompensate() {
        return feeCompensate;
    }

    public void setFeeCompensate(String feeCompensate) {
        this.feeCompensate = feeCompensate == null ? null : feeCompensate.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
	public String getDailyDeliveryNew() {
		return dailyDeliveryNew;
	}

	public void setDailyDeliveryNew(String dailyDeliveryNew) {
		this.dailyDeliveryNew = dailyDeliveryNew;
	}

	public Customer(String cteName, String customServiceCenter, String customServiceTop, String customServiceLast,
			String customType, String largeArea, String sliceArea, String fenbu, Date openDate, Date outDate,
			String business, String accountsType, String pageType, BigDecimal dailyDelivery, String goodsDetail,
			String carryGoodsType, String packetPoint, String returnPiece, String matter, String complainRebate,
			String optionFine, String feeCompensate, String note, String state, Date createTime,String dailyDeliveryNew) {
		super();
		this.cteName = cteName;
		this.customServiceCenter = customServiceCenter;
		this.customServiceTop = customServiceTop;
		this.customServiceLast = customServiceLast;
		this.customType = customType;
		this.largeArea = largeArea;
		this.sliceArea = sliceArea;
		this.fenbu = fenbu;
		this.openDate = openDate;
		this.outDate = outDate;
		this.business = business;
		this.accountsType = accountsType;
		this.pageType = pageType;
		this.dailyDelivery = dailyDelivery;
		this.goodsDetail = goodsDetail;
		this.carryGoodsType = carryGoodsType;
		this.packetPoint = packetPoint;
		this.returnPiece = returnPiece;
		this.matter = matter;
		this.complainRebate = complainRebate;
		this.optionFine = optionFine;
		this.feeCompensate = feeCompensate;
		this.note = note;
		this.state = state;
		this.createTime = createTime;
		this.dailyDeliveryNew =dailyDeliveryNew; 
	}

	public Customer() {
		super();
	}
    
}