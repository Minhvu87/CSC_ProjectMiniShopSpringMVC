<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="products">
  <table class="table table-bordered">
    <tr>
      <th>InvoiceId</th>
      <th>Email</th>
      <th>Tel</th>
      <th>Address</th>
      <th>AddedDate</th>
    </tr>
    <c:forEach items="${invoices}" var="in">
      <tr>
        <td>${in.id}</td>
        <td>${in.email}</td>
        <td>${in.tel}</td>
        <td>${in.address}</td>
        <td>${in.date}</td>
      </tr>
    </c:forEach>
  </table>
</div>