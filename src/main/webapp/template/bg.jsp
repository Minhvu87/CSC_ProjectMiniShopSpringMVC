<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="title">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}">MiniShop</a></div>
		</div>
	</div>
	<div class="sidebar">
		
		<ul>
			<li><a href="${pageContext.request.contextPath}/home/list.html">Home</a></li>
			<li><a href="${pageContext.request.contextPath}/auth/logon.html">Log On</a></li>
			<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/publisher/index.html">Publisher</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/author/list.html">Author</a></li>
			<li><a href="${pageContext.request.contextPath}/admin/category/list.html">Category</a></li>
		</ul>
	</div>
	<div class="main">
		<tiles:insertAttribute name="content" />
	</div>
</body>
</html>