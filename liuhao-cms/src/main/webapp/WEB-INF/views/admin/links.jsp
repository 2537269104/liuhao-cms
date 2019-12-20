<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
  	<form class="form-inline" id="queryForm">
	  <div class="form-group mx-sm-3 mb-2">
	    <input type="text" name="name" class="form-control" placeholder="请输入名称">
	  </div>
	  <input type="hidden" name="pageNum" value="${pageInfo.pageNum }">
	  <button type="button" class="btn btn-primary mb-2" onclick="query()">查询</button>
	</form>
  	<table class="table">
  <thead>
    <tr>
      <th scope="col"><input type="checkbox" value="" id="chkALL" name="chkALL"></th>
      <th scope="col">#</th>
      <th scope="col">名称</th>
      <th scope="col">URL</th>
      <th scope="col">创建时间</th>
      <th scope="col">操作</th>
    </tr>
  </thead>
  <tbody>
	 <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
  </tbody>
</table>
