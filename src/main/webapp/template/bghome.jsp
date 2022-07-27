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
	<div class="nav">
		<div class="container">
			<div class="brand"><a href="${pageContext.request.contextPath}/home/list.html">Mini Shop</a></div>
			<div class="nav-right">
				<ul>
					<li><a href="${pageContext.request.contextPath}/cart/list.html">Cart</a></li>
					<c:choose>
						<c:when test="${pageContext.request.userPrincipal.name != null}">
							<li>
								Welcome <span>${pageContext.request.userPrincipal.name}</span>
								<form class="form-hidden" method="post" action="${pageContext.request.contextPath}/auth/logoff.html">
									<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
									<button>Log Off</button>
								</form>
							</li>
						</c:when>
						<c:otherwise>
							<li><a href="${pageContext.request.contextPath}/auth/logon.html">Log On</a></li>
							<li><a href="${pageContext.request.contextPath}/auth/register.html">Register</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
	</div>
	<div class="page">
		<div class="container">
			<div class="col-3">
<ul>
	<c:forEach items="${categories}" var="o">
		<c:if test="${o.parent eq 0}">
			<li>${o.name}</li>
			<ul>
			<c:forEach items="${categories}" var="child">
				<c:if test="${child.parent eq o.id}">
					<li><a href="${pageContext.request.contextPath}/home/browse.html?id=${child.id}">${child.name}</a></li>
				</c:if>
			</c:forEach>
			</ul>
		</c:if>
	</c:forEach>
</ul>
			</div>
			<div class="col-9">
				<div class="page-header"><tiles:insertAttribute name="title" /></div>
				<tiles:insertAttribute name="content" />
			</div>
			<div class="clear"></div>
		</div>
	</div>
</body>
</html>