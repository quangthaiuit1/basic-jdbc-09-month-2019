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
					<th>NAME</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${categoryList}">
					<tr>
						<td>${item.id}</td>
						<td>${item.name}</td>
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