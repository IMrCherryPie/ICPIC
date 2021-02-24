package com.dstu.p8.workWithDB.dirty;

import java.sql.*;

public class PaymentRunImpl implements Runnable {
    Connection connection;
    public PaymentRunImpl(Connection connPymt) {
        this.connection = connPymt;
    }

    @Override
    public void run() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Student SET course = 2 WHERE id = 5");
            statement.executeUpdate("DELETE FROM Student WHERE id = 2");
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
