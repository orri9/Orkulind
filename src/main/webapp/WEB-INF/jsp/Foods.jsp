<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Food Programs</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <h1><a href="/food">Food Programs</a></h1>

    <sf:form method="POST" modelAttribute="Food" action="/postfood">

        <table>
            <tr>
                <td> Name:</td>
                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td> Meal:</td>
                <td><sf:input path="meal" type="text" placeholder="Enter Meal Type"/></td>
            </tr>
            <tr>
                <td> Recipe:</td>
                <td><sf:input path="recipe" type="text" placeholder="Enter Recipe"/></td>
            </tr>
            <tr>
                <td> Diet Type:</td>
                <td><sf:input path="diet" type="text" placeholder="Enter Diet Type"/></td>
            </tr>
            
        </table>

        <input type="submit" VALUE="Create Food Program"/>

    </sf:form>

            <tr>
   <c:choose>
        <c:when test="${not empty Food}">
            <table class="food">

                <c:forEach var="postfood" items="${Foods}">

                        <td><a href="/postfood/${postfood.name}">${postfood.name}</a></td>
                        <td>${postfood.meal}</td>
                        <td>${postfood.diet}</td>
                        <td>${postfood.recipe}</td>


                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No Food Programs!</h3>
        </c:otherwise>
    </c:choose>                
            </tr>

    </body>
</html>