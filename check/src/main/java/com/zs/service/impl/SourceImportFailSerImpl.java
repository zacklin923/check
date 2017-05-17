package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.SourceImportFailedMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceZm;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.SourceImportErr;
import com.zs.service.SourceImportFailSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

@Service("sourceImportFailSer")
public class SourceImportFailSerImpl implements SourceImportFailSer{

	Gson g = new Gson(); 	
	@Resource 
	private SourceImportFailedMapper sourceImportFailedMapper;
	@Resource
	private StaffUserMapper userMapper;
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
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
				SourceImportErr sie = g.fromJson(sif.getFailInfo(), SourceImportErr.class);
				if(sie.getStuNum()!=null && !sie.getStuNum().equals("")){
					try {
						StaffUser suer = userMapper.selectByPrimaryKey(sie.getStuNum());
						sie.setStuNum(suer.getStuName());
					} catch (Exception e) {
						sie.setStuNum("");
					}
				}else{
					sie.setStuNum("");
				}
				sif.setSourceImport(sie);
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

	public String ExportData(EasyUIAccept accept, HttpServletRequest req) {
		List<SourceImportFailed> list=sourceImportFailedMapper.queryFenye(accept);
		for (int i = 0; i < list.size(); i++) {
			SourceImportErr sie = g.fromJson(list.get(i).getFailInfo(), SourceImportErr.class);
			list.get(i).setSourceImport(sie);
		}
		String[] obj ={"时间","失败类型","创建时间","客户名","客户条码","快递单号","地址","订单编号","收件人","联系方式","商家ID","快递公司","物品价值","物品","类型","一段码","省份"};
		String[][] objs = new String[list.size()][obj.length];
		for (int i = 0; i < objs.length; i++) {
			objs[i][0] = Trans.TimestampTransToString(list.get(i).getCreateTime());
			objs[i][1] = list.get(i).getFailType();
			objs[i][2] = list.get(i).getSourceImport().getCreateDate();
			objs[i][3] = list.get(i).getSourceImport().getCtmName();
			objs[i][4] = list.get(i).getSourceImport().getCtmBarCode();
			objs[i][5] = list.get(i).getSourceImport().getCourierNumber();
			objs[i][6] = list.get(i).getSourceImport().getAddress();
			objs[i][7] = list.get(i).getSourceImport().getOrderNumber();
			objs[i][8] = list.get(i).getSourceImport().getAddressee();
			objs[i][9] = list.get(i).getSourceImport().getPhone();
			objs[i][10] = list.get(i).getSourceImport().getShopNumber();
			objs[i][11] = list.get(i).getSourceImport().getCourierCompany();
			objs[i][12] = list.get(i).getSourceImport().getGoodsCost();
			objs[i][13] = list.get(i).getSourceImport().getGoods();
			objs[i][14] = list.get(i).getSourceImport().getNumberType();
			objs[i][15] = list.get(i).getSourceImport().getOneCode();
			objs[i][16] = list.get(i).getSourceImport().getProvince();
		}
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/导入错误数据.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}

	public int deleteAll(String stuNum) {
		return sourceImportFailedMapper.deleteAll(stuNum);
	}
	
}
