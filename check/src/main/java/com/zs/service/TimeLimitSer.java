package com.zs.service;

import java.math.BigDecimal;
import com.zs.entity.TimeLimit;

public interface TimeLimitSer extends BaseServiceExcel<TimeLimit,BigDecimal>{
	
	public TimeLimit selectByEndProvince(String endProvince);
	
}
