package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.VersionUpdateMapper;
import com.zs.entity.VersionUpdate;
import com.zs.entity.VersionUpdateExample;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.VersionSer;

@Service("versionSer")
public class VersionSerImpl implements VersionSer{

	@Resource
	private VersionUpdateMapper updateMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer add(VersionUpdate obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(VersionUpdate obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public VersionUpdate get(String id) {
		return null;
	}

	//得到最近一个版本，也就是当前版本
	public VersionUpdate last() {
		VersionUpdateExample example=new VersionUpdateExample();
		example.setOrderByClause("create_time desc");
		List<VersionUpdate> list=updateMapper.selectByExample(example);
		return list.size()>0?list.get(0):null;
	}

	//用户看了
	public String read(String stuNum) {
		VersionUpdate vu=this.last();
		if(vu.getVerStuNums()!=null && !vu.getVerStuNums().equals("")){
			if(!(","+vu.getVerStuNums()+",").equals(","+stuNum+",")){
				vu.setVerStuNums(vu.getVerStuNums()+","+stuNum);
			}
		}else {
			vu.setVerStuNums(stuNum);
		}
		updateMapper.updateByPrimaryKeySelective(vu);
		return null;
	}

}
