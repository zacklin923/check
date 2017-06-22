package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.other.EasyUIAccept;

public interface ReportSer{
	public List query(EasyUIAccept accept);
	
	public void callproduce(EasyUIAccept accept);
	
	public String exportData(EasyUIAccept accept,HttpServletRequest request);
}
