package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SourceImport {
    private BigDecimal courierNumber;

    private Date sendTime;

    private String ctmName;

    private BigDecimal ctmBarCode;

    private String province;

    private String address;

    private BigDecimal orderNumber;

    private String addressee;

    private String phone;

    private String shopNumber;

    private BigDecimal weight;

    private BigDecimal courierCompany;

    private BigDecimal fee;

    private String goods;

    private String numberType;

    public BigDecimal getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(BigDecimal courierNumber) {
        this.courierNumber = courierNumber;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getCtmName() {
        return ctmName;
    }

    public void setCtmName(String ctmName) {
        this.ctmName = ctmName == null ? null : ctmName.trim();
    }

    public BigDecimal getCtmBarCode() {
        return ctmBarCode;
    }

    public void setCtmBarCode(BigDecimal ctmBarCode) {
        this.ctmBarCode = ctmBarCode;
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

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
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

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber == null ? null : shopNumber.trim();
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(BigDecimal courierCompany) {
        this.courierCompany = courierCompany;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods == null ? null : goods.trim();
    }

    public String getNumberType() {
        return numberType;
    }

    public void setNumberType(String numberType) {
        this.numberType = numberType == null ? null : numberType.trim();
    }
}