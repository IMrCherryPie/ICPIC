package com.dstu.p8;

import com.dstu.p6.service.ServiceReadWrite;
import com.dstu.p6.student.Student;
import com.dstu.p8.workWithDB.CustomConnection;
import com.dstu.p8.workWithDB.WorkWithDBv2;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App8 {

    public static void main(String[] args) throws SQLException {
        String pathStudentBD = "src/main/resources/student.txt";
        CustomConnection customConnection = new CustomConnection();
            Connection connection = customConnection.getConnection();
            if(connection != null) {

                Statement statement = connection.createStatement();

                Service service = new Service();

                ServiceReadWrite read = new ServiceReadWrite();
                ArrayList<Student> students = read.readStudent(pathStudentBD);
                new WorkWithDBv2<Student>().addNewData(students, statement);

                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
                ResultSet resultSet = preparedStatement.executeQuery();
                service.printResultSetStudentOrTeacher(resultSet, true);

                preparedStatement = connection.prepareStatement("SELECT * FROM teacher");
                resultSet = preparedStatement.executeQuery();
                service.printResultSetStudentOrTeacher(resultSet, false);

                service.conditionalRequest(connection);
                customConnection.close(connection);
            }
    }

}
