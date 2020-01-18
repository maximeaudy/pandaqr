<%@page pageEncoding="UTF-8" isErrorPage="true" contentType="text/html" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Booking Rooms Coworking</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <style type="text/css">
        body {
            background-color: #f1f1f1;
        }

        .container {
            background-color: white;
            min-height: 100vh;
            padding-top: 5%;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="col-md-12">
        <h1>Bienvenue dans la pizzeria !</h1>
        <div>
            <a href="<c:url value="/admin"/>">Administration</a><br>
            <a href="<c:url value="/booking"/>">Réserver une salle</a>
        </div>
    </div>
</div>
</body>
</html>