package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SourceZm extends SourceZmKey {
    private String largeArea;

    private String sliceArea;

    private String fenbu;

    private String ctmBarCode;

    private String ctmName;

    private Date sendTime;

    private String province;

    private String address;

    private String shopNumber;

    private String addressee;

    private String phone;

    private BigDecimal weight;

    private String courierCompany;

    private BigDecimal goodsCost;

    private String goods;

    private String orderNumber;

    private Date createTime;

    private Date createDate;

    private String courierState;

    private String fbdArea;

    private Date timeOut;

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

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber == null ? null : shopNumber.trim();
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany == null ? null : courierCompany.trim();
    }

    public BigDecimal getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(BigDecimal goodsCost) {
        this.goodsCost = goodsCost;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @JsonFormat(pattern="yyyy/MM/dd",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCourierState() {
        return courierState;
    }

    public void setCourierState(String courierState) {
        this.courierState = courierState == null ? null : courierState.trim();
    }

    public String getFbdArea() {
        return fbdArea;
    }

    public void setFbdArea(String fbdArea) {
        this.fbdArea = fbdArea == null ? null : fbdArea.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
    }

	public SourceZm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SourceZm(String largeArea, String sliceArea, String fenbu, String ctmBarCode, String ctmName, Date sendTime,
			String province, String address, String shopNumber, String addressee, String phone, BigDecimal weight,
			String courierCompany, BigDecimal goodsCost, String goods, String orderNumber, Date createTime,
			Date createDate, String courierState, String fbdArea, Date timeOut,String courierNumber,Date returnDate) {
		this.largeArea = largeArea;
		this.sliceArea = sliceArea;
		this.fenbu = fenbu;
		this.ctmBarCode = ctmBarCode;
		this.ctmName = ctmName;
		this.sendTime = sendTime;
		this.province = province;
		this.address = address;
		this.shopNumber = shopNumber;
		this.addressee = addressee;
		this.phone = phone;
		this.weight = weight;
		this.courierCompany = courierCompany;
		this.goodsCost = goodsCost;
		this.goods = goods;
		this.orderNumber = orderNumber;
		this.createTime = createTime;
		this.createDate = createDate;
		this.courierState = courierState;
		this.fbdArea = fbdArea;
		this.timeOut = timeOut;
		this.setCourierNumber(courierNumber);
		this.setReturnDate(returnDate);
	}

	@Override
	public String toString() {
		return largeArea + "," + sliceArea + "," + fenbu + "," + ctmBarCode + "," + ctmName + "," + sendTime + ","
				+ province + "," + address + "," + shopNumber + "," + addressee + "," + phone + "," + weight + ","
				+ courierCompany + "," + goodsCost + "," + goods + "," + orderNumber + "," + createTime + ","
				+ createDate + "," + courierState + "," + fbdArea + "," + timeOut + "," + getCourierNumber() + ","
				+ getReturnDate();
	}


	
    
}