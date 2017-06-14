package com.zs.service;

import java.util.List;

import com.zs.entity.ModuleLine;

public interface ModuleLineSer extends BaseService<ModuleLine,String>{
	List<ModuleLine> queryStyle(String tbn);
}
