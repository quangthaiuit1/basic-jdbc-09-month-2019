<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form action = "<c:url value='/admin-category'/>" method="get" id="formCategory">	
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
				<ul class="pagination" id="pagination"></ul>

		<script type="text/javascript">
			var totalPages = ${totalPages}
			$(function() {
				window.pagObj = $('#pagination').twbsPagination({
					totalPages : totalPages,
					visiblePages : 5,
					startPage: 1,
					onPageClick : function(event, page) {
					 	$('#inputPage').val(page);
						$('#formCategory').submit();
					 }
				});
			});
		</script>
		<!-- End Phân trang -->
		
	</div>
</form>