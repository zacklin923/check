package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.dao.SourceZmMapper;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceZmSer;

@Transactional
@Service("sourceZmSer")
public class SourceZmSerImpl implements SourceZmSer{

	@Resource
	private SourceZmMapper zmMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=zmMapper.queryFenye(accept);
			int rows=zmMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(SourceZm obj) {
		return zmMapper.insertSelective(obj);
	}

	public Integer update(SourceZm obj) {
		return zmMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(SourceZmKey id) {
		return zmMapper.deleteByPrimaryKey(id);
	}

	public SourceZm get(SourceZmKey id) {
		return zmMapper.selectByPrimaryKey(id);
	}

}
