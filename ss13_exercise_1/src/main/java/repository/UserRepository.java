package repository;

import com.mysql.cj.jdbc.ConnectionImpl;
import model.User;
import repository.impl.BaseUserRepository;
import repository.impl.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private static final String INSERT_USERS_SQL = "insert into users(name,email,country) values (?,?,?);";
    private static final String SELECT_USER_BY_ID = "select * from users where id=?";
    private static final String SELECT_USER_BY_COUNTRY = "select * from users where country=?";
    private static final String SELECT_ALL_USERS = "select*from users;";
    private static final String DELETE_USERS_SQL = "delete from users where id=?;";
    private static final String UPDATE_USERS_SQL = "update users set name=?,email=?,country=? where id=?;";

    @Override
    public boolean save(User user) {
        Connection connection = BaseUserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        Connection connection = BaseUserRepository.getConnectDB();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean update(User user) {
        Connection connection = BaseUserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.setInt(4, user.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = BaseUserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USERS_SQL);
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public User findById(int id) {
        User user = null;
        Connection connection = BaseUserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                user = new User(name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findByCountry(String country) {
        List<User> list = new ArrayList<>();
        Connection connection = BaseUserRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_COUNTRY);
            preparedStatement.setString(1,country);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String countrynew=resultSet.getString("country");
                User user= new User(id, name, email,countrynew);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PreparedStatement preparedStatement1 = null;

        ResultSet resultSet = null;
        try {
            connection = BaseUserRepository.getConnectDB();

            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(INSERT_USERS_SQL, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, user.getName());

            preparedStatement.setString(2, user.getEmail());

            preparedStatement.setString(3, user.getCountry());

            int rowAffected = preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

            int userId = 0;
            if (resultSet.next())

                userId = resultSet.getInt(1);

            if (rowAffected == 1) {
                String sqlPivot = "INSERT INTO user_permision(user_id,permision_id) " + "VALUES(?,?)";
                preparedStatement1 = connection.prepareStatement(sqlPivot);

                for (int permisionId : permision) {

                    preparedStatement1.setInt(1, userId);

                    preparedStatement1.setInt(2, permisionId);

                    preparedStatement1.executeUpdate();
                }
                connection.commit();
            } else {
                connection.rollback();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }


