package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

public class personalStyle {
    private BigDecimal id;

    private String moduleName;

    private String stuNum;

    private String orderStyle;

    private Date createTime;

    private String state;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName == null ? null : moduleName.trim();
    }

    public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getOrderStyle() {
        return orderStyle;
    }

    public void setOrderStyle(String orderStyle) {
        this.orderStyle = orderStyle == null ? null : orderStyle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public personalStyle(BigDecimal id, String moduleName, String stuNum, String orderStyle, Date createTime,
			String state) {
		super();
		this.id = id;
		this.moduleName = moduleName;
		this.stuNum = stuNum;
		this.orderStyle = orderStyle;
		this.createTime = createTime;
		this.state = state;
	}

	public personalStyle() {
		super();
	}
    
    
}