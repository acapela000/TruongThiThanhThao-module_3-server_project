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
<h1 style="text-align: center">==== List of employee ====</h1>

<c:if test="${requestScope['msg'] != null}">
    <span>
            ${requestScope['msg']}
    </span>
</c:if>

    <table class="table table-striped" id="employeeTable">
<%--        PHẢI CÓ thead vs tbody THÌ MỚI PHÂN TRANG ĐC--%>
        <thead>
            <tr>

                <th>Id</th>
                <th>Name</th>
                <th>Date of birth</th>
                <th>Id card</th>
                <th>Salary</th>
                <th>Phone number</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position Id</th>
                <th>Education Degree Id</th>
                <th>Divition Id</th>
                <th>Username</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach items="${employeeList}" var="employee" varStatus="stt">
                <tr>
                    <td>${stt.count}</td>
                    <%--<td>${customer.id}</td> nếu ko đặt id tự độg tăng bên sql --%>
<%--                    int id, String name, String dateOfBirth, int idCard, double salary, String phoneNumber, String email,--%>
<%--                    String address, int positionId, int educationDegreeId, int divitionId, String username)--%>
                    <td>${employee.name}</td>
                    <td>${employee.dateOfBirth}</td>
                    <td>${employee.idCard}</td>
                    <td>${employee.salary}</td>
                    <td>${employee.phoneNumber}</td>
                    <td>${employee.email}</td>
                    <td>${employee.address}</td>
                    <td>${employee.positionId}</td>
                    <td>${employee.educationDegreeId}</td>
                    <td>${employee.divitionId}</td>
                    <td>${employee.username}</td>

                    <td>
                        <a href="/employeeMainPage?action=edit&id=${employee.id}">Edit</a>
                       <%--<a href="/customerMainPage?action=delete&id=${customer.id}">Delete</a>--%>
                    </td>
                    <td>
                        <!-- Button trigger modal -->
                        <button onclick="deleteEmployee('${employee.id}','${employee.name}')" type="button" class="btn btn-outline-info" data-bs-toggle="modal" data-bs-target="#deleteEmployee">
                            DELETE
                        </button>
                    <%--có khối div, có thể bỏ phía dưới--%>
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
<div class="modal fade" id="deleteEmployee" tabindex="-1" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5"></h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal"
                        aria-label="Close"></button>
            </div>

        <%-- triển khai thẻ form để lấy action=delete--%>
            <form action="/employeeMainPage?action=delete" method="post">
            <div class="modal-body">
        <%--   HIỂN THỊ THÔNG TIN TRONG HỘP THOẠI DELETE--%>
                <input hidden type="text" id="deleteId" name="id">
                <span>You want delete Employee</span>
                <span style="color:red;" id="deleteName"></span>
        <%--  HIỂN THỊ THÔNG TIN TRONG HỘP THOẠI DELETE--%>
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-secondary" name="action" data-bs-dismiss="modal">Yes</button>
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">No</button>
            </div>
            </form>
        <%--triển khai thẻ form để lấy action=delete--%>
        </div>
    </div>
</div>

<%--PHÂN TRANG--%>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
    $(document).ready(
      function () {
          $('#employeeTable').dataTable({
              "dom": "lrtip","lengthChange": false, "pageLength": 5
          });
      });
</script>
</body>
<script>
    function deleteEmployee(id,name) {
        document.getElementById('deleteId').value = id;
        document.getElementById('deleteName').innerText = name;
    }
</script>
</html>
