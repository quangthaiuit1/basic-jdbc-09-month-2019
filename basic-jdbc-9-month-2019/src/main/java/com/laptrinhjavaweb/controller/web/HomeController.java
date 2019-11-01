package com.laptrinhjavaweb.controller.web;

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
import com.laptrinhjavaweb.entity.User;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.UserService;

@WebServlet(urlPatterns = {"/web-home","/dang-nhap"})
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 2686801510274002166L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		  //Check Home or Login | LogOut 
		String pageStr = request.getParameter("action");
		if(pageStr != null && pageStr.equals("dang-nhap")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response); 
		}
		if(pageStr != null && pageStr.equals("dang-ky")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/logout.jsp");
			rd.forward(request, response); } 
		else {
		 
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		} 
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  //Check Home or Login | LogOut 
		String pageStr = request.getParameter("action");
		if(pageStr != null && pageStr.equals("login")) {
			String userName = request.getParameter("userName");
			String passWord = request.getParameter("passWord");
			User user = new User();
			user = UserService.findByUserName(userName);
			if(user.getUserName() != null && user.getUserName().equals(userName)) {
				if(user.getPassWord().equals(passWord)) {
					if(user.getRoleName().equals("admin")) {
						//get Name to show to view
						request.setAttribute("name", user.getName());
						response.sendRedirect(request.getContextPath() + "/admin-home"); 
					}
					else {
						//get Name to show to view
						request.setAttribute("name", user.getName());
						response.sendRedirect(request.getContextPath() + "/web-home"); 
					}
				}
				else {
					String exception = "Password không chính xác";
					request.setAttribute("exception", exception);
					RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
					rd.forward(request, response);
				}
			}
			else {
				String exception = "Tên đăng nhập không tồn tại";
				request.setAttribute("exception", exception);
				RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
				rd.forward(request, response);
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response); 

		}
	}
}
