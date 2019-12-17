<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Réservation réussie</title>
</head>
<body>
<div>
	Vous avez bien réservé la salle <c:out value="${booking.room.code}"/> 
	pour le créneau de <fmt:formatDate value="${booking.start_time}" type="date" dateStyle="long"/> à <fmt:formatDate value="${booking.end_date}" type="date" dateStyle="long"/>.
</div>
<div>
	<c:url value="/" var="accueil"/>
	<a href="${accueil}">Retour à l'accueil</a>
</div>
</body>
</html>