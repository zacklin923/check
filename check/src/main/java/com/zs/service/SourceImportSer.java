package com.zs.service;

import java.util.List;

import com.zs.entity.SourceImport;

public interface SourceImportSer extends BaseService<SourceImport>{

	public String importData(List<String[]> list);
}
