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
    <title>Edit customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <style>
        h1, form {color: darkblue; text-align: center}
        span {color: blue}
    </style>
</head>

<body>
<h1>==== Update customer's information ====</h1>

<c:if test="${requestScope['msg'] != null}">
    <span><a href="/customerMainPage?action=edit"></a>${msg}</span>
    <%--    ${msg} = ${requestScope['msg']} chỗ span--%>
</c:if>

<form action="/customerMainPage?action=edit" method="post">
    <fieldset class="border p-2">
        <legend class="float-none w-auto">Customer's information</legend>
        <table class="table table-info">
            <tr>
                <td>Customer_type_id:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getCustomer_type_id()}" name="customer_type_id">
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getName()}" name="name">
                </td>
            </tr>
            <tr>
                <td>Date_of_birth:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getDate_of_birth()}" name="date_of_birth">
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getGender()}" name="gender">
                </td>
            </tr>
            <tr>
                <td>Id_card:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getId_card()}" name="id_card">
                </td>
            </tr>
            <tr>
                <td>Phone_number:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getPhone_number()}" name="phone_number">
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getEmail()}" name="email">
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                    <input type="text" value="${requestScope['customerEdit'].getAddress()}" name="address">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Edit!">
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
