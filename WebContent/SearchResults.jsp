<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://localhost:8080/CyberFlix/CyberFlix.css">
<title>Search Results</title>
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
	<div class="w3-container" style="height: 100vh">
		<c:choose>
			<c:when test="${not empty films}">
				<c:forEach items="${films}" var="film">
					<a href="${detailServlet}?film_title=${film.title}"
						style="text-decoration: none">
						<div class="card red hover" style="color: white">
							<img
								src="http://localhost:8080/CyberFlix/inputFiles/images/moviePoster${film.posterImage}.jpg"
								alt="${film.title}"
								style="float: left; width: auto; height: 100%; margin-right: 10px">
							<h3>${film.title}</h3>
							<h5>Running Time: ${film.length} min </h5>
							<h5>Year: ${film.releaseYear}</h5>
							<h5>Rated: ${film.rating}</h5>
							<h5>${film.description}</h5>
						</div>
					</a>
					<form action="http://localhost:8080/CyberFlix/CyberFlixAddToCartServlet"
								method="get"><button class="w3-button w3-round-xlarge" name="film" value="${film.title}"
								style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Add to Cart</button></form>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<div class="page" style="color: white">
					<h3>
						&nbsp; &nbsp; &nbsp; &nbsp; No Films were found matching your
						search results <i class="fa fa-frown-o" style="color: white"></i>
					</h3>
					<button class="w3-button w3-round-xlarge"
						style="margin-left: 250px; background: rgb(239, 192, 80)" name="back" onclick="history.back()">Go
						Back</button>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</body>
</html>