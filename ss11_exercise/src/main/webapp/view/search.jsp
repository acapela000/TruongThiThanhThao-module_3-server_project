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
    <title>Search Product</title>
</head>
<body>
<h1>Search Product</h1>
<p>
    <a href="/Products">Back to Product list</a>
</p>
<form method="post">
    <fieldset>
        <legend>Search Product</legend>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="searchName"></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Search"></td>
        </tr>
    </fieldset>
</form>

<c:if test='${requestScope["products1"] != null}'>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Describe</th>
            <th>Producer</th>
        </tr>
        <c:forEach items='${requestScope["products1"]}' var="product">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescribe()}</td>
                <td>${product.getProducer()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
