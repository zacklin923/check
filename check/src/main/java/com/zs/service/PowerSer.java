package com.zs.service;

import java.math.BigDecimal;
import java.util.List;

import com.zs.entity.StaffPower;
import com.zs.entity.other.EasyUIPage;

public interface PowerSer extends BaseService<StaffPower,String>{

	public EasyUIPage queryFenye();
	
	public List<StaffPower> queryforId(String id);
	
	public StaffPower selectByUrlAndMethodEqual(String url,String method);
	
	public StaffPower selectByUrlAndMethodLike(String url,String method);
}
