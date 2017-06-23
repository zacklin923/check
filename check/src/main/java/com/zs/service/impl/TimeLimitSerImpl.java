package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zs.dao.TimeLimitMapper;
import com.zs.entity.StaffUser;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.TimeLimitSer;
import com.zs.tools.ExcelExport;

@Service("timeLimitSer")
public class TimeLimitSerImpl implements TimeLimitSer{

	@Resource
	private TimeLimitMapper limitMapper;
	private Logger log=Logger.getLogger(getClass());
	
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

	public TimeLimit selectByEndProvince(String endProvince) {
		return limitMapper.selectByEndProvince(endProvince);
	}

	public String importData(List<String[]> list, String stuNum) {
		// TODO Auto-generated method stub
		return null;
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest request) {
		List<TimeLimit> list=limitMapper.queryFenye(accept);
		String[] obj =new String[]{"编号","始发中转站","到达省份","小时"};
		String[][] objs = new String[list.size()][obj.length];
		for (int i = 0; i < list.size(); i++) {
			TimeLimit limit=list.get(i);
			objs[i][0]=limit.getOrderNumber()+"";
			objs[i][1]=limit.getBeginProvince();
			objs[i][2]=limit.getEndProvince();
			objs[i][3]=limit.getHourCost()+"";
		}
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String path ="file/时效控制表.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}

}
