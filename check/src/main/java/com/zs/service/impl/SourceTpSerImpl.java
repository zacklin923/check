package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.gson.Gson;
import com.zs.dao.NoUpdateMapper;
import com.zs.dao.SourceThirdPartyMapper;
import com.zs.dao.SourceZmMapper;
import com.zs.entity.NoUpdate;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.SourceZm;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.NoUpdateSer;
import com.zs.service.SourceTpSer;
import com.zs.service.SourceZmSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

@Transactional
@Service("sourceTpSer")
public class SourceTpSerImpl implements SourceTpSer{
	
	@Resource
	private SourceThirdPartyMapper thirdPartyMapper;
	@Resource
	private SourceZmMapper zmMapper;
	@Resource
	private SourceZmSer sourceZmSer;
	@Resource
	private NoUpdateSer noUpdateSer;

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
			for (int i = 0; i < list.size(); i++) {
				SourceThirdParty tp=(SourceThirdParty) list.get(i);
				if(reckon(tp)){
					thirdPartyMapper.updateByPrimaryKeySelective(tp);
				}
			}
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

	public String importData(List<String[]> list , HttpServletRequest req) {
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0].equals("")||list.get(i)[7].equals("")){
				ls.add((i+1)+",");
			}else{
				try {
					SourceThirdPartyKey stpk = new SourceThirdPartyKey(Trans.tostring(list.get(i)[0]),Trans.TransToDate(list.get(i)[7]));
					SourceThirdParty isstp = thirdPartyMapper.selectByPrimaryKey(stpk);
					SourceThirdParty stp = new SourceThirdParty(Trans.tostring(list.get(i)[0]), Trans.TransToDate(list.get(i)[7]), list.get(i)[2], list.get(i)[3], Trans.toTimestamp(list.get(i)[4]), list.get(i)[1], list.get(i)[5], Trans.toBigDecimal(list.get(i)[6]));
					if(isstp!=null){
						if(list.get(i)[2].equals("配送成功")||list.get(i)[2].equals("配送失败")){
							if(!isstp.getDeliveryState().equals(list.get(i)[2])){
								NoUpdate nu = new NoUpdate();
								nu.setCourierNumber(list.get(i)[0]);
								nu.setNoUpdateName("delivery_state");
								nu.setNoUpdateValue(list.get(i)[2]);
								StaffUser u = (StaffUser) req.getSession().getAttribute("user");
								nu.setStuNum(u.getStuNum());
								noUpdateSer.add(nu);
							}
						}
						SourceZm sz = new SourceZm(stp.getCourierNumber(), stp.getReturnDate(), stp.getProvince(),stp.getAddress(), stp.getShopNumber(),stp.getAddressee(),stp.getPhone(), stp.getGoods(), stp.getGoodsCost(), stp.getOrderNumber());
						zmMapper.updateByPrimaryKeySelective(sz);
						thirdPartyMapper.updateByPrimaryKeySelective(stp);
					}else{
						ls.add((i+1)+"");
					}
				} catch (Exception e) {
					e.printStackTrace();
					ls.add((i+1)+"");
				}
			}
		}
		if(ls.size()>0){
			return "错误行号为"+new Gson().toJson(ls);
		}else{
			return "";
		}
	}

	public String ExportData(EasyUIAccept accept, HttpServletRequest req) {
		List<SourceThirdParty> list=thirdPartyMapper.queryFenye(accept);
		for (int i = 0; i < list.size(); i++) {
			SourceThirdParty tp=(SourceThirdParty) list.get(i);
			if(reckon(tp)){
				thirdPartyMapper.updateByPrimaryKeySelective(tp);
			}
		}
		String[] obj ={"创建日期","所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","是否超时","异常原因","省份","地址","配送状态","签收人","签收时间","签收站点","收件人","订单编号","客户店铺","联系方式","重量","快递公司","物品","物品价值","费用","返回日期"};
		String[][] objs = new String[list.size()][obj.length];
		for (int i = 0; i < objs.length; i++) {
			objs[i][0] = Trans.TransToString(list.get(i).getCreateDate());
			objs[i][1] = list.get(i).getLargeArea();
			objs[i][2] = list.get(i).getSliceArea();
			objs[i][3] = list.get(i).getFenbu();
			objs[i][4] = list.get(i).getFbdArea();
			objs[i][5] = list.get(i).getCtmBarCode();
			objs[i][6] = list.get(i).getCtmName();
			objs[i][7] = list.get(i).getCourierNumber();
			objs[i][8] = Trans.TimestampTransToString(list.get(i).getSendTime());
			if(list.get(i).getIsTimeOut()==null){
				objs[i][9] = "";
			}else{
				objs[i][9] = list.get(i).getIsTimeOut().toString();
			}
			objs[i][10] = list.get(i).getAbnormalCause();
			objs[i][11] = list.get(i).getProvince();
			objs[i][12] = list.get(i).getAddress();
			objs[i][13] = list.get(i).getDeliveryState();
			objs[i][14] = list.get(i).getSignatory();
			objs[i][15] = Trans.TimestampTransToString(list.get(i).getSignTime());
			objs[i][16] = list.get(i).getSignPort();
			objs[i][17] = list.get(i).getAddressee();
			objs[i][18] = list.get(i).getOrderNumber();
			objs[i][19] = list.get(i).getShopNumber();
			objs[i][20] = list.get(i).getPhone();
			if(list.get(i).getWeight()==null){
				objs[i][21] = "";
			}else{
				objs[i][21] = list.get(i).getWeight().toString();
			}
			objs[i][22] = list.get(i).getCourierCompany();
			objs[i][23] = list.get(i).getGoods();
			if(list.get(i).getGoodsCost()==null){
				objs[i][24] = "";
			}else{
				objs[i][24] = list.get(i).getGoodsCost().toString();
			}
			if(list.get(i).getFee()==null){
				objs[i][25] = "";
			}else{
				objs[i][25] = list.get(i).getFee().toString();
			}
			objs[i][26] = Trans.TransToString(list.get(i).getReturnDate());
			
		}
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/哲盟返回第三方数据.xls";
		ExcelExport.OutExcel1(obj, objs, basePath+path);
		return path;
	}

	public List<SourceThirdParty> queryHistory(EasyUIAccept accept) {
		return thirdPartyMapper.queryByNumber(accept);
	}

	public String updateState(String state) {
	      if(state.equals("签收")){
				return "配送成功";
	      }else if(state.equals("收件")||state.equals("在途")||state.equals("派件")||state.equals("揽件")){
	      		return "配送中";
	      }else if(state.equals("疑难")){
	      		return "配送异常";
	      }
		  return null;
	}
	//重新计算超时时间,true:改了，false：没改
	public boolean reckon(SourceThirdParty tp) {
		//----------开始计算是否超时---计算完之后，补上以下数据：[是否超时]----------
		SourceZm zm=sourceZmSer.last(tp.getCourierNumber());
		BigDecimal b1=tp.getIsTimeOut();
		if (zm!=null 
				&& zm.getTimeOut()!=null 
				&& tp.getDeliveryState()!=null 
				&& !tp.getDeliveryState().equals("签收")
				&& !tp.getDeliveryState().equals("疑难")) {//剩余三种状态时才判断
			if (new Date().after(zm.getTimeOut())) {//现在>超时时间  ，就代表超期
				tp.setIsTimeOut(new BigDecimal(1));
			}else {
				tp.setIsTimeOut(new BigDecimal(0));
			}
		}
		BigDecimal b2=tp.getIsTimeOut();
		if ((b1==null && b2==null) || (b1!=null && b2!=null && b1.equals(b2))) {
			return false;
		}else{
			return true;
		}
	}

}
