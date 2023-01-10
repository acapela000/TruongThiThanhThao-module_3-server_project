package controller;

import model.Employee;
import service.EmployeeServiceImpl;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Employee page", urlPatterns = "/employeeAA")
public class EmployeeServlet extends HttpServlet {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                break;
            case "delete":
                break;
            case "find":
                break;
            case "view":
                break;
            default:
                showList(request,response);
        }

    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeListJava = employeeService.findAll();
        request.setAttribute("employeeList",employeeListJava);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/list.jsp");

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
                break;
            case "delete":
                break;
            case "find":
                break;
            case "view":
                break;
            default:
                showList(request,response);
        }
    }

    private void createEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Employee employee = new Employee(id,name,email,address);
        employeeService.save(employee);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/create.jsp");
        //request.setAttribute("employeeCreate",employee);

        String msg;
        if (employeeService.save(employee)) {
            msg = "Create new employee successfully!";
        } else {
            msg = "Failed to create new employee!";
            requestDispatcher = request.getRequestDispatcher("view/error.jsp");
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
}
