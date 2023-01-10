package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseRepository {
    //sao cần static chỗ này -> để gọi mà ko cần tạo đối tượng
    private static final String URL = "jdbc:mysql://localhost:3306/student_ss12_jdbc";
    private static final String USER = "root";
    private static final String PASS = "CodeGym@@@123";

    public static Connection getConnectDB() {

        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
