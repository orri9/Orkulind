<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
        <title>Create User</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
<body>
	<h1>Create User</h1>
	<a href="/"> Heim</a>
	<sf:form method="POST" modelAttribute="storeUser" action="/storeUser">
	
	<table>
            <tr>
                <td> Name:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td> password:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="password" type="text" placeholder="Enter Type"/></td>
            </tr>
        </table>

        <input type="submit" VALUE="Create user"/>

    </sf:form>
</body>
</html>

