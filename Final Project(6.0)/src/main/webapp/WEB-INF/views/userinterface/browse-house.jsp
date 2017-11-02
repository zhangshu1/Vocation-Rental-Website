<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Browse House</title>
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

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<div class="container" style="margin-top:70px">
	<h1>Search Location</h1>  
    <form name="vinform">  
    <input type="text" name="name" onkeyup="searchInfo()">  
    </form>  
  
<span id="mylocation"></span> 
	<table>
		<tr>
			<td>Title</td>
			<td>Photo</td>
		</tr>
		<c:forEach var="house" items="${houses}">
		<form action="${contextPath}/house/detail.htm" method = "get">
			<tr>
				<td>${house.title}</td>
				<td><img height="150" width="150" src="file://${house.filename}" /></td>
				<td><input type="submit" value="details" /><input type="hidden" name="house" value="${house.houseID}"/></td>
			</tr>
		</form>
		</c:forEach>
	</table>
	</div>

	<script>
		var request = new XMLHttpRequest();
		function searchInfo() {
			var name = document.vinform.name.value;
			var url = "useless.htm?val=" + name;

			try {
				request.onreadystatechange = function() {
					if (request.readyState == 4) {
						var val = request.responseText;
						document.getElementById('mylocation').innerHTML = val;
					}
				}//end of function  
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}
		}
	</script>
	<a href="${contextPath}/house/useless.htm">useless</a>
</body>
</html>