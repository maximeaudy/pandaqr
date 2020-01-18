<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis.H
  Date: 10/12/2019
  Time: 16:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Administration</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style type="text/css">
        body{
            background-color:#f1f1f1;
        }

        .container{
            background-color:white;
            min-height: 100vh;
            padding-top:5%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <form:form>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Sélection</th>
                    <th scope="col">Code</th>
                    <th scope="col">Options</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td><input type="checkbox" value="${room.id}" name="room-items"></td>
                        <td>Salle ${room.code}</td>
                        <td><a href="${room.id}">Voir plus</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <input type="submit" value="Enregistrer" />
        </form:form>
    </div>
</div>
</body>
</html>
