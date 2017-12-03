<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />

<script type="text/javascript" src="${ctxStatic}/js/pagination.js"></script>

<div class="Page navigation">
	<input type="hidden" id="qp_number" name="number" value="${page.number }">
	<input type="hidden" id="page_number" value="${page.number }">
	<ul class="pagination">
	<c:if test="${page.totalPages != 0}">
		<c:choose>
			<c:when test="${page.firstPage}">
			  <li class="disabled"><a>首页</a></li>
		      <li class="disabled"><a>上一页</a></li>
		    </c:when>
		    <c:otherwise>  
		       <li><a href="javascript:goPage('1');" class="prev">首页</a></li>
		       <li><a href="javascript:onPrev();" class="prev">上一页</a></li>
		    </c:otherwise>
	    </c:choose>
		<c:forEach var="x" begin="${page.beginPage}" end="${page.endPage}">
			<c:choose>
				<c:when test="${page.number==x}">
			      <li class="active"><a class="current">${x }</a></li>
			    </c:when>
			    <c:otherwise>  
			      <li><a href="javascript:goPage(${x });">${x }</a></li>
			    </c:otherwise>
		    </c:choose>
		</c:forEach>
		
		<c:choose>
			<c:when test="${page.lastPage}"> 
			  <li class="disabled"><a>下一页</a></li>
		      <li class="disabled"><a>最后一页</a></li>
		    </c:when>
		    <c:otherwise>  
		       <li><a href="javascript:onNext();" class="next">下一页</a></li>
		       <li><a href="javascript:goPage(${page.totalPages});" class="prev">最后一页</a></li>
		    </c:otherwise>
	    </c:choose>
	    <li class="disabled"><a>共${page.totalPages}页&nbsp;/&nbsp;总${page.totalElements}条</a></li>
	    <select id="selectNum" class="form-control" name="size" onchange="onSelectedSubmit()" >
	    				<option value="10" <c:if test="${page.size==10}">selected</c:if>>10</option>
	    				<option value="20" <c:if test="${page.size==20}">selected</c:if>>20</option>
	    				<option value="50" <c:if test="${page.size==50}">selected</c:if>>50</option>
	    				<option value="100" <c:if test="${page.size==100}">selected</c:if>>100</option>
	    				<option value="200" <c:if test="${page.size==200}">selected</c:if>>200</option>
	    </select>
	    <li><input type="text" name="goTo" id="goTo" class="form-control" style="width:50px"/>页<a href="javascript:goTo(${page.totalPages});" style="float:right;">跳转</a></li>
	</c:if>	

	</ul>
</div>
