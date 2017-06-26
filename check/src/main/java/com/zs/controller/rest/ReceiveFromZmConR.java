package com.zs.controller.rest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zs.entity.ProvinceCode;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.ResultFromSendToZM;
import com.zs.service.ProvinceCodeSer;
import com.zs.service.SourceImportSer;
import com.zs.service.SourceTpSer;
import com.zs.service.SourceZmSer;
import com.zs.service.TimeLimitSer;
import com.zs.tools.ProvinceHelper;
import com.zs.tools.Trans;

/**
 * 接收哲盟返回数据
 * @author 张顺
 * 2017-4-28
 */
@RestController
@RequestMapping("/api/receive")
public class ReceiveFromZmConR {

	@Resource
	private SourceZmSer sourceZmSer;
	@Resource
	private SourceTpSer sourceTpSer;
	@Resource
	private SourceImportSer sourceImportSer;
	@Resource
	private ProvinceCodeSer provinceCodeSer;
	@Resource
	private TimeLimitSer timeLimitSer;
	private Logger log=Logger.getLogger(getClass());
	private Gson gson=new Gson();
	
	
	/**接收哲盟返回数据
	 * 1、尝试插入数据
	 * 2、如果无法插入，那么尝试修改数据
	 * 3、如果无法修改，那么记录到错误日志中*/
	@RequestMapping(value="/zm",method=RequestMethod.POST)
	public ResultFromSendToZM receiveResultFromZm(String data,String key) {
		Date date1=new Date();
		int tols=-1;//统计接收到的最大数据
		int rows=0;//统计执行的条数
		boolean isError=false;//是否错误
		ArrayList<String> failList=new ArrayList<String>();//接收失败单号的容器
		if (data!=null && key!=null && key.equals("sz_zm_2017-4-26")) {
			try {
				List<SourceZm> list=gson.fromJson(data, new TypeToken<List<SourceZm>>(){}.getType());
				tols=list.size();
				for (int i = 0; i < list.size(); i++) {
					SourceZm zm=list.get(i);
					if(!zm.getCourierNumber().trim().substring(0,2).equals("88")){
						zm.setReturnDate(Trans.timeToDate(new Date()));
						//--------装填状态信息：是否已发货-----------------
						if (zm.getSendTime()==null) {
							zm.setCourierState("0");
						}else {
							zm.setCourierState("1");
						}
						if(zm.getProvince()!=null && zm.getProvince().trim().equals(""))zm.setProvince(null);
						try {
							//--------装填其他信息-----------
							SourceImport im=sourceImportSer.get(zm.getCourierNumber());
							if (im!=null) {
								zm.setCtmName(im.getCtmName());
								zm.setCtmBarCode(im.getCtmBarCode());
								zm.setCreateDate(im.getCreateDate());
								zm.setAddress(im.getAddress());
								zm.setAddressee(im.getAddressee());
								zm.setPhone(im.getPhone());
								zm.setGoods(im.getGoods());
								zm.setGoodsCost(im.getGoodsCost());
								zm.setCourierCompany(im.getCourierCompany());
								zm.setOrderNumber(im.getOrderNumber());
								zm.setShopNumber(im.getShopNumber());
								//-------装填省份信息-----------------
								if(im.getProvince()==null||im.getProvince().equals("")){
									try{
										if(zm.getProvince()!=null){
											zm.setProvince(ProvinceHelper.getProvince(zm.getProvince()));
										}
									}catch(Exception e){
										e.printStackTrace();
										//导入表既没有一段码也没有省份
										log.error("【哲盟返回接口】该条记录无法计算出省份。"+zm);
									}
								}else{
									zm.setProvince(im.getProvince());
								}
							}else{
								try{
									if(zm.getProvince()!=null){
										zm.setProvince(ProvinceHelper.getProvince(zm.getProvince()));
									}
								}catch(Exception e){
									e.printStackTrace();
									log.error("【哲盟返回接口】该条记录无法计算出省份。"+zm);
								}
							}
							//-----------计算超时时间----------------
							if(zm.getProvince()!=null){
								TimeLimit tl=timeLimitSer.selectByEndProvince(zm.getProvince());
								if(tl!=null && zm.getSendTime()!=null){
									Calendar calendar=Calendar.getInstance();
									calendar.setTime(zm.getSendTime());
									calendar.add(Calendar.SECOND, (int)(tl.getHourCost().doubleValue()*(60*60)));
									zm.setTimeOut(calendar.getTime());
								}
							}
							sourceZmSer.add(zm);
							rows++;
						} catch (Exception e) {
	//						log.warn("插入失败，开始尝试修改。失败数据："+zm);
							try {
								//------去掉不应该修改的字段--------
								zm.setCtmName(null);
								zm.setCtmBarCode(null);
								zm.setCreateDate(null);
								zm.setAddress(null);
								zm.setAddressee(null);
								zm.setPhone(null);
								zm.setGoods(null);
								zm.setGoodsCost(null);
								zm.setCourierCompany(null);
								zm.setOrderNumber(null);
								zm.setShopNumber(null);
								//-----------计算超时时间----------------
								if(zm.getProvince()!=null){
									TimeLimit tl=timeLimitSer.selectByEndProvince(zm.getProvince());
									if(tl!=null && zm.getSendTime()!=null){
										Calendar calendar=Calendar.getInstance();
										calendar.setTime(zm.getSendTime());
										calendar.add(Calendar.SECOND, (int)(tl.getHourCost().doubleValue()*(60*60)));
										zm.setTimeOut(calendar.getTime());
									}
								}
								sourceZmSer.update(zm);
								rows++;
							} catch (Exception e2) {
								e2.printStackTrace();
								log.error("【哲盟返回接口】错误：该条数据既无法插入也无法修改："+zm);
								failList.add(zm.getCourierNumber());
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("【哲盟返回接口】接收哲盟返回数据出错，原因不明。"+data);
				isError=true;
			}
		}
		Date date2=new Date();
		log.info("【哲盟返回接口】本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,共耗时["+(date2.getTime()-date1.getTime())+"]ms");
		if (failList.size()>0) {
			return new ResultFromSendToZM(StringUtils.join(failList.toArray(new String[failList.size()]), ","),"fail");
		}else{
			if(isError==false){
				return new ResultFromSendToZM("","success");
			}else{
				return new ResultFromSendToZM("","error");
			}
		}
	}
	

	/**接收第三方返回数据*/
	@RequestMapping(value="/tp",method=RequestMethod.POST)
	public ResultFromSendToZM receiveResultFromTP(String data,String key) {
		Date date1=new Date();
		int tols=-1;//统计接收到的最大数据
		int rows=0;//统计执行的条数
		int emptys=0;//除了单号其他为空的数据
		boolean isError=false;//是否错误
		ArrayList<String> failList=new ArrayList<String>();//接收失败单号的容器
		if (data!=null && key!=null && key.equals("sz_zm_2017-4-26")) {
			try {
				List<SourceThirdParty> list=gson.fromJson(data, new TypeToken<List<SourceThirdParty>>(){}.getType());
				tols=list.size();
				for (int i = 0; i < list.size(); i++) {
					SourceThirdParty tp=list.get(i);
					if(!tp.getCourierNumber().trim().substring(0, 2).equals("88")){
						tp.setReturnDate(Trans.timeToDate(new Date()));
						//------------签收时间的处理------------
						if (tp.getSignTime()!=null 
								&& (tp.getSignTime().getTime()==new Long("-2209017600000") || tp.getSignTime().getTime()==new Long("-62135798400000")) ) {
							tp.setSignTime(null);
						}
						//------除了单号+时间其余全部为空的数据处理-----------
						tp.trim();
						if (tp.isEmptyFromZm()) {
							emptys++;
							continue;
						}
						try {
							//--------装填其他信息-----------
							SourceZm zm=sourceZmSer.last(tp.getCourierNumber());
							if (zm!=null) {
								tp.setLargeArea(zm.getLargeArea());
								tp.setSliceArea(zm.getSliceArea());
								tp.setFenbu(zm.getFenbu());
								tp.setFbdArea(zm.getFbdArea());
								tp.setSendTime(zm.getSendTime());
								tp.setCtmName(zm.getCtmName());
								tp.setCtmBarCode(zm.getCtmBarCode());
								tp.setProvince(zm.getProvince());
								tp.setCreateDate(zm.getCreateDate());
								tp.setAddress(zm.getAddress());
								tp.setAddressee(zm.getAddressee());
								tp.setOrderNumber(zm.getOrderNumber());
								tp.setShopNumber(zm.getShopNumber());
								tp.setPhone(zm.getPhone());
								tp.setWeight(zm.getWeight());
								tp.setCourierCompany(zm.getCourierCompany());
								tp.setGoods(zm.getGoods());
								tp.setGoodsCost(zm.getGoodsCost());
								//----------开始计算是否超时---计算完之后，补上以下数据：[是否超时]----------
								sourceTpSer.reckon(tp);
							}
							sourceTpSer.add(tp);
							rows++;
						} catch (Exception e) {
	//					log.info("插入失败，开始尝试修改。失败数据："+tp);
							try {
								//--------装填其他信息-----------
								tp.setLargeArea(null);
								tp.setSliceArea(null);
								tp.setFenbu(null);
								tp.setFbdArea(null);
								tp.setSendTime(null);
								tp.setCtmName(null);
								tp.setCtmBarCode(null);
								tp.setProvince(null);
								tp.setCreateDate(null);
								tp.setAddress(null);
								tp.setAddressee(null);
								tp.setOrderNumber(null);
								tp.setShopNumber(null);
								tp.setPhone(null);
								tp.setWeight(null);
								tp.setCourierCompany(null);
								tp.setGoods(null);
								tp.setGoodsCost(null);
								//----------开始计算是否超时---计算完之后，补上以下数据：[是否超时]----------
								sourceTpSer.reckon(tp);
								sourceTpSer.update(tp);
								rows++;
							} catch (Exception e2) {
								e2.printStackTrace();
								log.error("【哲盟返回第三方接口】错误：该条数据既无法插入也无法修改："+tp);
								failList.add(tp.getCourierNumber());
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				log.error("【哲盟返回第三方接口】接收哲盟返回数据出错，原因不明。"+data);
				isError=true;
			}
		}
		Date date2=new Date();
		log.info("【哲盟返回第三方接口】本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,除了单号其余为空数据有["+emptys+"]条(不存),共耗时["+(date2.getTime()-date1.getTime())+"]ms");
		if (failList.size()>0) {
			return new ResultFromSendToZM(StringUtils.join(failList.toArray(new String[failList.size()]), ","),"fail");
		}else{
			if(isError==false){
				return new ResultFromSendToZM("","success");
			}else{
				return new ResultFromSendToZM("","error");
			}
		}
	}
	
	
}
