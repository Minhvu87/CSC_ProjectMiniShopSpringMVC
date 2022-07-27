<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title" /></title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/css.css">
</head>
<body>
	<div class="panel-login">
		<div class="panel-heading">
			<h2 class="panel-title"><tiles:insertAttribute name="title" /></h2>
		</div>
		<div class="panel-body">
		<tiles:insertAttribute name="content" />
		</div>
	</div>
</body>
</html>