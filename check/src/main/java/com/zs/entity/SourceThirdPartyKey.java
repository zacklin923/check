package com.zs.entity;

import java.util.Date;

public class SourceThirdPartyKey {
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

	public SourceThirdPartyKey(String courierNumber, Date returnDate) {
		this.courierNumber = courierNumber;
		this.returnDate = returnDate;
	}

	public SourceThirdPartyKey() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}