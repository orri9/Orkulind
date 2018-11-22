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
</head>
<body>
	<h1>Train</h1>
	
	<sf:form method="POST" modelAttribute="training" action="/train">

        <table>
            <tr>
            		<td>Session:</td>
            		<td>
            			<form:select items="${allSessions}" onchange="this.form.submit()" itemLabel = "name" multiple="false" path="session" style="width: 1000px"/>	
				</td>
            </tr>
            
        </table>

    </sf:form>
    <sf:form method="POST" modelAttribute="trainings" action="/finishTraining">
    		<table class="trains">
    			<c:forEach var="t" items="${trainings.trainingList}"  varStatus="vs">
        			<tr>
               	 	<td>${t.exercise.name}</td>
               	 	<td>
               	 	<sf:input path = "trainingList[${vs.index}].reps" type="text" placeholder="Enter Reps"/>
               	 	</td>
         		</tr>
       		</c:forEach>
   		</table>
   		
   		<input type="submit" VALUE="Finish"/>
   	</sf:form>
</body>
</html>