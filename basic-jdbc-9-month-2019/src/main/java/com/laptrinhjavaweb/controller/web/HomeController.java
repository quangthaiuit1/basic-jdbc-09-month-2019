package com.laptrinhjavaweb.controller.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.laptrinhjavaweb.entity.User;
import com.laptrinhjavaweb.service.UserService;

@WebServlet(urlPatterns = { "/web-home", "/dang-nhap", "/dang-xuat" })
public class HomeController extends HttpServlet {

	private static final long serialVersionUID = 0L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Check Home or Login | LogOut
		String pageStr = request.getParameter("action");
		if (pageStr != null && pageStr.equals("login")) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		} else if (pageStr != null && pageStr.equals("logout")) {
			// invalidate the session if exists
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/web-home");
			} else {
				response.sendRedirect(request.getContextPath() + "/web-home");
			}
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Check Home or Login | LogOut
		String pageStr = request.getParameter("action");
		if (!"login".equals(pageStr)) {
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
			return;
		}

		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		try {
			// Select User has userName = userName
			User user = UserService.findByUserName(userName);
			// Check esixt username
			if (user == null || !userName.equals(user.getUserName())) {
				throw new Exception("Tên đăng nhập không tồn tại");
			}
			// Check password
			if (!user.getPassWord().equals(passWord)) {
				throw new Exception("Password không chính xác");
			}
			// Create session and set value
			HttpSession session = request.getSession();
			session.setAttribute("id", user.getId());
			session.setAttribute("userName", user.getUserName());
			session.setAttribute("passWord", user.getPassWord());
			session.setAttribute("roleName", user.getRoleName());
			// get Name to show to view
			request.setAttribute("name", user.getName());

			if (user.getRoleName().equals("admin")) {
				response.sendRedirect(request.getContextPath() + "/admin-home");
			} else {
				response.sendRedirect(request.getContextPath() + "/web-home");
			}
		}catch (Exception ex) {
			request.setAttribute("exception", ex.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
			rd.forward(request, response);
		}
	}
}
