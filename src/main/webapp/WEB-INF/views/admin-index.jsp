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
</head>
<body>
<form:form>
    <table>
        <tr>
            <td>Sélection</td>
            <td>Code</td>
            <td>Options</td>
        </tr>
        <c:forEach items="${rooms}" var="room">
            <tr>
                <td><input type="checkbox" value="${room.id}" name="room-items"></td>
                <td>Salle ${room.code}</td>
                <td><a href="admin/${room.id}">Voir plus</a></td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Enregistrer" />
</form:form>
</body>
</html>
