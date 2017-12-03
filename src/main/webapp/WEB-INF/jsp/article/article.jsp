<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="icon" href="${ctxStatic }/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="${ctxStatic }/css/common.css" />
<script type="text/javascript" src="${ctxStatic }/js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="${ctxStatic }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctxStatic }/js/pagination.js"></script>
<script type="text/javascript" src="${ctxStatic }/My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="${ctxStatic }/js/common.js"></script>
<script type="text/javascript" src="${ctxStatic }/js/article.js"></script>
</head>
<body>
	<div class="container">
		<form class="form-inline" name="form1" action="${ctx }/article" method="post">
			<div class="form-group">
			    <label for="inputDate">创建时间</label>
			    <input
					type="text" class="form-control" style="width: 180px" name="startDate"
					value="<fmt:formatDate value='${page.startDate}'
									pattern='yyyy-MM-dd HH:mm:ss' />" id="startDate"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',maxDate:'#F{$dp.$D(\'endDate\')||\'2020-10-01 00:00:00\'}'})" />
		  	</div>
		  	<div class="form-group">
			    <label for="inputDate"> - </label>
			    <input
					type="text" class="form-control" style="width: 180px" name="endDate"
					value="<fmt:formatDate value='${page.endDate}'
									pattern='yyyy-MM-dd HH:mm:ss' />" id="endDate"
					onFocus="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'2020-10-01 00:00:00'})" />
		  	</div>
		  	<div class="form-group">
			    <label for="title">标题</label>
			   	<input type="text" class="form-control" name="title" value="${page.title }"/>
		  	</div>
			<button type="submit" class="btn btn-primary" id="search">查询</button>
			<div class="tools">
				<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#addArticleModal">
				  新增
				</button>
				<button type="button" class="btn btn-primary" id="updateArticleBefore">
				  修改
				</button>
				<button type="button" class="btn btn-primary" id="deleteArticle">
				  删除
				</button>
			</div>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>选择</th>
						<th>栏目</th>
						<th>标题</th>
						<th>内容</th>
						<th>创建时间</th>
						<th>修改时间</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${page.datas == null}">
						<tr>
							<td colspan="5" align="center">
								未找到符合条件的数据
							</td>
						</tr>
					</c:if>
					<c:forEach items="${page.datas}" var="data" varStatus="status">
						<c:choose>
							<c:when test="${status.index == 1 }">
								<tr class="danger">
							</c:when>
							<c:when test="${status.index == 5 }">
								<tr class="success">
							</c:when>
							<c:otherwise>
								<tr>
							</c:otherwise>
						</c:choose>
							<td>
							<input value="${data.id}" name="checkedIds"
								type="checkbox" class="checkbox" />
							</td>
							<td>
								<c:choose>
									<c:when test="${data.columnId == 1 }">
										午夜
									</c:when>
									<c:when test="${data.columnId == 2 }">
										激情
									</c:when>
									<c:when test="${data.columnId == 9 }">
										公交车
									</c:when>
									<c:otherwise>
										其他
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								<a href="javascript:void(0)" class="tooltip-test" data-toggle="tooltip" data-placement="top" title="${data.title }">
									${fn:length(data.title) > 8 ? fn:substring(data.title,0,8) : data.title}
									${fn:length(data.title) > 8 ? '..' : ''}
								</a>
							</td>
							<td>
								<a href="javascript:void(0)" class="tooltip-test" data-toggle="tooltip" data-placement="top" title="${data.content }">
									${fn:length(data.content) > 8 ? fn:substring(data.content,0,8) : data.content}
									${fn:length(data.content) > 8 ? '..' : ''}
								</a>
							</td>
							<td>
								<fmt:formatDate value="${data.createDate}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td>
								<fmt:formatDate value="${data.updateDate}"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<%@ include file="../common/pagination.jsp"%>
		</form>
	</div>
	
	<!-- 新增文章 -->
	<div class="modal fade" id="addArticleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增文章</h4>
	      </div>
	      <div class="modal-body">
	      	<form role="form" id="addArticleForm" action="addArticle" method="post">
	      		<div class="form-group">
				    <label for="columnId">栏目id</label>
				    <input type="text" class="form-control" id="add_columnId" name="columnId" placeholder="请输入栏目">
			 	</div>
	      		<div class="form-group">
				    <label for="title">标题</label>
				    <input type="text" class="form-control" id="add_title" name="title" placeholder="请输入标题">
			 	</div>
				<div class="form-group">
				    <label for="content">内容</label>
				    <textarea class="form-control" rows="3" id="add_content" name="content" placeholder="请输入内容"></textarea>
			 	</div>  
	      	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="addArticle">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 修改文章 -->
	<div class="modal fade" id="updateArticleModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">修改文章</h4>
	      </div>
	      <div class="modal-body">
	      	<form role="form" id="updateArticleForm" action="updateArticle" method="post">
	      		<input type="hidden" id="update_id" name="id">      		
	      		<div class="form-group">
				    <label for="columnId">栏目id</label>
				    <input type="text" class="form-control" id="update_columnId" name="columnId">
			 	</div>
	      		<div class="form-group">
				    <label for="title">标题</label>
				    <input type="text" class="form-control" id="update_title" name="title">
			 	</div>
				<div class="form-group">
				    <label for="content">内容</label>
				    <textarea class="form-control" rows="3" id="update_content" name="content"></textarea>
			 	</div>  
	      	</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="updateArticle">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
</body>
</html>