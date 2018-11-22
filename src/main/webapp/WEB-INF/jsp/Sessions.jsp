<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

    <head>
        <title>Session</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    </head>
    <body>
	
	<div class="headBox">
		<h1>Sessions</h1>
	</div>
    
	<div class="body">
    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
	    <sf:form class="formBox" method="POST" modelAttribute="session" action="/sessions">
	    	
			<div class="input">
					<div class="inputBox">
						<p>Name:</p>
						<sf:input path="name" type="text" placeholder="Enter Name"/>
					</div>
					<p class="text inputBox">Here you can add the exercise name. Here is a <a href="http://travelstrong.net/bodyweight-exercises/">list of exercises</a></p>
			</div>
			
			<div class="input">
					<div class="inputBox">
						<p>Type:</p>
						<sf:input path="type" type="text" placeholder="Enter Type"/>
					</div>
					<p class="text inputBox">Text</p>
			</div>
			
			<div class="input">
					<div class="inputBox">
						<p>Exercises:</p>
						<form:select items="${allExercises}" multiple="true" path="exercises" itemLabel = "name" style="width: 300px"/>
					</div>
					<p class="text inputBox">Text</p>
			</div>
	
	        <input type="submit" VALUE="Create Session"/>
			
	    </sf:form>
  	</div>
	<%@include file="headerAndFooder/footer.jsp" %>
    </body>
    
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
    <script type="text/javascript">
    		$('option').mousedown(function(e) {
      		e.preventDefault();
        	    var originalScrollTop = $(this).parent().scrollTop();
        	    $(this).prop('selected', $(this).prop('selected') ? false : true);
        	    var self = this;
        	    $(this).parent().focus();
        	    setTimeout(function() {
        	        $(self).parent().scrollTop(originalScrollTop);
        	    }, 0);
        	    
        	    return false;
    		});
  	</script>
    
    
</html>


