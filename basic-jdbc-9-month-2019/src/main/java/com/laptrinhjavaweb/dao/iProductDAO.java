package com.laptrinhjavaweb.dao;

import java.util.List;

import com.laptrinhjavaweb.entity.Product;

public interface iProductDAO {
	public List<Product> findAll();
	public List<Product> findByCategoryId(int x);
}
