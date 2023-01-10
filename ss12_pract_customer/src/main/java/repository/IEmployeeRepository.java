package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();
    Employee findById(int id);
    boolean save(Employee employee);
    boolean update(Employee employee);
    boolean remove(int id);

}
