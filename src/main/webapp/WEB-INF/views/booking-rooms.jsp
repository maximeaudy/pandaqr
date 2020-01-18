<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis.H
  Date: 19/12/2019
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
    <ul>
        <c:forEach items="${rooms}" var="room">
            <li><a href="<c:url value="//booking/${room.code}"/>">${room.code}</a></li>
        </c:forEach>
    </ul>
    </div>
</div>
</body>
</html>
