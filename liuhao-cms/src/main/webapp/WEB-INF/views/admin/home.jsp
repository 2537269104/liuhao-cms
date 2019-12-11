<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/public/css/bootstrap.min.css">
<link rel="stylesheet" href="/public/css/cms.css">
<title>后台管理界面</title>
</head>
<body>
	<jsp:include page="../common/admin/head.jsp"></jsp:include>
	<div class="container-fluid">
		<div class="row" style="margin-top: 15px;">
			<div class="col-3">
				<jsp:include page="../common/admin/left.jsp"></jsp:include>
			</div>
			<div class="col-9">
				<div class="tab-content" id="v-pills-tabContent"></div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
	<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/public/js/cms.js"></script>
	<script type="text/javascript">
		
	</script>
</body>
</html>