<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/4/2023
  Time: 8:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h1>Product</h1>
<p>
    <a href="/Products?action=create">Create new Product</a>
</p><br>
<p>
    <a href="/Products?action=search">Search Product</a>
</p>
<table border="1">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
        <th>Describe</th>
        <th>Producer</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach items='${requestScope["products"]}' var="product">
        <tr>
            <td><a href="/Products?action=view&id=${product.getId()}">${product.getId()}</a></td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescribe()}</td>
            <td>${product.getProducer()}</td>
            <td><a href="/Products?action=edit&id=${product.getId()}">Edit</a></td>
            <td><a href="/Products?action=delete&id=${product.getId()}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
