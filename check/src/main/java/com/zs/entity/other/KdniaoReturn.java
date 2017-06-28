package com.zs.entity.other;

import java.util.List;


public class KdniaoReturn {

	private String EBusinessID;
	private String OrderCode;
	private String ShipperCode;
	private String LogisticCode;
	private String CallBack;
	private Boolean Success;
	private String Reason;
	private String State;
	private List<Traces> Traces;
	public String getEBusinessID() {
		return EBusinessID;
	}
	public void setEBusinessID(String eBusinessID) {
		EBusinessID = eBusinessID;
	}
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
	public String getCallBack() {
		return CallBack;
	}
	public void setCallBack(String callBack) {
		CallBack = callBack;
	}
	public Boolean getSuccess() {
		return Success;
	}
	public void setSuccess(Boolean success) {
		Success = success;
	}
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public List<Traces> getTraces() {
		return Traces;
	}
	public void setTraces(List<Traces> traces) {
		Traces = traces;
	}
	public KdniaoReturn(String eBusinessID, String orderCode, String shipperCode, String logisticCode, String callBack,
			Boolean success, String reason, String state, List<com.zs.entity.other.Traces> traces) {
		super();
		EBusinessID = eBusinessID;
		OrderCode = orderCode;
		ShipperCode = shipperCode;
		LogisticCode = logisticCode;
		CallBack = callBack;
		Success = success;
		Reason = reason;
		State = state;
		Traces = traces;
	}
	public KdniaoReturn() {
		super();
	}
	@Override
	public String toString() {
		return "KdniaoReturn [EBusinessID=" + EBusinessID + ", OrderCode=" + OrderCode + ", ShipperCode=" + ShipperCode
				+ ", LogisticCode=" + LogisticCode + ", CallBack=" + CallBack + ", Success=" + Success + ", Reason="
				+ Reason + ", State=" + State + ", Traces=" + Traces + "]";
	}
	
}
