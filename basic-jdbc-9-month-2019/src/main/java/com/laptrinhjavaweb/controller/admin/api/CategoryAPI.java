package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
		//Read object from json
		Category category = HttpUtil.of(req.getReader()).toEntity(Category.class);
		CategoryService.addOne(category);
		objectMapper.writeValue(resp.getOutputStream(), category);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category category = HttpUtil.of(req.getReader()).toEntity(Category.class);
		CategoryService.updateOne(category);
		objectMapper.writeValue(resp.getOutputStream(), category);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category category = HttpUtil.of(req.getReader()).toEntity(Category.class);
		CategoryService.delete(category.getIds());
		objectMapper.writeValue(resp.getOutputStream(), category);
	}
}
