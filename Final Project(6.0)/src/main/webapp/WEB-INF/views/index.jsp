<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>NEU Vacation Rentals</title>
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

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 100%;
	height: 580px;
	margin: auto;
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
			<li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Sign Up</a>
               <ul class="dropdown-menu">
                 <li><a href="person/householder.htm">Sign up for householder</a></li>
                 <li><a href="person/user.htm">Sign up for user</a></li>
               </ul></li>
			<li><a onclick = openLogin() href="#">Log in</a></li>
		</ul>
	</div>
	</nav>

	<div class="container" style="margin-top:70px">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src="file:///Users/zhangshu/Documents/workspace-sts-3.8.3.RELEASE/Final%20Project(6.0)/images/carousel01.jp2" alt="carousel01" width="460" height="345">
				</div>

				<div class="item">
					<img src="file:///Users/zhangshu/Documents/workspace-sts-3.8.3.RELEASE/Final%20Project(6.0)/images/carousel02.jp2" alt="carousel02" width="460" height="345">
				</div>

				<div class="item">
					<img src="file:///Users/zhangshu/Documents/workspace-sts-3.8.3.RELEASE/Final%20Project(6.0)/images/carousel03.jpg" alt="carousel03" width="460" height="345">
				</div>

				<div class="item">
					<img src="file:///Users/zhangshu/Documents/workspace-sts-3.8.3.RELEASE/Final%20Project(6.0)/images/carousel04.jpg" alt="carousel04" width="460" height="345">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> 
			<a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
    </div>
    
    <!--login div begins-->
    <div id=login style="display:none; position: fixed; left:50%; top:50%; width:600px; height:400px; margin-left:-300px; margin-top:-200px; border:1px solid #888; text-align:center; background-color: white; opacity: 0.8">
        <div>
            <br>
            <h1>Log in</h1>
            <br>
        <form onsubmit="return docheck()" action="login.htm" method = "get">
        
        <div class="form-group">
        <label for="username">Username:</label>
        <input id="username" type="text" name="username" class="form-control"  style="width: 80%; margin-left: 10%" required>
        </div>

        <div class="form-group">
        <label for="password">Password:</label>
        <input id="password" type="password" name="password" class="form-control" style="width: 80%; margin-left: 10%" required>
        </div>
        
        <div class="form-group">
        <input type="radio" name="role" value="householder" />&nbsp;Householder&nbsp;&nbsp;&nbsp;
        <input type="radio" name="role" value="user" />&nbsp;User<br>&nbsp;&nbsp;&nbsp;
        <input type="radio" name="role" value="admin" />&nbsp;Admin<br>
        </div>
        
        <a href="javascript: checkform()；"><input class="btn" type="submit" value="Log in" ></a>&nbsp;&nbsp;&nbsp;
        <a href="javascript:closeLogin();">cancel</a>
        </form>
        </div>
    </div>
    <!--login div ends-->
    
    <script>
    function openLogin(){
    document.getElementById("login").style.display="";
    }
    function closeLogin(){
    document.getElementById("login").style.display="none";
    } 
    </script>

</body>
</html>