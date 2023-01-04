<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/4/2023
  Time: 8:30 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Product</title>
    <style>
        .message{
            color: green;
        }
    </style>
</head>
<body>
<h1>Edit Product</h1>
<c:if test='${requestScope["message"] != null}'>
    <span class="message">${requestScope["message"]}</span>
</c:if>
<p>
    <a href="/Products">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Product information</legend>
        <table>
            <tr>
                <td>Name: </td>
                <td><input type="text" name="name" value="${requestScope["product"].getName()}"></td>
            </tr>
            <tr>
                <td>Price: </td>
                <td><input type="text" name="price" value="${requestScope["product"].getPrice()}"></td>
            </tr>
            <tr>
                <td>Describe: </td>
                <td><input type="text" name="describe" value="${requestScope["product"].getDescribe()}"></td>
            </tr>
            <tr>
                <td>Producer: </td>
                <td><input type="text" name="producer" value="${requestScope["product"].getProducer()}"></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Update Product"></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
