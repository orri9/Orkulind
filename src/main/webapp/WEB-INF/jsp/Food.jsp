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

    <table border="1px gray">
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
                <td>${name}</td>
                <td>${meal}</td>
                <td>${recipe}</td>
                <td>${diet}</td>
            </tr>
        </tbody>
    </table>


    </body>

</html>