package com.zs.service;

import java.util.List;

import com.zs.entity.StaffRole;

public interface RoleSer extends BaseService<StaffRole>{
	
	public List<StaffRole> queryAll();
}
