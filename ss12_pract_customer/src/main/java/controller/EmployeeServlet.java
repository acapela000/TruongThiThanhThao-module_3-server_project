package controller;

import model.Employee;
import service.IEmployeeService;
import service.impl.EmployeeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Employee Page", urlPatterns = "/employeeMainPage")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        request.setAttribute("employeeEdit",employee);

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request,response);
                break;
            case "edit":
                updateEmployee(request,response);
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            default:
                showList(request,response);
        }
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        int idCard = Integer.parseInt(request.getParameter("id_card"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divitionId = Integer.parseInt(request.getParameter("divition_id"));
        String username = request.getParameter("username");
        Employee employee = employeeService.findById(id);

        String msg;
        RequestDispatcher requestDispatcher;
        if (employee == null) {
            requestDispatcher = request.getRequestDispatcher("view/employee/error.jsp");
        } else {
            employee.setName(name);
            employee.setDateOfBirth(dateOfBirth);
            employee.setIdCard(idCard);
            employee.setSalary(salary);
            employee.setPhoneNumber(phoneNumber);
            employee.setEmail(email);
            employee.setAddress(address);
            employee.setPositionId(positionId);
            employee.setEducationDegreeId(educationDegreeId);
            employee.setDivitionId(divitionId);
            employee.setUsername(username);
            employeeService.update(employee);
            if (employeeService.update(employee)) {
                msg = "Update information successfully!";
            } else msg = "Failed to update information";
            requestDispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
            request.setAttribute("msg",msg);
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        //int id, String name, String dateOfBirth, int idCard, double salary, String phoneNumber, String email,
        // String address, int positionId, int educationDegreeId, int divitionId, String username)
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("date_of_birth");
        int idCard = Integer.parseInt(request.getParameter("id_card"));
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("position_id"));
        int educationDegreeId = Integer.parseInt(request.getParameter("education_degree_id"));
        int divitionId = Integer.parseInt(request.getParameter("divition_id"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divitionId, username);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");

        String msg;
        if (employeeService.save(employee)) {
            msg = "Create employee successfully!";
        } else {
            msg = "Failed to create new employee!";
            requestDispatcher = request.getRequestDispatcher("view/employee/error.jsp");
        }
        request.setAttribute("msg",msg);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Employee> employeeList = employeeService.findAll();
        request.setAttribute("employeeList",employeeList);
        RequestDispatcher requestDispatcher;

        String msg;
        if (employeeList == null) {
            requestDispatcher = request.getRequestDispatcher("view/employee/error.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
            if (employeeService.remove(id)) {
                msg = "Delete successfully!";
            } else msg = "Delete unsuccessfully!";
            request.setAttribute("msg",msg);
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

