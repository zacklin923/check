package com.zs.service;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;

public interface SourceZmSer extends BaseService<SourceZm, SourceZmKey>{

	public String ExportData(EasyUIAccept accept,HttpServletRequest req);
}
