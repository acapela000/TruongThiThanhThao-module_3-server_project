package repository;

import model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryImpl implements IEmployeeRepository {

    public static Connection connection = BaseRepository.getConnectionDB();

    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from ss12_pract_employee;");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                Employee employee = new Employee(id,name,email,address);
                employeeList.add(employee);
            }
        } catch (SQLException e) {
          e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public List<Employee> findByName(String name) {
        return null;
    }

    @Override
    public boolean save(Employee employee) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into ss12_pract_employee values (?,?,?,?);");
            preparedStatement.setInt(1,employee.getId());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getEmail());
            preparedStatement.setString(4,employee.getAddress());
            return preparedStatement.executeUpdate() > 0 ;
        } catch (SQLException ex) {
        ex.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(int it, Employee employee) {
        return true;
    }

    @Override
    public boolean remove(int id) {
        return true;
    }

}
