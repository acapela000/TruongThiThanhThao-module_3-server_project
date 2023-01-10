<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/4/2023
  Time: 1:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add new student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

</head>
<body>

<a href="/student"> Back to list </a>
<p style="color: dodgerblue"> ${msg} </p>

<form action="/student" method="post">

    <input type="text" name="action" value="create" hidden>
    <input type="text" name="id" placeholder="nhập id"> <br>
    <input type="radio" name="gender" value="true"> Nam
    <input type="radio" name="gender" value="false"> Nữ <br>
    <input type="number" name="point" placeholder="nhập điểm"> <br>
    <select name="classId">
        <option value="0"> Chọn lớp </option>
        <option value="1"> C09 </option>
        <option value="2"> C10 </option>
    </select>
    <button type="submit"> Save </button>

</form>

</body>
</html>
