<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Food Page</title>
    </head>
    <body>

    <h1>Food Page</h1>
    <p>Some food information</p>

    <table border="1px black">
        <thead>
            <tr style="font-weight: 600;">
                <td>Name</td>
                <td>Meal</td>
                <td>Recipe</td>
                <td>Diet</td>
            </tr>
        </thead>

        <tbody>
            <tr>
   <c:choose>
        <c:when test="${not empty food}">
            <table class="food">

                <c:forEach var="food" items="${Food}">

                        <td><a href="/food/${food.name}">${food.name}</a></td>
                        <td>${food.name}</td>
                        <td><a href="/food/${food.meal}">${food.meal}</a></td>
                        <td>${food.meal}</td>
                        <td><a href="/food/${food.recipe}">${food.recipe}</a></td>
                        <td>${food.recipe}</td>
                        <td><a href="/food/${food.diet}">${food.diet}</a></td>
                        <td>${food.diet}</td>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <h3>No names!</h3>
        </c:otherwise>
    </c:choose>                
            </tr>
        </tbody>
    </table>

    </body>

</html>