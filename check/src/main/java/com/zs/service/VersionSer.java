package com.zs.service;

import com.zs.entity.VersionUpdate;

public interface VersionSer extends BaseService<VersionUpdate, String>{

	public VersionUpdate last();
	public String read(String stuNum);
}
