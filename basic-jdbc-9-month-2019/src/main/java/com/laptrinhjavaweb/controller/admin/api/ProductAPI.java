package com.laptrinhjavaweb.controller.admin.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.entity.Product;
import com.laptrinhjavaweb.service.iProductService;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.utils.HttpUtil;

@WebServlet(urlPatterns = { "/api-admin-product" })
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private iProductService productService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Product product = HttpUtil.of(req.getReader()).toEntity(Product.class);
		productService = new ProductService();
		productService.addOne(product);
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
