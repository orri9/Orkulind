<!DOCTYPE html>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Food Programs</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
        
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: middle;
                padding: 12px;
            }

            tr:nth-child(even) {
                background-color: #A1C8A0;
            }
        </style>
    </head>
    <body>

    <h1><a href="/food">Food Programs</a></h1>

            <tr>
   <c:choose>
        <c:when test="${not empty Food}">
            <table class="food">
                <tr>
                    <th>${"Name"}</th>
                    <th>${"Meal"}</th>
                    <th>${"Diet"}</th>
                    <th>${"recipe"}</th>    
                </tr>

                <c:forEach var="postfood" items="${Foods}">
                    <tr>
                        <td><a href="https://www.medicalnewstoday.com/articles/5847.php">${postfood.name}</a></td>
                        <td>${postfood.meal}</td>
                        <td>${postfood.diet}</td>
                        <td>${postfood.recipe}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>

        <%--If all tests are false, then do this--%>
        <c:otherwise>
            <sql:setDataSource var = "snapshot" driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/hbv"
            user = "postgres"  password = "3103"/>
            
            <sql:update dataSource = "${snapshot}" var = "Foods">
                INSERT INTO food (id, name, meal, recipe, diet)
                VALUES(1,2,3,4,5);
            </sql:update>
        </c:otherwise>
    </c:choose>             
    <br />
    <h2>Make Your Own Food Program:</h2>   
            </tr>
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
    </body>
</html>