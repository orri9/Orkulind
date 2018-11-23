<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
        <title>Statistics</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
<body>
	<h1>Statistcis</h1>
	<sf:form class="formBox" method="POST" modelAttribute="stats" action="/statistics">
		<table>
			<tr>
				<td>
					<form:select items="${allExercises}" itemLabel = "name" multiple="false" path="exercise"/>
				</td>
			</tr>
			<tr>
				<td>
					<label for="startDate">From:</label>
					<form:input type="date" id="startDate" path = "startDate"/>
					<label for="endDate">To:</label>
					<form:input type="date" id="endDate" path = "endDate"/>
				</td>
			</tr>
		</table>
		<input type="submit" VALUE="Get"/>
	</sf:form>
	
	<table>
		<tr>
			<td>
				Average Reps:
			</td>
			<td>
				${calcStats.averageReps}
			</td>
		</tr>
	</table>
</body>

</html>

