package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.util.List;

import com.laptrinhjavaweb.model.ProductModel;

public interface iProductDAO {
	public Connection getConnection();
	public List<ProductModel> findAll();
}
