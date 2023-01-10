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
    <title>Delete customer</title>
</head>

<body>
<h1>Delete customer's information</h1>
<c:if test="${requestScope['msg'] != null}">
    <span>
        ${requestScope['msg']}
    </span>
</c:if>

<form action="/customerMainPage?action=delete&id=${customerDelete.id}" method="post">
    <fieldset class="border p-2">
        <legend class="float-none w-auto">Customer's information</legend>
        <table class="table table-info">
            <tr>
                <td>Customer_type_id:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getCustomer_type_id()}" name="customer_type_id">
                </td>
            </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getName()}" name="name">
                </td>
            </tr>
            <tr>
                <td>Date_of_birth:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getDate_of_birth()}" name="date_of_birth">
                </td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].isGender()}" name="gender">
                </td>
            </tr>
            <tr>
                <td>Id_card:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getId_card()}" name="id_card">
                </td>
            </tr>
            <tr>
                <td>Phone_number:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getPhone_number()}" name="phone_number">
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getEmail()}" name="email">
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                    <input type="text" value="${requestScope['customerDelete'].getAddress()}" name="address">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Delete!">
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
