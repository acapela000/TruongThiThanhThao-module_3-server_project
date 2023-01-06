/*
package dao;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UserDAO implements IUserDAO {

    private String JDBC_URL = "jdbc:mysql://localhost:3306/ss12_exercise?useSSL=false";
    private String JDBC_USERNAME = "root";
    private String JDBC_PASSWORD = "CodeGym@@@123";

    private static final String INSERT_USERS_SQL = "insert into users(name, email,country) values(?,?,?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id = ?;";
    private static final String SELECT_ALL_USERS = "select * from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
    private static final String UPDATE_USERS_SQL = "update users set name = ?, email = ?, country = ? where id = ?;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL,JDBC_USERNAME,JDBC_PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
           e.printStackTrace();
        } catch (SQLException e) {
           e.printStackTrace();
        }
        return connection;
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public User selectUser(int id) {
        return null;
    }

    @Override
    public List<User> selectAllUser() {
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }
}
*/
