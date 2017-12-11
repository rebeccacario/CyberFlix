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
		<h2 style="margin-left:125px">Login</h2>
 		<form action="http://localhost:8080/CyberFlix/CyberFlixLoginServlet" 
			method="post">
			Email: &nbsp; &nbsp; &nbsp; &nbsp;
			<input style="color: black" type="email" name="email"><br>
			Password: <input style="color: black" type="password" name="password">
			<button class="w3-button w3-round-xlarge"
				style="background: rgb(239, 192, 80); color:white; margin-bottom: 5px; margin-left: 5px;">Login</button>
		</form>
	</div>