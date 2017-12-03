<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String requestPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
%>
<c:set var="ctx" value="${requestPath }" />

<nav aria-label="Page navigation">
	<ul class="pagination">
		<c:choose>
			<c:when test="${page.firstPage }">
				<li class="disabled">
					<a href="javascript:void(0)" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:when>
			<c:otherwise>
				<li>
					<a href="${ctx }?number=${page.number - 1 }" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
					</a>
				</li>
			</c:otherwise>
		</c:choose>
		<c:forEach var="x" begin="${page.beginPage}" end="${page.endPage}">
			<c:choose>
				<c:when test="${page.number == x}">
					<li class="active"><a class="current">${x }</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="${ctx }?number=${x }">${x }</a></li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:choose>
			<c:when test="${page.lastPage }">
				<li class="disabled">
					<a href="javascript:void(0)" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:when>
			<c:otherwise>
				<li>
					<a href="${ctx }?number=${page.number + 1 }" aria-label="Next"> 
						<span aria-hidden="true">&raquo;</span>
					</a>
				</li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>