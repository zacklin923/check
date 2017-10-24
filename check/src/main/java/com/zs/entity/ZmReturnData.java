package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ZmReturnData {
    private String courierNumber;

    private String ctmBarCode;

    private String ctmName;

    private String largeArea;

    private String sliceArea;

    private String fenbu;

    private String fbdArea;

    private String shopNumber;

    private String address;

    private String addressee;

    private String phone;

    private String goods;

    private BigDecimal goodsCost;

    private BigDecimal weight;

    private BigDecimal fee;

    private String courierCompany;

    private String orderNumber;

    private Date sendTime;

    private String province;

    private String courierState;

    private Date timeOut;

    private String deliveryState;

    private String signatory;

    private Date signTime;

    private String signPort;

    private String abnormalCause;

    private Date createTime;

    private Date updateTime;

    private Date createDate;
    
    private String updateMan;

    //-------------------
    private Integer isTimeOut;//是否超时
    private NoUpdate noUpdateProvince;//不可更改项-省份
    private NoUpdate noUpdateDeliveryState;//不可更改项-配送状态
    
    

	public NoUpdate getNoUpdateProvince() {
		return noUpdateProvince;
	}

	public void setNoUpdateProvince(NoUpdate noUpdateProvince) {
		this.noUpdateProvince = noUpdateProvince;
	}

	public NoUpdate getNoUpdateDeliveryState() {
		return noUpdateDeliveryState;
	}

	public void setNoUpdateDeliveryState(NoUpdate noUpdateDeliveryState) {
		this.noUpdateDeliveryState = noUpdateDeliveryState;
	}

	public Integer getIsTimeOut() {
		return isTimeOut;
	}

	public void setIsTimeOut(Integer isTimeOut) {
		this.isTimeOut = isTimeOut;
	}

	public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber == null ? null : courierNumber.trim();
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

    public String getFbdArea() {
        return fbdArea;
    }

    public void setFbdArea(String fbdArea) {
        this.fbdArea = fbdArea == null ? null : fbdArea.trim();
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

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public String getCourierCompany() {
        return courierCompany;
    }

    public void setCourierCompany(String courierCompany) {
        this.courierCompany = courierCompany == null ? null : courierCompany.trim();
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber == null ? null : orderNumber.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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

    public String getCourierState() {
        return courierState;
    }

    public void setCourierState(String courierState) {
        this.courierState = courierState == null ? null : courierState.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Date timeOut) {
        this.timeOut = timeOut;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public String getSignPort() {
        return signPort;
    }

    public void setSignPort(String signPort) {
        this.signPort = signPort == null ? null : signPort.trim();
    }

    public String getAbnormalCause() {
        return abnormalCause;
    }

    public void setAbnormalCause(String abnormalCause) {
        this.abnormalCause = abnormalCause == null ? null : abnormalCause.trim();
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS",timezone = "GMT+8")
    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

	public String getUpdateMan() {
		return updateMan;
	}

	public void setUpdateMan(String updateMan) {
		this.updateMan = updateMan;
	}

	public ZmReturnData() {
		super();
	}

	//运单信息的构造方法
	public ZmReturnData(String courierNumber, String ctmBarCode, String ctmName, String largeArea, String sliceArea,
			String fenbu, String fbdArea, String shopNumber, String address, String addressee, String phone,
			String goods, BigDecimal goodsCost, BigDecimal weight, String courierCompany, String orderNumber,
			Date sendTime, String province, String courierState, Date timeOut, Date updateTime, Date createDate,String updateMan) {
		super();
		this.courierNumber = courierNumber;
		this.ctmBarCode = ctmBarCode;
		this.ctmName = ctmName;
		this.largeArea = largeArea;
		this.sliceArea = sliceArea;
		this.fenbu = fenbu;
		this.fbdArea = fbdArea;
		this.shopNumber = shopNumber;
		this.address = address;
		this.addressee = addressee;
		this.phone = phone;
		this.goods = goods;
		this.goodsCost = goodsCost;
		this.weight = weight;
		this.courierCompany = courierCompany;
		this.orderNumber = orderNumber;
		this.sendTime = sendTime;
		this.province = province;
		this.courierState = courierState;
		this.timeOut = timeOut;
		this.updateTime = updateTime;
		this.createDate = createDate;
		this.updateMan = updateMan;
	}

	//运单状态用的
	public ZmReturnData(String courierNumber, String ctmBarCode, String ctmName, String largeArea, String sliceArea,
			String fenbu, String fbdArea, String shopNumber, String address, String addressee, String phone,
			String goods, BigDecimal goodsCost, BigDecimal weight, BigDecimal fee, String courierCompany,
			String orderNumber, Date sendTime, String province, String deliveryState, String signatory, Date signTime,
			String signPort, String abnormalCause, Date updateTime, Date createDate,String updateMan) {
		super();
		this.courierNumber = courierNumber;
		this.ctmBarCode = ctmBarCode;
		this.ctmName = ctmName;
		this.largeArea = largeArea;
		this.sliceArea = sliceArea;
		this.fenbu = fenbu;
		this.fbdArea = fbdArea;
		this.shopNumber = shopNumber;
		this.address = address;
		this.addressee = addressee;
		this.phone = phone;
		this.goods = goods;
		this.goodsCost = goodsCost;
		this.weight = weight;
		this.fee = fee;
		this.courierCompany = courierCompany;
		this.orderNumber = orderNumber;
		this.sendTime = sendTime;
		this.province = province;
		this.deliveryState = deliveryState;
		this.signatory = signatory;
		this.signTime = signTime;
		this.signPort = signPort;
		this.abnormalCause = abnormalCause;
		this.updateTime = updateTime;
		this.createDate = createDate;
		this.updateMan = updateMan;
	}
	//哲盟返回字段字符串去空格，并且将空串转成空
	public void trim() {
		if (getCourierNumber()!=null) {
			setCourierNumber(getCourierNumber().trim());
			if (getCourierNumber().equals("")) {
				setCourierNumber(null);
			}
		}
		if (getDeliveryState()!=null) {
			setDeliveryState(getDeliveryState().trim());
			if (getDeliveryState().equals("")) {
				setDeliveryState(null);
			}
		}
		if (getSignPort()!=null) {
			setSignPort(getSignPort().trim());
			if (getSignPort().equals("")) {
				setSignPort(null);
			}
		}
	}
	
	//判断哲盟返回字段中是否除了主键外，其余字段为空
	public boolean isEmptyFromZm() {
		if (deliveryState==null
				&& signTime==null
				&& signPort==null) {
			return true;
		}else {
			return false;
		}
		
	}
    
}