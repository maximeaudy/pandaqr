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
</head>
<body>
    <ul>
        <c:forEach items="${rooms}" var="room">
            <li><a href="<c:url value="//booking/${room.code}"/>">${room.code}</a></li>
        </c:forEach>
    </ul>
</body>
</html>
