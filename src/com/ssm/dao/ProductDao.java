package com.ssm.dao;

import java.util.List;

import com.ssm.entity.Product;

public interface ProductDao {
	
	public Product queryProductById(Integer prodId);
	
	public List<Product> queryAllProduct();

}
