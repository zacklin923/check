package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.SourceImportFailedMapper;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceImportFailSer;

@Service("sourceImportFailSer")
public class SourceImportFailSerImpl implements SourceImportFailSer{

	@Resource 
	private SourceImportFailedMapper sourceImportFailedMapper;
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		Gson g = new Gson(); 	
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=sourceImportFailedMapper.queryFenye(accept);
			for (int i = 0; i < list.size(); i++) {
				SourceImportFailed sif = (SourceImportFailed) list.get(i);
				SourceImport si = g.fromJson(sif.getFailInfo(), SourceImport.class);
				sif.setSourceImport(si);
			}
			int rows=sourceImportFailedMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(SourceImportFailed obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(SourceImportFailed obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		return sourceImportFailedMapper.deleteByPrimaryKey(new BigDecimal(id));
	}

	public SourceImportFailed get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
