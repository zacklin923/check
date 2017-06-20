package com.zs.service;

import java.util.List;

import com.zs.entity.PrimeCodeReport;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.PrimeCodeCollect;

public interface PrimeCodeImportSer extends BaseService<PrimeCodeReport,String>{

	public String importData(List<String[]> list,String stuNum);
	
	public int deleteAll(String userNum);
	
	public EasyUIPage queryCollect(EasyUIAccept accept);
	
	public EasyUIPage querPer(EasyUIAccept accept);
}
