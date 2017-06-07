package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;

public interface SourceZmSer extends BaseService<SourceZm, SourceZmKey>{
	
	public String importData(List<String[]> list,String stuNum);
	
	public String importDatatest(List<String[]> list,String stuNum);

	public String ExportData(EasyUIAccept accept,HttpServletRequest req);
	
	public SourceZm last(String num);
	
	public Integer update(SourceZm zm,String stuNum);
	
	public List<SourceThirdParty> queryHistory(EasyUIAccept accept);
}
