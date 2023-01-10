<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/7/2023
  Time: 12:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create new employee!</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</head>
<body>
<h1>==== Create new employee ====</h1>

<p>
    <c:if test="${requestScope['msg'] != null}">
        <span class="msg" style="color: blue">
            ${requestScope['msg']}
        </span>
    </c:if>
</p>

<form action="" method="post">
<fieldset>
    <legend>New employee's information</legend>

        <table>
           <tr>
               <td>ID:</td>
               <td>
                   <input type="text" value="id" name="id">
               </td>
           </tr>
            <tr>
                <td>Name:</td>
                <td>
                    <input type="text" value="name" name="name">
                </td>
            </tr>
            <tr>
                <td>Email:</td>
                <td>
                    <input type="text" value="@io.com" name="email">
                </td>
            </tr>
            <tr>
                <td>Address:</td>
                <td>
                    <input type="text" value="Korea" name="address">
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <input type="submit" value="Create!">
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <a href="/employeeAA">Back to home</a>
                </td>
            </tr>
        </table>
</fieldset>
</form>
</body>
</html>
