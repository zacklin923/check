package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.zs.dao.StaffPowerMapper;
import com.zs.entity.StaffPower;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.PowerSer;
import com.zs.tools.Trans;

@Transactional
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
		return powerMapper.insertSelective(obj);
	}

	public Integer update(StaffPower obj) {
		return powerMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		return powerMapper.deleteByPrimaryKey(Trans.toBigDecimal(id));
	}

	public StaffPower get(String id) {
		return powerMapper.selectByPrimaryKey(Trans.toBigDecimal(id));
	}

	public List<StaffPower> queryforId(String id) {
		return powerMapper.queryforId(id);
	}

	public StaffPower selectByUrlAndMethodEqual(String url, String method) {
		return powerMapper.selectByUrlAndMethodEqual(url, method);
	}

	public StaffPower selectByUrlAndMethodLike(String url, String method) {
		List<StaffPower> list=powerMapper.selectByUrlAndMethodLike(url, method);
		for (StaffPower p:list) {
			if (p.getStpUrl().contains("%")) {
				continue;
			}else {
				return p;
			}
		}
		return list.size()>0?list.get(list.size()-1):null;
	}

	

}
