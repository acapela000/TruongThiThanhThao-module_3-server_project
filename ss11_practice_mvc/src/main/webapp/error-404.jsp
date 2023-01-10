<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/5/2023
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error!</title>
</head>
<body>
<h1 style="color: brown">An error has occured! Can't process the edit!</h1>
<p>
    <c:if test="${requestScope['customerEdit'] == null}">
        <span class="msg" style="color: brown"></span>
    </c:if>
</p>
<p>
    <a href="/customerAAA">Back to customer's list</a>
</p>

</body>
</html>
