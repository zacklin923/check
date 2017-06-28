package com.zs.service;

import java.math.BigDecimal;
import com.zs.entity.CheckLog;

public interface CheckLogSer extends BaseService<CheckLog, BigDecimal>{
	
	void saveOfAsyn(final CheckLog log,final Object oldData,final Object bigData);
	
}
