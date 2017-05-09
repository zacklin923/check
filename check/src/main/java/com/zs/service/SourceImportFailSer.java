package com.zs.service;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.SourceImportFailed;
import com.zs.entity.other.EasyUIAccept;

public interface SourceImportFailSer extends BaseService<SourceImportFailed,String>{

	public String ExportData(EasyUIAccept accept,HttpServletRequest req);
}
