package com.zs.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.other.EasyUIAccept;

public interface SourceTpSer extends BaseService<SourceThirdParty, SourceThirdPartyKey>{
	public String importData(List<String[]> list ,HttpServletRequest req);

	public String ExportData(EasyUIAccept accept,HttpServletRequest req);
	
	public List<SourceThirdParty> queryHistory(EasyUIAccept accept);
	
	public boolean reckon(SourceThirdParty tp);
	
}
