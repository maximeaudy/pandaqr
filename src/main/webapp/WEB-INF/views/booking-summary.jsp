<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Réservation réussie</title>
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
			<div>
				Vous avez bien réservé la salle <c:out value="${booking.room.code}"/>
				pour le créneau du <fmt:formatDate value="${booking.start_time}" type="both" dateStyle="long"/> au <fmt:formatDate value="${booking.end_time}" type="both" dateStyle="long"/>.
			</div>
			<div>
				<c:url value="/" var="accueil"/>
				<a href="${accueil}">Retour à l'accueil</a>
			</div>
		</div>
	</div>
</body>
</html>