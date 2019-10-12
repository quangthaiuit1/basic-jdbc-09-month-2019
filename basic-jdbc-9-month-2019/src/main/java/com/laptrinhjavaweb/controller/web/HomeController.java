package com.laptrinhjavaweb.controller.web;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.laptrinhjavaweb.service.iCategoryService;
import com.laptrinhjavaweb.service.iProductService;
import com.laptrinhjavaweb.service.impl.CategoryService;
import com.laptrinhjavaweb.service.impl.ProductService;

@WebServlet(urlPatterns = {"/web-home"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;
	private iCategoryService categoryService;
	private iProductService productService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		categoryService = new CategoryService();
		productService = new ProductService();
		request.setAttribute("categorys", categoryService.findAll());
		request.setAttribute("productCate1", productService.findByCategoryId(1));
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}
