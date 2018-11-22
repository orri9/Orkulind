<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Exercises</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    </head>
    <body>

		<div class="headBox">
			<h1>Create Exercises</h1>
		</div>
		
    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
    <div class="body">
	    <sf:form class="formBox" method="POST" modelAttribute="exercise" action="/exercises">
			
			<div class="input">
				<div class="inputBox">
					<p>Exercise name:</p>
					<sf:input path="name" type="text" placeholder="Enter Name"/>
				</div>
				<p class="text inputBox">Here you can add the exercise name. Here is a <a href="http://travelstrong.net/bodyweight-exercises/">list of exercises</a></p>
			</div>
			
			<div class="input">
				<div class="inputBox">
					<p>Targeted area to train:</p>
					<sf:input path="type" type="text" placeholder="Enter Type"/>
				</div>
				<p class="text inputBox">Here you can write what area your exercise is targeting.</p>
			</div>
			
			<div class="input">
				<div class="inputBox">
					<p>Rep Type:</p>
		        	<sf:input path="repType" type="text" placeholder="Enter Rep Type"/>
				</div>
				<p class="text inputBox">Here you can write what your rep is based on time or reps.</p>
			</div>
			
			<div class="input">
				<div class="inputBox">
					<p>Reps:</p>
			        <sf:input path="reps" type="text" placeholder="Enter Reps"/>
				</div>
				<p class="text inputBox">How many reps you want to do in your exercise</p>
			</div>
			
			<div class="input">
				<div class="inputBox">
					<p>Info:</p>
			        <sf:textarea path="info" type="text" placeholder="Enter Info"/>
				</div>
				<p class="text inputBox"> Some info about exercise </p>
			</div>
			
			<div>
		    	<input type="submit" VALUE="Create Exercise"/>	
			</div>
	    </sf:form>
	    
    </div>
    
  
	<%@include file="headerAndFooder/footer.jsp" %>
    </body>
</html>
