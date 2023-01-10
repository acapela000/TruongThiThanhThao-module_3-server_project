<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/3/2023
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<p><a href="/customerAAA?action=create"> Create new customer </a></p>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${requestScope['customerList']}" var="customerZ">
        <tr>
            <td>${customerZ.getId()}</td>
            <td><a href="/customerAAA?action=view&id=${customerZ.getId()}">${customerZ.getName()}</a></td>
            <td>${customerZ.getEmail()}</td>
            <td>${customerZ.getAddress()}</td>
            <td><a href="/customerAAA?action=edit&id=${customerZ.getId()}">edit</a></td>
            <td><a href="/customerAAA?action=delete&id=${customerZ.getId()}">delete</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>