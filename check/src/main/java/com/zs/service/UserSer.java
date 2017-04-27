package com.zs.service;

import com.zs.entity.StaffUser;

public interface UserSer extends BaseService<StaffUser,String>{
	
	public StaffUser selectFromLogin(String num);
	
	
}
