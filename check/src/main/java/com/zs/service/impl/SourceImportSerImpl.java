package com.zs.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.SourceImportMapper;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportKey;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceImportSer;
import com.zs.tools.Trans;

@Service("sourceImportSer")
public class SourceImportSerImpl implements SourceImportSer{

	@Resource
	private SourceImportMapper importMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		Gson g= new Gson();
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=importMapper.queryFenye(accept);
			System.out.println(g.toJson(list));
			int rows=importMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(SourceImport obj) {
		return importMapper.insertSelective(obj);
	}

	public Integer update(SourceImport obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SourceImport get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String importData(List<String[]> list) {
		int it=0;
		List<SourceImport> errlist = new ArrayList<SourceImport>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[4].equals("")){
				SourceImportKey sik = new SourceImportKey();
				sik.setCourierNumber(list.get(i)[3]);
				sik.setCreateDate(Trans.TransToDate(list.get(i)[4],"yyyy-MM-dd"));
				SourceImport skey =importMapper.selectByPrimaryKey(sik);
				if(skey==null){
					
				}else{
					errlist.add(skey);
				}
			}
			
			SourceImport s = new SourceImport();
			it = it +  importMapper.insertSelective(s);
		}
		String str="";
		return str;
	}

}
