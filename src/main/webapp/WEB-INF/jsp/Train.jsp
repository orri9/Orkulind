<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    	<link href="https://fonts.googleapis.com/css?family=Roboto" rel="stylesheet">
</head>
<body>
	
	<div class="header">
			<div class="headBox">
		  			<h1>Train</h1>
			</div>
	</div>
	
	<div class="body">
	<div class="train">
	
	<div class="trainCheckBox">
	
	
	<sf:form class="formBox" method="POST" modelAttribute="training" action="/train">
		<div class="input">
		
        <table>
            <tr>
            		<td>Session:</td>
            		<td>
            			<form:select path = "session" onchange="this.form.submit()" multiple="false" style="width: 300px">
            				<option disabled selected value> -- select a session -- </option>
            				<form:options items="${allSessions}" itemLabel = "name"/>
            			</form:select>
				</td>
            </tr>
            
        </table>
        
        </div>
    </sf:form>
	</div>
	
	
    <sf:form method="POST" modelAttribute="trainings" action="/finishTraining">
    			<c:forEach var="t" items="${trainings.trainingList}"  varStatus="vs">
        			
         			<div class="input">
					<div class="inputBox">
					<p>${t.exercise.name}</p>
					<p>Goal reps: ${t.exercise.reps}</p>
					<p>What type of rep: ${t.exercise.repType}
					<sf:input path = "trainingList[${vs.index}].reps" type="text" placeholder="Enter Reps"/>
					</div>
						<div class="videos">
							${t.exercise.info}
						</div>
					</div>
       			</c:forEach>
       			
		<div class="input submit">
				<div class="inputBox">
					<p>Here you can finish your training session</p>
			        <input type="submit" VALUE="Finish"/>
				</div>
		</div>
   	</sf:form>
   	</div>
   	</div>
   	<%@include file="headerAndFooder/footer.jsp" %>
</body>
</html>