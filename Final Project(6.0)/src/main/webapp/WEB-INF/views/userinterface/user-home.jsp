<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Home</title>
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
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand">NEU Vocation Rentals</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
        <li><a href="${contextPath}/logout.htm">Log out</a></li>
        </ul>
	</div>
	</nav>
<div class="container" style="margin-top:70px">	
<h1>Welcome ${user.userName}</h1>

<ul>
<li><form action = "${contextPath}/request/browse.htm" method="get">
    <input type="hidden" name="user" value="${user.personID}"/>
    <input type="submit" value="Inbox" />
    </form>
</li>
<li><a href = "${contextPath}/house/browse.htm">Browse Posts</a></li>
<li><a href = "${contextPath}/user/view.htm">View My Profile</a></li>
<li><a href = "${contextPath}/request/history.htm">Order History</a></li>
</ul>
</div>
</body>
</html>