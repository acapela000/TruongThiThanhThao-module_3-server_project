package repository.impl;

import model.Customer;
import model.Employee;
import repository.IEmployeeRepository;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    private static Connection connection = BaseRepository.getConnectionDB();
    private PreparedStatement preparedStatement;

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement("select * from employee;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int idCard = resultSet.getInt("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divitionId = resultSet.getInt("divition_id");
                String username = resultSet.getString("username");
                Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divitionId, username);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = null;
        try {
            preparedStatement = connection.prepareStatement("select * from employee where id = ?;");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                int idCard = resultSet.getInt("id_card");
                Double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divitionId = resultSet.getInt("divition_id");
                String username = resultSet.getString("username");
                employee = new Employee(name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationDegreeId, divitionId, username);
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return employee;
    }

    @Override
    public boolean save(Employee employee) {
        try {
            preparedStatement = connection.prepareStatement("insert into employee (name, date_of_birth, id_card, salary, phone_number, email, address, position_id, education_degree_id, divition_id, username) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setInt(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6,employee.getEmail());
            preparedStatement.setString(7, employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivitionId());
            preparedStatement.setString(11,employee.getUsername());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(Employee employee) {
        try {
            //int id, String name, String dateOfBirth, int idCard, double salary, String phoneNumber, String email,
            // String address, int positionId, int educationDegreeId, int divitionId, String username)
            preparedStatement = connection.prepareStatement("update employee set `name`=?, date_of_birth=?, id_card=?, salary=?, phone_number=?, email=?, address=?, position_id=?, education_degree_id=?, divition_id=?, username=? where id=?;");
            preparedStatement.setString(1,employee.getName());
            preparedStatement.setString(2, employee.getDateOfBirth());
            preparedStatement.setInt(3,employee.getIdCard());
            preparedStatement.setDouble(4,employee.getSalary());
            preparedStatement.setString(5,employee.getPhoneNumber());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setString(7,employee.getAddress());
            preparedStatement.setInt(8,employee.getPositionId());
            preparedStatement.setInt(9,employee.getEducationDegreeId());
            preparedStatement.setInt(10,employee.getDivitionId());
            preparedStatement.setString(11,employee.getUsername());
            preparedStatement.setInt(12,employee.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean remove(int id) {
        try {
            preparedStatement = connection.prepareStatement("delete from employee where id = ?;");
            preparedStatement.setInt(1,id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
