<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<form class="form-inline">
	<input type="hidden" name="pageNum" value="${pageInfo.pageNum}">
	<div class="form-group mx-sm-3 mb-2">
		<input type="text" class="form-control" name="title"
			value="${article.title}" placeholder="请输入文章标题">
	</div>
	<div class="form-group mx-sm-3 mb-2">
		<select id="inputState" class="form-control" name="channel_name">
			<option selected value="">请选择频道...</option>
			<c:forEach items="${channelList }" var="item">
	     		<c:if test="${item.name==article.channel_name }">
			        <option value="${item.name }" selected="selected">${item.name }</option>
	     		</c:if>
	     		<c:if test="${item.name!=article.channel_name }">
			        <option value="${item.name }">${item.name }</option>
	     		</c:if>
	     	</c:forEach>
		</select>
	</div>
	<div class="form-group mx-sm-3 mb-2">
		<select id="inputState2" class="form-control"  name="status">
			<option selected value="">请选择审核状态...</option>
			<option  value="0" <c:if test="${article.status==0 }">selected="selected"</c:if>>未审核</option>
			<option  value="1" <c:if test="${article.status==1 }">selected="selected"</c:if>>审核通过.</option>
			<option  value="-1"<c:if test="${article.status==-1 }">selected="selected"</c:if>>审核未通过.</option>
		</select>
	</div>
	<button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
</form>
<table class="table">
	<thead>
		<tr>
			<th scope="col">
			 <input type="checkbox" onclick="choose(this)">
			</th>
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
				<td>${article.id}</td>
				<td>${article.title}</td>
				<td>${article.channel_name}</td>
				<td>${article.category_name}</td>
				<td>${article.hot<=0?"非热点":"热点"}</td>
				<td><c:if test="${article.status==0}">
						          已审核
						    </c:if> <c:if test="${article.status==1}">
						         审核通过
						    </c:if> <c:if test="${article.status==-1}">
						          审核未通过
						    </c:if></td>
				<td>
				 <fmt:formatDate pattern="yyyy-MM-dd HH:mm" value="${article.created}"/>
				        
				</td>

				<td><input type="button" class="btn btn-primary" value="审核"
					onclick="check(${article.id})">
					<input type="button" class="btn btn-primary" value="加热"
					onclick="addHot(${article.id})"></td>
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
<div class="alert alert-danger" role="alert" style="display: none"></div>

<div class="modal" tabindex="-1" role="dialog" id="checkModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">文章审核</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="checkForm">
        	<input type="hidden" id="id" name="id">
        	<div class="form-check">
			  <input class="form-check-input" type="radio" name="status" value="1" checked>
			  <label class="form-check-label" for="exampleRadios1">
			    	审核通过
			  </label>
			</div>
			<div class="form-check">
			  <input class="form-check-input" type="radio" name="status" value="-1" checked>
			  <label class="form-check-label" for="exampleRadios1">
			    	审核不通过
			  </label>
			</div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
        <button type="button" class="btn btn-primary" onclick="toCheck();">确定</button>
      </div>
    </div>
  </div>
</div>
<script>
     //添加修改 
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
	  //全选,全不选
	  function choose(own){
		  $("[name=check]").attr("checked",own.checked)
	  }
	  //审核
	  function check(id){
		  $.post("/article/checkArticle",{id:id},function(flag){
			  if(flag){
				  alert("审核通过");
				  query();
			  }
		  })
	  }
	  //加热
	  function addHot(id){
		  $.post("/article/addHot",{id:id},function(flag){
			  if(flag){
				  query();
			  }
		  })
	  }
        function gotoPage(pageNum){
        	$("[name=pageNum]").val(pageNum);
        	query();
        }
        
       function toCheck(){
    		var data = $('#checkForm').serialize();
    		console.log("data:"+data);
    		$.post("/admin/article/update/status",data,function(res){
    			$('#checkModal').modal('hide');
    			$('.alert').html("审核通过");
    			$('.alert').show();
    			query();
    		});
    	}
       function view(id){
   		window.open("/article/"+id+".html");
   	}
	</script>
