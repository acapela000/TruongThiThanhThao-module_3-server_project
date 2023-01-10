package repository;

import model.Employee;

import java.util.List;

public interface IEmployeeRepository {

    List<Employee> findAll();

    Employee findById(int id);

    List<Employee> findByName(String name);

    boolean save(Employee employee);
    boolean update(int it, Employee employee);
    boolean remove(int id);

}
