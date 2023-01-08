<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/7/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <style>
        h1, table, tr {color: darkgreen}
    </style>
</head>

<body>
<h1 style="text-align: center">==== List of customer ====</h1>
    <table class="table table-success">
        <tr>
            <th>Id</th>
            <th>Customer_type_id</th>
            <th>Name</th>
            <th>Date_of_birth</th>
            <th>Gender</th>
            <th>Id_card</th>
            <th>Phone_number</th>
            <th>Email</th>
            <th>Address</th>
        </tr>

        <c:forEach items="${customerList}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.customer_type_id}</td>
                <td>${customer.name}</td>
                <td>${customer.date_of_birth}</td>
                <td>${customer.gender}</td>
                <td>${customer.id_card}</td>
                <td>${customer.phone_number}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="/customerMainPage?action=edit">Edit</a>
                </td>
                <td>
                    <a href="/customerMainPage?action=delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

<p style="text-align: center">
    <a href="http://localhost:8080">Back to home</a>
</p>


</body>
</html>
