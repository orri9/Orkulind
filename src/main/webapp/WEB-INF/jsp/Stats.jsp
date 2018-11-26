<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>


<html lang="en">
	<head>
        <title>Statistics</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/styleIndex.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/header.css"/>"/>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/footer.css"/>"/>
    </head>
<body>
	<div class="header">
			<div class="headBox">
		  			<h1>Statistic</h1>
			</div>
	</div>
	
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
		<input type="submit" VALUE="Get Statistics"/>
	</sf:form>

	<div id="chartContainer" style="height: 350px; width: 700px;"></div>
	
	<table>
		<tr>
			<td>
				Average Reps:
			</td>
			<td>
				${calcStats.averageReps}
			</td>
		</tr>
		<tr>
			<td>
				Total Reps:
			</td>
			<td>
				${calcStats.totalReps}
			</td>
		</tr>
	</table>
	<%@include file="headerAndFooder/footer.jsp" %>
</body>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script type="text/javascript">
window.onload = function() {

var dps = [[]];
var chart = new CanvasJS.Chart("chartContainer", {
	theme: "light2", // "light1", "dark1", "dark2"
	animationEnabled: true,
	title: {
		text: "Progress",
		padding: 20
	},
	axisX: {
		valueFormatString: "D MMM"
	},
	axisY: {
		title: "Reps",
		gridThickness: 0.5
	},
	data: [{
		type: "line",
		xValueType: "dateTime",
		xValueFormatString: "D MMM a't' HH:mm",
		yValueFormatString: "#0 reps",
		dataPoints: dps[0]
	}]
});
 
var xValue;
var yValue;
<c:choose>
<c:when test="${not empty calcStats.dataPoints}">
<c:forEach items="${calcStats.dataPoints}" var="points" varStatus="loop">	
<c:forEach items="${points}" var="point">
	xValue = parseInt("${point.x}");
	yValue = parseFloat("${point.y}");
	dps[parseInt("${loop.index}")].push({
		x : xValue,
		y : yValue
	});		
</c:forEach>	
</c:forEach> 
chart.render();
</c:when>
</c:choose>
 
}
</script>

</html>

