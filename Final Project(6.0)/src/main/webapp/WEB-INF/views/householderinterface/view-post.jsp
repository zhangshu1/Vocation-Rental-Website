<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>View My Post</title>
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

<div class="container" style="margin-top:60px">
<table>
<c:forEach var="house" items="${results}">
		<form action="${contextPath}/house/detail.htm" method = "get">
			<tr>
				<td>${house.title}</td>&nbsp;&nbsp;&nbsp;&nbsp;
				<td>${house.location}</td>&nbsp;&nbsp;&nbsp;&nbsp;
				<td>${house.duration}</td>&nbsp;&nbsp;&nbsp;&nbsp;
				<td>${house.price}</td>&nbsp;&nbsp;&nbsp;&nbsp;
				<td><img height="150" width="150" src="file://${house.filename}" /></td>
				<td></td>
			</tr>
		</form>
</c:forEach>
</table>
</div>
</body>
</html>