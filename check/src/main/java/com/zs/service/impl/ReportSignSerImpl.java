package com.zs.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zs.dao.ReportSignMapper;
import com.zs.dao.SourceThirdPartyMapper;
import com.zs.entity.ReportSign;
import com.zs.entity.ReportSignExample;
import com.zs.entity.ReportSignKey;
import com.zs.entity.SourceThirdParty;
import com.zs.entity.SourceThirdPartyExample;
import com.zs.entity.SourceThirdPartyExample.Criteria;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.entity.other.ReportSignBean;
import com.zs.service.ReportSignSer;
import com.zs.service.SourceTpSer;

@Service("reportSignSer")
public class ReportSignSerImpl implements ReportSignSer{

	private Logger log=Logger.getLogger(getClass());
	@Resource
	private ReportSignMapper reportSignMapper;
	@Resource
	private SourceThirdPartyMapper sourceThirdPartyMapper;
	
	
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		/*if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=signMapper.queryFenye(accept);
			int rows=signMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}*/
		return null;
	}

	public Integer add(ReportSign obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer update(ReportSign obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer delete(ReportSignKey id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReportSign get(ReportSignKey id) {
		// TODO Auto-generated method stub
		return null;
	}
	//重新生成某一天的签收报表的数据,如果date为null就生成今天的,ctmBarCode和province为null则为所有
	public void obtainReportSign(String date,String ctmBarCode,String province) {
		if(date==null || date.equals("")){
			ReportSign reportSign=new ReportSign();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			date=sdf.format(new Date());
		}
		List<ReportSign> list=sourceThirdPartyMapper.queryReportSign(date,ctmBarCode,province);
		//先删除该天的数据
		reportSignMapper.deleteByDate(date,ctmBarCode,province);
		for (ReportSign rs : list) {
			int succ=sourceThirdPartyMapper.queryReportSignSucc(date, rs.getCtmBarCode(), rs.getCtmName(), rs.getProvince());
			int succtimeout=sourceThirdPartyMapper.queryReportSignSuccTimeout(date, rs.getCtmBarCode(), rs.getCtmName(), rs.getProvince());
			int wait=sourceThirdPartyMapper.queryReportSignWait(date, rs.getCtmBarCode(), rs.getCtmName(), rs.getProvince());
			rs.setTotalSucc(new BigDecimal(succ));
			rs.setTotalSuccTimeout(new BigDecimal(succtimeout));
			rs.setWaitCourierNumber(wait+"");
			reportSignMapper.insertSelective(rs);
		}
	}
	//更新以前的签收报表数据，检测wait是否有值，且不为0，就重新生成
	public void obtainReportSignUpdate() {
		ReportSignExample example=new ReportSignExample();
		com.zs.entity.ReportSignExample.Criteria criteria=example.createCriteria();
		criteria.andWaitCourierNumberNotEqualTo("0");
		List<ReportSign> listupdate=reportSignMapper.selectByExample(example);
		for (ReportSign reportSign : listupdate) {
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			String date=sdf.format(reportSign.getSendTime());
			this.obtainReportSign(date,reportSign.getCtmBarCode(),reportSign.getProvince());
		}
	}
	
	//获取  按 客户+身份查询的签收率
	public List<ReportSignBean> obtainOfCtmAndProvince(EasyUIAccept accept) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(accept.getDate2());
		calendar.add(Calendar.DATE, 1);
		return reportSignMapper.obtainOfCtmAndProvince(accept.getDate1(), calendar.getTime(),accept.getStr1(),accept.getStr2());
	}

	//获取签收率，按客户
	public List<ReportSignBean> obtainOfCtm(EasyUIAccept accept) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(accept.getDate2());
		calendar.add(Calendar.DATE, 1);
		return reportSignMapper.obtainOfCtm(accept.getDate1(), calendar.getTime(),accept.getStr1(),accept.getStr2());
	}
	//计算签收率，总量
	public List<ReportSignBean> obtainOfSum(EasyUIAccept accept) {
		Calendar calendar=Calendar.getInstance();
		calendar.setTime(accept.getDate2());
		calendar.add(Calendar.DATE, 1);
		return reportSignMapper.obtainOfSum(accept.getDate1(), calendar.getTime());
	}
	

}
