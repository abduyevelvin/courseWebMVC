<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 11/10/2018
  Time: 6:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table border="1" style="width: 100%;">
    <thead>
        <tr>
            <th>No</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Date of Birth</th>
            <th>Teacher</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach items="${studentList}" var="sl">
            <tr>
                <td>${sl.id_student}</td>
                <td>${sl.name}</td>
                <td>${sl.surname}</td>
                <td>${sl.address}</td>
                <td>${sl.dob}</td>
                <td>${sl.teacherName} ${sl.teacherSurname}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.3.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>
