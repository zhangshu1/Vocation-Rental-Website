<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>House Holder Profile</title>
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
	<div class="col-sm-3 sidenav">
	<img height="150" width="150" src="file://${householder.filename}" />
	</div>
	<div class="col-sm-9 sidenav">
	<p>Username: ${householder.userName}</p>
    <p>Email: ${householder.email}</p>
	</div>
	
	</div>

</body>
</html>