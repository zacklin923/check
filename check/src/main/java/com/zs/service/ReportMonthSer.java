package com.zs.service;

import java.util.List;

import com.zs.entity.other.EasyUIAccept;

public interface ReportMonthSer{
	public List query(EasyUIAccept accept);
	
	public void callproduce(EasyUIAccept accept);
	
}
