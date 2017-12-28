package com.ssm.dao;

import com.ssm.entity.Customer;

public interface CustomerDao {
	
	public Customer queryCustomerByName(String cusName);

}
