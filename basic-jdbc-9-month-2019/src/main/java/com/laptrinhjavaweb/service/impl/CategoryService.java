package com.laptrinhjavaweb.service.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.laptrinhjavaweb.dao.iCategoryDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.dao.impl.ConnectionDAO;
import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.iCategoryService;

public class CategoryService implements iCategoryService {
	private iCategoryDAO categoryDao;
	
	public CategoryService() {
		categoryDao = new CategoryDAO();
	}
	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
	@Override
	public void addOne(Category category) {
		categoryDao.addOne(category);
	}

}
