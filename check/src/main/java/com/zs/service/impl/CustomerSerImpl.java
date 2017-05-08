package com.zs.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.zs.dao.CustomerMapper;
import com.zs.dao.StaffUserMapper;
import com.zs.entity.Customer;
import com.zs.entity.ProvinceCode;
import com.zs.entity.StaffUser;
import com.zs.entity.other.EasyUIAccept;
import com.zs.entity.other.EasyUIPage;
import com.zs.service.CustomerSer;
import com.zs.service.UserSer;

@Service("customerSer")
public class CustomerSerImpl implements CustomerSer{

	@Resource
	private CustomerMapper customerMapper;
	private Logger log=Logger.getLogger(getClass());
	
	public EasyUIPage queryFenye(EasyUIAccept accept) {
		if (accept!=null) {
			Integer page=accept.getPage();
			Integer size=accept.getRows();
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
		return customerMapper.insertSelective(obj);
	}

	public Integer update(Customer obj) {
		return customerMapper.updateByPrimaryKeySelective(obj);
	}

	public Integer delete(String id) {
		return customerMapper.deleteByPrimaryKey(id);
	}

	public Customer get(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	/*2017-5-4，张顺，就用一次，方便把数据存进数据而已，以后不会用了，所有没有写判断，不要给用户使用。*/
	public String importData(List<String[]> list, String stuNum) {
		for (int i = 1; i < list.size(); i++) {
			Customer code=new Customer(list.get(i)[1],list.get(i)[0]);
			try {
				customerMapper.insertSelective(code);
			} catch (Exception e) {
				log.error("【导入客户信息错误】"+list.get(i)[1]);
			}
		}
		return null;
	}

	public String exportData(EasyUIAccept accept, HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

}
