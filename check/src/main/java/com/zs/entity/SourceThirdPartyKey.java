package com.zs.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SourceThirdPartyKey {
    private String courierNumber;

    private Date returnDate;

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber == null ? null : courierNumber.trim();
    }

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

	public SourceThirdPartyKey(String courierNumber, Date returnDate) {
		super();
		this.courierNumber = courierNumber;
		this.returnDate = returnDate;
	}

	public SourceThirdPartyKey() {
		super();
	}
    
    
}