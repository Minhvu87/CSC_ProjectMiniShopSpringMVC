<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<a href="${pageContext.request.contextPath}/admin/author/add.html" class="btn btnprimary">Add</a>

<form method="post" action="${pageContext.request.contextPath}/admin/author/dels.html">
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
          <a href="${pageContext.request.contextPath}/admin/author/edit.html/${o.id}">
            <img src="${pageContext.request.contextPath}/images/edit.png" alt="Edit">
          </a>
        </td>
        <td>
          <a href="${pageContext.request.contextPath}/admin/author/del.html/${o.id}">
           <img src="${pageContext.request.contextPath}/images/trash.png" alt="Delete">
          </a>
        </td>
      </tr>
    </c:forEach>
  </table>
</form>