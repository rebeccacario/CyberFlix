<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://localhost:8080/CyberFlix/CyberFlix.css">
<title>Movie Details</title>
</head>

<body background="http://localhost:8080/CyberFlix/inputFiles/Backgrounds/popcorn1.jpg" style="background-repeat: no-repeat; background-size: cover; background-attachment: fixed" >
	<%@ page import="java.util.List"%>
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
	<div class="w3-container padding" style="color: white;">
		<img
			src="http://localhost:8080/CyberFlix/inputFiles/images/moviePoster${film.posterImage}.jpg"
			alt="${film.title}" style="height: 500px; margin-right: 20px">
		<h3>${film.title}</h3>
		<br>
		<h5>Category: ${film.category}</h5>
		<h5>Running Time: ${film.length} min</h5>
		<h5>Year: ${film.releaseYear}</h5>
		<h5>Rated: ${film.rating}</h5>
		<h5>${film.description}</h5>
		<br><br><br>
		<h5>
			Actors:
			<c:forEach items="${film.actors}" var="actor" varStatus="loop">
					${actor.firstName} ${actor.lastName}<c:if test="${!loop.last}">,</c:if>
			</c:forEach>
		</h5>
		<br>
		<form action="http://localhost:8080/CyberFlix/CyberFlixAddToCartServlet"
								method="get"><button class="w3-button w3-round-xlarge" name="film" value="${film.title}"
								style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Add to Cart</button></form>
	</div>
</body>
</html>