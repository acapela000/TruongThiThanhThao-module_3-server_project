<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/3/2023
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete customer</title>
</head>

<body>
<h1>Delete customer</h1>
<p>
    <c:if test="${requestScope['customerDelete'] != null}">
        <span class="msg" style="color: darkorange">${msg}</span>
    </c:if>
</p>
<p>
    <a href="/customerAAA">Back to customer's list</a>
</p>

<form action="" method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>Customer information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>${requestScope['customerDelete'].getName()}</td>
            </tr>

            <tr>
                <td>Email: </td>
                <td>${requestScope['customerDelete'].getEmail()}</td>
            </tr>

            <tr>
                <td>Address: </td>
                <td>${requestScope['customerDelete'].getAddress()}</td>
            </tr>

            <tr>
                <td><input type="submit" value="Delete customer"></td>
                <td>
<%--                    <a href="/customerAAA">Back to customer's list</a>--%>
                </td>
            </tr>
        </table>
    </fieldset>
</form>


</body>
</html>
