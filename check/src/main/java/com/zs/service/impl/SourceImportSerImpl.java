package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.zs.dao.CustomerMapper;
import com.zs.dao.ItCommonUserMapper;
import com.zs.dao.SourceImportFailedMapper;
import com.zs.dao.SourceImportMapper;
import com.zs.dao.SourceZmMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.ItCommonUser;
import com.zs.entity.ItCommonUserExample;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmExample;
import com.zs.entity.SourceZmExample.Criteria;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.ResultFromSendToZM;
import com.zs.entity.other.SourceImportErr;
import com.zs.service.SourceImportSer;
import com.zs.tools.HttpHelper;
import com.zs.tools.ManagerId;
import com.zs.tools.Trans;

@Service("sourceImportSer")
public class SourceImportSerImpl implements SourceImportSer{

	@Resource
	private SourceImportMapper importMapper;
	@Resource
	private SourceImportFailedMapper importFailMapper;
	@Resource
	private SourceZmMapper zmMapper;
	@Resource
	private CustomerMapper customerMapper;
	@Resource
	private ItCommonUserMapper itCommonUserMapper;
	
	private Gson gson=new Gson();
	private final String URL_ZM="http://116.204.8.6:8020/InBarCode.aspx";
	private Logger log=Logger.getLogger(getClass());
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			int rows=importMapper.getCount(accept);
			List list=importMapper.queryFenye(accept);
			for (int i = 0; i < list.size(); i++) {
				SourceImport si = (SourceImport) list.get(i);
				if(si.getStuNum()!=null && !si.getStuNum().equals("")){
					ItCommonUserExample icexample= new ItCommonUserExample();
					icexample.createCriteria().andUsernumberEqualTo(si.getStuNum());
					List<ItCommonUser> suer = itCommonUserMapper.selectByExample(icexample);
					si.setStuName(suer.get(0).getName()==null?"":suer.get(0).getName());
				}else{
					si.setStuName("");
				}
			}
			return new EasyUIPage(rows, list);
		}
		return null;
	}

	public Integer add(SourceImport obj) {
		return importMapper.insertSelective(obj);
	}

	public Integer update(SourceImport obj) {
		return importMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		return importMapper.deleteBatch(id);
	}

	public SourceImport get(String id) {
		return importMapper.selectByPrimaryKey(id);
	}

	public String importData(List<String[]> list,String stuNum) {
		int inull1=0;
		int inull2=0;
		int inull3=0;
		int inull4=0;
		int inull5=0;
		int succs=0;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0].equals("") 
					|| list.get(i)[1].equals("")
					|| list.get(i)[2].equals("")
					|| list.get(i)[3].equals("")
					|| list.get(i)[4].equals("")){
				SourceImportErr sie = new SourceImportErr(list.get(i)[3].trim().replace(",", ""),
						list.get(i)[2].trim().replace(",", ""),
						list.get(i)[1],list.get(i)[8],list.get(i)[0],
						list.get(i)[4],list.get(i)[6],list.get(i)[7],
						list.get(i)[9],list.get(i)[11],list.get(i)[10],
						list.get(i)[5],"大客户",
						new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
						null,stuNum,list.get(i)[12],null);
				SourceImportFailed sif = new SourceImportFailed();
				sif.setStuNum(stuNum);
				sif.setFailInfo(gson.toJson(sie));
				sif.setFailType("数据必填项为空");
				importFailMapper.insertSelective(sif);
				inull1=1;
			}else{
				if(Trans.tostring(list.get(i)[3]).matches("[0-9]*")&&(Trans.tostring(list.get(i)[3]).length()==13 ||!list.get(i)[9].equals("11"))){
					SourceImport skey =importMapper.selectByPrimaryKey(Trans.tostring(list.get(i)[3]));
					if(skey==null){
						//张顺，2017-5-26,新增两种错误类型：1、条码不全是数字。2、条码不是6位数。
						String ctmbarcode=Trans.tostring(list.get(i)[2]);//客户条码
						CustomerKey ck = new CustomerKey();
						ck.setCteBarCode(ctmbarcode);
						ck.setHistoryCount(new BigDecimal(0));
						Customer isct =  customerMapper.selectByPrimaryKey(ck);
						if(isct==null){
							SourceImportErr sie = new SourceImportErr(list.get(i)[3].trim().replace(",", ""),
									list.get(i)[2].trim().replace(",", ""),
									list.get(i)[1],list.get(i)[8],list.get(i)[0],
									list.get(i)[4],list.get(i)[6],list.get(i)[7],
									list.get(i)[9],list.get(i)[11],list.get(i)[10],
									list.get(i)[5],"大客户",
									new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),
									null,stuNum,list.get(i)[12],null);
							SourceImportFailed sif = new SourceImportFailed();
							sif.setStuNum(stuNum);
							sif.setFailInfo(gson.toJson(sie));
							sif.setFailType("客户条码不存在");
							importFailMapper.insertSelective(sif);
							inull5=5;
							
						}else{
							try {
								String oneCode=list.get(i)[12].length()>=3?list.get(i)[12].substring(0,3):null;
								SourceImport s = new SourceImport(list.get(i)[3].trim().replace(",", ""),
										ctmbarcode,
										isct.getCteName(),
										list.get(i)[8].trim().replace(",", ""),
										Trans.TransToDate(list.get(i)[0]),
										list.get(i)[4],
										list.get(i)[6],
										list.get(i)[7],
										list.get(i)[9],
										list.get(i)[11],
										Trans.toBigDecimal(list.get(i)[10]),
										list.get(i)[5].trim().replace(",", ""),
										"大客户",
										new Timestamp(new Date().getTime()),
										new BigDecimal("0"),
										stuNum,
										oneCode,
										null);
								importMapper.insertSelective(s);
								succs++;
							} catch (Exception e) {
								e.printStackTrace();
								SourceImportErr sie = new SourceImportErr(list.get(i)[3].trim().replace(",", ""),list.get(i)[2].trim().replace(",", ""),list.get(i)[1],list.get(i)[8].replace(",", ""),list.get(i)[0],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],list.get(i)[10],list.get(i)[5],"大客户",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),null,stuNum,list.get(i)[12],null);
								SourceImportFailed sif = new SourceImportFailed();
								sif.setStuNum(stuNum);
								sif.setFailInfo(gson.toJson(sie));
								sif.setFailType("数据类型转换错误");
								importFailMapper.insertSelective(sif);
								inull3=3;
							}
						}
					}else{
						SourceImportErr sier = new SourceImportErr(list.get(i)[3].trim().replace(",", ""),list.get(i)[2].trim().replace(",", ""),list.get(i)[1],list.get(i)[8],list.get(i)[0],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],list.get(i)[10],list.get(i)[5],"大客户",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),null,stuNum,list.get(i)[12],null);
						SourceImportFailed sifk = new SourceImportFailed();
						sifk.setStuNum(stuNum);
						sifk.setFailInfo(gson.toJson(sier));
						sifk.setFailType("重复快递单号");
						importFailMapper.insertSelective(sifk);
						inull2=2;
					}
				}else{
					SourceImportErr sier = new SourceImportErr(list.get(i)[3].trim().replace(",", ""),list.get(i)[2].trim().replace(",", ""),list.get(i)[1],list.get(i)[8],list.get(i)[0],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],list.get(i)[10],list.get(i)[5],"大客户",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()),null,stuNum,list.get(i)[12],null);
					SourceImportFailed sifk = new SourceImportFailed();
					sifk.setStuNum(stuNum);
					sifk.setFailInfo(gson.toJson(sier));
					sifk.setFailType("快递单号不符合规范");
					importFailMapper.insertSelective(sifk);
					inull4=4;
				}
			}
		}
		String str="";
		int count = inull1+inull2+inull3+inull4;
		if(inull1==1){
			str=str+"必填项有为空的数据，请到导入数据错误表中查看";
		}else if(inull2==2){
			str=str+"有重复快递单号，请到导入数据错误表中查看";
		}else if(inull3==3){
			str="数据类型转换错误，请到导入数据错误表中查看";
		}else if(inull4==4){
			str="快递单号不符合规范，请到导入数据错误表中查看";
		}else if(inull5==5){
			str="客户条码不存在，请到导入数据错误表中查看";
//		}else if(inull6==6){
//			str="客户条码不是6位数，请到导入数据错误表中查看";
		}else if(count>0){
			str="导入数据有多种错误，请到导入错误数据表中查看详情";
		}
		int rows=list.size()-1;
		str=str+"\n共["+rows+"]条，成功["+succs+"]条，失败["+(rows-succs)+"]条。";
		return str;
	}

	/**张顺，2017-4-28 
	 * 推送数据到哲盟,当用户导入时就执行
	 */
	public synchronized String sendToZm(String userNum) {
		Date d1=new Date();
		int succrows=0;
		//----------------
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, -24);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		List<SourceImport> list=importMapper.queryToZM(calendar.getTime(), userNum);
		int count = list.size()/100;
		List<SourceImport> listtmp = new ArrayList<SourceImport>();
		for (int k = 0; k <= count; k++) {
			if(k!=count){
				listtmp = list.subList(k*100, (k+1)*100);
			}else{
				listtmp = list.subList(k*100, list.size());
			}
			String json=gson.toJson(listtmp);
			
			List<NameValuePair> formparams=new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("data", json));
			String result=HttpHelper.postForm(URL_ZM, formparams);
			log.error("【用户导入】第一次推送的结果:"+result);
			//-------给推送成功的，打上标记：是否推送成功,未推送成功的再推送一次---------------------
			List<SourceImport> list2=new ArrayList<SourceImport>();
			if (result!=null) {
				ResultFromSendToZM resultFromSendToZM=gson.fromJson(result, ResultFromSendToZM.class);
				if(resultFromSendToZM.getResult().equals("fail")){
					for (int i = 0; i < listtmp.size(); i++) {
						if ((","+resultFromSendToZM.getFailRows()+",").contains(","+listtmp.get(i).getCourierNumber()+",")) {//失败的
							list2.add(listtmp.get(i));
						}else {
							SourceImport im2=new SourceImport();
							im2.setCourierNumber(listtmp.get(i).getCourierNumber());
							im2.setIsPushed(new BigDecimal(1));
							importMapper.updateByPrimaryKeySelective(im2);
							succrows++;
						}
					}
				}else if(resultFromSendToZM.getResult().equals("success")){
					for (int i = 0; i < listtmp.size(); i++) {
						SourceImport im2=new SourceImport();
						im2.setCourierNumber(listtmp.get(i).getCourierNumber());
						im2.setIsPushed(new BigDecimal(1));
						importMapper.updateByPrimaryKeySelective(im2);
						succrows++;
					}
				}
			}
			if(list2.size()>0){
				//-----再推送一次，还失败就不推送了------
				String json2=gson.toJson(list2);
				List<NameValuePair> formparams2=new ArrayList<NameValuePair>();
				formparams2.add(new BasicNameValuePair("data", json2));
				String result2=HttpHelper.postForm(URL_ZM, formparams2);
				log.error("【用户导入】第二次推送的结果:"+result2);
				if (result2!=null) {
					ResultFromSendToZM resultFromSendToZM=gson.fromJson(result2, ResultFromSendToZM.class);
					if(resultFromSendToZM.getResult().equals("fail")){
						for (int i = 0; i < list2.size(); i++) {
							if ((","+resultFromSendToZM.getFailRows()+",").contains(","+list2.get(i).getCourierNumber()+",")) {//失败的
//								SourceImport im2=new SourceImport();
//								im2.setCourierNumber(list2.get(i).getCourierNumber());
//								im2.setIsPushed(new BigDecimal(0));
//								importMapper.updateByPrimaryKeySelective(im2);
							}else {
								SourceImport im2=new SourceImport();
								im2.setCourierNumber(list2.get(i).getCourierNumber());
								im2.setIsPushed(new BigDecimal(1));
								importMapper.updateByPrimaryKeySelective(im2);
								succrows++;
							}
						}
					}else if(resultFromSendToZM.getResult().equals("success")){
						for (int i = 0; i < list2.size(); i++) {
							SourceImport im2=new SourceImport();
							im2.setCourierNumber(list2.get(i).getCourierNumber());
							im2.setIsPushed(new BigDecimal(1));
							importMapper.updateByPrimaryKeySelective(im2);
							succrows++;
						}
					}
				}
			}
		}
		Date d2=new Date();
		log.info("【用户导入】共上传了["+list.size()+"]条数据，成功了["+succrows+"]条，耗时["+(d2.getTime()-d1.getTime())+"]ms。");
		return "【用户导入】共上传了["+list.size()+"]条数据，成功了["+succrows+"]条，耗时["+(d2.getTime()-d1.getTime())+"]ms。";
	}


	/**
	 * 推送未发货的，该方法定时执行，每天执行一次
	 */
	public void sendToZm2(){
		Date d1=new Date();
		int succrows=0;
		//-----找出未发货的数据，然后也推送过去--------------------------------
		List<SourceImport> list=new ArrayList<SourceImport>();
		//--------得到今天的15天前的日期-------------------
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(ManagerId.getNow());
		calendar.add(Calendar.DATE, -30);
		List<SourceZm> zms=zmMapper.querySendToZm2(calendar.getTime());
		for (int i = 0; i < zms.size(); i++) {
			SourceImport im=new SourceImport();
			im.setCourierNumber(zms.get(i).getCourierNumber());
			im.setCtmBarCode(zms.get(i).getCtmBarCode());
			list.add(im);
		}
		
		int count = list.size()/100;
		List<SourceImport> listtmp = new ArrayList<SourceImport>();
		for (int k = 0; k <= count; k++) {
			if(k!=count){
				listtmp = list.subList(k*100, (k+1)*100);
			}else{
				listtmp = list.subList(k*100, list.size());
			}
			String json=gson.toJson(listtmp);
			List<NameValuePair> formparams=new ArrayList<NameValuePair>();
			formparams.add(new BasicNameValuePair("data", json));
			String result=HttpHelper.postForm(URL_ZM, formparams);
			log.error("【系统每天自动推送未发货】第一次推送的结果:"+result);
			//-------未推送成功的再推送一次---------------------
			List<SourceImport> list2=new ArrayList<SourceImport>();
			if (result!=null) {
				try {
					ResultFromSendToZM resultFromSendToZM=gson.fromJson(result, ResultFromSendToZM.class);
					if(resultFromSendToZM.getResult().equals("fail")){
						for (int i = 0; i < listtmp.size(); i++) {
							if ((","+resultFromSendToZM.getFailRows()+",").contains(","+listtmp.get(i).getCourierNumber()+",")) {//失败的
								list2.add(listtmp.get(i));
							}else{
								succrows++;
							}
						}
					}else if(resultFromSendToZM.getResult().equals("success")){
						succrows=succrows+listtmp.size();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if(list2.size()>0){
				String json2=gson.toJson(list2);
				List<NameValuePair> formparams2=new ArrayList<NameValuePair>();
				formparams2.add(new BasicNameValuePair("data", json2));
				String result2=HttpHelper.postForm(URL_ZM, formparams2);
				log.error("【系统每天自动推送未发货】第二次推送的结果,这次错误的将不会再处理:"+result2);
				ResultFromSendToZM resultFromSendToZM=gson.fromJson(result2, ResultFromSendToZM.class);
				succrows=succrows+(list2.size()-resultFromSendToZM.getFailRows().split(",").length);
			}
		}
		Date d2=new Date();
		log.error("【系统每天自动推送未发货】共推送["+zms.size()+"]条，成功["+succrows+"]条，耗时["+(d2.getTime()-d1.getTime())+"]ms。");
	}

	public int deleteAll(String stuNum) {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return importMapper.deleteAll(calendar.getTime(),stuNum);
	}
	
	//用JAVA自带的函数判断是否是纯数字
	private boolean isNumeric(String str){
		for (int i = 0; i < str.length(); i++){
		   if (!Character.isDigit(str.charAt(i))){
			   return false;
		   }
		}
		return true;
	}
	
	
//	public static void main(String[] args) {
//		System.out.println(new SourceImportSerImpl().isNumeric("1asd"));
//	}
}
