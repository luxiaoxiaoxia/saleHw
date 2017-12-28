package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.dao.CustomerDao;
import com.ssm.dao.OrderDao;
import com.ssm.dao.OrderLineDao;
import com.ssm.dao.ProductDao;
import com.ssm.entity.Customer;
import com.ssm.entity.Order;
import com.ssm.entity.OrderLine;
import com.ssm.entity.Product;
import com.ssm.service.SaleService;
@Service("saleService")
public class SaleServiceImpl implements SaleService{
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderLineDao orderLineDao;

	@Override
	public Customer findCustomerByName(String cusName) {
		return customerDao.queryCustomerByName(cusName);
	}

	@Override
	public Product findProductById(Integer prodId) {
		return productDao.queryProductById(prodId);
	}

	@Override
	public List<Product> findAllProduct() {
		return productDao.queryAllProduct();
	}

	@Override
	public int addOrder(Order order) {
		return orderDao.insertOrder(order);
	}

	@Override
	public int findLastId() {
		return orderDao.queryLastId();
	}

	@Override
	public int addOrderLine(OrderLine orderLine) {
		return orderLineDao.insertOrderLine(orderLine);
	}

	@Override
	public int deleteOrderLine(int odlOrderId) {
		return orderLineDao.deleteOrderLine(odlOrderId);
	}

}
