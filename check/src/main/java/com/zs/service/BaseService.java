package com.zs.service;

import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;

public interface BaseService<T> {
	
	public EasyUIPage queryFenye(EasyUIAccept accept);
	
	public Integer add(T obj);
	
	public Integer update(T obj);
	
	public Integer delete(String id);

	public T get(String id);
	
}
