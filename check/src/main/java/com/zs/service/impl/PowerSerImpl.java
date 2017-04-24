package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zs.dao.StaffPowerMapper;
import com.zs.entity.StaffPower;
import com.zs.entity.StaffPowerExample;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.PowerSer;

@Service("powerSer")
public class PowerSerImpl implements PowerSer{

	@Resource
	private StaffPowerMapper powerMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=powerMapper.queryFenye(accept);
			int rows=powerMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}
	
	public EasyUIPage queryFenye() {
		EasyUIAccept accept=new EasyUIAccept();
		List list=powerMapper.queryFenye(accept);
		int rows=powerMapper.getCount(accept);
		return new EasyUIPage(rows, list);
	}

	public Integer add(StaffPower obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(StaffPower obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffPower get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
