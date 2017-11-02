<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create post of your house!</title>
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
		<ul class="nav navbar-nav navbar-right">
        <li><a href="logout.htm">Log out</a></li>
        </ul>
	</div>
	</nav>
<div class="container" style="margin-top:70px">	
<h1>Create post of your house!</h1>
	<c:set var = "contextPath" value = "${pageContext.request.contextPath}" />
	<form:form id="house" commandName = "house" action="${contextPath}/house/add.htm"  method="post" enctype="multipart/form-data">
		<p>
		    Title: <input type="text" name="title" required/>
		</p>
		<p>
			Address: <input type="text" name="location" placeholder="Street, City, State" required/>
		</p>
		<p>
			Duration: <input type="text" name="duration" required/>
		</p>
		<p>
			Price: $<input type="text" name="price" required/>
		</p>
		<p>
			Create Album: <input type="text" name="filename" required/>
		</p>
		<p>
			Select Photo: <input type="file" name="photo" />
		</p>
		<p>
			Description:
			<textarea name="description" required></textarea>
		</p>
		<input type = "submit" value = "Save">
	</form:form>
</div>	
</body>
</html>