package com.dstu.p8.workWithDB.dirty;

import com.dstu.p8.Service;

import java.sql.*;

public class ReaderRunImpl implements Runnable {
    Connection connection;
    public ReaderRunImpl(Connection connReader) {
        this.connection = connReader;
    }

    @Override
    public void run() {
        try {
            PreparedStatement preparedStatement;
            Service service = new Service();
            preparedStatement = connection.prepareStatement("SELECT * FROM Student WHERE id = 5" );
            ResultSet resultSet = preparedStatement.executeQuery();
            service.printResultSetStudentOrTeacher(resultSet, true);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
