package com.zs.service;

import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;

public interface BaseService<T,ID_TYPE> {
	
	public EasyUIPage queryFenye(EasyUIAccept accept);
	
	public Integer add(T obj);
	
	@Deprecated
	public Integer update(T obj);
	
	public Integer delete(ID_TYPE id);

	public T get(ID_TYPE id);
	
}
