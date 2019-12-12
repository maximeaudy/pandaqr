<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexis.H
  Date: 10/12/2019
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Infos</title>
</head>
<body>
<form:form>
    <input type="date" name="day"/>
    <input type="submit" value="Rechercher" />
</form:form>
<h1>${room.code}</h1>
<ul><li>Réservations</li>
    <c:forEach items="${room.bookings}" var="booking">
        <li><ul>
            <li><c:out value="${booking.name}" /></li>
            <li><c:out value="${booking.description}" /></li>
            <li><fmt:formatDate value="${booking.start_time}" type="both"/></li>
            <li><fmt:formatDate value="${booking.end_time}" type="both"/></li>
            <li><c:out value="${booking.user.email}" /></li>
            <li><ul>
                <c:forEach items="${booking.participants}" var="participant">
                    <li><c:out value="${participant.email}" /></li>
                </c:forEach>
            </ul></li>
        </ul></li>
    </c:forEach>
</ul>
</body>
</html>
