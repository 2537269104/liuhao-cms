<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<nav aria-label="Page navigation example col-4">
		<ul class="pagination">
		<c:if test="${!pageInfo.isFirstPage}">
		<li class="page-item "><a class="page-link" href="javascript:gotoPage(${pageInfo.prePage})">上一页</a></li>
		</c:if>
		
		<c:forEach items="${pageInfo.navigatepageNums}" var="page">
		      <c:if test="${pageInfo.pages>10 }">
		        <c:if test="${pageInfo.pageNum==page && (page>pageInfo.pageNum-3 || page<=pageInfo.pageNum+3) }">
		        <li class="page-item active"><a class="page-link" href="javascript:gotoPage(${page})">${page}</a></li>
		        </c:if>
		        <c:if test="${pageInfo.pageNum!=page && (page>pageInfo.pageNum-3 || page<=pageInfo.pageNum+3) }">
		        <li class="page-item "><a class="page-link" href="javascript:gotoPage(${page})">${page}</a></li>
		        </c:if>
		     </c:if>
		     <c:if test="${pageInfo.pages<=10 }">
		        <c:if test="${pageInfo.pageNum==page }">
		        <li class="page-item active"><a class="page-link" href="javascript:gotoPage('${page}')">${page}</a></li>
		        </c:if>
		        <c:if test="${pageInfo.pageNum!=page }">
		        <li class="page-item "><a class="page-link" href="javascript:gotoPage('${page}')">${page}</a></li>
		        </c:if>
		     </c:if>
		</c:forEach>
		<c:if test="${!pageInfo.isLastPage}">
		<li class="page-item "><a class="page-link" href="javascript:gotoPage(${pageInfo.nextPage})">下一页</a></li>
		</c:if>
		</ul>
	</nav>
