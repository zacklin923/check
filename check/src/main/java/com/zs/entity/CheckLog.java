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

    private String bigdata;
	//--张顺，2017-6-27，用于规范类型----------
    public static final String TYPE_QUERY="查询";
    public static final String TYPE_ADD="添加";
    public static final String TYPE_UPDATE="修改";
    public static final String TYPE_DELETE="删除";
    public static final String TYPE_GET="查看";
    public static final String TYPE_IMPORT="导入";
    public static final String TYPE_EXPORT="导出";
	
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
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
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
    @JsonFormat(pattern="yyyy/MM/dd HH:mm:ss.SSS",timezone = "GMT+8")
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

    public String getBigdata() {
        return bigdata;
    }

    public void setBigdata(String bigdata) {
        this.bigdata = bigdata == null ? null : bigdata.trim();
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

	public CheckLog(String logisticcode, String tablename, String olddata, String userNumber, String type,
			String bigdata) {
		super();
		this.logisticcode = logisticcode;
		this.tablename = tablename;
		this.olddata = olddata;
		this.userNumber = userNumber;
		this.type = type;
		this.bigdata = bigdata;
	}

	public CheckLog(String tablename, String olddata, String userNumber, String type, String bigdata) {
		super();
		this.tablename = tablename;
		this.olddata = olddata;
		this.userNumber = userNumber;
		this.type = type;
		this.bigdata = bigdata;
	}

	public CheckLog(String logisticcode, String tablename, String userNumber, String type) {
		super();
		this.logisticcode = logisticcode;
		this.tablename = tablename;
		this.userNumber = userNumber;
		this.type = type;
	}

	
}