<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/5/2023
  Time: 7:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Create New User</title>
</head>

<body>
<h1>User</h1>
<p>
  <a href="/user" >Back to user's list</a>
</p>
<p style="color: red">${msg}</p>

<form method="post">

  <p>Name</p>
  <input name="name" type="text">
  <p>Email</p>
  <input name="email" type="text" >
  <p>Country</p>
  <input name="country" type="text">
  <button type="submit" value="Create user">Create</button>

</form>

</body>
</html>
