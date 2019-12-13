<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
${pageInfo.list}
<form class="form-inline">
	<input type="hidden" name="pageNum">
	<div class="form-group mx-sm-3 mb-2">
		<input type="text" class="form-control" name="title"
			value="${article.title}" placeholder="请输入文章标题">
	</div>
	<div class="form-group mx-sm-3 mb-2">
		<select id="inputState" class="form-control" name="channel_name">
			<option selected value="">请选择频道...</option>
		</select>
	</div>
	<div class="form-group mx-sm-3 mb-2">
		<select id="inputState2" class="form-control"  name="status">
			<option selected value="">请选择审核状态...</option>
			<option  value="0">刚发布</option>
			<option  value="1">审核通过.</option>
			<option  value="-1">审核未通过.</option>
		</select>
	</div>
	<button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
</form>
<table class="table">
	<thead>
		<tr>
			<th scope="col">选择</th>
			<th scope="col">序号</th>
			<th scope="col">标题</th>
			<th scope="col">所属频道</th>
			<th scope="col">所属类别</th>
			<th scope="col">是否热点</th>
			<th scope="col">审核状态</th>
			<th scope="col">发布时间</th>
			<th scope="col">操作</th>

		</tr>
	</thead>
	<tbody>
		<c:forEach items="${pageInfo.list}" var="article" varStatus="count">
			<tr>
				<td><input type="checkbox" name="check" value="${article.id}">
				</td>
				<td>${count.count}</td>
				<td>${article.title}</td>
				<td>${article.channel_name}</td>
				<td>${article.category_name}</td>
				<td>${article.hot==0?"非热点":"热点"}</td>
				<td><c:if test="${article.status==0}">
						          刚发布
						    </c:if> <c:if test="${article.status==1}">
						         审核通过
						    </c:if> <c:if test="${article.status==-1}">
						          审核未通过
						    </c:if></td>
				<td>${article.created}</td>

				<td><input type="button" class="btn btn-primary" value="文章详情"
					onclick="xiangqing()"></td>
			</tr>
		</c:forEach>

	</tbody>
</table>
<div class="row">
	<nav aria-label="Page navigation example col-5"
		style="margin-right: 10px;">
		<button type="button" class="btn btn-primary" onclick="add()">添加</button>
		<button type="button" class="btn btn-primary">批删</button>
	</nav>
	<jsp:include page="../common/page.jsp"></jsp:include>
</div>
<script>
	 function add() {
			$.get("/admin/addArticle",{},function(res){
				$(".tab-content").html(res);
			},"html");
		}
	 function xiangqing(id){
		  location.href="/article/xiangqing?id="+id;
	 }
	 
	  function query() {
    	  var params = $("form").serialize();
    	   reload(params);
	}
        function locked(id){
        	$.post("/admin/userLocked",{userId:id},function(flag){
        		if(flag){
        			reload();
        		}
        	})
        }
        function unLocked(id){
        	$.post("/admin/userUnLocked",{userId:id},function(flag){
        		if(flag){
        			reload();
        		}
        	})
        }
        function gotoPage(pageNum){
        	$("[name=pageNum]").val(pageNum);
        	query();
        }
         $(function(){
        	 $.get("/channel/selectChannel",{},function(obj){
        		 for(var i in obj){
        			 $("#inputState").append("<option value='"+obj[i].name+"'>"+obj[i].name+"</option>")
        		 }
        	 })
        	
         })
	</script>
