package com.laptrinhjavaweb.service;
import java.util.ArrayList;
import java.util.List;

import com.laptrinhjavaweb.dao.CategoryDAO;
import com.laptrinhjavaweb.entity.Category;

public class CategoryService {

	public static List<Category> findAll() {
		return CategoryDAO.findAll();
	}
	public static List<Category> findByLimit(int offset,int limit){
		return CategoryDAO.findByLimit(offset, limit);
	}
	// return total page of table based on number items one page
	public static int totalPages(int maxItemOnePage) {
		List<Category> list = new ArrayList<Category>();
		list = CategoryDAO.findAll();
		if(list.size() % maxItemOnePage == 0) {
			return list.size() / maxItemOnePage;
		}
		else return (list.size() / maxItemOnePage) + 1;
	}
	public static void addOne(Category category) {
		CategoryDAO.addOne(category);
	}
	public static void updateOne(Category category) {
		CategoryDAO.updateOne(category);
	}
	public static void delete(int[] id) {
		for(int i = 0; i < id.length; i++) {
			CategoryDAO.delete(id[i]);
		}
	}

}
