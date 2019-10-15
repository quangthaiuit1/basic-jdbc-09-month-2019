package com.laptrinhjavaweb.service;
import java.util.List;

import com.laptrinhjavaweb.dao.CategoryDAO;
import com.laptrinhjavaweb.entity.Category;

public class CategoryService {

	public static List<Category> findAll() {
		return CategoryDAO.findAll();
	}
	public void addOne(Category category) {
		CategoryDAO.addOne(category);
	}
	public void updateOne(Category category) {
		CategoryDAO.updateOne(category);
	}
	public void delete(int[] id) {
		for(int i = 0; i < id.length; i++) {
			CategoryDAO.delete(id[i]);
		}
	}

}
