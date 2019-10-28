package com.laptrinhjavaweb.service;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.ProductDAO;
import com.laptrinhjavaweb.entity.Product;

public class ProductService {
	
	
	public static List<Product> findAll() {
		return ProductDAO.findAll();
	}
	public static List<Product> findByLimit(int offset,int limit){
		return ProductDAO.findByLimit(offset, limit);
	}
	public static List<Product> findByCategoryId(int x) {
		return ProductDAO.findByCategoryId(x);
	}
	public static void addOne(Product product) throws FileNotFoundException {
		ProductDAO.addOne(product);
	}
	public static int totalPages(int maxItemOnePage) {
		List<Product> list = new ArrayList<Product>();
		list = ProductDAO.findAll();
		if(list.size() % maxItemOnePage == 0) {
			return list.size() / maxItemOnePage;
		}
		else return (list.size() / maxItemOnePage) + 1;
		 
	}

}
