package service;

import model.Student;

import java.util.List;

public interface IStudentService {
    //findAll: display all the els in list
    List<Student> findAll();
    //findById: only display the els is found by Id
    Student findById(int id);

    boolean save(Student student);
    boolean delete(int id);
}
