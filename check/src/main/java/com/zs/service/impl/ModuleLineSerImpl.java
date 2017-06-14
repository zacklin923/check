package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.ModuleLineMapper;
import com.zs.entity.ModuleLine;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.ModuleLineSer;

@Service("moduleLineSer")
public class ModuleLineSerImpl implements ModuleLineSer{

	@Resource
	private ModuleLineMapper mlMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer add(ModuleLine obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(ModuleLine obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ModuleLine get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ModuleLine> queryStyle(String tbn) {
		return mlMapper.queryTable(tbn);
	}


}
