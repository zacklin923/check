package com.zs.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SourceZmKey {
	public String courierNumber;

    public Date returnDate;

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber == null ? null : courierNumber.trim();
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

	public SourceZmKey(String courierNumber, Date returnDate) {
		super();
		this.courierNumber = courierNumber;
		this.returnDate = returnDate;
	}

	public SourceZmKey() {
		super();
	}
    
    
}