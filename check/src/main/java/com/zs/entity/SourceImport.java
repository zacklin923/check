package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SourceImport extends SourceImportKey {
    private String ctmBarCode;

    private String ctmName;

    private String shopNumber;

    private String address;

    private String addressee;

    private String phone;

    private String courierCompany;

    private String goods;

    private BigDecimal goodsCost;

    private String orderNumber;

    private String numberType;

    private Date createTime;

    private BigDecimal isPushed;

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

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber == null ? null : shopNumber.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany == null ? null : courierCompany.trim();
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public BigDecimal getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(BigDecimal goodsCost) {
        this.goodsCost = goodsCost;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType == null ? null : numberType.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getIsPushed() {
        return isPushed;
    }

    public void setIsPushed(BigDecimal isPushed) {
        this.isPushed = isPushed;
    }

	public SourceImport(String ctmBarCode, String ctmName, String shopNumber, String address, String addressee,
			String phone, String courierCompany, String goods, BigDecimal goodsCost, String orderNumber,
			String numberType, Date createTime, BigDecimal isPushed) {
		super();
		this.ctmBarCode = ctmBarCode;
		this.ctmName = ctmName;
		this.shopNumber = shopNumber;
		this.address = address;
		this.addressee = addressee;
		this.phone = phone;
		this.courierCompany = courierCompany;
		this.goods = goods;
		this.goodsCost = goodsCost;
		this.orderNumber = orderNumber;
		this.numberType = numberType;
		this.createTime = createTime;
		this.isPushed = isPushed;
	}

	public SourceImport() {
		super();
	}
    
    
}