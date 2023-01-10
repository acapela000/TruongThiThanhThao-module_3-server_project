package repository;

import model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements ICustomerRepository {
    private static Map<Integer,Customer> customerMap;

    static {
        customerMap = new HashMap<>();
        customerMap.put(1, new Customer(1,"John","john@gmail.com","NZ"));
        customerMap.put(2,new Customer(2,"Bill","bill@gmail.com","LA"));
        customerMap.put(3,new Customer(3,"Alex","alex@gmail.com","AU"));
        customerMap.put(4,new Customer(4,"Adam","adam@gmail.com","CA"));
        customerMap.put(5,new Customer(5,"Sophia","sophia@gmail.com","JP"));
        customerMap.put(6,new Customer(6,"Rose","rose@gmail.com","SP"));
    }

    @Override
    public List<Customer> findAll() {
        //(?) tại sao chỗ này return rồi lại new?
        //(?) .values() nghĩa là gì -> values() trả về Collection<> nên tạo mới ArrayList để chuyển
        //đổi từ Collection sang Arraylist
        return new ArrayList<>(customerMap.values());
    }

    @Override
    public Customer findById(int id) {
        return customerMap.get(id);
    }

    @Override
    public boolean save(Customer customer) {
        customerMap.put(customer.getId(), customer);//put(customer.getId(), customer) = put(key,value)
        return true;
    }

    @Override
    public boolean update(int id, Customer customer) {
        customerMap.put(id,customer);
        return true;
    }

    @Override
    public boolean remove(int id) {
        customerMap.remove(id);
        return true;
    }
}
