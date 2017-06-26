package com.zs.entity;

public class ProvinceCode {
    private String provinceCode;

    private String province;

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode == null ? null : provinceCode.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

	public ProvinceCode(String provinceCode, String province) {
		super();
		this.provinceCode = provinceCode;
		this.province = province;
	}

	public ProvinceCode() {
		super();
	}

	@Override
	public String toString() {
		return "ProvinceCode [provinceCode=" + provinceCode + ", province=" + province + "]";
	}
    
    
}