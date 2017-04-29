package com.zs.service;

import java.util.List;

import com.zs.entity.SourceImport;

public interface SourceImportSer extends BaseService<SourceImport,String>{

	public String importData(List<String[]> list,String stuNum);
	
	public void sendToZm();
	
}
