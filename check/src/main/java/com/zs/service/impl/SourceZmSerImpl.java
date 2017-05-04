package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.zs.dao.SourceZmMapper;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceZmSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

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

	public String ExportData(EasyUIAccept accept,HttpServletRequest req) {
		List<SourceZm> list=zmMapper.queryFenye(accept);
		String[] obj ={"所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","省份","地址","客户店铺","收件人","联系方式","重量","快递公司","物品价值","物品","创建日期","状态","返回日期","订单编号"};
		String[][] objs = new String[list.size()][obj.length];
		for (int i = 0; i < objs.length; i++) {
			objs[i][0] = list.get(i).getLargeArea();
			objs[i][1] = list.get(i).getSliceArea();
			objs[i][2] = list.get(i).getFenbu();
			objs[i][3] = list.get(i).getFbdArea();
			objs[i][4] = list.get(i).getCtmBarCode();
			objs[i][5] = list.get(i).getCtmName();
			objs[i][6] = list.get(i).getCourierNumber();
			objs[i][7] = Trans.TimestampTransToString(list.get(i).getSendTime());
			objs[i][8] = list.get(i).getProvince();
			objs[i][9] = list.get(i).getAddress();
			objs[i][10] = list.get(i).getShopNumber();
			objs[i][11] = list.get(i).getAddressee();
			objs[i][12] = list.get(i).getPhone();
			if(list.get(i).getWeight()==null){
				objs[i][13] = "";
			}else{
				objs[i][13] = list.get(i).getWeight().toString();
			}
			objs[i][14] = list.get(i).getCourierCompany();
			if(list.get(i).getGoodsCost()==null){
				objs[i][15] = "";
			}else{
				objs[i][15] = list.get(i).getGoodsCost().toString();
			}
			objs[i][16] = list.get(i).getGoods();
			objs[i][17] = Trans.TransToString(list.get(i).getCreateDate());
			objs[i][18] = list.get(i).getCourierState();
			objs[i][19] = Trans.TransToString(list.get(i).getReturnDate());
			objs[i][20] = list.get(i).getOrderNumber();
		}
		System.out.println(list.get(2).getGoodsCost());
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/哲盟返回数据.xls";
		ExcelExport.OutExcel(obj, objs, basePath+path);
		return path;
	}

}
