package com.zs.service.impl;

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
import com.zs.entity.SourceImport;
import com.zs.entity.SourceImportFailed;
import com.zs.entity.SourceImportKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.SourceImportSer;
import com.zs.tools.HttpHelper;
import com.zs.tools.Trans;

@Service("sourceImportSer")
public class SourceImportSerImpl implements SourceImportSer{

	@Resource
	private SourceImportMapper importMapper;
	@Resource
	private SourceImportFailedMapper importFailMapper;
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
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public SourceImport get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public String importData(List<String[]> list,String stuNum) {
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
					SourceImportKey sik = new SourceImportKey();
					sik.setCourierNumber(Trans.tostring(list.get(i)[3]));
					sik.setCreateDate(Trans.TransToDate(list.get(i)[0],"yyyy-MM-dd"));
					SourceImport skey =importMapper.selectByPrimaryKey(sik);
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
		String json=gson.toJson(list);
		List<NameValuePair> formparams=new ArrayList<NameValuePair>();
		formparams.add(new BasicNameValuePair("data", json));
		String result=HttpHelper.postForm(URL_ZM, formparams);
		log.error("推送失败的单号:"+result);
	}


	
}
