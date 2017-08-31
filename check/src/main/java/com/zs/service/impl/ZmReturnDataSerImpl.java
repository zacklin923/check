package com.zs.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.CustomerMapper;
import com.zs.dao.NoUpdateMapper;
import com.zs.dao.StaffRoleMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.dao.ZmReturnDataMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.NoUpdate;
import com.zs.entity.NoUpdateKey;
import com.zs.entity.StaffUser;
import com.zs.entity.TimeLimit;
import com.zs.entity.ZmReturnData;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CheckLogSer;
import com.zs.service.TimeLimitSer;
import com.zs.service.ZmReturnDataSer;
import com.zs.tools.ExcelExport;
import com.zs.tools.Trans;

/**
 * 新版本的服务类，用于处理运单信息查询模块，和运单状态查询模块的数据
 * @author 张顺，2017-6-26
 */
@Service("zmReturnDataSer")
public class ZmReturnDataSerImpl implements ZmReturnDataSer{

	@Resource
	private ZmReturnDataMapper zmReturnDataMapper;
	private Logger log=Logger.getLogger(getClass());
	@Resource
	private NoUpdateMapper noUpdateMapper;
	@Resource
	private CheckLogSer checkLogSer;
	@Resource
	private CustomerMapper custormerMapper;
	@Resource
	private TimeLimitSer timeLimitSer;
	@Resource
	private StaffUserMapper userMapper;
	
