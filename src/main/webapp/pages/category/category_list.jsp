<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h2>List Category</h2>

<a href="${pageContext.request.contextPath}/admin/category/add.html" class="btn btnprimary">Add</a>
<form method="post" action="${pageContext.request.contextPath}/admin/category/dels.html"> <!-- Sua sau -->
  <table class="table">
    <tr>
      <td><button class="btn btn-info">Delete</button></td>
      <th>Id</th>
      <th>Name</th>
      <th>Edit</th>
      <th>Delete</th>
    </tr>
    <c:forEach items="${list}" var="o">
      <tr>
        <td><input type="checkbox" value="${o.id}" name="ids">
        </td>
        <td>${o.id}</td>
        <td>${o.name}</td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/category/edit.html/${o.id}">         
            <img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit">
           </a>
        </td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/category/del.html/${o.id}">
            <img src="${pageContext.request.contextPath}/images/trash.png" alt="Delete">
          </a>
        </td>
      </tr>
    </c:forEach>
  </table>
</form>