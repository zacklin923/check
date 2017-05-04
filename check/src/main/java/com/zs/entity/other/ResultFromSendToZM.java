package com.zs.entity.other;

public class ResultFromSendToZM {
	
	private String failRows;
	private String result;
	public String getFailRows() {
		return failRows;
	}
	public void setFailRows(String failRows) {
		this.failRows = failRows;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public ResultFromSendToZM(String failRows, String result) {
		super();
		this.failRows = failRows;
		this.result = result;
	}
	public ResultFromSendToZM() {
		super();
	}

	
}
