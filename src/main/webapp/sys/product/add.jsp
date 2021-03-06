<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML>
<html>
	<head>
		<base href="<%=basePath%>">

		<title>添加文章</title>

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>/static/jslib/bootstrap/css/bootstrap.css">
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>/static/css/theme.css">
			<link rel="stylesheet" type="text/css" href="<%=basePath%>jslib/bootstrap/css/bootstrap-datetimepicker.min.css">
		<link rel="stylesheet"
			href="<%=basePath%>/static/jslib/font-awesome/css/font-awesome.css">
		<script src="<%=basePath%>/static/jslib/jquery-1.7.2.min.js"
			type="text/javascript"></script>
		<script src="<%=basePath%>/static/jslib/bootstrap/js/bootstrap.min.js"></script>
		<script src="<%=basePath%>/static/jslib/bootstrap/js/bootstrap-datetimepicker.min.js"></script>
			<script src="<%=basePath%>/static/jslib/bootstrap/js/bootstrap-datetimepicker.zh-CN.js"></script>
            



	</head>

	<body class="content1">
		<div class="header">
			<h1 class="page-title">
				添加商品
			</h1>
		</div>

		<ul class="breadcrumb">
			<li>
				<a href="index.html">商品管理</a>
				<span class="divider">/</span>
			</li>
			<li class="active">
				添加商品
			</li>
		</ul>

		<div class="container-fluid">
				<div class="row-fluid">
				<div class="span12">
				</div>
				
				<form method="post" action="<%=basePath%>product/add" enctype="multipart/form-data">
					<div class="btn-toolbar">
						<input type="submit" class="btn btn-primary" style="background: #dea32c;" value="保存 ">
						<a href="<%=basePath%>product/list" class="btn">取消</a>

					</div>

					<div class="well">
						<div class="tab-pane active in">


							<label>
								商品名称：
							</label>
							<input type="text" name="pname" maxlength="100"
								>
							<label>
								商品原价格：
							</label>
							<input type="text" name="sprice" maxlength="100"
								>
							<label>
								商品现价：
							</label>
							<input type="text" name="cprice" maxlength="100"
								>
							<label>
								商品数量：
							</label>
							<input type="text" name="number" maxlength="100"
								>
							<label>
								商品描述：
							</label>
							<textarea rows="10" cols="30" name="pdesc"></textarea><br/>
								
							<label>
								热点：
							</label>
							
							<select  name="isHot">
								<option value="true">是</option>
								<option value="false">否</option>
							</select>
							
							<label>
								商品图片：
							</label>
							
   							<input type="file" name="file"/>

							<div style="color: red">
								${msg}
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>
