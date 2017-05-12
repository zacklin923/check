package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.transform.Source;

import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;

public interface SourceZmSer extends BaseService<SourceZm, SourceZmKey>{
	
	public String importData(List<String[]> list);

	public String ExportData(EasyUIAccept accept,HttpServletRequest req);
	
	public SourceZm last(String num);
}
