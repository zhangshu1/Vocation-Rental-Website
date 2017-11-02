<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Sign Up Page</title>
<style>
.navbar {
	margin-bottom: 0;
	background-color: #7a4928;
	border: 0;
	opacity: 0.9;
}

.navbar .navbar-brand {
	color: #fff !important;
}
</style>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">NEU Vocation Rentals</a>
		</div>
	</div>
	</nav>
	
    <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
	<form:form commandName="user" method="post" action="${contextPath}/user/signup.htm" enctype="multipart/form-data">
	<div class="container" style="margin-top:70px">
	<h1>Please fill in the blanks!</h1>
		<p>
			UserName:<input name="userName" />
		</p>
		<p>
			Password: <input name="password" />
		</p>
		<p>
			Email: <input name="email" />
		</p>
		<p>
			Create Album:<input type="text" name="filename" /><br />
		</p>
		<p>
			Select photo: <input type="file" name="photo" />
		</p>
		<p>
			<input type="submit" value="Create Account" />
		</p>
	</div>
	</form:form>
</body>
</html>