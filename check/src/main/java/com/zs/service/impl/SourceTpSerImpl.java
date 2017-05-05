package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.dao.SourceThirdPartyMapper;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.SourceZm;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceTpSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

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

	public String importData(List<String[]> list) {
		// TODO Auto-generated method stub
		return null;
	}

	public String ExportData(EasyUIAccept accept, HttpServletRequest req) {
		List<SourceThirdParty> list=thirdPartyMapper.queryFenye(accept);
		String[] obj ={"所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","省份","地址","客户店铺","收件人","联系方式","重量","快递公司","物品价值","物品","创建日期","状态","返回日期","订单编号","超时时间"};
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
			objs[i][19] = Trans.TransToString(list.get(i).getReturnDate());
			objs[i][20] = list.get(i).getOrderNumber();
		}
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/哲盟返回数据.xls";
		ExcelExport.OutExcel(obj, objs, basePath+path);
		return path;
	}

}
