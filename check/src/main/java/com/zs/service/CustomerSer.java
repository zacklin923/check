package com.zs.service;

import java.util.List;

import com.zs.entity.Customer;

public interface CustomerSer extends BaseService<Customer> {

	public List<Customer> queryFenye();
}
