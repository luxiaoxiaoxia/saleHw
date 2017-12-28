package com.ssm.dao;

import com.ssm.entity.Order;

public interface OrderDao {
	
	public int insertOrder(Order order);
	
	public int queryLastId(); 

}
