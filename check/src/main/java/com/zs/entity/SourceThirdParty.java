package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class SourceThirdParty {
    private BigDecimal courierNumber;

    private Date sendTime;

    private String ctmName;

    private BigDecimal ctmBarCode;

    private String province;

    private String address;

    private String deliveryState;

    private String signatory;

    private String addressee;

    private Date signTime;

    private String abnormalCause;

    private BigDecimal isTimeOut;

    private BigDecimal orderNumber;

    private String shopNumber;

    private String phone;

    private BigDecimal weight;

    private BigDecimal courierCompany;

    private String goods;

    private BigDecimal goodsCost;

    private BigDecimal fee;

    private Date createTime;

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

    public String getDeliveryState() {
        return deliveryState;
    }

    public void setDeliveryState(String deliveryState) {
        this.deliveryState = deliveryState == null ? null : deliveryState.trim();
    }

    public String getSignatory() {
        return signatory;
    }

    public void setSignatory(String signatory) {
        this.signatory = signatory == null ? null : signatory.trim();
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee == null ? null : addressee.trim();
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getAbnormalCause() {
        return abnormalCause;
    }

    public void setAbnormalCause(String abnormalCause) {
        this.abnormalCause = abnormalCause == null ? null : abnormalCause.trim();
    }

    public BigDecimal getIsTimeOut() {
        return isTimeOut;
    }

    public void setIsTimeOut(BigDecimal isTimeOut) {
        this.isTimeOut = isTimeOut;
    }

    public BigDecimal getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(BigDecimal orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(String shopNumber) {
        this.shopNumber = shopNumber == null ? null : shopNumber.trim();
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

    public BigDecimal getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(BigDecimal courierCompany) {
        this.courierCompany = courierCompany;
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}