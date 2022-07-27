<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	<p>
		<input value="admin@yahoo.com.vn" type="email" class="form-control" placeholder="Email" name="email">
	</p>
	<p>
		<input value="admin" class="form-control" placeholder="Username" type="text" name="username"> 
	</p>
	<p>
		<input value="123" class="form-control" placeholder="Password" type="password" name="password">
	</p>
	<p>
		<input value="54677" type="number" class="form-control" placeholder="Tel" name="tel">
	</p>
	<p>
		<input value="hcm" type="text" class="form-control" placeholder="Address" name="address">
	</p>
	<p>
		<select name="gender">
			<option value="0">Male</option>
			<option value="1">Female</option>
			<option value="2">Undefined</option>
		</select>
	</p>
	<p>
		<button class="btn btn-primary btn-lg">Register</button>
	</p>
	<p class="center"><a href="${pageContext.request.contextPath}/login/logon.html">Log On</a></p>
	<p class="center"><a href="${pageContext.request.contextPath}/login/forgot.html">Forgot Password?</a></p>
</form>
<c:if test="${not empty msg}">
	<div class="error">${msg}</div>
</c:if>