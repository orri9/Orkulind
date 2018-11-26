<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

    <head>
        <title>Session</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    </head>
    <body>
	
	<div class="header">
			<div class="headBox">
		  			<h1>Create Session</h1>
			</div>
	</div>
    
	<div class="body">
		<div class="train">
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
			
			<div class="input submit">
				<div class=inputBox>
					<p>Here you can create your session when finish.</p>
					<input type="submit" VALUE="Create Session"/>
				</div>
			</div>
			
	    </sf:form>
	    
	    <sf:form class="formBox" method="POST" modelAttribute="session" action="/removeSession">
			<div class="input">
        		<table>
           		<tr>
            			<td></td>
            			<td>
            				<form:select items="${allSessions}" itemLabel = "name" multiple="false" path="id" style="width: 300px"/>
					</td>
            		</tr>
            
        		</table>
        
        		<input type="submit" VALUE="Remove"/>
			</div>
    		</sf:form>
    		</div>
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


