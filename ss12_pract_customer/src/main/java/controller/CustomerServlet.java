package controller;

import model.Customer;
import service.impl.CustomerServiceImpl;
import service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Customer Page", value = "/customerMainPage")
public class CustomerServlet extends HttpServlet {
    private final ICustomerService customerService = new CustomerServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
//                showDeleteForm(request,response);
            case "find":
                break;
            case "view":
                break;
            default:
                showList(request, response);
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("view/customer/error.jsp");
        } else {
            request.setAttribute("customerEdit", customer);
            requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        }

        try {
            requestDispatcher.forward(request, response);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
//        Customer customer = customerService.findById(id);
//        RequestDispatcher requestDispatcher;
//
//        if (customer == null) {
//            requestDispatcher = request.getRequestDispatcher("view/error.jsp");
//        } else {
//            requestDispatcher = request.getRequestDispatcher("view/delete.jsp");
//            request.setAttribute("customerDelete",customer);
//        }
//
//        try {
//            requestDispatcher.forward(request,response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();

        request.setAttribute("customerList", customerList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");

        try {
            requestDispatcher.forward(request, response);
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
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        //id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
        //int id = Integer.parseInt(request.getParameter("id"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String date_of_birth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address);
        //customerService.save(customer);//do id tự động tăng nên ko truyền tham số id khi tạo đối tượng mới
        //request.setAttribute("customerCreate",customer); -> thừa
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        String msg;
        if (customerService.save(customer)) {
            msg = "Create new customer successfully!";
        } else {
            msg = "Failed to create new customer!";
        }
        request.setAttribute("msg", msg);

        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int customer_type_id = Integer.parseInt(request.getParameter("customer_type_id"));
        String name = request.getParameter("name");
        String date_of_birth = request.getParameter("date_of_birth");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = customerService.findById(id);
        String msg;
//        request.setAttribute("customerEdit", customer);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("view/customer/error.jsp");
        } else {
            customer.setCustomer_type_id(customer_type_id);
            customer.setName(name);
            customer.setDate_of_birth(date_of_birth);
            customer.setGender(gender);
            customer.setId_card(id_card);
            customer.setPhone_number(phone_number);
            customer.setEmail(email);
            customer.setAddress(address);
            customerService.update(customer);
            if (customerService.update(customer)) {
                msg = "Update customer's information successfully!";
            } else {
                msg = "Failed to customer's information!";
            }
            request.setAttribute("msg", msg);
            requestDispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        }
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {

        //List<Customer> customerList = customerService.findById(id);
        int id = Integer.parseInt(request.getParameter("id"));
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList",customerList);
        RequestDispatcher requestDispatcher;

        String msg;

        if (customerList == null) {
            requestDispatcher = request.getRequestDispatcher("view/customer/error.jsp");
        } else {
            requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
            if (customerService.remove(id)) {
                msg = "Delete successfully!";
            } else msg = "Failed to delete!";
            request.setAttribute("msg", msg);
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //CHUYỂN TRANG TRỰC TIẾP SAU KHI XÓA
        //        try {
//            response.sendRedirect("/customerAAA");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}