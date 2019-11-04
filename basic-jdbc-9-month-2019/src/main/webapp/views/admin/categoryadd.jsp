<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<form>
	<div class="form-row" >
		<div style="width: 50%; margin: 0 auto">
			<label for="validationDefault01">Tên loại danh mục</label> 
			<input type="text" class="form-control" id="txtCategoryName" placeholder="Nhập tên loại danh mục" value="" required>
			<button class="btn btn-primary" id="btnAdd" style="width: 30%;margin-top: 20px">Thêm</button>
			<button class="btn btn-primary" id="results" style="width: 80%;margin-top: 20px"></button>
		</div>
	</div>
</form>

<script>
	$(document).ready(function(){
		$('form').submit(false);
	  $("#txtCategoryName").blur(function(){
		  let categoryName = $("#txtCategoryName").val();
		  $("#btnAdd").click(function(){
			  $.ajax({
				  	url: "/api-admin-category",
					type: 'POST',
					dataType: 'json',
					data: {
						name: categoryName
					},
					success    : function(resultText){
				  $('#results').html(resultText);
				  },
					  error : function(jqXHR, exception){
					  console.log('Error occured!!');
				  }
			  });
		  });
	  });
	});
</script>