package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.zs.controller.rest.BaseRestController.Code;
import com.zs.dao.CheckLogMapper;
import com.zs.dao.CustomerMapper;
import com.zs.dao.NoUpdateMapper;
import com.zs.dao.SourceZmMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.NoUpdate;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmExample;
import com.zs.entity.SourceZmExample.Criteria;
import com.zs.entity.SourceZmKey;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.Result;
import com.zs.entity.other.SourceImportErr;
import com.zs.service.SourceZmSer;
import com.zs.service.TimeLimitSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.ProvinceHelper;
import com.zs.tools.Trans;

@Transactional
@Service("sourceZmSer")
public class SourceZmSerImpl implements SourceZmSer{

	@Resource
	private SourceZmMapper zmMapper;
	@Resource
	private NoUpdateMapper noUpdateMapper;
	@Resource
	private CheckLogMapper checkLogMapper;
	@Resource
	private CustomerMapper custormerMapper;
	@Resource
	private TimeLimitSer timeLimitSer;
	
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
	
	@Deprecated
	public Integer update(SourceZm obj) {
		return this.update(obj, null);
	}

	public Integer update(SourceZm zm, String stuNum) {
		Integer i=zmMapper.updateByPrimaryKeySelective(zm);
		checkUpdateProvince(zm, stuNum);
		return i;
	}
	
	
	public Integer delete(SourceZmKey id) {
		return zmMapper.deleteByPrimaryKey(id);
	}

	public SourceZm get(SourceZmKey id) {
		return zmMapper.selectByPrimaryKey(id);
	}

//	public String ExportData(EasyUIAccept accept,HttpServletRequest req) {
//		List<SourceZm> list=zmMapper.queryFenye(accept);
//		String[] obj ={"所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","省份","地址","客户店铺","收件人","联系方式","重量","快递公司","物品价值","物品","创建日期","状态","返回日期","订单编号","超时时间"};
//		String[][] objs = new String[list.size()][obj.length];
//		for (int i = 0; i < objs.length; i++) {
//			objs[i][0] = list.get(i).getLargeArea();
//			objs[i][1] = list.get(i).getSliceArea();
//			objs[i][2] = list.get(i).getFenbu();
//			objs[i][3] = list.get(i).getFbdArea();
//			objs[i][4] = list.get(i).getCtmBarCode();
//			objs[i][5] = list.get(i).getCtmName();
//			objs[i][6] = list.get(i).getCourierNumber();
//			objs[i][7] = Trans.TimestampTransToString(list.get(i).getSendTime());
//			objs[i][8] = list.get(i).getProvince();
//			objs[i][9] = list.get(i).getAddress();
//			objs[i][10] = list.get(i).getShopNumber();
//			objs[i][11] = list.get(i).getAddressee();
//			objs[i][12] = list.get(i).getPhone();
//			if(list.get(i).getWeight()==null){
//				objs[i][13] = "";
//			}else{
//				objs[i][13] = list.get(i).getWeight().toString();
//			}
//			objs[i][14] = list.get(i).getCourierCompany();
//			if(list.get(i).getGoodsCost()==null){
//				objs[i][15] = "";
//			}else{
//				objs[i][15] = list.get(i).getGoodsCost().toString();
//			}
//			objs[i][16] = list.get(i).getGoods();
//			objs[i][17] = Trans.TransToString(list.get(i).getCreateDate());
//			objs[i][18] = list.get(i).getCourierState();
//			objs[i][19] = Trans.TransToString(list.get(i).getReturnDate());
//			objs[i][20] = list.get(i).getOrderNumber();
//			objs[i][21] = Trans.TimestampTransToString(list.get(i).getTimeOut());
//		}
//		String basePath = req.getSession().getServletContext().getRealPath("/");
//		String path ="file/哲盟返回数据.xls";
//		ExcelExport.OutExcel1(obj, objs, basePath+path);
//		return path;
//	}

	public String ExportData(EasyUIAccept accept,HttpServletRequest req) {
		String line[] = accept.getStr6().split(",");
		List<SourceZm> list=zmMapper.queryFenye(accept);
		String[] obj ={"所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","省份","地址","客户店铺","收件人","联系方式","重量","快递公司","物品价值","物品","创建日期","状态","返回日期","订单编号","超时时间","系统接收时间"};
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
			objs[i][21] = Trans.TimestampTransToString(list.get(i).getTimeOut());
			objs[i][22] = Trans.TimestampTransToString(list.get(i).getCreateTime());
		}
		String [][] lines = new String[objs.length][line.length];
		for (int k = 0; k < objs.length; k++) {
			for (int j = 0; j < line.length; j++) {
				for (int i = 0; i < obj.length; i++) {
					if(line[j].equals(obj[i])){
						lines[k][j]=objs[k][i];
					}
				}
			}
		}
		
