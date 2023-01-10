<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/4/2023
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Student List</title>
<%--    1:59--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">--%>
<%--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>--%>
</head>

<body>
<c:import url="/view/navbar.jsp"></c:import>
<h1> Student's List </h1>
<a href="/student?action=create"> Thêm mới </a>
<table class="table table-success">

    <tr>
        <th> STT </th>
        <th> ID </th>
        <th> Name </th>
        <th> Gender </th>
        <th> Point </th>
        <th> Rank </th>
        <th> Class_id </th>
    </tr>

    <c:forEach var="student" items="${studentList}" varStatus="status">

        <tr>
            <td> ${status.count} </td>
            <td> ${student.id} </td>
            <td> ${student.name} </td>
            <c:if test="${student.gender}">
                <td> Nam </td>
            </c:if>
            <c:if test="${!student.gender}">
                <td> Nữ </td>
            </c:if>
            <td> ${student.point} </td>
            <td> ${student.classId} </td> // lấy dữ liệu từ Student(java)
            <td>  </td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
