<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/3/2023
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit customer</title>
</head>
<body>
<h1>Edit customer</h1>
<p>
    <c:if test="${requestScope['customerEdit'] != null}">
        <span class="msg" style="color: dodgerblue">${msg}</span>
    </c:if>
</p>
<p>
    <a href="/customerAAA">Back to customer's list</a>
</p>

<form action="" method="post">
    <fieldset>
        <legend>Customer's information</legend>

        <table>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" name="name" id="name" value="${requestScope['customerEdit'].getName()}">
                </td>
            </tr>

            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" name="email" id="email" value="${requestScope['customerEdit'].getEmail()}">
                </td>
            </tr>

            <tr>
                <td>Address:</td>
                <td>
                    <input type="text" name="address" id="address" value="${requestScope['customerEdit'].getAddress()}">
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Update customer">
                </td>
            </tr>
        </table>
    </fieldset>
</form>

</body>
</html>
