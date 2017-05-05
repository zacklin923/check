package com.zs.controller.rest;

import java.math.BigDecimal;
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
import com.zs.entity.SourceThirdPartyKey;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.entity.TimeLimit;
import com.zs.entity.other.ResultFromSendToZM;
import com.zs.service.ProvinceCodeSer;
import com.zs.service.SourceImportSer;
import com.zs.service.SourceTpSer;
import com.zs.service.SourceZmSer;
import com.zs.service.TimeLimitSer;
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
					zm.setReturnDate(Trans.timeToDate(new Date()));
					//--------装填状态信息：是否已发货-----------------
					if (zm.getSendTime()==null) {
						zm.setCourierState("0");
					}else {
						zm.setCourierState("1");
					}
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
							//-------装填省份信息-----------------
							if (zm.getProvince()==null || (zm.getProvince()!=null && zm.getProvince().trim().equals(""))) {//哲盟没有返回省份
								if (im.getProvince()!=null && !im.getProvince().trim().equals("")) {//导入表有省份
									zm.setProvince(im.getProvince());
								}else if(im.getOneCode()!=null && !im.getOneCode().equals("")){//导入表有一段码
									ProvinceCode provinceCode=provinceCodeSer.get(im.getOneCode());
									if(provinceCode!=null) zm.setProvince(provinceCode.getProvince());
								}else {//导入表既没有一段码也没有省份
									log.error("该条记录无法计算出省份。"+zm);
								}
							}
							//-----------计算超时时间----------------
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
							if(zm.getProvince()!=null && zm.getProvince().trim().equals(""))zm.setProvince(null);
							//-----------计算超时时间----------------
							TimeLimit tl=timeLimitSer.selectByEndProvince(zm.getProvince());
							if(tl!=null && zm.getSendTime()!=null){
								Calendar calendar=Calendar.getInstance();
								calendar.setTime(zm.getSendTime());
								calendar.add(Calendar.SECOND, (int)(tl.getHourCost().doubleValue()*(60*60)));
								zm.setTimeOut(calendar.getTime());
							}
							sourceZmSer.update(zm);
							rows++;
						} catch (Exception e2) {
							log.error("错误：该条数据既无法插入也无法修改："+zm);
							failList.add(zm.getCourierNumber());
						}
					}
				}
			} catch (Exception e) {
				log.error("接收哲盟返回数据出错，原因不明。");
				isError=true;
			}
		}
		Date date2=new Date();
		log.info("本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,共耗时["+(date2.getTime()-date1.getTime())+"]ms");
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
		boolean isError=false;//是否错误
		ArrayList<String> failList=new ArrayList<String>();//接收失败单号的容器
		if (data!=null && key!=null && key.equals("sz_zm_2017-4-26")) {
			try {
				List<SourceThirdParty> list=gson.fromJson(data, new TypeToken<List<SourceThirdParty>>(){}.getType());
				tols=list.size();
				for (int i = 0; i < list.size(); i++) {
					SourceThirdParty tp=list.get(i);
					tp.setReturnDate(Trans.timeToDate(new Date()));
					try {
						//--------装填其他信息-----------
						SourceZm zm=sourceZmSer.get(new SourceZmKey(tp.getCourierNumber(),tp.getReturnDate()));
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
							if (zm.getTimeOut()!=null) {
								if (zm.getTimeOut().after(new Date())) {//发货日期+规定消耗的时间  > 现在  ，就代表超期
									tp.setIsTimeOut(new BigDecimal(1));
								}else {
									tp.setIsTimeOut(new BigDecimal(0));
								}
							}
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
							SourceZm zm=sourceZmSer.get(new SourceZmKey(tp.getCourierNumber(), tp.getReturnDate()));
							if (zm!=null && zm.getTimeOut()!=null) {
								if (zm.getTimeOut().after(new Date())) {//发货日期+规定消耗的时间  > 现在  ，就代表超期
									tp.setIsTimeOut(new BigDecimal(1));
								}else {
									tp.setIsTimeOut(new BigDecimal(0));
								}
							}
							sourceTpSer.update(tp);
							rows++;
						} catch (Exception e2) {
							log.error("错误：该条数据既无法插入也无法修改："+tp);
							failList.add(tp.getCourierNumber());
						}
					}
				}
			} catch (Exception e) {
				log.error("接收哲盟返回数据出错，原因不明。");
				isError=true;
			}
		}
		Date date2=new Date();
		log.info("本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,共耗时["+(date2.getTime()-date1.getTime())+"]ms");
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
	
	
	private void tell(List<SourceZm> zms){
		for (int i = 0; i < zms.size(); i++) {
			System.out.println(zms.get(i));
		}
	}
}
