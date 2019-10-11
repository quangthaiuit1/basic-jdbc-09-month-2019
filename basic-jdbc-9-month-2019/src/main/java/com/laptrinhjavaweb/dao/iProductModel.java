package com.laptrinhjavaweb.dao;

import java.sql.Connection;
import java.util.List;

import com.laptrinhjavaweb.model.CategoryModel;

public interface iProductModel {
	public Connection getConnection();
	public List<CategoryModel> findAll();
}
