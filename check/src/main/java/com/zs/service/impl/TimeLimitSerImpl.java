package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.TimeLimitMapper;
import com.zs.entity.StaffUser;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.TimeLimitSer;

@Service("timeLimitSer")
public class TimeLimitSerImpl implements TimeLimitSer{

	@Resource
	private TimeLimitMapper limitMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=limitMapper.queryFenye(accept);
			int rows=limitMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(TimeLimit obj) {
		return limitMapper.insertSelective(obj);
	}

	public Integer update(TimeLimit obj) {
		return limitMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(BigDecimal id) {
		return limitMapper.deleteByPrimaryKey(id);
	}

	public TimeLimit get(BigDecimal id) {
		return limitMapper.selectByPrimaryKey(id);
	}

}
