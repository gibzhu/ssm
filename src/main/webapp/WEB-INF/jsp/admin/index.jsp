<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="ctxStatic" value="${pageContext.request.contextPath}/static" />
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>首页</title>
		<link rel="icon" href="${ctxStatic }/img/favicon.ico">
		<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${ctxStatic }/bootstrap/css/bootstrap-theme.css" />
		<!--为了增强跨浏览器表现的一致性，我们使用了 Normalize.css，这是由 Nicolas Gallagher 和 Jonathan Neal 维护的一个CSS 重置样式库-->
		<link rel="stylesheet" type="text/css" href="${ctxStatic }/css/normalize.css" />
		<link rel="stylesheet" type="text/css" href="${ctxStatic }/css/main.css" />
		<script type="text/javascript" src="${ctxStatic }/js/jquery-3.2.0.js"></script>
		<script type="text/javascript" src="${ctxStatic }/bootstrap/js/bootstrap.min.js"></script>
	</head>

	<body>
		<!--页头-->
		<header>
			<nav class="navbar navbar-inverse">
				<div class="container">
					<!-- Brand and toggle get grouped for better mobile display -->
					<div class="navbar-header">
						<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					        <span class="sr-only">Toggle navigation</span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
					        <span class="icon-bar"></span>
				      	</button>
						<a class="navbar-brand" href="#">
							<img class="logo" alt="Google logo" src="${ctxStatic }/img/googlelogo.png">
						</a>
					</div>

					<!-- Collect the nav links, forms, and other content for toggling -->
					<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
						<ul class="nav navbar-nav">
							<li class="active">
								<a href="#">首页 <span class="sr-only">(current)</span></a>
							</li>
							<li>
								<a href="#">Boostrap</a>
							</li>
							<li>
								<a href="#">Java</a>
							</li>
							<li class="dropdown">
								<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">其他 <span class="caret"></span></a>
								<ul class="dropdown-menu">
									<li>
										<a href="#">PHP</a>
									</li>
									<li>
										<a href="#">Python</a>
									</li>
									<li>
										<a href="#">C#</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">C++</a>
									</li>
									<li role="separator" class="divider"></li>
									<li>
										<a href="#">.Net</a>
									</li>
								</ul>
							</li>
						</ul>
						<form class="navbar-form navbar-left">
							<div class="form-group">
								<input type="text" class="form-control" placeholder="Search">
							</div>
							<button type="submit" class="btn btn-default">Submit</button>
						</form>
						<ul class="nav navbar-nav navbar-right">
							<li>
								<a href="#">关于我们</a>
							</li>
						</ul>
					</div>
					<!-- /.navbar-collapse -->
				</div>
				<!-- /.container-fluid -->
			</nav>
		</header>
		<div class="container" id="main">
			<div class="row">
				<div class="col-sm-4 col-md-4">
					<button type="button" class="btn btn-primary btn-lg btn-block">管理员菜单</button>
					<shiro:hasPermission name="admin:menu">
						<shiro:hasPermission name="user:userList">
							<button type="button" class="btn btn-primary btn-lg btn-block">用户管理</button>
						</shiro:hasPermission>
						<shiro:hasPermission name="role:roleList">
						<button type="button" class="btn btn-primary btn-lg btn-block">角色管理</button>
						</shiro:hasPermission>
						<shiro:hasPermission name="function:functionList">
						<button type="button" class="btn btn-primary btn-lg btn-block">权限管理</button>
						</shiro:hasPermission>
						<shiro:hasPermission name="article:articleList">
						<button type="button" class="btn btn-primary btn-lg btn-block">用户管理</button>
						</shiro:hasPermission>
					</shiro:hasPermission>
				</div>
				<div class="col-sm-8 col-md-8">
					<h1>主页面</h1>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. At ipsum minus temporibus modi deserunt voluptates voluptas maiores vel tempore id esse amet blanditiis libero odit impedit laborum dignissimos perferendis. Unde.</p>
				</div>
			</div>
		</div>
		<!--页尾-->
		<footer class="footer">
			<div class="wrap">
				<p>版权所有，保留一切权利！© 2017-2018 zhuwenbin</p>
				<div class="container">
					<div class="row">
						<div class="col-sm-4 col-md-4">
							<div class="relaction">
								<h2>友情链接</h2>
								<ul>
									<li>Cras justo odio</li>
									<li>Dapibus ac facilisis in</li>
									<li>Morbi leo risus</li>
									<li>Porta ac consectetur ac</li>
									<li>Vestibulum at eros</li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 col-md-4">
							<div class="relaction">
								<h2>友情链接</h2>
								<ul>
									<li>Cras justo odio</li>
									<li>Dapibus ac facilisis in</li>
									<li>Morbi leo risus</li>
									<li>Porta ac consectetur ac</li>
									<li>Vestibulum at eros</li>
								</ul>
							</div>
						</div>
						<div class="col-sm-4 col-md-4">
							<div class="relaction">
								<h2>友情链接</h2>
								<ul>
									<li>Cras justo odio</li>
									<li>Dapibus ac facilisis in</li>
									<li>Morbi leo risus</li>
									<li>Porta ac consectetur ac</li>
									<li>Vestibulum at eros</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</footer>
	</body>

</html>