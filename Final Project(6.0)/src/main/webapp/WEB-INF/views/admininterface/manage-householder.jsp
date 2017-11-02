<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>Insert title here</title>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<div class="container" style="margin-top:70px">

	<h1>Manage House Holder</h1>  
    <form name="vinform">  
    <input type="text" name="name" onkeyup="searchInfo()" placeholder="Please enter the username"/>  
    </form>  
    <span id="result"></span> 
    
    <script>
		var request = new XMLHttpRequest();
		function searchInfo() {
			var name = document.vinform.name.value;
			var url = "${contextPath}/admin/results.htm?val=" + name;

			try {
				request.onreadystatechange = function() {
					if (request.readyState == 4) {
						var val = request.responseText;
						document.getElementById('result').innerHTML = val;
					}
				}//end of function  
				request.open("GET", url, true);
				request.send();
			} catch (e) {
				alert("Unable to connect to server");
			}
		}
	</script>
	<a href="${contextPath}/admin/results.htm">link</a>
</div>
</body>
</html>