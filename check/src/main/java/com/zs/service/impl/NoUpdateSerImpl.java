package com.zs.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.NoUpdateMapper;
import com.zs.entity.NoUpdate;
import com.zs.entity.NoUpdateKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.NoUpdateSer;

@Service("noUpdateSer")
public class NoUpdateSerImpl implements NoUpdateSer{

	@Resource
	private NoUpdateMapper noUpdateMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		return null;
	}

	public Integer add(NoUpdate obj) {
		return noUpdateMapper.insertSelective(obj);
	}

	public Integer update(NoUpdate obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(NoUpdateKey id) {
		return noUpdateMapper.deleteByPrimaryKey(id);
	}

	public NoUpdate get(NoUpdateKey id) {
		return noUpdateMapper.selectByPrimaryKey(id);
	}

}
