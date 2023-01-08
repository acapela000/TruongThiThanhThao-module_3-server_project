package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {// create_table
    private static String DB_NAME = "jdbc:mysql://localhost:3306/ss12_pract_customer";
    private static String USER = "root";
    private static String PASSWORD = "CodeGym@@@123";

    public static Connection getConnectionDB() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_NAME,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
