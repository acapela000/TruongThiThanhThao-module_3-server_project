<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/7/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>

<body>
<h1 style="text-align: center; color: darkslategrey">==== List of Employee ====</h1>
<a href="/employeeAA"></a>

<table class="table table-success" style="color: darkgreen">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach var="employeeListJSP" items="${employeeList}">
    <tr>
        <td>${employeeListJSP.id}</td>
        <td>${employeeListJSP.name}</td>
        <td>${employeeListJSP.email}</td>
        <td>${employeeListJSP.address}</td>
        <td><a href="/employeeAA?action=edit&id=${employeeListJSP.id}"></a>Edit</td>
        <td><a href="/employeeAA?action=delete&id=${employeeListJSP.id}"></a>Delete</td>
    </tr>
    </c:forEach>
</table>

<p style="text-align: center">
    <a href="http://localhost:8080">Back to home</a>
</p>


</body>
</html>
