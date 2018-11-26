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
		<div class="textBox">
			<p class="text border">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec ipsum non lorem hendrerit interdum. Cras at arcu urna. Fusce ornare ullamcorper imperdiet. Nunc id quam consequat, commodo massa vel, vehicula magna. Pellentesque quis neque egestas, convallis tellus sed, rutrum felis. Praesent tellus felis, iaculis nec felis nec, pellentesque tempor risus. Aenean a massa nisi. Vivamus massa est, posuere ut tincidunt nec, vulputate eget dolor. Donec sed quam egestas, pellentesque nisl non, cursus urna. Sed nec neque at quam sagittis tempus. Aliquam quis finibus ligula. Vestibulum vitae dolor ex.
			Pellentesque mattis eros sed nisi auctor, eget gravida mauris mollis. Etiam ac lectus pellentesque, ultricies ante nec, vehicula nisi. Morbi ac quam ut tortor aliquet sollicitudin id eu leo. Nam ut nisl efficitur, mollis nisl sed, dignissim odio. Etiam fringilla aliquam nisl non vehicula. Donec tempor, justo vitae fringilla molestie, odio lacus vulputate lorem, a ultricies risus est nec est. Suspendisse eget metus ut felis imperdiet facilisis ut non nisi. In hac habitasse platea dictumst. Nunc blandit nibh imperdiet ex varius sodales. Curabitur hendrerit suscipit lectus vitae fringilla. Nulla tempus posuere ante eget placerat. Sed et velit id mauris mattis venenatis in nec odio. Aenean non lectus eget sapien lobortis finibus vitae eu lorem. Curabitur pulvinar auctor sapien at mattis. Quisque a purus mi. In vulputate, lacus vitae consectetur vestibulum, ante orci porta ex, quis semper lorem mauris at mi.
			</p>
		</div>
		<div class="textBox">
			<p class="text border">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aenean nec ipsum non lorem hendrerit interdum. Cras at arcu urna. Fusce ornare ullamcorper imperdiet. Nunc id quam consequat, commodo massa vel, vehicula magna. Pellentesque quis neque egestas, convallis tellus sed, rutrum felis. Praesent tellus felis, iaculis nec felis nec, pellentesque tempor risus. Aenean a massa nisi. Vivamus massa est, posuere ut tincidunt nec, vulputate eget dolor. Donec sed quam egestas, pellentesque nisl non, cursus urna. Sed nec neque at quam sagittis tempus. Aliquam quis finibus ligula. Vestibulum vitae dolor ex.
			Pellentesque mattis eros sed nisi auctor, eget gravida mauris mollis. Etiam ac lectus pellentesque, ultricies ante nec, vehicula nisi. Morbi ac quam ut tortor aliquet sollicitudin id eu leo. Nam ut nisl efficitur, mollis nisl sed, dignissim odio. Etiam fringilla aliquam nisl non vehicula. Donec tempor, justo vitae fringilla molestie, odio lacus vulputate lorem, a ultricies risus est nec est. Suspendisse eget metus ut felis imperdiet facilisis ut non nisi. In hac habitasse platea dictumst. Nunc blandit nibh imperdiet ex varius sodales. Curabitur hendrerit suscipit lectus vitae fringilla. Nulla tempus posuere ante eget placerat. Sed et velit id mauris mattis venenatis in nec odio. Aenean non lectus eget sapien lobortis finibus vitae eu lorem. Curabitur pulvinar auctor sapien at mattis. Quisque a purus mi. In vulputate, lacus vitae consectetur vestibulum, ante orci porta ex, quis semper lorem mauris at mi.
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
				<a href="/personal">Personal training page</a>
			</div>
	
		    
		    <div class="box">
		    	<a href="/createUser">Create User</a>
		    </div>
			
		</div>
		</div>
			<p>${villa}</p>
			    
    	
	</div>
	</div>
	
	
	<canvas class="background"></canvas>
    </body>
    
</html>
