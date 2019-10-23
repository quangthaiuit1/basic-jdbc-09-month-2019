package com.laptrinhjavaweb.service;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.CategoryDAO;
import com.laptrinhjavaweb.entity.Category;

public class CategoryService {

	public static List<Category> findAll() {
		return CategoryDAO.findAll();
	}
	public static List<Category> findByRows(int offset,int limit){
		return CategoryDAO.findByRows(offset, limit);
	}
	// return total page of table based on number items one page
	public static int totalPages(int maxItemOnePage) {
		List<Category> list = new ArrayList<Category>();
		list = CategoryDAO.findAll();
		return list.size() / maxItemOnePage;
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
