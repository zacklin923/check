package com.zs.entity.other;

import java.math.BigDecimal;

public class SendToZmData {

	BigDecimal courier_number;
	BigDecimal ctm_bar_code;
	String number_type;
	
	public BigDecimal getCourier_number() {
		return courier_number;
	}
	public void setCourier_number(BigDecimal courier_number) {
		this.courier_number = courier_number;
	}
	public BigDecimal getCtm_bar_code() {
		return ctm_bar_code;
	}
	public void setCtm_bar_code(BigDecimal ctm_bar_code) {
		this.ctm_bar_code = ctm_bar_code;
	}
	public String getNumber_type() {
		return number_type;
	}
	public void setNumber_type(String number_type) {
		this.number_type = number_type;
	}
	public SendToZmData(BigDecimal courier_number, BigDecimal ctm_bar_code, String number_type) {
		super();
		this.courier_number = courier_number;
		this.ctm_bar_code = ctm_bar_code;
		this.number_type = number_type;
	}
	public SendToZmData() {
		super();
	}
	
}
