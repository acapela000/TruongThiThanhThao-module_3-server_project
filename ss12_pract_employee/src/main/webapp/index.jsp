<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee Page</title>
</head>

<body>
<h1><%= "==== Employee Page ====" %></h1><br/>

<a href="/employeeAA">View list of employee</a><br>
<a href="/employeeAA?action=create">Create new employee</a>
<%--<c:redirect url="/employeeAA">  </c:redirect>--%>

</body>
</html>