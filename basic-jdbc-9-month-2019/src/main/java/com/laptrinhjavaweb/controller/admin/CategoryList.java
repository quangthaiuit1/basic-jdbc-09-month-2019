package com.laptrinhjavaweb.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.entity.Category;
import com.laptrinhjavaweb.service.CategoryService;

@WebServlet(urlPatterns = {"/admin-category"})
public class CategoryList extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> list = new ArrayList<Category>();
		list = CategoryService.findAll();
		request.setAttribute("categoryList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/categorylist.jsp");
		rd.forward(request, response);
	}
}
