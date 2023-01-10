package service.impl;

import model.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepositoryImpl;
import service.IEmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    private final IEmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public boolean save(Employee employee) {
        employeeRepository.save(employee);
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        employeeRepository.update(employee);
        return true;
    }

    @Override
    public boolean remove(int id) {
        employeeRepository.remove(id);
        return true;
    }
}
