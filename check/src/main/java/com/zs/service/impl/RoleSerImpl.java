package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.prefs.BackingStoreException;

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
		return roleMapper.insertSelective(obj);
	}

	public Integer update(StaffRole obj) {
		return roleMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		BigDecimal b = new BigDecimal(id);
		return roleMapper.deleteByPrimaryKey(b);
	}

	public StaffRole get(String id) {
		return null;
	}

	public List<StaffRole> queryAll() {
		EasyUIAccept accept = new EasyUIAccept();
		List<StaffRole> list=roleMapper.queryFenye(accept);
		return list;
	}

}
