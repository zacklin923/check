package com.zs.entity;

public class NoUpdateKey {
    private String courierNumber;

    private String noUpdateName;

    public String getCourierNumber() {
        return courierNumber;
    }

    public void setCourierNumber(String courierNumber) {
        this.courierNumber = courierNumber == null ? null : courierNumber.trim();
    }

    public String getNoUpdateName() {
        return noUpdateName;
    }

    public void setNoUpdateName(String noUpdateName) {
        this.noUpdateName = noUpdateName == null ? null : noUpdateName.trim();
    }

	public NoUpdateKey(String courierNumber, String noUpdateName) {
		super();
		this.courierNumber = courierNumber;
		this.noUpdateName = noUpdateName;
	}

	public NoUpdateKey() {
		super();
	}
    
    
}