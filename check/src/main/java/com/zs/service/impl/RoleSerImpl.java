package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.StaffRoleMapper;
import com.zs.entity.StaffRole;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.RoleSer;

@Service("roleSer")
public class RoleSerImpl implements RoleSer{

	@Resource
	private StaffRoleMapper roleMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=roleMapper.queryFenye(accept);
			int rows=roleMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(StaffRole obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(StaffRole obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffRole get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
