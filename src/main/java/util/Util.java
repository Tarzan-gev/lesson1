package util;

import java.sql.*;


public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1982";


    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("Драйвер MySQL не найден!");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение с БД установлено!");
        } catch (SQLException e) {
            System.err.println("Ошибка подключения к БД: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

}
