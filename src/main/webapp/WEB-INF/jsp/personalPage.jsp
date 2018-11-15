	<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

	<head>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
		<title>Insert title here</title>
	</head>
	<body>
		<div class="headBox">
			<%@include file="headerAndFooder/header.jsp" %>
			<h1>Personal Training Page</h1>
		</div>
		
		<p>${logedUser}</p>
		<ul>
			<li> <a href="\train">Train</a> </li>
			<li> <a href="\sessions"> Create training session</a> </li>
			<li> <a href="\exercises"> Create a exercise</a> </li>
			<li> <a href="\"> Home </a> </li>
			<li> <a href="\food"> Food programs </a> </li>
		</ul>
	</body>

</html>