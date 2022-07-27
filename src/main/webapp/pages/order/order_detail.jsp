<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="products">
	<div>Email: ${o.email}</div>
	<div>Tel: ${o.tel}</div>
	<div>Address: ${o.address}</div>
	<table class="table table-bordered">
		<tr><th>Title</th><th>Quantity</th><th>Price</th><th>Image</th></tr>
		<c:forEach items="${o.details}" var="detail">
			<tr>
				<td>${detail.title}</td>
				<td>${detail.quantity}</td>
				<td>${detail.price}</td>
				<td><img width="70px" src="${pageContext.request.contextPath}/upload/${detail.imageUrl}" ></td>
			</tr>
		</c:forEach>
	</table>
</div>