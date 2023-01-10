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
    <title>View customer</title>
</head>
<body>
<h1>Customer details</h1>
<p>
    <a href="/customerAAA">Back to customer's list</a>
</p>

<fieldset>
    <legend>Customer's information</legend>
    <table>
        <tr>
            <td>ID: </td>
            <td>${requestScope['customerView'].getId()}</td>
        </tr>

        <tr>
            <td>Name: </td>
            <td>${requestScope['customerView'].getName()}</td>
        </tr>

        <tr>
            <td>Email: </td>
            <td>${requestScope['customerView'].getEmail()}</td>
        </tr>

        <tr>
            <td>Address: </td>
            <td>${requestScope['customerView'].getAddress()}</td>
        </tr>
    </table>
</fieldset>


</body>
</html>
