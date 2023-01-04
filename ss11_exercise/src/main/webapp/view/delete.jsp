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
  <title>Delete Product</title>
  <style>
    .message{
      color: green;
    }
  </style>
</head>
<body>
<h1>Delete Product</h1>
<c:if test='${requestScope["message"] != null}'>
  <span class="message">${requestScope["message"]}</span>
</c:if>
<p>
  <a href="/Products">Back to Product list</a>
</p>
<form method="post">
  <h2>Are you sure?</h2>
  <fieldset>
    <legend>Product information</legend>
    <table>
      <tr>
        <td>Name: </td>
        <td>${requestScope["product"].getName()}</td>
      </tr>
      <tr>
        <td>Price: </td>
        <td>${requestScope["product"].getPrice()}</td>
      </tr>
      <tr>
        <td>Describe: </td>
        <td>${requestScope["product"].getDescribe()}</td>
      </tr>
      <tr>
        <td>Producer: </td>
        <td>${requestScope["product"].getProducer()}</td>
      </tr>
      <tr>
        <td></td>
        <td><input type="submit" value="Delete Product"></td>
      </tr>
    </table>
  </fieldset>
</form>
</body>
</html>
