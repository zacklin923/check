package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.personalStyleMapper;
import com.zs.entity.personalStyle;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.PersonalStyleSer;

@Service("personalStyleSer")
public class PersonalStyleSerImpl implements PersonalStyleSer{

	@Resource
	private personalStyleMapper psMapper ;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		return null;
	}

	public Integer add(personalStyle obj) {
		return psMapper.insertSelective(obj);
	}

	public Integer update(personalStyle obj) {
		return psMapper.updateByPrimaryKeySelective(obj);
	}

	public personalStyle get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<personalStyle> queryStyle(EasyUIAccept accept) {
		return psMapper.querystyle(accept);
	}

}
