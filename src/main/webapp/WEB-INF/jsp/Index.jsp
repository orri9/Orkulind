<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
    	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
        <title>Project Title</title>
    </head>
    <body>

    <h1 class="head">Orkulind</h1>
    <p>Í vinnslu</p>

    <ul>
    	<li><a href="/personal">Personal training page</a> </li>
        <li><a href="/postit">Click here for Persistence Layer Demo</a></li>
        <li><a href="/createUser">Create User</a> </li>
    </ul>
    
    
    <sf:form method="POST" modelAttribute="user" action="/log">
	<table>
            <tr>
                <td> Name:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td> password:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="password" type="password" placeholder="Enter Type"/></td>
            </tr>
        </table>

        <input type="submit" VALUE="Login"/>

    </sf:form>
       
    </body>
    <footer>Class HBV501G, University of Iceland</footer>
</html>
