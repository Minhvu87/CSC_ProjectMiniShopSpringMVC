<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<div class="page-header">Edit Author</div>
<form method="post" class="form">
	<input type="hidden" name="id" value="${o.id}">
	<div>
		<label>Name</label> <input type="text" name="name" value="${o.name}">
	</div>
	<div>
		<button class="btn btn-primary">Save</button>
	</div>
</form>