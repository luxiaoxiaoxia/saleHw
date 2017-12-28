package com.ssm.dao;

import com.ssm.entity.OrderLine;

public interface OrderLineDao {
	
	public int insertOrderLine(OrderLine orderLine);
	
	public int deleteOrderLine(int odlOrderId);

}
