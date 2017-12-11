<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://localhost:8080/CyberFlix/CyberFlix.css">
<title>Welcome to CyberFlix!</title>
</head>

<body background="http://localhost:8080/CyberFlix/inputFiles/Backgrounds/popcorn1.jpg" style="background-repeat: no-repeat; background-size: cover; background-attachment: fixed" >
	<div class="w3-container header">
		<h1>
			
        <c:choose>
	         	<c:when test="${empty cart}"> 
	        <form action="http://localhost:8080/CyberFlix/CyberFlixShowCartServlet" method="get">
	          	<button class="fa fa-shopping-cart hover" style="float:right; margin-right:15px; border:none; background: rgba(221, 65, 50, 0.75);"></button>
	        	</form>
	         	</c:when>
	        	<c:when test="${not empty cart}">
	        	<form action="http://localhost:8080/CyberFlix/CyberFlixShowCartServlet" method="get">
	          	<button class="fa fa-cart-plus hover" style="float:right; margin-right:15px; border:none; background: rgba(221, 65, 50, 0.75);"></button>
	        	</form>
	        	</c:when>
        	</c:choose> 
        	<i class="glyphicon glyphicon-cd" style="color: rgb(239, 192, 80)"></i> Welcome to
			CyberFlix!
        	<a href="http://localhost:8080/CyberFlix/login.jsp">
          	<span class="fa fa-user" style="float:right;"></span>
        	</a>
        	<a href="http://localhost:8080/CyberFlix/search.jsp">
          	<span class="glyphicon glyphicon-search" style="float:right; margin-right:10px"></span>
        	</a>
		</h1>
	</div>
	<div class="w3-container" style="color: white; padding-left: 70px">
		<h2>Let's Find You a Movie!</h2>
		<form action="http://localhost:8080/CyberFlix/CyberFlixServlet"
			method="get">
			Keyword(s): <input style="color: black" type="text" name="film_title">
			<button class="w3-button w3-round-xlarge" 
				style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Search</button>
			<br>
			Runtime: &nbsp; &nbsp; <input style="color: black" type="text" name="length">
			<br>
			<input type="radio" name="rating" value="G"> G
			<input type="radio" name="rating" value="PG"> PG
			<input type="radio" name="rating" value="PG_13"> PG-13
			<input type="radio" name="rating" value="R"> R
			<input type="radio" name="rating" value="NC_17"> NC-17
			<input type="radio" name="rating" value="X"> X
			<input type="radio" name="rating" value="UR"> UR
		</form>
		<h5 style="padding-left:173px; padding-bottom:15px">-or-</h5>
			<form action="http://localhost:8080/CyberFlix/CyberFlixCategoryServlet"
			method="get">
				<select name="category">
					<option value="action">Action</option>
					<option value="animation">Animation</option>
					<option value="children">Children</option>
					<option value="classics">Classics</option>
					<option value="comedy">Comedy</option>
					<option value="documentary">Documentary</option>
					<option value="drama">Drama</option>
					<option value="family">Family</option>
					<option value="foreign">Foreign</option>
					<option value="games">Games</option>
					<option value="horror">Horror</option>
					<option value="music">Music</option>
					<option value="new">New</option>
					<option value="scifi">Sci-Fi</option>
					<option value="sports">Sports</option>
					<option value="travel">Travel</option>
				</select>
			<button class="w3-button w3-round-xlarge"
				style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Browse by Category</button>
		</form>
		<h5 style="padding-left:173px; padding-bottom:15px">-or-</h5>
		<form action="http://localhost:8080/CyberFlix/CyberFlixServlet"
			method="get">
			Enter a Letter: <input style="color: black" type="text" name="letter" maxlength="1">
			<button class="w3-button w3-round-xlarge" 
				style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Browse Alphabetically</button>
			<br>
		</form>
	</div>
</body>
</html>