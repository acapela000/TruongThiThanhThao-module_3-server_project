package repository;

import model.Student;

import java.util.List;

public interface IStudentRepository {

    List<Student> findAll();
    Student findById(int Id);
    boolean save(Student student);
    boolean delete(int Id);
}
