<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form method="post">
  <input type="hidden" name="${_csrf.parameterName}"
    value="${_csrf.token}" />
  <p>
    <input class="form-control" value="admin" placeholder="Username"
      type="text" name="username">
  </p>
  <p>
    <input class="form-control" value="123" placeholder="Password"
      type="password" name="password">
  </p>
  <p>
    <label> <input type="checkbox" name="remember" value="1">
      Remember me
    </label>
  </p>
  <p>
    <button class="btn btn-primary btn-lg">Log On</button>
  </p>
  <p class="center">
    <a href="${pageContext.request.contextPath}/auth/register.html">Register
      an Account</a>
  </p>
  <p class="center">
    <a href="${pageContext.request.contextPath}/auth/forgot.html">Forgot
      Password?</a>
  </p>
</form>
<c:if test="${not empty msg}">
  <div class="error">${msg}</div>
</c:if>