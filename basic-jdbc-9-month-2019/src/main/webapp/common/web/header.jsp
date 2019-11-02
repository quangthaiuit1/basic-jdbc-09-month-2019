<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
	
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
		<div class="container">
			<a class="navbar-brand" href="#">Ngáo Ngơ Guitar</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Trang Chủ<span class="sr-only">(current)</span></a></li>
					<li class="nav-item"><a class="nav-link" href="#">Giới Thiệu</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Sản Phẩm</a></li>
					<li class="nav-item"><a class="nav-link" href="#">Liên Hệ</a></li>
					<% if (session.getAttribute("name") != null) { %>
					<li class="nav-item"><a class="nav-link" href="<c:url value='#' />">Xin chào <c:out value='${sessionScope["name"]}' /> </a></li>			
					<% } else {%>
    				<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap?action=login' />">Đăng Nhập</a></li>			   
					<% } %>
					<% if (session.getAttribute("name") != null) { %>
					<li class="nav-item"><a class="nav-link"  href="<c:url value='/dang-xuat?action=logout' />" >Thoát</a></li>			
					<% } else {%>
    				<li class="nav-item"><a class="nav-link" href="<c:url value='/dang-nhap?action=dang-nhap' />">Đăng Ký</a></li>			   
					<% } %>
				</ul>
			</div>
		</div>
	</nav>
