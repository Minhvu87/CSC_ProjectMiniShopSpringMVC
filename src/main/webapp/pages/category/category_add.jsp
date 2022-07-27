<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<h2>Add Category</h2>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="post" modelAttribute="obj" cssClass="form">
  <p>
    <label>Name</label>
    <form:input path="name" />
  </p>
  <p>
    <label>Parent</label>
    <form:select path="parent">
      <form:option value="">--Select Parent--</form:option>
      <%-- <form:options items="${map}" /> --%>
      <form:options items="${list}" itemLabel="name" itemValue="id"/>
    </form:select>
  </p>
  <p>
    <button class="btn btn-primary">Save</button>
  </p>
</form:form>