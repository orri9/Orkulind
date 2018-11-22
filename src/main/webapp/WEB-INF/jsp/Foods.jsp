<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">

    <head>
        <title>Diet Programs</title>

<<<<<<< HEAD
		<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
        
=======
        	<link rel="stylesheet" type="text/css" href="<c:url value="/css/style.css"/>"/>
>>>>>>> 5f4372e449b206a083e67eaa9757c561c14ea22b
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #999999;
                text-align: middle;
                padding: 12px;
            }

            tr:nth-child(even) {
                background-color: #A1C8A0;
            }
        </style>
    </head>
    <body>

    <h1><a href="/food">Diet Programs</a></h1>

            <tr>
   <c:choose>
        <c:when test="${not empty Food}">
            <table class="food">
                <tr>
                    <th>${"Name"}</th>
                    <th>${"Meal"}</th>
                    <th>${"Diet"}</th>
                    <th>${"Main Focus Of Diet"}</th>    
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/7382.php">${"The Zone diet"}</a></td>
                    <td>${"Protein/Fat/carbohydrates"}</td>
                    <td>${"40 percent carbohydrates, 30 percent fats, and 30 percent protein"}</td>
                    <td>${"The focus is also on controlling insulin levels, which may result in more successful 
                        weight loss and body weight control than other approaches."}</td>
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/7379.php">${"The Atkins diet"}</a></td>
                    <td>${"Protein/Fat"}</td>
                    <td>${"Low-carbohydrate"}</td>
                    <td>${"The Atkins diet, or Atkins nutritional approach, focuses on controlling the levels of 
                        insulin in the body through a low-carbohydrate diet."}</td>
                </tr>
            
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/149090.php">${"Mediterranean diet"}</a></td>
                    <td>${"Plants ,fruits , beans, nuts, whole grains, seeds, olive oil"}</td>
                    <td>${"30 percent fats"}</td>
                    <td>${"The emphasis is on lots of plant foods, fresh fruits as dessert, beans, nuts, whole grains, 
                        seeds, olive oil as the main source of dietary fats. Cheese and yogurts are the main dairy foods."}</td>
                </tr>
            
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/7381.php">${"Raw food diet"}</a></td>
                    <td>${"Non processed food"}</td>
                    <td>${"75 percent Non processed uncooked food"}</td>
                    <td>${"The raw food diet, or raw foodism, involves consuming foods and drinks that are not processed, 
                        are completely plant-based, and ideally organic. Raw foodists believe that at least three-quarters 
                        of a person's food intake should consist of uncooked food."}</td>
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/7380.php">${"South Beach diet"}</a></td>
                    <td>${"carbohydrates"}</td>
                    <td>${"unrefined slow carbohydrates"}</td>
                    <td>${"It focuses on the control of insulin levels, and the benefits of unrefined slow 
                        carbohydrates versus fast carbohydrates."}</td>
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/149636.php">${"Vegan diet"}</a></td>
                    <td>${"No animal-based foods"}</td>
                    <td>${"Vegan"}</td>
                    <td>${"A vegan does not eat anything that is animal-based, including eggs, dairy, and honey. 
                        Vegans do not usually adopt veganism just for health reasons, but also for environmental, 
                        ethical, and compassionate reasons."}</td>
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/8749.php">${"Vegetarian diet"}</a></td>
                    <td>${"No animal-based foods"}</td>
                    <td>${"Vegan"}</td>
                    <td>${"A vegan does not eat anything that is animal-based, including eggs, dairy, and honey. 
                        Vegans do not usually adopt veganism just for health reasons, but also for environmental, 
                        ethical, and compassionate reasons."}</td>
                </tr>
                
                <tr>
                    <td><a href="https://www.medicalnewstoday.com/articles/180858.php">${"Ketogenic diet"}</a></td>
                    <td>${"Fat"}</td>
                    <td>${"Healthy fats, Low-carbohydrate"}</td>
                    <td>${"The diet causes the break down of fat deposits for fuel and creates substances called 
                        ketones through a process called ketosis."}</td>
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

        </c:otherwise>
    </c:choose>             
    <br />
    <h2>Make Your Own Diet Program:</h2>   
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
                <td> Main Focus Of Diet:</td>
                <td><sf:input path="recipe" type="text" placeholder="Enter Main Focus Of Diet"/></td>
            </tr>
            <tr>
                <td> Diet Type:</td>
                <td><sf:input path="diet" type="text" placeholder="Enter Diet Type"/></td>
            </tr>
            
        </table>

        <input type="submit" VALUE="Create Diet Program"/>

    </sf:form>

    <%-- This is for the user to enter what he ate --%>
 
    </body>

</html>