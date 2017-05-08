package com.zs.service;

import java.util.List;

import com.zs.entity.Customer;

public interface CustomerSer extends BaseServiceExcel<Customer,String> {

	public List<Customer> queryFenye();
}
