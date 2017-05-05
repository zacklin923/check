package com.zs.entity;

import java.util.Date;

public class SourceZmKey {
    private String courierNumber;

    private Date returnDate;

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
		this.courierNumber = courierNumber;
		this.returnDate = returnDate;
	}

	public SourceZmKey() {
		super();
	}
    
}