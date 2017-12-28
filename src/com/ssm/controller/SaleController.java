package com.ssm.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.entity.Customer;
import com.ssm.entity.Order;
import com.ssm.entity.OrderLine;
import com.ssm.entity.Product;
import com.ssm.service.SaleService;
import com.ssm.util.MyUtil;

@Controller
@RequestMapping("/sale")
public class SaleController {
	@Autowired
	private SaleService saleService;
	
	@RequestMapping("/toAddOrder")
	public String toAddOrder(Model model) {
		int lastOrderId = saleService.findLastId();
		int orderId = lastOrderId + 1;
		String odrOrderDate = MyUtil.newDateToString();
		model.addAttribute("orderId", orderId);
		model.addAttribute("odrOrderDate", odrOrderDate);
		return "addOrder";
	}
	
	@RequestMapping("/findCustomerByName")
	@ResponseBody
	public String findCustomerByName(Model model,String odrCustomerName) {
		Customer customer = saleService.findCustomerByName(odrCustomerName);
		String data = "0";
		if(customer != null) {
			data = "1";
		}else {
			data = "0";
		}
		return data;
	}
	
	@RequestMapping("/addOrder")
	public String addOrder(Model model,Integer orderId,String odrOrderDateStr,String odrCustomerName,String odrDeliverDateStr,String odrDeliverAddr,HttpSession session) {
		Customer odrCustomer = saleService.findCustomerByName(odrCustomerName);
		List<Product> pList = saleService.findAllProduct();
		Date odrOrderDate = MyUtil.stringToDate(odrOrderDateStr);
		Date odrDeliverDate = MyUtil.stringToDate(odrDeliverDateStr);
		Order order = new Order(orderId, odrCustomer.getCusId(), odrCustomerName, odrDeliverAddr, odrOrderDate, odrDeliverDate, "1");
		int res = saleService.addOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("pList", pList);
		session.setAttribute("order", order);
		return "addOrderLine";
	}
	
	@RequestMapping("/findProductById")
	@ResponseBody
	public String findProductById(Model model,Integer productId) {
		System.out.println(productId);
		Product product = saleService.findProductById(productId);
		String data = product.getProdPrice()+"";
		return data;
	}
	
	@RequestMapping("/addOrderLine")
	@ResponseBody
	public String addOrderLine(Model model,HttpSession session,Integer productId,int count) {
		Product product = saleService.findProductById(productId);
		Order order = (Order) session.getAttribute("order");
		OrderLine orderLine = new OrderLine(-1, order.getOdrId(), product.getProdName(), product.getProdPrice(), count);
		int res = saleService.addOrderLine(orderLine);
		String data = "";
		if(res > 0) {
			data = product.getProdName();
		}else {
			data = "false";
		}
		return data;
	}
	
	@RequestMapping("/success")
	public String success() {
		return "success";
	}

}