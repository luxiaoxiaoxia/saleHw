package com.ssm.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ssm.dao.CustomerDao;
import com.ssm.dao.OrderDao;
import com.ssm.dao.OrderLineDao;
import com.ssm.dao.ProductDao;
import com.ssm.entity.Customer;
import com.ssm.entity.Order;
import com.ssm.entity.OrderLine;
import com.ssm.entity.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring*.xml"})
public class TestDao {
	
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private OrderDao orderDao;
	@Autowired
	private OrderLineDao orderLineDao;
	
	@Test
	public void queryCustomerByName() {
		String cusName = "cus01";
		Customer customer = customerDao.queryCustomerByName(cusName);
		System.out.println(customer);
	}
	
	@Test
	public void queryProductById() {
		Product Product = productDao.queryProductById(1);
		System.out.println(Product);
	}
	
	@Test
	public void queryAllProduct() {
		List<Product> pList = productDao.queryAllProduct();
		System.out.println(pList);
	}
	
	@Test
	public void insertOrder() {
		Order order = new Order(4, 1, "aaa", "aaa", new Date(), new Date(), "aaa");
		int res = orderDao.insertOrder(order);
		System.out.println(res);
	}
	
	@Test
	public void queryLastId() {
		int res = orderDao.queryLastId();
		System.out.println(res);
	}
	
	@Test
	public void insertOrderLine() {
		OrderLine orderLine = new OrderLine(-1, 1, "aa", 10, 10);
		int res = orderLineDao.insertOrderLine(orderLine);
		System.out.println(res);
	}
	
	@Test
	public void deleteOrderLine() {
		int res = orderLineDao.deleteOrderLine(1);
		System.out.println(res);
	}
	
	@Test
	public void datetext() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		Date date=new Date();  
		String str=sdf.format(date); 
		System.out.println(str);
	}

}
