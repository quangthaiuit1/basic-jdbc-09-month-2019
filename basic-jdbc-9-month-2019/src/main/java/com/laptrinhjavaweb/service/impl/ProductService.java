package com.laptrinhjavaweb.service.impl;
import java.util.List;

import com.laptrinhjavaweb.dao.iProductDAO;
import com.laptrinhjavaweb.dao.impl.ProductDAO;
import com.laptrinhjavaweb.model.ProductModel;
import com.laptrinhjavaweb.service.iProductService;

public class ProductService implements iProductService {
	private iProductDAO productDao;
	
	@Override
	public List<ProductModel> findAll() {
		productDao = new ProductDAO();
		return productDao.findAll();
	}

}
