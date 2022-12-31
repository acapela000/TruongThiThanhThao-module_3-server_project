package com.example.ss10_exercise_2_simple_calculator;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "Simple Calculator", urlPatterns = "/simple-calculator")
public class CalculatorServlet extends HttpServlet {
    private float firstOperand;
    private float secondOperand;
    private char operator;
    private float result;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        firstOperand = Float.parseFloat(request.getParameter("first_operand"));
        secondOperand = Float.parseFloat(request.getParameter("second_operand"));
        operator = request.getParameter("operator").charAt(0);

        Calculator calculator = new Calculator();
        PrintWriter printWriter = response.getWriter();
        try {
             result = calculator.calculate(firstOperand, secondOperand, operator);
        } catch (ArithmeticException a) {
            System.out.println("An error has occured!");
            printWriter.println("An error has occured!");

        } catch (CatchException e) {
            System.out.println("An error has occured!");
            printWriter.println("An error has occured!");
        }
        request.setAttribute("f1",firstOperand);
        request.setAttribute("f2",secondOperand);
        request.setAttribute("operator",operator);
        request.setAttribute("result",result);

        request.getRequestDispatcher("/result.jsp").forward(request,response);

    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}