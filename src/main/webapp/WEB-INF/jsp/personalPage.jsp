	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
		<title>Insert title here</title>
	</head>
	
	<body>
		<div class="header">
			<div class="headBox">
				<h1>Personal Training Page</h1>
			</div>
		</div>
		<p>${logedUser}</p>
		
		<div class="body">
			<div class="container">
				<div class="box">
					<a href="\train">
						<img src="train_icon.png">
					</a>
					<a href="\train">Train</a>
				</div>
				<div class="box">
					<a href="\exercises">
						<img src="exercise_icon.png">
					</a>
					<a href="\exercises">Create exercise</a>
				</div>
				<div class="box">
					<a href="\sessions">
						<img src="session_icon.png">
					</a>
					<a href="\sessions">Create training session</a>
				</div>
				<div class="box">
					<a href="\">
						<img src="home_icon.png">
					</a>
					<a href="\">Logout</a>
				</div>
				<div class="box">
					<a href="\food">
						<img src="food_icon.png">
					</a>
					<a href="\food">Food programs</a>
				</div>
				<div class="box">
					<a href="\statistics">
						<img src="stats_icon.png">
					</a>
					<a href="\statistics">Statistics</a>
				</div>
			</div>
		
		</div>

	</body>

</html>