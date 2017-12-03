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
<title>登陆</title>
<link rel="icon" href="${ctxStatic }/img/favicon.ico">
<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap-theme.css" />
<link rel="stylesheet" type="text/css" href="${ctxStatic }/css/signin.css" />
<script type="text/javascript" src="${ctxStatic }/js/jquery-3.2.0.js"></script>
<script type="text/javascript" src="${ctxStatic }/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${ctxStatic }/js/md5.js"></script>
<script type="text/javascript" src="${ctxStatic }/js/admin.js"></script>
</head>
<body>
 <div class="container">
      <form class="form-signin" id="loginForm" action="${ctx }/admin/login" method="post">
        <h2 class="form-signin-heading">请登陆</h2>
        <label for="userName" class="sr-only">用户名</label>
        <input type="text" id="userName" name="userName" class="form-control" placeholder="请输入用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="请输入密码" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> 记住密码
          </label>
        </div>
        <c:if test="${errorMsg != null }">
        	<div class="alert alert-danger" role="alert">${errorMsg }</div>
        </c:if>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登陆</button>
      </form>
    </div>
</body>
</html>