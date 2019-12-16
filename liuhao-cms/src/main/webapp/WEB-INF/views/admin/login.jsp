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
	   <h3>欢迎使用CMS系统</h3>
	   <!-- 警告框 -->
	  <div class="alert alert-danger" role="alert" style="display: none">
			</div> 
	 <div class="form-group" >
	    <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名">
	  </div>
	  <div class="form-group">
	    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
	  </div>
	  <input type="button" class="btn btn-primary" onclick="login()" value="登录">
	  <!--  <label for="exampleInputPassword1">没有账号，去<a href="/">注册</a></label> -->
	  </form>
	</div>
</div>
<script type="text/javascript" src="/public/js/jquery.min.1.12.4.js"></script>
<script type="text/javascript" src="/public/js/bootstrap.min.js"></script>
<script type="text/javascript">
       function login(){
    	   //空判断
    	   var username=$("#username").val();
    	   var password=$("#password").val();
    	   if(username== null || password == ""){
    		   $(".alert-danger").html("请输入用户名和密码");
    		   $(".alert-danger").show();
    		   return;
    	   }
    	   else{
    		   $(".alert-danger").hide();
    		   //后台验证
    	    	  var formData = $("form").serialize();
    	    	   $.post("/admin/user/login",formData,function(res){
    	    		   if(res.result){
    	    			   //验证通过跳转到后台
    	    			   location.href="/admin/home";
    	    		   }
    	    		   else{
    	    			   //提示错误信息
    	    			   $(".alert-danger").html(res.message);
    	        		   $(".alert-danger").show();
    	    		   }
    	    	   })
    	   }
    	 
       }




</script>
</body>
</html>