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
		
		<div class="body">
			<div class="container">
				<div class="box">
					<a href="\train">
						<img  width="800" height="450" src="https://36iusc2tb88y2g492si2bqd1-wpengine.netdna-ssl.com/wp-content/uploads/2017/10/overfat-exercise-cartoon.jpg">
					</a>
					<a href="\train">Train</a>
				</div>
				<div class="box">
					<a href="\exercises">
						<img class="alignnone size-medium wp-image-1003" src="http://www.eurobusinessmedia.com/app/uploads/2015/05/writer.jpg?w=291" alt="writer" width="291" height="300">
					</a>
					<a href="\exercises">Create exercise</a>
				</div>
				<div class="box">
					<a href="\sessions">
						<img src="https://elearningindustry.com/wp-content/uploads/2015/12/7-tips-to-create-effective-elearning-assessments-to-measure-online-training-e1450261977656.jpg">
					</a>
					<a href="\sessions">Create training session</a>
				</div>
				<div class="box">
					<a href="\">
						<img src="https://us.123rf.com/450wm/clairev/clairev1103/clairev110300155/9199593-small-family-house-.jpg?ver=6" alt="Image result for cartoon home">
					</a>
					<a href="\">Home</a>
				</div>
				<div class="box">
					<a href="\food">
						<img src="https://previews.123rf.com/images/clairev/clairev1306/clairev130600087/20458429-%E9%87%8E%E8%8F%9C%E3%81%AE%E3%83%86%E3%83%BC%E3%83%9E-%E3%82%B3%E3%83%AC%E3%82%AF%E3%82%B7%E3%83%A7%E3%83%B3.jpg">
					</a>
					<a href="\food">Food programs</a>
				</div>
			</div>
		
		</div>
		
		<ul>
			<li> <a href="\train">Train</a> </li>
			<li> <a href="\sessions"> Create training session</a> </li>
			<li> <a href="\exercises"> Create a exercise</a> </li>
			<li> <a href="\"> Home </a> </li>
			<li> <a href="\food"> Food programs </a> </li>
		</ul>
	</body>

</html>