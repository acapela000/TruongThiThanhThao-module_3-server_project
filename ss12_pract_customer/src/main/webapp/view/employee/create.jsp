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
    <title>Create new employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <style>
        h1, form {color: darkblue; text-align: center}
        span {color: blue}
    </style>
</head>

<body>
<h1>==== Create new employee ====</h1>

<c:if test="${requestScope['msg'] != null}">
    <span><a href="/employeeMainPage?action=create"></a>${msg}</span>
<%--    ${msg} = ${requestScope['msg']} chỗ span--%>
</c:if>

<form action="/employeeMainPage?action=create" method="post">
    <fieldset class="border p-2">
        <legend class="float-none w-auto">New employee's information</legend>
        <table class="table table-info">
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" value="Miller" name="name">
                </td>
            </tr>
            <tr>
                <td>Date_of_birth:</td>
                <td>
                    <input type="date" value="0000-00-00" name="date_of_birth">
                </td>
            </tr>
            <tr>
                <td>Id_card:</td>
                <td>
                    <input type="number" value="1" name="id_card">
                </td>
            </tr>
            <tr>
                <td>Salary:</td>
                <td>
                    <input type="number" value="1000" name="salary">
                </td>
            </tr>
            <tr>
                <td>Phone_number:</td>
                <td>
                    <input type="text" value="000-000-0000" name="phone_number">
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" value="miller@gmail.com" name="email">
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                    <input type="text" value="Istanbul" name="address">
                </td>
            </tr>
<%--            `name`, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, divition_id, username--%>
            <tr>
                <td>Position_id:</td>
                <td>
                    <input type="number" value="1" name="position_id">
                </td>
            </tr>
            <tr>
                <td>Education_degree_id:</td>
                <td>
                    <input type="number" value="1" name="education_degree_id">
                </td>
            </tr>
            <tr>
                <td>Divition_id:</td>
                <td>
                    <input type="number" value="1" name="divition_id">
                </td>
            </tr>
            <tr>
                <td>Username:</td>
                <td>
                    <input type="text" value="abc" name="username">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Create!">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

<p style="text-align: center">
    <a href="http://localhost:8080">Back to home</a>
</p>
</body>
</html>
