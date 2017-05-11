package com.zs.service;

import java.util.List;

import com.zs.entity.SourceImport;

public interface SourceImportSer extends BaseService<SourceImport,String>{

	public String importData(List<String[]> list,String stuNum);
	
	public String sendToZm(String userNum);
	
	public void sendToZm2();
	
	public int deleteAll(String userNum);
}
