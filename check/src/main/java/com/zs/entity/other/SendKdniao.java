package com.zs.entity.other;

public class SendKdniao {
	private String OrderCode;
	private String ShipperCode;
	private String LogisticCode;
	
	public String getOrderCode() {
		return OrderCode;
	}
	public void setOrderCode(String orderCode) {
		OrderCode = orderCode;
	}
	public String getShipperCode() {
		return ShipperCode;
	}
	public void setShipperCode(String shipperCode) {
		ShipperCode = shipperCode;
	}
	public String getLogisticCode() {
		return LogisticCode;
	}
	public void setLogisticCode(String logisticCode) {
		LogisticCode = logisticCode;
	}
	public SendKdniao(String orderCode, String shipperCode, String logisticCode) {
		super();
		OrderCode = orderCode;
		ShipperCode = shipperCode;
		LogisticCode = logisticCode;
	}
	public SendKdniao() {
		super();
	}
	
}
