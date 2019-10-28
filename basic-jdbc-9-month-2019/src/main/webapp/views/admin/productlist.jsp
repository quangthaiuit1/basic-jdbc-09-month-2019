<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>

<form action="<c:url value='/admin-product'/>" method="get"
	id="formCategory">
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th style="width:2%">ID</th>
					<th style="width:8%">TÊN SẢN PHẨM</th>
					<th style="width:30%">MÔ TẢ</th>
					<th style="width:10%">GIÁ</th>
					<th style="width:14%">ẢNH</th>
					<th style="width:9%">THUỘC DANH MỤC</th>
					<th style="width:9%">THUỘC LOẠI SẢN PHẨM</th>
					<th style="width:8%">NGÀY TẠO</th>
					<th style="width:5%">SỬA</th>
					<th style="width:5%">XÓA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${productList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
						<td>${item.description}</td>
						<td>${item.price}</td>
						
						<!-- Chỗ đây là cái hình -->
						
						<td></td>
						<td>${item.categoryName}</td>
						<td>${item.productTypeName}</td>
						<td>${item.createdDate}</td>
						<td><button type="button" style="width:90%;" class="btn btn-warning">Sửa</button></td>
						<td><button type="button" style="width:90%;" class="btn btn-danger">Xóa</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" value="" id="inputPage" name="page">

		<!-- Phân trang -->
		<div class="container">
			<nav aria-label="Page navigation">
				<ul id="pagination" class="pagination-sm"></ul>
			</nav>
		</div>

		<script type="text/javascript">
			$(function() {
				var total = ${totalPages};
				var currentPage = ${currentPage};
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : total,
					visiblePages : 2,
					startPage : currentPage,
					onPageClick : function(event, page) {
						var current = page;
						if (currentPage != page) {
							$('#inputPage').val(page);
							$('#formCategory').submit();
						}
					}
				});
			});
		</script>
	<!-- End Phân trang -->
	</div>
</form>