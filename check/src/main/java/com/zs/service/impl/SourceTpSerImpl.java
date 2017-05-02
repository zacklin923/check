package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.dao.SourceThirdPartyMapper;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceTpSer;

@Transactional
@Service("sourceTpSer")
public class SourceTpSerImpl implements SourceTpSer{
	
	@Resource
	private SourceThirdPartyMapper thirdPartyMapper;

	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=thirdPartyMapper.queryFenye(accept);
			int rows=thirdPartyMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(SourceThirdParty obj) {
		return thirdPartyMapper.insertSelective(obj);
	}

	public Integer update(SourceThirdParty obj) {
		return thirdPartyMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(SourceThirdPartyKey id) {
		return thirdPartyMapper.deleteByPrimaryKey(id);
	}

	public SourceThirdParty get(SourceThirdPartyKey id) {
		return thirdPartyMapper.selectByPrimaryKey(id);
	}

}
