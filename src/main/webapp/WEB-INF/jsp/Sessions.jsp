<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html lang="en">

    <head>
        <title>Exercises</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <h1><a href="/sessions">Sessions</a></h1>

    <%--Note that the `commandName` given here HAS TO MATCH the name of the attribute--%>
    <%--that is added to the model that is passed to the view.--%>
    <%--See PostitNoteController, method postitNoteViewGet(), and find where this attribute is added to the model.--%>
    <sf:form method="POST" modelAttribute="session" action="/ses">

        <table>
            <tr>
                <td> Name:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td> Type:</td>
                <%--the `path` attribute matches the `name` attribute of the Entity that was passed in the model--%>
                <td><sf:input path="type" type="text" placeholder="Enter Type"/></td>
            </tr>
            
        </table>

        <input type="submit" VALUE="Create Exercise"/>

    </sf:form>

  

    </body>
</html>
