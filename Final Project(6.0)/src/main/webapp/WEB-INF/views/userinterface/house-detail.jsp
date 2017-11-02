<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>House Detail</title>
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
<div class="container" style="margin-top:60px">
<img height=500px width=100% src="file://${house.filename}" />
<form action="${contextPath}/travelplan/create.htm" method="get">
<h1>${house.title}</h1>
<p>Address: ${house.location}</p>
<p>${house.description}</p>
<input type="submit" value="Create your own travel plan"/>&nbsp;&nbsp;&nbsp;
<a onclick=openCheckOut()>Check out</a>
</form>

    <!--check out div begins-->
    <div id="checkout" style="display:none; position: fixed; left:50%; top:50%; width:600px; height:400px; margin-left:-300px; margin-top:-200px; border:1px solid #888; text-align:center; background-color: white; opacity: 0.8">
        <div>
            <br>
            <h1>Please confirm the information below</h1>
            <br>  
        <form action="${contextPath}/request/send.htm" method = "get">
        <p>${house.title}</p>   
        <div class="form-group">
        </div>

        <div class="form-group">
        <p>Address: ${house.location}</p>
        </div>
        
        <input type="hidden" name="house" value="${house.houseID}" />
        <input type="hidden" name="user" value="${user.personID}" />
        <input type="hidden" name="householder" value="${house.owner.personID}" /><!--null-->
        <input class="btn" type="submit" value="Place order" >&nbsp;&nbsp;&nbsp;
        <a href="javascript:closeCheckOut();">cancel</a>
        </form>
        </div>
    </div>
    <!--check out div ends-->
   
    </div>
    
    <script>
    function openCheckOut(){
    document.getElementById("checkout").style.display="";
    }
    function closeCheckOut(){
    document.getElementById("checkout").style.display="none";
    } 
    </script>
</body>
</html>