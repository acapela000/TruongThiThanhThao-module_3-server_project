package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {
    Connection connection = BaseRepository.getConnectionDB();

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM ss12_pract_customer;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int customer_type_id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("name");
                String date_of_birth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Customer customer = new Customer(id,customer_type_id,name,date_of_birth,gender,id_card,phone_number,email,address);
                customerList.add(customer);
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ss12_pract_customer where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customer_type_id = resultSet.getInt("customer_type_id");
                String name = resultSet.getString("name");
                String date_of_birth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String id_card = resultSet.getString("id_card");
                String phone_number = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                customer = new Customer(id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address);
                }
            } catch (SQLException e) {
        }
        return customer;
    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }

    @Override
    public List<Customer> findByCustomerTypeId(int customer_type_id) {
        return null;
    }

    @Override
    public boolean save(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {//id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
            preparedStatement = connection.prepareStatement("insert into ss12_pract_customer (customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address)  values ( ?, ?, ?, ?, ?, ?, ?, ?);");
            //preparedStatement.setInt(1,customer.getId()); id tự động tăng
            preparedStatement.setInt(1,customer.getCustomer_type_id());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getDate_of_birth());
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getId_card());
            preparedStatement.setString(6,customer.getPhone_number());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Customer customer) {
        PreparedStatement preparedStatement = null;
        try {//id, customer_type_id, name, date_of_birth, gender, id_card, phone_number, email, address
            preparedStatement = connection.prepareStatement("update ss12_pract_customer set customer_type_id = ?, name = ?, date_of_birth = ?, gender = ?, id_card = ?, phone_number = ?, email = ?, address = ? where id = ?;");
            preparedStatement.setInt(1,customer.getCustomer_type_id());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getDate_of_birth());
            preparedStatement.setBoolean(4,customer.isGender());
            preparedStatement.setString(5,customer.getId_card());
            preparedStatement.setString(6,customer.getPhone_number());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getId());
            return preparedStatement.executeUpdate() > 0 ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from ss12_pract_customer where id = ?;");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
