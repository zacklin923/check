package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.StaffRoleMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.UserSer;

@Service("userSer")
public class UserSerImpl implements UserSer{

	@Resource
	private StaffUserMapper userMapper;
	@Resource
	private StaffRoleMapper roleMapper;
	private Gson g = new Gson();
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=userMapper.queryFenye(accept);
			for (int i = 0; i < list.size(); i++) {
				StaffUser su = (StaffUser) list.get(i);
				su.setRole(roleMapper.selectByPrimaryKey(su.getStuRole()));
			}
			int rows=userMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(StaffUser obj) {
		return userMapper.insertSelective(obj);
	}

	public Integer update(StaffUser obj) {
		// TODO Auto-generated method stub
		return userMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		return userMapper.deleteByPrimaryKey(id);
	}

	public StaffUser get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffUser selectFromLogin(String num) {
		return userMapper.selectByPrimaryKey(num);
	}

}
