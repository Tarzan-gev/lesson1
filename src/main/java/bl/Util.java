package bl;

import java.sql.*;


public class Util {

    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1982";


    static {
        try {
            Class.forName("jdbc:mysql://localhost:3306/mydbtest1");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
