<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
        <title>Create User</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    </head>
<body>
	
	<div class="header">
			<div class="headBox">
		  			<h1>Create User</h1>
			</div>
	</div>
	
	<div class="body">
	<div class="train">
		
		<div class="input submit">
				<a href="/" class="text inputBox">Heim</a>
		</div>
		
	<sf:form  class="formBox" method="POST" modelAttribute="storeUser" action="/storeUser">

	<p>${creatUser}</p>
				
				<div class="input">
				<div class="inputBox">
					<p>Exercise name: ${villa}</p>
					<sf:input path="name" type="text" placeholder="Enter Name"/>
				</div>
				<p class="text inputBox">Here you can add the exercise name. Here is a <a href="http://travelstrong.net/bodyweight-exercises/">list of exercises</a></p>
				</div>
				
				<div class="input">
				<div class="inputBox">
					<p>Exercise name: ${villa}</p>
					<sf:input path="password" type="password" placeholder="Enter Type"/>
				</div>
				<p class="text inputBox">Here you can add the exercise name. Here is a <a href="http://travelstrong.net/bodyweight-exercises/">list of exercises</a></p>
				</div>
                
                <div class="input submit">
				<div class="inputBox">
					<p>Here you can create you exercises when finish.</p>
			        <input type="submit" VALUE="Create user"/>
				</div>
			</div>
    </sf:form>
	</div>
	</div>
	
</body>
</html>

