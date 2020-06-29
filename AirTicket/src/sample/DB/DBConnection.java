package sample.DB;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/air_ticket";
    private static final String userName = "root";
    private static final String password = "randompass123";
    private static Connection connection;

    private DBConnection() {
    }

    public static Connection getConnection() {

        try {
            if (connection == null || connection.isClosed()) {

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, userName, password);
            }


        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
        }

        return connection;

    }

    public static void closeConnection() {

        try {
            if (connection != null && !connection.isClosed())
                connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
