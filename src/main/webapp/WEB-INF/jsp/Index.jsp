<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
        <title>Project Title</title>
    </head>
    <body>
	
	<div class="header">
		<div class="headBox">
	    <%@include file="headerAndFooder/header.jsp" %>
		</div>
	</div>
	<div class="homePage">
	<div >
		<div class="textBox icon>
				<img src="logo_icon.png">
			
		</div>

		<div class="textBox">
			<p class="text border">
				Orkulind is a website with ways to refine your lifestyle, fitness and diet. We help people change what needs to be changed to gain 
				better health and a better life. Orkulind attaches great importance to keeping track of everything that happens in the large and 
				complex world of healthcare industry, bringing it to its customers in the simplest and most understandable way.
			</p>
		</div>
		
		<div class=header>
		<div class="loginBox">
			
		    
		    <sf:form method="POST" modelAttribute="user" action="/log">
			<table class="login">
		            <tr>
		                <td> Name:</td>
		                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
		                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
		            </tr>
		            <tr>
		                <td> password:</td>
		                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
		                <td><sf:input path="password" type="password" placeholder="Enter Type"/></td>
		            </tr>
		        </table>
		
		        <input type="submit" VALUE="Login"/>
		    </sf:form>
		    
			
		    <div class="box">
		    	<p>${villa}</p>
		    	<a class="blackText" href="/createUser">Create User</a>
		    </div>
			
		</div>
		</div>
			    
	</div>
	</div>
    </body>
    
</html>
