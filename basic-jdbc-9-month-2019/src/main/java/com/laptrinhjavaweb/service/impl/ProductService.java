package com.laptrinhjavaweb.service.impl;
import java.util.List;

import com.laptrinhjavaweb.dao.iProductDAO;
import com.laptrinhjavaweb.dao.impl.ProductDAO;
import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.service.iProductService;

public class ProductService implements iProductService {
	private iProductDAO productDao;
	
	public ProductService() {
		productDao = new ProductDAO();
	}
	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}
	@Override
	public List<Product> findByCategoryId(int x) {
		productDao.findByCategoryId(x);
		return null;
	}

}
