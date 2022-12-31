<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/30/2022
  Time: 6:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: "French Script MT";
        }
    </style>
</head>
<body>
<%--<c:import url="table.jsp"></c:import>--%>
<h3 class="text text-success"> === Result of Calculation === </h3>

<table class="table table-info text text-warning">
    <tr>
        <th> First Operand </th>
        <th> Operator </th>
        <th> Second Operand </th>
        <th>  </th>
        <th colspan="2"> Result </th>

    </tr>
    <tr>
        <td> ${f1} </td>
        <td> ${operator} </td>
        <td> ${f2} </td>
        <td> = </td>
        <td> ${result} </td>
    </tr>
</table>



<%--    <c:set var="option" >--%>
<%--    <c:forEach var="option" items="operator">
        <c:choose>

            <c:when test="${option.operator}">
                <td> ${f1} +  ${f2} = ${add}</td>
            </c:when>

            <c:when test="${option.operator}">
                <td> ${f1} -  ${f2} = ${sub}</td>
            </c:when>

            <c:when test="${option.operator}">
                <td> ${f1} *  ${f2} = ${multi}</td>
            </c:when>

            <c:when test="${option.operator}">
                <td> ${f1} /  ${f2} = ${divi}</td>
            </c:when>

            <c:otherwise>
                <td><p> Choose again! </p></td>
            </c:otherwise>

        </c:choose>
&lt;%&ndash;        </c:set>&ndash;%&gt;
    </c:forEach>--%>

</body>
</html>
