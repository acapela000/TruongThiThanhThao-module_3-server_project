<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/30/2022
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>


<body>
<c:import url="navbar.jsp"></c:import>

<h1> === Customer List === </h1>
<table class="table table-success">
<tr>
    <th> Numb. </th>
    <th> Name </th>
    <th> Address </th>
    <th> Date or birth </th>
    <th> Picture </th>

</tr>

<c:forEach var="customer" items="${customerList}" varStatus="cus">
    <tr>
        <td> ${cus.count} </td>
        <td> ${customer.name} </td>
        <td> ${customer.address} </td>
        <td> ${customer.dateOfBirth} </td>
        <td><img src=${customer.image} height="100px" width="100px"> </td>
    </tr>

</c:forEach>

</table>


</body>
</html>
