package service;

import model.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> findAll();
    Employee findById(int id);
    boolean save(Employee employee);
    boolean update(Employee employee);
    boolean remove(int id);

}
