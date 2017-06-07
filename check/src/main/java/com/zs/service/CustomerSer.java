package com.zs.service;

import java.util.List;

import com.zs.entity.Customer;
import com.zs.entity.CustomerKey;

public interface CustomerSer extends BaseServiceExcel<Customer,CustomerKey> {

	public List<Customer> queryFenye();
}
