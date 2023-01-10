package service.impl;

import model.Customer;
import repository.impl.CustomerRepositoryImpl;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
    private final ICustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public List<Customer> findByCustomerTypeId(int customer_type_id) {
        return customerRepository.findByCustomerTypeId(customer_type_id);
    }

    @Override
    public boolean save(Customer customer) {
        customerRepository.save(customer);
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        customerRepository.update(customer);
        return true;
    }

    @Override
    public boolean remove(int id) {
        customerRepository.remove(id);
        return false;
    }
}
