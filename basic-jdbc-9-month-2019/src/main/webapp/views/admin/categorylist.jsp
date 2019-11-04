<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form action="<c:url value='/admin-category'/>" method="get"
	id="formCategory">
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>TÊN DANH MỤC</th>
					<th>SỬA</th>
					<th>XÓA</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${categoryList}">
					<tr>
						<td id="id">${item.id}</td>
						<td>${item.name}</td>
						<td><button type="button" style="width: 20%; heigh: 5px"
								class="btn btn-warning" id="btnUpdate">Sửa</button></td>
						<td><button type="button" style="width: 20%; heigh: 50%"
								class="btn btn-danger" id="btnDelete">Xóa</button></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<input type="hidden" value="" id="action" name="action"> <input
			type="hidden" value="" id="inputPage" name="page">

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
					visiblePages : 3,
					startPage : currentPage,
					onPageClick : function(event, page) {
						var current = page;
						if (currentPage != page) {
							if (page >= 2) {
								$('#action').val("list");
								$('#inputPage').val(page);
								$('#formCategory').submit();
							}
							$('#action').val("list");
							$('#inputPage').val(page);
							$('#formCategory').submit();
						}
					}
				});
			});
		</script>
		<!-- End Phân trang -->
		<script>
			$(document).ready(function() {
				$(this + "#btnDelete").click(function() {
					alert("đã vào");
					let id = $(this + "#id").val();
					alert(id);
					$.ajax({
						type : 'DELETE',
						url : "api-admin-category",
						contentType : "application/json; charset=utf-8",
						dataType : 'JSON',
						data : JSON.stringify({
							"id" : id
						}),
						success : function(status) {
							alert("Xóa thành công");
						},
						error : function(error) {
							console.log("error", error);
						}
					});

				});
			});
		</script>
	</div>
</form>