package service;

import model.Customer;
import repository.CustomerRepository;
import repository.ICustomerRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        //(?) tại sao chỗ này return rồi lại new?
        //(?) .values() nghĩa là gì
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public boolean save(Customer customer) {
        customerRepository.save(customer);
        return false;
    }

    @Override
    public boolean update(int id, Customer customer) {
        customerRepository.update(id,customer);
        return false;
    }

    @Override
    public boolean remove(int id) {
       customerRepository.remove(id);
       return false;
    }
}
