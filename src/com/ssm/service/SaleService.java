package com.ssm.service;

import java.util.List;

import com.ssm.entity.Customer;
import com.ssm.entity.Order;
import com.ssm.entity.OrderLine;
import com.ssm.entity.Product;

public interface SaleService {
	
	public Customer findCustomerByName(String cusName);
	
	public Product findProductById(Integer prodId);
	
	public List<Product> findAllProduct();
	
	public int addOrder(Order order);
	
	public int findLastId(); 
	
	public int addOrderLine(OrderLine orderLine);
	
	public int deleteOrderLine(int odlOrderId);

}
