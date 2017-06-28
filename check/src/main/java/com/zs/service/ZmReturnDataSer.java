package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceZm;
import com.zs.entity.ZmReturnData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;

public interface ZmReturnDataSer{
	
	public Integer add(ZmReturnData obj,HttpServletRequest req);
	public Integer update(ZmReturnData obj,HttpServletRequest req);
	public Integer delete(String id,HttpServletRequest req);
	public ZmReturnData get(String id,HttpServletRequest req);
	
	public boolean reckon(ZmReturnData data);
	public void checkUpdateProvince(ZmReturnData data,String stuNum);
	public void checkUpdateDeliveryState(ZmReturnData data,String stuNum);
	
	public EasyUIPage queryFenyeOfZm(EasyUIAccept accept,HttpServletRequest req);
	public String importDataOfZm(List<String[]> list,String stuNum);
	public String importDatatestOfZm(List<String[]> list,String stuNum);
	public String ExportDataOfZm(EasyUIAccept accept,HttpServletRequest req);
	
	public EasyUIPage queryFenyeOfTp(EasyUIAccept accept,HttpServletRequest req);
	public String importDataOfTp(List<String[]> list ,HttpServletRequest req);
	public String ExportDataOfTp(EasyUIAccept accept,HttpServletRequest req);
	
	
}
