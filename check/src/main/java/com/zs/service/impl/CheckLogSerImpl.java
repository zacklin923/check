package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.CheckLogMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CheckLogSer;

@Service("checkLogSer")
public class CheckLogSerImpl implements CheckLogSer{

	@Resource
	private CheckLogMapper checkLogMapper;
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
			List list=checkLogMapper.queryFenye(accept);
			for(int i = 0 ; i < list.size() ; i ++){
				CheckLog cl = (CheckLog) list.get(i);
				StaffUser user = userMapper.selectByPrimaryKey(cl.getUserNumber());
				cl.setUserNumber(user.getStuName());
			}
			int rows=checkLogMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(CheckLog obj) {
		return checkLogMapper.insertSelective(obj);
	}

	public Integer update(CheckLog obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}

	public CheckLog get(BigDecimal id) {
		// TODO Auto-generated method stub
		return null;
	}
}
