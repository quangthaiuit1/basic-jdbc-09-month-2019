package com.laptrinhjavaweb.dao;
import java.util.List;
import com.laptrinhjavaweb.entity.Category;

public interface iCategoryDAO {
	public List<Category> findAll();
}
