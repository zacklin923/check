package com.zs.service;

import java.util.List;

import com.zs.entity.ProvinceCode;

public interface ProvinceCodeSer extends BaseServiceExcel<ProvinceCode, String>{
	
	public List<String> selectProvince(String pro);	
}