		String basePath = req.getSession().getServletContext().getRealPath("/");
		String path ="file/哲盟返回数据.xls";
		ExcelExport.OutExcel1(line, lines, basePath+path);
		return path;
	}
	
	public String importData(List<String[]> list,String stuNum) {
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[6].equals("")||list.get(i)[19].equals("")){
				ls.add((i+1)+"");
			}else{
				try {
					SourceZmKey szk = new SourceZmKey(Trans.tostring(list.get(i)[6]), Trans.TransToDate(list.get(i)[19]));
					SourceZm iszs = zmMapper.selectByPrimaryKey(szk);
					SourceZm sz = new SourceZm(
							Trans.tostring(list.get(i)[6]),
							Trans.TransToDate(list.get(i)[19]),
							list.get(i)[8],
							list.get(i)[9],
							Trans.tostring(list.get(i)[10]),
							list.get(i)[11],
							Trans.tostring(list.get(i)[12]),
							list.get(i)[16],
							Trans.toBigDecimal(list.get(i)[15]),
							Trans.tostring(list.get(i)[20]));
					if(iszs!=null){
						try {
							//-------判断下省份到底改了没-------------
							SourceZm sourceZm=get(new SourceZmKey(sz.getCourierNumber(), sz.getReturnDate()));
							if ((sourceZm.getProvince()!=null && sz.getProvince()!=null && sourceZm.getProvince().equals(sz.getProvince()))
									|| (sourceZm.getProvince()==null && sz.getProvince()==null)) {
								sz.setProvince(null);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
						zmMapper.updateByPrimaryKeySelective(sz);
						//添加信息到日志表
						CheckLog clog = new CheckLog(null, Trans.tostring(list.get(i)[6]),Trans.TransToDate(list.get(i)[19]), "source_zm",new Gson().toJson(iszs) , null,stuNum , "修改");
						checkLogMapper.insertSelective(clog);
						//
						checkUpdateProvince(sz, stuNum);
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
			return "数据修改错误行号为"+new Gson().toJson(ls);
		}else{
			return "";
		}
	}

	public String importDatatest(List<String[]> list,String stuNum) {
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[6].equals("")||list.get(i)[19].equals("")){
				ls.add((i+1)+"");
			}else{
				try {
					SourceZmKey szk = new SourceZmKey(Trans.tostring(list.get(i)[6]), Trans.TransToDate(list.get(i)[19]));
					SourceZm iszs = zmMapper.selectByPrimaryKey(szk);
					CustomerKey ck = new CustomerKey();
					ck.setCteBarCode(list.get(i)[4]);
					ck.setHistoryCount(new BigDecimal(0));
					Customer ct = custormerMapper.selectByPrimaryKey(ck);
					String ctm_name="";
					if(ct!=null){
						ctm_name = ct.getCteName();
					}
					SourceZm sz = new SourceZm(
							list.get(i)[0],
							list.get(i)[1],
							list.get(i)[2],
							list.get(i)[4],
							ctm_name,
							Trans.toTimestamp(list.get(i)[7]),
							ProvinceHelper.getProvince(list.get(i)[8]),
							null,null,null,null,
							Trans.toBigDecimal(list.get(i)[13]),
							null,null,null,null,null,null,null,
							list.get(i)[3],null,
							Trans.tostring(list.get(i)[6]),
							Trans.TransToDate(list.get(i)[19]));
					
					if(sz.getProvince()!=null){
						TimeLimit tl=timeLimitSer.selectByEndProvince(sz.getProvince());
						if(tl!=null && sz.getSendTime()!=null){
							Calendar calendar=Calendar.getInstance();
							calendar.setTime(sz.getSendTime());
							calendar.add(Calendar.SECOND, (int)(tl.getHourCost().doubleValue()*(60*60)));
							sz.setTimeOut(calendar.getTime());
						}
					}
					if(iszs!=null){
						zmMapper.updateByPrimaryKeySelective(sz);
					}else{
						zmMapper.insertSelective(sz);
					}
				} catch (Exception e) {
					e.printStackTrace();
					ls.add((i+1)+"");
				}
			}
		}
		if(ls.size()>0){
			return "数据修改错误行号为"+new Gson().toJson(ls);
		}else{
			return "";
		}
	}
	
	
	/*得到最新的一条记录*/
	public SourceZm last(String num) {
		SourceZmExample example=new SourceZmExample();
		example.setOrderByClause("return_date desc");
		Criteria criteria=example.createCriteria();
		criteria.andCourierNumberEqualTo(num);
		List<SourceZm> list=zmMapper.selectByExample(example);
		return list.size()>0?list.get(list.size()-1):null;
	}

	/**
	 * 检查是否改了省份以及如何处理
	 */
	public void checkUpdateProvince(SourceZm zm,String stuNum){
		if (zm!=null && zm.getProvince()!=null && zm.getCourierNumber()!=null && stuNum!=null) {
			NoUpdate noUpdate=noUpdateMapper.selectByNumberOfZm(zm.getCourierNumber());
			if (noUpdate==null) {
				noUpdateMapper.insertSelective(new NoUpdate(zm.getCourierNumber(),"province",zm.getProvince(),new Date(),stuNum));
			}else {
				noUpdateMapper.updateByPrimaryKeySelective(new NoUpdate(zm.getCourierNumber(),"province",zm.getProvince(),new Date(),stuNum));
			}
		}
	}

	public List<SourceThirdParty> queryHistory(EasyUIAccept accept) {
		return zmMapper.queryByNumber(accept);
	}
	
}
