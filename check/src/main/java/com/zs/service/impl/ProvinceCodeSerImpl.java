package com.zs.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.zs.dao.ProvinceCodeMapper;
import com.zs.entity.ProvinceCode;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.ProvinceCodeSer;
import com.zs.tools.ExcelExport;

import oracle.net.aso.a;

@Service("provinceCodeSer")
public class ProvinceCodeSerImpl implements ProvinceCodeSer{

	private Logger log=Logger.getLogger(getClass());
	@Resource
	private ProvinceCodeMapper codeMapper;

	/*2017-5-4，张顺，就用一次，方便把数据存进数据而已，以后不会用了，所有没有写判断，不要给用户使用。*/
	public String importData(List<String[]> list, String stuNum) {
		for (int i = 2; i < list.size(); i++) {
			ProvinceCode code=new ProvinceCode(list.get(i)[8],list.get(i)[3]);
			try {
				codeMapper.insertSelective(code);
			} catch (Exception e) {
				log.error("【导入省份码错误】"+list.get(i)[8]);
			}
		}
		return null;
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest request) {
		List<ProvinceCode> list=codeMapper.queryFenye(accept);
		String[] obj =new String[]{"一段码","省份名称"};
		String[][] objs = new String[list.size()][obj.length];
		for (int i = 0; i < list.size(); i++) {
			ProvinceCode code=list.get(i);
			objs[i][0]=code.getProvinceCode();
			objs[i][1]=code.getProvince();
		}
		String basePath = request.getSession().getServletContext().getRealPath("/");
		String path ="file/一段码省份对照表.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}

	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=codeMapper.queryFenye(accept);
			int rows=codeMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(ProvinceCode obj) {
		return codeMapper.insertSelective(obj);
	}

	public Integer update(ProvinceCode obj) {
		return codeMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		return codeMapper.deleteByPrimaryKey(id);
	}

	public ProvinceCode get(String id) {
		return codeMapper.selectByPrimaryKey(id);
	}

	public List<String> selectProvince(String pro) {
		return codeMapper.selectProvince(pro);
	}
	

}
