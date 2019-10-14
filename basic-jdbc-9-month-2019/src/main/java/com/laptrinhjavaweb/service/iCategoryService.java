package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.Category;

public interface iCategoryService {
	public List<Category> findAll();
	public void addOne(Category category);
}