	public Integer add(ZmReturnData obj,HttpServletRequest req) {
		//添加信息到日志表
		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
		CheckLog clog = new CheckLog(obj.getCourierNumber(),"zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_ADD);
		checkLogSer.saveOfAsyn(clog,obj,null);
		return zmReturnDataMapper.insertSelective(obj);
	}
	/*有省份判断，和配送状态判断*/
	public Integer update(ZmReturnData obj,HttpServletRequest req) {
		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
		String str = null;
		if(user!=null){
			checkUpdateProvince(obj,user.getStuNum());
			checkUpdateDeliveryState(obj, user.getStuNum());
			obj.setUpdateMan(user.getStuNum());
		}else{
			str = stateUpdate(obj);
		}
		if(str!=null){
			obj.setDeliveryState(str);
		}
		Integer i=zmReturnDataMapper.updateByPrimaryKeySelective(obj);
		//添加信息到日志表
		CheckLog clog = new CheckLog(obj.getCourierNumber(),"zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_UPDATE);
		checkLogSer.saveOfAsyn(clog,obj,null);
		return i;
	}
	public Integer delete(String id,HttpServletRequest req) {
		//添加信息到日志表
		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
		ZmReturnData zm=zmReturnDataMapper.selectByPrimaryKey(id);
		CheckLog clog = new CheckLog(id,"zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_DELETE);
		checkLogSer.saveOfAsyn(clog,zm,null);
		return zmReturnDataMapper.deleteByPrimaryKey(id);
	}
	public ZmReturnData get(String id,HttpServletRequest req) {
		//添加信息到日志表
		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
		ZmReturnData zm=zmReturnDataMapper.selectByPrimaryKey(id);
		CheckLog clog = new CheckLog(id,"zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_GET);
		checkLogSer.saveOfAsyn(clog,zm,null);
		return zm;
	}
	//重新计算超时时间,true:改了，false：没改
	public boolean reckon(ZmReturnData tp) {
		//----------开始计算是否超时---计算完之后，补上以下数据：[是否超时]----------
		Integer b1=tp.getIsTimeOut();
		if (tp!=null
				&& tp.getDeliveryState()!=null 
				&& tp.getTimeOut()!=null
				) {
			if(tp.getDeliveryState().equals("配送成功")){
				if(tp.getSignTime()!=null && tp.getTimeOut()!=null){
					if(tp.getSignTime().after(tp.getTimeOut())){ //签收时间>超时时间，就代表超时
						tp.setIsTimeOut(1);
					}else {
						tp.setIsTimeOut(0);
					}
				}
			}else if(tp.getDeliveryState().equals("配送中")
					|| tp.getDeliveryState().equals("揽件") 
					){
				if (new Date().after(tp.getTimeOut())) {//现在>超时时间  ，就代表超期
					tp.setIsTimeOut(1);
				}else {
					tp.setIsTimeOut(0);
				}
			}
		}
		Integer b2=tp.getIsTimeOut();
		if ((b1==null && b2==null) || (b1!=null && b2!=null && b1.equals(b2))) {
			return false;
		}else{
			return true;
		}
	}
	/**
	 * 检查是否改了省份以及如何处理
	 */
	public void checkUpdateProvince(ZmReturnData zm,String stuNum){
		if (zm!=null && zm.getProvince()!=null && zm.getCourierNumber()!=null && stuNum!=null) {
			ZmReturnData zmt=zmReturnDataMapper.selectByPrimaryKey(zm.getCourierNumber());
			if(zmt.getProvince()!=null){
				if(!zmt.getProvince().equals(zm.getProvince())){
					NoUpdate noUpdate=noUpdateMapper.selectByNumberOfZm(zm.getCourierNumber());
					if (noUpdate==null) {
						noUpdateMapper.insertSelective(new NoUpdate(zm.getCourierNumber(),"province",zm.getProvince(),new Date(),stuNum));
					}else {
						noUpdateMapper.updateByPrimaryKeySelective(new NoUpdate(zm.getCourierNumber(),"province",zm.getProvince(),new Date(),stuNum));
					}
				}
			}
		}
	}
	/**
	 * 检查是否改了不能更改的配送状态以及如何处理
	 */
	public void checkUpdateDeliveryState(ZmReturnData zm, String stuNum) {
		if (zm!=null && zm.getDeliveryState()!=null && stuNum!=null) {
			//-------判断配送状态是否修改为系统不能修改的两个字段
			try {
				if(zm.getDeliveryState().equals("配送成功")||zm.getDeliveryState().equals("配送失败")||zm.getDeliveryState().equals("退回件")){
					ZmReturnData stp = zmReturnDataMapper.selectByPrimaryKey(zm.getCourierNumber());
					if(!stp.getDeliveryState().equals(zm.getDeliveryState())){
						NoUpdate nu = new NoUpdate();
						nu.setCourierNumber(zm.getCourierNumber());
						nu.setNoUpdateName("delivery_state");
						nu.setNoUpdateValue(zm.getDeliveryState());
						nu.setStuNum(stuNum);
						try {
							noUpdateMapper.insertSelective(nu);
						} catch (Exception e) {
							noUpdateMapper.updateByPrimaryKeySelective(nu);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				
			}
		}
	}
	/*计算不可更改项，1是信息的，2是状态的*/
	private void checkNoUpdate(List<ZmReturnData> data,int type){
		for (ZmReturnData zm : data) {
			List<NoUpdate> list=new ArrayList<NoUpdate>();
			if (type==1) {
				NoUpdate noUpdate=noUpdateMapper.selectByNumberOfZm(zm.getCourierNumber());
				zm.setNoUpdateProvince(noUpdate);
			}else if(type==2){
				NoUpdate noUpdate=noUpdateMapper.selectByNumberOfTp(zm.getCourierNumber());
				zm.setNoUpdateDeliveryState(noUpdate);
			}
		}
	}
	
	//----------------------------------------------------------------------------
	public EasyUIPage queryFenyeOfZm(EasyUIAccept accept,HttpServletRequest req) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=zmReturnDataMapper.queryFenyeOfZm(accept);
			for (int i = 0; i < list.size(); i++) {
				ZmReturnData tp=(ZmReturnData) list.get(i);
				if(tp.getUpdateMan()!=null&&!tp.getUpdateMan().equals("")){
					StaffUser us = userMapper.selectByPrimaryKey(tp.getUpdateMan());
					tp.setUpdateMan(us.getStuName());
				}
			}
			int rows=zmReturnDataMapper.getCountOfZm(accept);
			//查不可更改项
			checkNoUpdate(list, 1);
			EasyUIPage easyUIPage=new EasyUIPage(rows, list);
			//添加信息到日志表,查询不存
//			StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
//			CheckLog clog = new CheckLog(null,"zm_return_data",user==null?null:user.getStuNum(),CheckLog.TYPE_QUERY);
//			checkLogSer.saveOfAsyn(clog, accept, easyUIPage);
			return easyUIPage;
		}
		return null;
	}


	public String ExportDataOfZm(EasyUIAccept accept,HttpServletRequest req) {
		String line[] = accept.getStr6().split(",");
//		System.out.println(accept);
		List<ZmReturnData> list=zmReturnDataMapper.queryFenyeOfZm(accept);
//		System.out.println(list.size());
		String[] obj ={"所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","省份","地址","客户店铺","收件人","联系方式","重量","快递公司","物品价值","物品","创建日期","状态","订单编号","超时时间","系统接收时间","修改人"};
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
			objs[i][19] = list.get(i).getOrderNumber();
			objs[i][20] = Trans.TimestampTransToString(list.get(i).getTimeOut());
			objs[i][21] = Trans.TimestampTransToString(list.get(i).getCreateTime());
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
//		//添加信息到日志表
//		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
//		CheckLog clog = new CheckLog(null, "zm_return_data",user==null?null:user.getStuNum(),CheckLog.TYPE_EXPORT);
//		checkLogSer.saveOfAsyn(clog, accept, list);
		return path;
	}
	
	public String importDataOfZm(List<String[]> list,String stuNum) {
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[6].equals("")){
				ls.add((i+1)+"");
			}else{
				try {
					String id = Trans.tostring(list.get(i)[6]);
					ZmReturnData iszs = zmReturnDataMapper.selectByPrimaryKey(id);
					ZmReturnData sz = new ZmReturnData(
							Trans.tostring(list.get(i)[6]),
							Trans.tostring(list.get(i)[4]),
							list.get(i)[5],
							list.get(i)[0],
							list.get(i)[1],
							list.get(i)[2],
							list.get(i)[3],
							Trans.tostring(list.get(i)[10]),
							list.get(i)[9],
							list.get(i)[11],
							Trans.tostring(list.get(i)[12]),
							list.get(i)[16],
							Trans.toBigDecimal(list.get(i)[15]),
							Trans.toBigDecimal(list.get(i)[13]),
							Trans.tostring(list.get(i)[14]),
							Trans.tostring(list.get(i)[19]),
							Trans.toTimestamp(list.get(i)[7]),
							list.get(i)[8],
							list.get(i)[18],
							Trans.toTimestamp(list.get(i)[20]),
							null,
							Trans.TransToDate(list.get(i)[17]),
							stuNum
							);
					if(iszs!=null){
						checkUpdateProvince(sz, stuNum);
						System.out.println(sz.getUpdateMan());
						zmReturnDataMapper.updateByPrimaryKeySelective(sz);
						
						//添加信息到日志表
						CheckLog clog = new CheckLog(sz.getCourierNumber(), "zm_return_data",stuNum, CheckLog.TYPE_IMPORT);
						checkLogSer.saveOfAsyn(clog, sz, null);
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

	public String importDatatestOfZm(List<String[]> list,String stuNum) {
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[6].equals("")){
				ls.add((i+1)+"");
			}else{
				try {
					String szk = Trans.tostring(list.get(i)[6]);
					ZmReturnData iszs = zmReturnDataMapper.selectByPrimaryKey(szk);
					CustomerKey ck = new CustomerKey();
					ck.setCteBarCode(list.get(i)[4]);
					ck.setHistoryCount(new BigDecimal(0));
					Customer ct = custormerMapper.selectByPrimaryKey(ck);
					String ctm_name="";
					if(ct!=null){
						ctm_name = ct.getCteName();
					}
					ZmReturnData sz = new ZmReturnData(
							Trans.tostring(list.get(i)[6]),
							Trans.tostring(list.get(i)[4]),
							list.get(i)[5],
							list.get(i)[0],
							list.get(i)[1],
							list.get(i)[2],
							list.get(i)[3],
							Trans.tostring(list.get(i)[10]),
							list.get(i)[9],
							list.get(i)[11],
							Trans.tostring(list.get(i)[12]),
							list.get(i)[16],
							Trans.toBigDecimal(list.get(i)[15]),
							Trans.toBigDecimal(list.get(i)[13]),
							Trans.tostring(list.get(i)[14]),
							Trans.tostring(list.get(i)[19]),
							Trans.toTimestamp(list.get(i)[7]),
							list.get(i)[8],
							list.get(i)[18],
							Trans.toTimestamp(list.get(i)[20]),
							null,
							Trans.TransToDate(list.get(i)[17]),stuNum
							);
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
						zmReturnDataMapper.updateByPrimaryKeySelective(sz);
					}else{
						zmReturnDataMapper.insertSelective(sz);
					}
					//添加信息到日志表
					CheckLog clog = new CheckLog(sz.getCourierNumber(), "zm_return_data",stuNum, CheckLog.TYPE_IMPORT);
					checkLogSer.saveOfAsyn(clog, sz, null);
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
	

	//---------------------------------------------
	public EasyUIPage queryFenyeOfTp(EasyUIAccept accept,HttpServletRequest req) {
		
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=zmReturnDataMapper.queryFenyeOfTp(accept);
			int rows=zmReturnDataMapper.getCountOfTp(accept);
			for (int i = 0; i < list.size(); i++) {
				ZmReturnData tp=(ZmReturnData) list.get(i);
				if(tp.getUpdateMan()!=null&&!tp.getUpdateMan().equals("")){
					StaffUser us = userMapper.selectByPrimaryKey(tp.getUpdateMan());
					tp.setUpdateMan(us.getStuName());
				}
				reckon(tp);
			}
			//不可更改项
			checkNoUpdate(list, 2);
			EasyUIPage easyUIPage=new EasyUIPage(rows, list);
//			//添加信息到日志表
//			StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
//			CheckLog clog = new CheckLog(null, "zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_QUERY);
//			checkLogSer.saveOfAsyn(clog, accept, easyUIPage);
			return easyUIPage;
		}
		return null;
	}

	public String importDataOfTp(List<String[]> list , HttpServletRequest req) {
		StaffUser u = (StaffUser) req.getSession().getAttribute("user");
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			Customer ct =null;
			if(!list.get(i)[1].trim().equals("")){
				CustomerKey ctkey = new CustomerKey();
				ctkey.setCteBarCode(list.get(i)[1].trim());
				ctkey.setHistoryCount(new BigDecimal(0));
				ct = custormerMapper.selectByPrimaryKey(ctkey);
			}
			if(list.get(i)[0].equals("")){
				ls.add((i+1)+",");
			}else if(!list.get(i)[3].trim().equals("配送成功")&&!list.get(i)[3].trim().equals("配送失败")&&
					!list.get(i)[3].trim().equals("揽件")&&!list.get(i)[3].trim().equals("配送异常")&&
					!list.get(i)[3].trim().equals("配送中")&&!list.get(i)[3].trim().equals("退回件")){
				ls.add((i+1)+",");
			}else if(ct==null&&!list.get(i)[1].equals("")){
				ls.add((i+1)+",");
			}else{
				try {
					String stpk = Trans.tostring(list.get(i)[0]);
					ZmReturnData isstp = zmReturnDataMapper.selectByPrimaryKey(stpk);
					ZmReturnData stp = new ZmReturnData();
					String	AbnormalCause = null;
					stp.setCourierNumber(Trans.tostring(list.get(i)[0]));
					if(!list.get(i)[2].trim().equals("")){
						AbnormalCause = list.get(i)[2].trim();
					}
					String ctmBarCode =null;
					if(ct!=null){
						ctmBarCode =ct.getCteBarCode();
					}
					stp.setCtmBarCode(ctmBarCode);
					stp.setAbnormalCause(AbnormalCause);
					stp.setDeliveryState(list.get(i)[3]);
					stp.setSignatory(list.get(i)[4]);
					stp.setSignTime(Trans.toTimestamp(list.get(i)[5]));
					stp.setGoods(list.get(i)[6]);
					stp.setGoodsCost(Trans.toBigDecimal(list.get(i)[7]));
					stp.setUpdateMan(u.getStuNum());
					if(isstp!=null){
						checkUpdateDeliveryState(stp, u.getStuNum());
//						System.out.println(stp.getUpdateMan());
						zmReturnDataMapper.updateByPrimaryKeySelective(stp);
						//添加信息到日志表
						CheckLog clog = new CheckLog(stp.getCourierNumber(), "zm_return_data",u==null?null:u.getStuNum(), CheckLog.TYPE_IMPORT);
						checkLogSer.saveOfAsyn(clog, stp, null);
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


	public String ExportDataOfTp(EasyUIAccept accept, HttpServletRequest req) {
		String line[] = accept.getStr7().split(",");
		List<ZmReturnData> list=zmReturnDataMapper.queryFenyeOfTp(accept);
		for (int i = 0; i < list.size(); i++) {
			ZmReturnData tp=(ZmReturnData) list.get(i);
			if(reckon(tp)){
				zmReturnDataMapper.updateByPrimaryKeySelective(tp);
			}
		}
		String[] obj ={"创建日期","所属大区","所属区部","所属分部","所属分拨点","客户条码","客户名称","快递单号","发货日期","是否超时","异常原因","省份","地址","配送状态","签收人","签收时间","签收站点","收件人","订单编号","客户店铺","联系方式","重量","快递公司","物品","物品价值","费用","修改人"};
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
		String path ="file/哲盟返回第三方数据.xls";
		ExcelExport.OutExcel1(line, lines, basePath+path);
//		//添加信息到日志表
//		StaffUser user=req==null?null:(StaffUser)req.getSession().getAttribute("user");
//		CheckLog clog = new CheckLog(null,"zm_return_data",user==null?null:user.getStuNum(), CheckLog.TYPE_EXPORT);
//		checkLogSer.saveOfAsyn(clog, accept, list);
		return path;
	}

	public String stateUpdate(ZmReturnData obj){
		if(obj!=null){
			if(obj.getDeliveryState()!=null){
				NoUpdateKey nuk = new NoUpdateKey();
				nuk.setCourierNumber(obj.getCourierNumber());
				nuk.setNoUpdateName("delivery_state");
				NoUpdate nu = noUpdateMapper.selectByPrimaryKey(nuk);
				if(nu!=null){
					return nu.getNoUpdateValue();
				}else{
					return obj.getDeliveryState();
				}
			}
		}
		return null;
	}

}
