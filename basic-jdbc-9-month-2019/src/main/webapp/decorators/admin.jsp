<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>Dashboard - Ace Admin</title>

<!-- Table bootstrap -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
  	<script src="<c:url value='/template/admin/js/jquery.twbsPagination.js' /> "></script>
  	
<!-- End table bootstrap -->

<meta name="description" content="overview &amp; stats" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/bootstrap.min.css' /> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/font-awesome/4.5.0/css/font-awesome.min.css' /> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/fonts.googleapis.com.css' /> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace.min.css" class="ace-main-stylesheet' /> "
	id="main-ace-style" />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace-skins.min.css' /> " />
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/ace-rtl.min.css' /> " />
<script src="<c:url value='/template/admin/js/ace-extra.min.js' /> "></script>

<!-- style -->
<style>
	table, th, td {
		
	}
	
	th, td {
		padding: 5px;
		text-align: left;
	}
</style>


</head>

<body class="no-skin">
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- End header -->

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.loadState('main-container')
			} catch (e) {
			}
		</script>
		<!-- menu -->
		<%@ include file="/common/admin/menu.jsp"%>
		<!-- End menu -->
		<div class="main-content">
			<div class="main-content-inner">
				<dec:body />
			</div>
		</div>
		<!-- /.main-content -->

		<!-- footer -->
		<%@ include file="/common/admin/footer.jsp"%>
		<!-- End footer -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<%-- <script src="<c:url value='/template/admin/js/jquery-2.1.4.min.js' /> "> </script> --%>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script src="<c:url value='/template/admin/js/bootstrap.min.js' />"></script>

	<!-- page specific plugin scripts -->

	<!--[if lte IE 8]>
		  <script src="assets/js/excanvas.min.js"></script>
		<![endif]-->
	<script
		src="<c:url value='/template/admin/js/jquery-ui.custom.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.ui.touch-punch.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.easypiechart.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.sparkline.index.min.js' /> "></script>
	<script src="<c:url value='/template/admin/js/jquery.flot.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.pie.min.js' /> "></script>
	<script
		src="<c:url value='/template/admin/js/jquery.flot.resize.min.js' /> "></script>

	<!-- ace scripts -->
	<script src="<c:url value='/template/admin/js/ace-elements.min.js' /> "></script>
	<script src="<c:url value='/template/admin/js/ace.min.js' /> "></script>

	<!-- inline scripts related to this page -->

</body>
</html>
