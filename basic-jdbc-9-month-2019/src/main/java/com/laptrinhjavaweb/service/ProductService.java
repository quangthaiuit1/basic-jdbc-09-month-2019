package com.laptrinhjavaweb.service;
import java.io.FileNotFoundException;
import java.util.List;

import com.laptrinhjavaweb.dao.ProductDAO;
import com.laptrinhjavaweb.entity.Product;

public class ProductService {
	private ProductDAO productDao;
	
	public ProductService() {
		productDao = new ProductDAO();
	}
	public List<Product> findAll() {
		return productDao.findAll();
	}
	public List<Product> findByCategoryId(int x) {
		productDao.findByCategoryId(x);
		return null;
	}
	public void addOne(Product product) throws FileNotFoundException {
		productDao.addOne(product);
	}

}
