package com.laptrinhjavaweb.dao;
import java.util.List;
import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.entity.Product;

public interface iCategoryDAO {
	public List<Category> findAll();
	public void addOne(Category category);
}
