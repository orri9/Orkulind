<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Personal Training Page</h1>
<p>${logedUser}</p>
<ul>
	<li> <a href="\train">Train</a> </li>
	<li> <a href="\createSession"> Create training session</a> </li>
	<li> <a href="\exercises"> Create a exercise</a> </li>
	<li> <a href="\"> Home </a> </li>
	<li> <a href="\food"> Food programs </a> </li>
</ul>
</body>
</html>