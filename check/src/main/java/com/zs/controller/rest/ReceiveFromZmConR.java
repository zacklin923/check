package com.zs.controller.rest;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmKey;
import com.zs.service.SourceImportSer;
import com.zs.service.SourceTpSer;
import com.zs.service.SourceZmSer;
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
	private Logger log=Logger.getLogger(getClass());
	private Gson gson=new Gson();
	
	
	/**接收哲盟返回数据
	 * 1、尝试插入数据
	 * 2、如果无法插入，那么尝试修改数据
	 * 3、如果无法修改，那么记录到错误日志中*/
	@RequestMapping(value="/zm",method=RequestMethod.POST)
	public void receiveResultFromZm(String data,String key) {
		Date date1=new Date();
		int tols=-1;
		int rows=0;
		if (data!=null && key!=null && key.equals("sz_zm_2017-4-26")) {
			List<SourceZm> list=gson.fromJson(data, new TypeToken<List<SourceZm>>(){}.getType());
			tols=list.size();
			for (int i = 0; i < list.size(); i++) {
				SourceZm zm=list.get(i);
				zm.setReturnDate(Trans.timeToDate(new Date()));
				try {
					//--------装填其他信息-----------
					SourceImport im=sourceImportSer.get(zm.getCourierNumber());
					System.out.println(im);
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
						//--------装填状态信息：是否已发货-----------------
						if (zm.getSendTime()==null) {
							zm.setCourierState("0");
						}else {
							zm.setCourierState("1");
						}
					}
					sourceZmSer.add(zm);
					rows++;
				} catch (Exception e) {
					log.error("插入失败，开始尝试修改。失败数据："+zm);
					try {
						//--------装填其他信息-----------
						SourceImport im=sourceImportSer.get(zm.getCourierNumber());
						System.out.println(im);
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
							//--------装填状态信息：是否已发货-----------------
							if (zm.getSendTime()==null) {
								zm.setCourierState("0");
							}else {
								zm.setCourierState("1");
							}
						}
						sourceZmSer.update(zm);
						rows++;
					} catch (Exception e2) {
						log.error("错误：该条数据既无法插入也无法修改："+zm);
					}
				}
			}
		}
		Date date2=new Date();
		log.info("本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,共耗时["+(date2.getTime()-date1.getTime())+"]ms");
	}
	
	/**接收第三方返回数据*/
	@RequestMapping(value="/tp",method=RequestMethod.POST)
	public void receiveResultFromTP(String data,String key) {
		Date date1=new Date();
		int tols=-1;
		int rows=0;
		if (data!=null && key!=null && key.equals("sz_zm_2017-4-26")) {
			List<SourceThirdParty> list=gson.fromJson(data, new TypeToken<List<SourceThirdParty>>(){}.getType());
			tols=list.size();
			for (int i = 0; i < list.size(); i++) {
				SourceThirdParty tp=list.get(i);
				tp.setReturnDate(Trans.timeToDate(new Date()));
				try {
					//--------装填其他信息-----------
					SourceZm zm=sourceZmSer.get(new SourceZmKey(tp.getCourierNumber(), Trans.timeToDate(new Date())));
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
					}
					//----------开始计算是否超时---计算完之后，补上以下数据：[是否超时]----------
					//.....这里写计算代码......
					sourceTpSer.add(tp);
					rows++;
				} catch (Exception e) {
					log.error("插入失败，开始尝试修改。失败数据："+tp);
					try {
						//--------装填其他信息-----------
						SourceZm zm=sourceZmSer.get(new SourceZmKey(tp.getCourierNumber(), Trans.timeToDate(new Date())));
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
						}
						sourceTpSer.update(tp);
						rows++;
					} catch (Exception e2) {
						log.error("错误：该条数据既无法插入也无法修改："+tp);
					}
				}
			}
		}
		Date date2=new Date();
		log.info("本次共接收["+tols+"]条数据，成功保存["+rows+"]条数据,共耗时["+(date2.getTime()-date1.getTime())+"]ms");
	}
	
	
	private void tell(List<SourceZm> zms){
		for (int i = 0; i < zms.size(); i++) {
			System.out.println(zms.get(i));
		}
	}
}
