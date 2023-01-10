package controller;

import model.Customer;
import service.CustomerServiceImpl;
import service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Customer List", urlPatterns = "/customerAAA") //tên url ko lq vs tên setAttribute
                                //nhưng tên URL ở đây phải khớp vs tên URL ở các file JSP
public class CustomerServlet extends HttpServlet {

    private ICustomerService customerService = new CustomerServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                viewCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");
        try {                                                  //customer ở đây là tên package chứa file JSP
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);

        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customerEdit",customer);
            requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("customerDelete",customer);
            requestDispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher requestDispatcher;

         if (customer == null) {
             requestDispatcher = request.getRequestDispatcher("error-404.jsp");
         } else {
             request.setAttribute("customerView",customer);
             requestDispatcher = request.getRequestDispatcher("customer/view.jsp");
         }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) {

        List<Customer> customerList = this.customerService.findAll();
        request.setAttribute("customerList",customerList);
        //"customer" chỗ setAttribute phải khớp với tên của giá trị truyền vào bên items="..." trog <c:forEach>
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/list.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            default:
                listCustomer(request,response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = (int) (Math.random() * 1000);
        //int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");//parameter lấy từ form ng dùng nhập vào
        Customer customer = new Customer(id,name,email,address);
        this.customerService.save(customer);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("customer/create.jsp");

        String msg;
        if (customerService.save(customer)) {
            msg = "New customer was created";
        } else msg = "Failed to create new customer";

        request.setAttribute("msg",msg);

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = this.customerService.findById(id);

        RequestDispatcher requestDispatcher;
        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            customer.setName(name);
            customer.setEmail(email);
            customer.setAddress(address);
            this.customerService.update(id,customer);
            request.setAttribute("customerEdit",customer);
            String msg = null;
            if (customerService.update(id,customer)) {
                msg = "Successfully update customer's information!";
            } else msg = "Failed to update customer's information!";
            request.setAttribute("msg",msg);
            requestDispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }

        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = this.customerService.findById(id);
        RequestDispatcher requestDispatcher;

        if (customer == null) {
            requestDispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            //this.customerService.remove(id);
            String msg;
            if (customerService.remove(id)) {
                request.setAttribute("customerDelete",customer);
                msg = "Delete successfully!";
            } else msg = "Failed to delete";
            request.setAttribute("msg", msg);
            requestDispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            response.sendRedirect("/customerAAA");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}