package com.zs.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.zs.dao.CheckLogMapper;
import com.zs.dao.CustomerMapper;
import com.zs.entity.CheckLog;
import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CustomerSer;
import com.zs.tools.Trans;

@Service("customerSer")
public class CustomerSerImpl implements CustomerSer{

	@Resource
	private CustomerMapper customerMapper;
	@Resource
	private CheckLogMapper logMapper;
	private Logger log=Logger.getLogger(getClass());
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
			if(accept.getInt1()!=null){
				if(accept.getInt1()!=0){
					accept.setInt1(null);
				}
			}
			if (page!=null && size!=null) {
				accept.setStart((page-1)*size);
				accept.setEnd(page*size);
			}
			List list=customerMapper.queryFenye(accept);
			int rows=customerMapper.getCount(accept);
			return new EasyUIPage(rows, list);
		}
		return null;
	}
	
	public List<Customer> queryFenye() {
		EasyUIAccept accept = new EasyUIAccept();
		List<Customer> list=customerMapper.queryFenye(accept);
		return list;
	}

	public Integer add(Customer obj) {
		obj.setHistoryCount(new BigDecimal(0));
		return customerMapper.insertSelective(obj);
	}

	public Integer update(Customer obj) {
		return customerMapper.updateByPrimaryKeySelective(obj);
	}
	
	public Integer delete(CustomerKey id) {
		// TODO Auto-generated method stub
		return customerMapper.deleteByPrimaryKey(id);
	}

	public Customer get(CustomerKey id) {
		return customerMapper.selectByPrimaryKey(id);
	}
	
	public String importData(List<String[]> list, String stuNum) {
		Gson g = new Gson();
		List<String> ls = new ArrayList<String>();
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i)[0]!=null&&!list.get(i)[0].equals("")){
				CustomerKey ck = new CustomerKey();
				ck.setCteBarCode(list.get(i)[0]);
				ck.setHistoryCount(new BigDecimal(0));
				Customer isct =  get(ck);
				try {
					Customer code=new Customer(list.get(i)[1],list.get(i)[2],list.get(i)[3],list.get(i)[4],
							list.get(i)[5],list.get(i)[6],list.get(i)[7],list.get(i)[8],Trans.TransToDate(list.get(i)[9]),
							Trans.TransToDate(list.get(i)[10]),list.get(i)[11],list.get(i)[12],list.get(i)[13],
							Trans.toBigDecimal(list.get(i)[14]),list.get(i)[15],list.get(i)[16],list.get(i)[17],
							list.get(i)[18],list.get(i)[19],list.get(i)[20],list.get(i)[21],list.get(i)[22],
							list.get(i)[23],"启用",new Timestamp(new Date().getTime()));
					code.setCteBarCode(list.get(i)[0]);
					code.setHistoryCount(new BigDecimal(0));
					if(isct==null){
						CheckLog cLog = new CheckLog(null,list.get(i)[0] ,null,"customer",g.toJson(code) ,null, stuNum,"添加");
						logMapper.insertSelective(cLog);
						customerMapper.insertSelective(code);
					}else{
						CheckLog cLog = new CheckLog(null,list.get(i)[0] ,null,"customer",g.toJson(isct) ,null, stuNum,"修改");
						logMapper.insertSelective(cLog);
						customerMapper.updateByPrimaryKeySelective(code);
					}
				} catch (Exception e) {
					e.printStackTrace();
					ls.add((i+1)+"");
				}
			}else{
				ls.add((i+1)+"");
			}
		}
		if(ls.size()>0){
			return "数据导入错误行号为"+new Gson().toJson(ls);
		}else{
			return "";
		}
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
