package com.example.display_customer_list;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Display Customer List", urlPatterns = "/display-list")
public class DisplayCusListServlet extends HttpServlet {
private static List<Customer> customerList = new ArrayList<>();
static {
    customerList.add(new Customer("John","NY","8/12/1990","img/img_1.jpg"));
    customerList.add(new Customer("Jack","EN","9/11/1991","img/img_2.jpg"));
    customerList.add(new Customer("Jane","NZ","10/10/1992","img/img_3.jpg"));
    customerList.add(new Customer("Julie","CA","12/9/1993","img/img_4.jpg"));

}
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        req.setAttribute("customerList",customerList);
        req.getRequestDispatcher("list.jsp").forward(req,resp);

    }


}