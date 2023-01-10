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
    <title>Create new customer</title>
</head>
<body>
<%--//requestScope là gì? -> chu trình có request gửi lên và có response trả về--%>
<p>
    <c:if test="${requestScope['msg'] != null}">
        <span class="msg" style="color: brown"> ${requestScope['msg']} </span>
    </c:if>
</p>
<p>
    <a href="/customerAAA">Back to customer's list</a>
</p>

<form action="" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td>
                    <input type="text" name="name" id="name">
                </td>
            </tr>

            <tr>
                <td>Email: </td>
                <td>
                    <input type="text" name="email" id="email">
                </td>
            </tr>

            <tr>
                <td>Address: </td>
                <td>
                    <input type="text" name="address" id="address">
                </td>
            </tr>

            <tr>
                <td> </td>
                <td>
                    <input type="submit" value="Create customer">
                </td>
            </tr>
        </table>
    </fieldset>

</form>


</body>
</html>
