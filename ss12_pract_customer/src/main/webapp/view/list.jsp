<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 1/7/2023
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List of customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
    <style>
        h1, table, tr {color: darkgreen}
        span {color: blue}
    </style>
</head>

<body>
<h1 style="text-align: center">==== List of customer ====</h1>

<c:if test="${requestScope['msg'] != null}">
    <span>
            ${requestScope['msg']}
    </span>
</c:if>
    <table class="table table-striped" id="customerTable">
        <thead>
            <tr>
                <th>Id</th>
                <th>Customer_type_id</th>
                <th>Name</th>
                <th>Date_of_birth</th>
                <th>Gender</th>
                <th>Id_card</th>
                <th>Phone_number</th>
                <th>Email</th>
                <th>Address</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${customerList}" var="customer" varStatus="stt">
                <tr>
                    <td>${stt.count}</td>
                        <%--                <td>${customer.id}</td>--%>
                    <td>${customer.customer_type_id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.date_of_birth}</td>
                    <td>${customer.gender}</td>
                    <td>${customer.id_card}</td>
                    <td>${customer.phone_number}</td>
                    <td>${customer.email}</td>
                    <td>${customer.address}</td>

                    <td>
                        <a href="/customerMainPage?action=edit&id=${customer.id}">Edit</a>
                            <%--                    <a href="/customerMainPage?action=delete&id=${customer.id}">Delete</a>--%>
                    </td>

                    <td>
                        <!-- Button trigger modal -->
                        <button onclick="deleteCustomer('${customer.id}','${customer.name}')" type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#deleteCustomer">
                            DELETE
                        </button>
                        <!-- Modal -->

                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

<p style="text-align: center">
    <a href="http://localhost:8080">Back to home</a>
</p>

<%--MODAL DELETE--%>
<div class="modal fade" id="deleteCustomer" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5"></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>

<%--            triển khai thẻ form để lấy action=delete--%>
            <form action="/customerMainPage?action=delete" method="post">
            <div class="modal-body">

        <%--   HIỂN THỊ THÔNG TIN TRONG HỘP THOẠI DELETE--%>
                <input hidden type="text" id="deleteId" name="id">
                <span>You want delete Customer</span>
                <span style="color:red;" id="deleteName"></span>
    <%--    HIỂN THỊ THÔNG TIN TRONG HỘP THOẠI DELETE--%>

            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-secondary" name="action" data-bs-dismiss="modal">Yes</button>
                <button type="submit" class="btn btn-primary">No</button>
            </div>
            </form>
            <%--            triển khai thẻ form để lấy action=delete--%>

        </div>l
    </div>
</div>

<%--PHÂN TRANG--%>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
$(document).ready(function () {
    $('#customerTable').dataTable( {
        "dom": 'lrtip',
        "lengthChange": false,
        "pageLength": 3
    } );
});
</script>

</body>
<script>
    function deleteCustomer(id,name){
        document.getElementById("deleteId").value = id;
        document.getElementById("deleteName").innerText = name;
    }
</script>
</html>
