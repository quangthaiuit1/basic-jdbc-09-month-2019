package com.laptrinhjavaweb.service;
import java.util.List;

import com.laptrinhjavaweb.entity.Product;

public interface iProductService {
	public List<Product> findAll();
	public List<Product> findByCategoryId(int x);
}
