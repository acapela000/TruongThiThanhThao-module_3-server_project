package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
    Customer findById(int id);
    boolean save(Customer customer);
    boolean update(int id, Customer customer);
    boolean remove(int id);

}
