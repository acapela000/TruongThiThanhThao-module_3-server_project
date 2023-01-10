package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    List<Employee> findByName(String name);

    boolean save(Employee employee);
    boolean update(int id, Employee employee);
    boolean remove(int id);

}
