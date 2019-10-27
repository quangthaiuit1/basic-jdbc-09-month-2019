<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<div id="sidebar"
	class="sidebar                  responsive                    ace-save-state">
	<div id="sidebar"
		class="sidebar                  responsive                    ace-save-state">
		<div class="" style="padding-left: 0px;padding-right: 0px; ">
			<div class="dropdown">
				<button type="button" style="width:100%" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
					Danh mục sản phẩm
				</button>
				<div class="dropdown-menu" >
					<button type="button" style="width:100%;" class="btn btn-defaut" >
						<a class="dropdown-item" href="<c:url value='/admin-category?page=1' /> " style="color:#ffffffff">Danh sách</a>
					</button>
					<button type="button" style="width:100%" class="btn .btn-default">
						<a class="dropdown-item" href="/category-admin?page=1" style="color:#ffffffff">Thêm</a>
					</button>
					
				</div>
			</div>
		</div>
		<div class="" style="padding-left: 0px;padding-right: 0px; ">
			<div class="dropdown">
				<button type="button" style="width:100%" class="btn btn-success dropdown-toggle" data-toggle="dropdown">
					Sản Phẩm
				</button>
				<div class="dropdown-menu" >
					<button type="button" style="width:100%;" class="btn btn-defaut" >
						<a class="dropdown-item" href="<c:url value='/admin-product?page=1' /> " style="color:#ffffffff">Danh sách</a>
					</button>
					<button type="button" style="width:100%" class="btn .btn-default">
						<a class="dropdown-item" href="/category-admin?page=1" style="color:#ffffffff">Thêm</a>
					</button>
					
				</div>
			</div>
		</div>
	</div>
</div>