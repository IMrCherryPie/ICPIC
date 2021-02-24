package com.dstu.p8.workWithDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CustomConnection {

    String userName = "root";
    String password = "root";
    String connectionURL = "jdbc:mysql://localhost:3306/People?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&serverTimezone=UTC";

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                return DriverManager.getConnection(connectionURL, userName, password);
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                System.out.println("SQLState: " + e.getSQLState());
                System.out.println("VendorError: " + e.getErrorCode());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("SQLException-> ");
            e.printStackTrace();
        }
    }

}
