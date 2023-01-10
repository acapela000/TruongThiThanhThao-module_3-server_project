//package repository.impl;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//
//public class BaseRepositoryA {
//
//    private static String DB_NAME = "jdbc:mysql://localhost:3306/ten_database";
//    private static String USER = "root";
//    private static String PASSWORD = "CodeGym@@@123";
//    private static Connection connection = null;
//
//    public static Connection getConnectionDB() {
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(DB_NAME,USER,PASSWORD);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//         catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return connection;
//    }
//
// }
