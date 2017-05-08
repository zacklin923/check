package com.zs.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StaffUser {
    private String stuNum;

    private String pass;

    private String stuName;

    private String ownBarCode;

    private String note;

    private Date createTime;

    private BigDecimal stuRole;

	//---------------
    private StaffRole role;
    private String licence;
	private String ownCteName;
	
    
    public String getOwnCteName() {
		return ownCteName;
	}

	public void setOwnCteName(String ownCteName) {
		this.ownCteName = ownCteName;
	}

	public String getStuNum() {
        return stuNum;
    }

    public void setStuNum(String stuNum) {
        this.stuNum = stuNum == null ? null : stuNum.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName == null ? null : stuName.trim();
    }

    public String getOwnBarCode() {
        return ownBarCode;
    }

    public void setOwnBarCode(String ownBarCode) {
        this.ownBarCode = ownBarCode == null ? null : ownBarCode.trim();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
	@JsonFormat(pattern="yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getStuRole() {
        return stuRole;
    }

    public void setStuRole(BigDecimal stuRole) {
        this.stuRole = stuRole;
    }

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public StaffRole getRole() {
		return role;
	}

	public void setRole(StaffRole role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "StaffUser [stuNum=" + stuNum + ", pass=" + pass + ", stuName=" + stuName + ", ownBarCode=" + ownBarCode
				+ ", note=" + note + ", createTime=" + createTime + ", stuRole=" + stuRole + ", role=" + role
				+ ", licence=" + licence + "]";
	}

	
}