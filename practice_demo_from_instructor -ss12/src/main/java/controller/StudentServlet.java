package controller;

import model.Student;
import service.IStudentService;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
//1 đối tượng là 1 servlet, ex: studentServlet, customerServlet...
//tất cả method cho đối tượng đó đều bỏ vào trong Servlet
public class StudentServlet extends HttpServlet {

    private IStudentService studentService = new StudentService();

    // ================== doPost ==================
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        
        String action = request.getParameter("action");
        //(?) action này để làm gì? -> action để đại diện cho phương thức của đối tượng, ex:add,edit,delete...
        
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                save(request,response);
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                break;
        }
    }

    // ================== save(method) ==================
    private void save(HttpServletRequest request, HttpServletResponse response) {
        //(?) tại sao lại tạo các biến này tại đây -> lấy dữ liệu từ form
        //do trong student các dữ liệu mặc định là string nên cần tạo các biến này vs các kiểu dl khác nhau lấy đc từ form
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        float point = Float.parseFloat(request.getParameter("point"));
        int classId = Integer.parseInt(request.getParameter("class_id"));//getParameter là lấy dữ liệu bên SQL: (class_id) tên phải giống với tên biến bên SQL
        //classId là lấy theo Student(java)

        //(?) tại sao cần tạo đối tượng mới chỗ này
        //đối tượng này là nơi thông tin lấy đc từ form(thông tin user nhập vào) đổ về đây
        Student student = new Student(id,name,gender,point,classId);
        
        //(?) check này dùng để làm gì -> check xem add ok hay chưa
        boolean check = studentService.save(student);
        String msg = "Thêm mới thành công";
        
        if (!check) {
            msg = "Thêm mới ko thành công";
        }
        
        request.setAttribute("name",msg);
        showFormCreate(request,response);

    }

    // ================== showFormCreate ==================
    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.getRequestDispatcher("view/student/create.jsp").forward(request,response);
        } catch (ServletException e) {
            //throw new RuntimeException(e);
            e.printStackTrace(); //xem lại printStackTrace()
        } catch (IOException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

    }

    // ================== showList ==================
    private void showList(HttpServletRequest request,HttpServletResponse response) {

        List<Student> studentList = studentService.findAll();
        request.setAttribute("studentList",studentList);

        try {
            request.getRequestDispatcher("view/student/list.jsp").forward(request,response);
        } catch (ServletException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        } catch (IOException e) {
            //throw new RuntimeException(e);
            e.printStackTrace();
        }

    }

    // ================== doGet ==================
    protected void doGet (HttpServletRequest request, HttpServletResponse response) {
        String action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                showFormCreate(request,response);
                break;
            default:
                showList(request,response);
                break;
        }
    }

}