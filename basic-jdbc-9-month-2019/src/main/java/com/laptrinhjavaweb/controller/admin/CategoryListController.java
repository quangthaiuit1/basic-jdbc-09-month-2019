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
public class CategoryListController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int totalPages = CategoryService.totalPages(3);
		request.setAttribute("totalPages", totalPages);
		List<Category> list = new ArrayList<Category>();
		
		//Get param on url
		String pageStr = request.getParameter("page");
		//Numbers item on one page
		int maxItemOnPage = 3;
		if(Integer.parseInt(pageStr)==1) {
			//This is page current in view
			request.setAttribute("currentPage",Integer.parseInt(pageStr));
			list = CategoryService.findByRows(0, maxItemOnPage);
		}
		else{
			// This is page current in view
			request.setAttribute("currentPage",Integer.parseInt(pageStr));
			int offset = ((Integer.parseInt(pageStr) - 1) * maxItemOnPage) + 1;
			list = CategoryService.findByRows(offset, maxItemOnPage);
		}
		
		
		request.setAttribute("categoryList", list);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/categorylist.jsp");
		rd.forward(request, response);
	}
}
