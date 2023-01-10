package service;

import model.Employee;
import repository.EmployeeRepositoryImpl;
import repository.IEmployeeRepository;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    public final IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByName(String name) {
        return employeeRepository.findByName(name);
    }

    @Override
    public boolean save(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean update(int id, Employee employee) {
        employeeRepository.update(id,employee);
        return true;
    }

    @Override
    public boolean remove(int id) {
        employeeRepository.remove(id);
        return true;
    }
}
