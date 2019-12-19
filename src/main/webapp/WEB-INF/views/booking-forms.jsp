<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Formulaire de réservation</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<div class="container" style="width:60%;">
	<div class="row">
		<div class="col-12">
			<h1>Formulaire de réservation</h1>
			<%--@elvariable id="bookingDto" type="pandaqr.service.BookingDto"--%>
			<form:form servletRelativeAction="/booking" modelAttribute="bookingDto">
				<input type="hidden" name="roomCode" value="${roomCode}" />
				<div class="input-group mt-2">
					<div class="input-group-prepend">
						<span class="input-group-text">Date et heure de début de la réservation</span>
					</div>
						<form:input type="date" path="start_date" cssClass="form-control"/>
						<form:errors path="start_date"/>
						<form:input type="time" path="start_time" cssClass="form-control"/>
						<form:errors path="start_time"/>
				</div>
				<div class="input-group mt-2 mb-2">
					<div class="input-group-prepend">
						<span class="input-group-text">Date et heure de fin de la réservation</span>
					</div>
						<form:input type="date" path="end_date" cssClass="form-control"/>
						<form:errors path="end_date"/>
						<form:input type="time" path="end_time" cssClass="form-control"/>
						<form:errors path="end_time"/>
				</div>
				<div class="form-group">
					<label>Nom :</label>
					<form:input path="name" cssClass="form-control"/>
					<form:errors path="name"/>
				</div>
				<div class="form-group">
					<label>Description :</label>
					<form:textarea path="description" cssClass="form-control"/>
					<form:errors path="description"/>
				</div>
				<div class="form-group">
					<label>Participants :</label>
					<form:textarea path="participants" cssClass="form-control"/>
					<form:errors path="participants"/>
				</div>
				<button type="submit">Réserver</button>
			</form:form>
		</div>
	</div>
</div>
</body>
</html>