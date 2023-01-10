package repository;

import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{

    private static String SELECT_ALL = "select * from student";

    private final String INSERT_INTO = "insert into student(id,name,gender,point,class_id) values(?,?,?,?,?)";
    //số lượng ? tương ứng với số lượng tham số muốn insert into vào table

    @Override
    public List<Student> findAll() {
        List<Student> studentList = new ArrayList<>();
        //cần kết nối db để lấy listStudent rồi return
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");//id: tên cột
                String name = resultSet.getString("name");
                boolean gender = resultSet.getBoolean("gender");
                float point = resultSet.getFloat("point");
                int classId = resultSet.getInt("class_id");

                Student student = new Student(id,name,gender,point,classId);
                studentList.add(student);
            }
        } catch (SQLException throwables) {
            //throw new RuntimeException(e);
            throwables.printStackTrace();
        }

        return studentList;
    }

    @Override
    public Student findById(int Id) {
        return null;
    }

    @Override
    public boolean save(Student student) {

        Connection connection = BaseRepository.getConnectDB();
        try { //số lượng set cho prepareStatement phải bằng và theo thứ tự với số lượng tham số của insert into
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setBoolean(3,student.isGender());
            preparedStatement.setFloat(4,student.getPoint());
            preparedStatement.setInt(5,student.getClassId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false ;
        //studentList.add(student);
    }

    @Override
    public boolean delete(int Id) {
        return false;
    }
}
