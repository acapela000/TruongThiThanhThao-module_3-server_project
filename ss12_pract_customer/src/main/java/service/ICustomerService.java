package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    Customer findById(int id);
    List<Customer> findByName(String name);
    List<Customer> findByCustomerTypeId(int customer_type_id);
    boolean save(Customer customer);
    boolean update(int id, Customer customer);
    boolean remove(int id);
}
