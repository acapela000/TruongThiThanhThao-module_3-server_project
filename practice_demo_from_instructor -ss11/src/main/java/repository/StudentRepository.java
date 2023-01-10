package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository{
    private static List<Student> studentList = new ArrayList<>();
    static {
        studentList.add(new Student(1,"thao1",true,5,1));
        studentList.add(new Student(2,"thao2",true,6,1));
        studentList.add(new Student(3,"thao3",false,7,1));
        studentList.add(new Student(4,"thao4",true,8,1));
        studentList.add(new Student(5,"thao5",false,9,1));

    }

    @Override
    public List<Student> findAll() {
        //cần kết nối db để lấy listStudent rồi return
        return studentList;
    }

    @Override
    public Student findById(int Id) {
        return null;
    }

    @Override
    public boolean save(Student student) {
        return studentList.add(student);
    }

    @Override
    public boolean delete(int Id) {
        return false;
    }
}
