package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CheckLog {
    private BigDecimal id;

    private String logisticcode;

    private Date idDate;

    private String tablename;

    private String olddata;

    private Date cretetime;

    private String userNumber;

    private String type;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getLogisticcode() {
        return logisticcode;
    }

    public void setLogisticcode(String logisticcode) {
        this.logisticcode = logisticcode == null ? null : logisticcode.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd",timezone = "GMT+8")
    public Date getIdDate() {
        return idDate;
    }

    public void setIdDate(Date idDate) {
        this.idDate = idDate;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename == null ? null : tablename.trim();
    }

    public String getOlddata() {
        return olddata;
    }

    public void setOlddata(String olddata) {
        this.olddata = olddata == null ? null : olddata.trim();
    }

    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCretetime() {
        return cretetime;
    }

    public void setCretetime(Date cretetime) {
        this.cretetime = cretetime;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber == null ? null : userNumber.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

	public CheckLog(BigDecimal id, String logisticcode, Date idDate, String tablename, String olddata, Date cretetime,
			String userNumber, String type) {
		super();
		this.id = id;
		this.logisticcode = logisticcode;
		this.idDate = idDate;
		this.tablename = tablename;
		this.olddata = olddata;
		this.cretetime = cretetime;
		this.userNumber = userNumber;
		this.type = type;
	}

	public CheckLog() {
		super();
	}
    
    
}