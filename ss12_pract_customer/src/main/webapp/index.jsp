<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Main Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>

    <style>
        h1,h3,a,table {color: darkgreen; text-align: center}

    </style>
</head>
<body>
<h1><%= "==== Main Page ====" %></h1><br/>
<h3>== Main menu ==</h3>
<table class="table html-editor-align-center">
    <tr>
        <th>Numb.</th>
        <th>Option</th>
    </tr>
    <tr>
        <td>1</td>
        <td>
            <a href="/customerMainPage">View/Edit/Delete customer's information in the list</a>
        </td>
    </tr>
    <tr>
        <td>2</td>
        <td>
            <a href="/customerMainPage?action=create">Create new customer</a>
        </td>
    </tr>
    <tr>
        <td>3</td>
        <td>
            <a href="/employeeMainPage">View/Edit/Delete employee's information in the list</a>
        </td>
    </tr>
    <tr>
        <td>4</td>
        <td>
            <a href="/employeeMainPage?action=create">Create new employee</a>
        </td>
    </tr>
</table>

</body>
</html>