package com.laptrinhjavaweb.dao;
import java.util.List;

import com.laptrinhjavaweb.entity.Category;

public interface iCategoryDAO {
	public List<Category> findAll();
	public void addOne(Category category);
	public void updateOne(Category category);
	public void delete(int id);
}
