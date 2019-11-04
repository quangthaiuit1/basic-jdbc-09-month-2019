<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form>
	<div class="form-row">
		<div style="width: 50%; margin: 0 auto">
			<label for="validationDefault01">Tên loại danh mục</label> <input
				type="text" class="form-control" id="txtCategoryName"
				placeholder="Nhập tên loại danh mục" value="">
			<button class="btn btn-primary" id="btnAdd"
				style="width: 30%; margin-top: 20px">Thêm</button>
			<h3 id="results"
				style="width: 80%; margin-top: 20px"></h3>
		</div>
	</div>
	<input type="hidden" value="list" id="action" name="action"> <input
		type="hidden" value="1" id="page" name="page">
</form>

<script>
	$(document).ready(function() {
		$('form').submit(false);
		$("#txtCategoryName").blur(function() {
			let categoryName = $("#txtCategoryName").val();
			$("#btnAdd").click(function() {
				$.ajax({
					type : 'POST',
					url : "api-admin-category",
					contentType : "application/json; charset=utf-8",
					dataType : 'JSON',
					data : JSON.stringify({
						"name" : categoryName
					}),
					success : function(status) {
						$("#results").text("Thêm thành công");
					},
					error : function(error) {
						console.log("error", error);
					}
				});

			});
		});
	});
</script>