package service;

import model.Student;
import repository.IStudentRepository;
import repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public List<Student> findAll() {
        //findAll này là method bên Repository
        return studentRepository.findAll();

    }

    @Override
    public Student findById(int id) {
        //(?) tại sao chỗ này để null
        //-> do chưa có data về student thì ko tìm = id đc nên để
        // null để ko bị lỗi
        return null;
    }

    @Override
    public boolean save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public boolean delete(int id) {
        //(?) tại sao return false
        //-> tương tự như findById
        return false;
    }
}
