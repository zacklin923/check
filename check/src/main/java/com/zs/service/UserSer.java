package com.zs.service;

import com.zs.entity.StaffUser;

public interface UserSer extends BaseService<StaffUser>{
	
	public StaffUser selectFromLogin(String num);
	
	
}
