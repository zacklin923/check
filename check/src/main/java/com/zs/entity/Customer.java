package com.zs.entity;

public class Customer {
    private String cteBarCode;

    private String cteName;

    public String getCteBarCode() {
        return cteBarCode;
    }

    public void setCteBarCode(String cteBarCode) {
        this.cteBarCode = cteBarCode == null ? null : cteBarCode.trim();
    }

    public String getCteName() {
        return cteName;
    }

    public void setCteName(String cteName) {
        this.cteName = cteName == null ? null : cteName.trim();
    }

	public Customer(String cteBarCode, String cteName) {
		super();
		this.cteBarCode = cteBarCode;
		this.cteName = cteName;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}