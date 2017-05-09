package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SourceThirdParty extends SourceThirdPartyKey {
    private Date sendTime;

    private String ctmName;

    private String ctmBarCode;

    private String province;

    private String address;

    private String deliveryState;

    private String signatory;

    private String addressee;

    private Date signTime;

    private String abnormalCause;

    private BigDecimal isTimeOut;

    private String orderNumber;

    private String shopNumber;

    private String phone;

    private BigDecimal weight;

    private String courierCompany;

    private String goods;

    private BigDecimal goodsCost;

    private BigDecimal fee;

    private Date createTime;

    private String largeArea;

    private String sliceArea;

    private String fenbu;

    private Date createDate;

    private String fbdArea;

    private String signPort;
//-----------
    private NoUpdate noUpdate;
    
	public NoUpdate getNoUpdate() {
		return noUpdate;
	}

	public void setNoUpdate(NoUpdate noUpdate) {
		this.noUpdate = noUpdate;
	}

	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
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

    public String getCtmBarCode() {
        return ctmBarCode;
    }

    public void setCtmBarCode(String ctmBarCode) {
        this.ctmBarCode = ctmBarCode == null ? null : ctmBarCode.trim();
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
    
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
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

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss.SSS",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getFbdArea() {
        return fbdArea;
    }

    public void setFbdArea(String fbdArea) {
        this.fbdArea = fbdArea == null ? null : fbdArea.trim();
    }

    public String getSignPort() {
        return signPort;
    }

    public void setSignPort(String signPort) {
        this.signPort = signPort == null ? null : signPort.trim();
    }

	public SourceThirdParty() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SourceThirdParty(Date sendTime, String ctmName, String ctmBarCode, String province, String address,
			String deliveryState, String signatory, String addressee, Date signTime, String abnormalCause,
			BigDecimal isTimeOut, String orderNumber, String shopNumber, String phone, BigDecimal weight,
			String courierCompany, String goods, BigDecimal goodsCost, BigDecimal fee, Date createTime,
			String largeArea, String sliceArea, String fenbu, Date createDate, String fbdArea, String signPort,String courierNumber,Date returnDate) {
		this.sendTime = sendTime;
		this.ctmName = ctmName;
		this.ctmBarCode = ctmBarCode;
		this.province = province;
		this.address = address;
		this.deliveryState = deliveryState;
		this.signatory = signatory;
		this.addressee = addressee;
		this.signTime = signTime;
		this.abnormalCause = abnormalCause;
		this.isTimeOut = isTimeOut;
		this.orderNumber = orderNumber;
		this.shopNumber = shopNumber;
		this.phone = phone;
		this.weight = weight;
		this.courierCompany = courierCompany;
		this.goods = goods;
		this.goodsCost = goodsCost;
		this.fee = fee;
		this.createTime = createTime;
		this.largeArea = largeArea;
		this.sliceArea = sliceArea;
		this.fenbu = fenbu;
		this.createDate = createDate;
		this.fbdArea = fbdArea;
		this.signPort = signPort;
		this.setCourierNumber(courierNumber);
		this.setReturnDate(returnDate);
	}

	public SourceThirdParty(String courierNumber, Date returnDate, String province, String address,
			String deliveryState, String addressee, String abnormalCause, BigDecimal isTimeOut, String orderNumber,
			String shopNumber, String phone, String goods, BigDecimal goodsCost, BigDecimal fee) {
		this.province = province;
		this.address = address;
		this.deliveryState = deliveryState;
		this.addressee = addressee;
		this.abnormalCause = abnormalCause;
		this.isTimeOut = isTimeOut;
		this.orderNumber = orderNumber;
		this.shopNumber = shopNumber;
		this.phone = phone;
		this.goods = goods;
		this.goodsCost = goodsCost;
		this.fee = fee;
		this.setCourierNumber(courierNumber);
		this.setReturnDate(returnDate);
	}

	@Override
	public String toString() {
		return "SourceThirdParty [sendTime=" + sendTime + ", ctmName=" + ctmName + ", ctmBarCode=" + ctmBarCode
				+ ", province=" + province + ", address=" + address + ", deliveryState=" + deliveryState
				+ ", signatory=" + signatory + ", addressee=" + addressee + ", signTime=" + signTime
				+ ", abnormalCause=" + abnormalCause + ", isTimeOut=" + isTimeOut + ", orderNumber=" + orderNumber
				+ ", shopNumber=" + shopNumber + ", phone=" + phone + ", weight=" + weight + ", courierCompany="
				+ courierCompany + ", goods=" + goods + ", goodsCost=" + goodsCost + ", fee=" + fee + ", createTime="
				+ createTime + ", largeArea=" + largeArea + ", sliceArea=" + sliceArea + ", fenbu=" + fenbu
				+ ", createDate=" + createDate + ", fbdArea=" + fbdArea + ", signPort=" + signPort
				+ ", getCourierNumber()=" + getCourierNumber() + ", getReturnDate()=" + getReturnDate() + "]";
	}
    
}