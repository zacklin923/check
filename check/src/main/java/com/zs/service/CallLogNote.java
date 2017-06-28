package com.zs.service;

import com.zs.entity.CheckLog;

/**
 * 用于日志记录的接口
 * @author 张顺，2017-6-27
 */
public interface CallLogNote {
	
	void save(CheckLog log);
	
}
