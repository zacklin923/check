package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
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
import com.zs.dao.SourceImportFailedMapper;
import com.zs.dao.SourceImportMapper;
import com.zs.dao.SourceZmMapper;
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceZm;
import com.zs.entity.SourceZmExample;
import com.zs.entity.SourceZmExample.Criteria;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.ResultFromSendToZM;
import com.zs.service.SourceImportSer;
import com.zs.tools.HttpHelper;
import com.zs.tools.Trans;

@Service("sourceImportSer")
public class SourceImportSerImpl implements SourceImportSer{

	@Resource
	private SourceImportMapper importMapper;
	@Resource
	private SourceImportFailedMapper importFailMapper;
	@Resource
	private SourceZmMapper zmMapper;
	private Gson gson=new Gson();
	private final String URL_ZM="";
	private Logger log=Logger.getLogger(getClass());
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=importMapper.queryFenye(accept);
			int rows=importMapper.getCount(accept);
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
		return importMapper.deleteByPrimaryKey(id);
	}

	public SourceImport get(String id) {
		return importMapper.selectByPrimaryKey(id);
	}

	public String importData(List<String[]> list,String stuNum) {
		/*于2017-4-29注释，张顺，因该表主键改为快递单号，故以下语句需要修改，但由于不确定使用导入模板，故暂且注释等待你回来再作修改。
		int inull=0;
		int knull=0;
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0].equals("")||list.get(i)[1].equals("")||list.get(i)[2].equals("")||list.get(i)[3].equals("")||list.get(i)[4].equals("")){
				SourceImport errs = new SourceImport(Trans.tostring(list.get(i)[2]),list.get(i)[1],list.get(i)[8],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],Trans.toBigDecimal(list.get(i)[10]),list.get(i)[5],"大客户",new Timestamp(new Date().getTime()),null,Trans.tostring(list.get(i)[3]),Trans.TransToDate(list.get(i)[0], "yyyy-MM-dd"));
				SourceImportFailed sif = new SourceImportFailed();
				sif.setStuNum(stuNum);
				sif.setFailInfo(gson.toJson(errs));
				sif.setFailType("数据必填项为空");
				importFailMapper.insert(sif);
				inull=1;
			}else{
				if(!list.get(i)[3].equals("")&&!list.get(i)[0].equals("")){
					SourceImport skey =importMapper.selectByPrimaryKey(Trans.tostring(list.get(i)[3]));
					if(skey==null){
						SourceImport s = new SourceImport(Trans.tostring(list.get(i)[2]),list.get(i)[1],list.get(i)[8],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],Trans.toBigDecimal(list.get(i)[10]),list.get(i)[5],"大客户",new Timestamp(new Date().getTime()),null,Trans.tostring(list.get(i)[3]),Trans.TransToDate(list.get(i)[0], "yyyy-MM-dd"));
						importMapper.insert(s);
					}else{
						SourceImport errsk = new SourceImport(Trans.tostring(list.get(i)[2]),list.get(i)[1],list.get(i)[8],list.get(i)[4],list.get(i)[6],list.get(i)[7],list.get(i)[9],list.get(i)[11],Trans.toBigDecimal(list.get(i)[10]),list.get(i)[5],"大客户",new Timestamp(new Date().getTime()),null,Trans.tostring(list.get(i)[3]),Trans.TransToDate(list.get(i)[0], "yyyy-MM-dd"));
						SourceImportFailed sifk = new SourceImportFailed();
						sifk.setStuNum(stuNum);
						sifk.setFailInfo(gson.toJson(errsk));
						sifk.setFailType("重复快递单号");
						importFailMapper.insert(sifk);
						knull=2;
					}
				}
			}
		}
		String str="";
		int count = inull+knull;
		if(count==1){
			str=str+"必填项有为空的数据，请到导入数据错误表中查看";
		}else if(count==2){
			str=str+"有重复快递单号，请到导入数据错误表中查看";
		}else if(count==3){
			str="数据有重复，且存在必填项为空数据，请到导入数据错误表中查看";
		}
		return str;
		*/
		return null;
	}

	/**张顺，2017-4-28 
	 * 推送数据到哲盟
	 */
	public void sendToZm() {
		Calendar calendar=Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		List<SourceImport> list=importMapper.queryToZM(calendar.getTime());
		//-----找出未发货的数据，然后也推送过去--------------------------------
		SourceZmExample example=new SourceZmExample();
		Criteria criteria=example.createCriteria();
		criteria.andCourierStateEqualTo("0");
		List<SourceZm> zms=zmMapper.selectByExample(example);
		for (int i = 0; i < zms.size(); i++) {
			SourceImport im=new SourceImport();
			im.setCourierNumber(zms.get(i).getCourierNumber());
			im.setCtmBarCode(zms.get(i).getCtmBarCode());
			list.add(im);
		}
		String json=gson.toJson(list);
		List<NameValuePair> formparams=new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("data", json));
		String result=HttpHelper.postForm(URL_ZM, formparams);
		log.error("推送失败的单号:"+result);
		//-------给推送成功的，打上标记：是否推送成功,未推送成功的再推送一次---------------------
		List<SourceImport> list2=new ArrayList<SourceImport>();
		if (result!=null) {
			ResultFromSendToZM resultFromSendToZM=gson.fromJson(result, ResultFromSendToZM.class);
			for (int i = 0; i < list.size(); i++) {
				if (resultFromSendToZM.getFailRows().contains(list.get(i).getCourierNumber())) {//失败的
					list2.add(list.get(i));
				}else {
					SourceImport im2=new SourceImport();
					im2.setCourierNumber(list.get(i).getCourierNumber());
					im2.setIsPushed(new BigDecimal(1));
					importMapper.updateByPrimaryKeySelective(im2);
				}
			}
		}else {
			log.error("错误：推送哲盟接收的返回值出现问题，该错误将导致无法知道哪些推送失败了，也不会处理未推送成功的。");
		}
		//-----再推送一次，还失败就不推送了------
		String json2=gson.toJson(list2);
		List<NameValuePair> formparams2=new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("data", json2));
		String result2=HttpHelper.postForm(URL_ZM, formparams2);
		if (result2!=null) {
			ResultFromSendToZM resultFromSendToZM=gson.fromJson(result2, ResultFromSendToZM.class);
			for (int i = 0; i < list2.size(); i++) {
				if (resultFromSendToZM.getFailRows().contains(list.get(i).getCourierNumber())) {//失败的
					SourceImport im2=new SourceImport();
					im2.setCourierNumber(list2.get(i).getCourierNumber());
					im2.setIsPushed(new BigDecimal(0));
					importMapper.updateByPrimaryKeySelective(im2);
				}else {
					SourceImport im2=new SourceImport();
					im2.setCourierNumber(list2.get(i).getCourierNumber());
					im2.setIsPushed(new BigDecimal(1));
					importMapper.updateByPrimaryKeySelective(im2);
				}
			}
		}else {
			log.error("错误：第二次推送哲盟接收的返回值出现问题，该错误将导致无法知道哪些推送失败了，也不会处理未推送成功的。");
		}
	}


	
}
