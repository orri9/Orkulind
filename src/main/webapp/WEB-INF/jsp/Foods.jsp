<!DOCTYPE html>


<html lang="en">

    <head>
        <title>Foods</title>

        <link rel="stylesheet" type="text/css" href="<c:url value="/css/postitnote.css"/>"/>
    </head>
    <body>

    <h1><a href="/food">Foods</a></h1>
    
    <sf:form method="POST" modelAttribute="food" action="/postfood">

        <table>
            <tr>
                <td> Name:</td>
                <td><sf:input path="name" type="text" placeholder="Enter Name"/></td>
            </tr>
            <tr>
                <td> Type:</td>
                <td><sf:input path="meal" type="text" placeholder="Enter Meal Type"/></td>
            </tr>
            <tr>
                <td> Rep Type:</td>
                <td><sf:input path="recipe" type="text" placeholder="Enter Recipe"/></td>
            </tr>
            <tr>
                <td> Reps:</td>
                <td><sf:input path="diet" type="text" placeholder="Enter Diet Type"/></td>
            </tr>
            
        </table>

        <input type="submit" VALUE="Create Food Program"/>

    </sf:form>

  

    </body>
</html>
