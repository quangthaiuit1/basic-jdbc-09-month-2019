package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.iCategoryService;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.utils.HttpUtil;


@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iCategoryService categoryService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category category = HttpUtil.of(req.getReader()).toEntity(Category.class);
		categoryService = new CategoryService();
		categoryService.addOne(category);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPut(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doDelete(req, resp);
	}
}
