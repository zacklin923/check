package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.StaffUserMapper;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.UserSer;

@Service("userSer")
public class UserSerImpl implements UserSer{

	@Resource
	private StaffUserMapper userMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=userMapper.queryFenye(accept);
			int rows=userMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(StaffUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(StaffUser obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffUser get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
