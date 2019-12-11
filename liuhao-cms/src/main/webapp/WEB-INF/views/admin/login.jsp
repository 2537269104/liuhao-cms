<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/public/css/bootstrap.min.css">
<link rel="stylesheet" href="/public/css/cms.css">
<title>登录界面</title>
</head>
<body>
<div class="container-fluid">
    
	<div class="col-4 offset-4 loginForm" >
	  <form action="/admin/home">
	  <div class="form-group" >
	   <h3>欢迎使用CMS系统</h3>
	    <input type="text" class="form-control" placeholder="请输入用户名">
	  </div>
	  <div class="form-group">
	    <input type="password" class="form-control" placeholder="请输入密码">
	  </div>
	  <button type="submit" class="btn btn-primary">登录</button>
	  <!--  <label for="exampleInputPassword1">没有账号，去<a href="/">注册</a></label> -->
	  </form>
	</div>
</div>

<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
</body>
</html>