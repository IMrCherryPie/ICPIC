package com.dstu.p8;

import com.dstu.p6.interfaces.Man;
import com.dstu.p6.service.ServiceReadWrite;
import com.dstu.p6.student.Student;
import com.dstu.p8.workWithDB.WorkWithDB;

import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

public class App8 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String pathStudentBD = "src/main/resources/test.txt";

        String userName = "root";
        String password = "root";
        String connectionURL = "jdbc:mysql://localhost:3306/People?useUnicode=true&useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&serverTimezone=UTC";
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (java.sql.Connection connection = DriverManager.getConnection(connectionURL, userName, password);
             Statement statement = connection.createStatement()) {
            System.out.println("We're connected");

            ServiceReadWrite read = new ServiceReadWrite();
            ArrayList<Student> students = read.readStudent(pathStudentBD);

            new WorkWithDB<Student>().addNewData(students, statement);

            String sql = "INSERT INTO Products (ProductName, Price) Values (?, ?)";
//            statement.executeUpdate("DROP TABLE Books");
//            statement.executeUpdate("CREATE TABLE IF NOT EXISTS teacher (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY(id));");
//            statement.executeUpdate("INSERT INTO teacher (name, patronymic, surname, position, department, experience) " +
//                    "VALUES ('Victor', 'Victorov', 'Victorovich', 'Doc. of since', 'IIVT', 3)");
//            statement.executeUpdate("INSERT INTO student (name, patronymic, surname, `group`, course) " +
////                    "VALUES ('Victor', 'Victorov', 'Victorovich', 'VIS31', 3)");


            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM student");
            ResultSet resultSet = preparedStatement.executeQuery();
            printResultSetStudentOrTeacher(resultSet, true);

            preparedStatement = connection.prepareStatement("SELECT * FROM teacher");
            resultSet = preparedStatement.executeQuery();
            printResultSetStudentOrTeacher(resultSet, false);

            conditionalRequest(connection);


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }

    private static void conditionalRequest(Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        Scanner in = new Scanner(System.in);

        System.out.println("Введите название таблицы и нажмите Enter");
        String nameTable = in.nextLine();

        System.out.println("Введите имя и нажмите Enter");
        String name = in.nextLine();

        preparedStatement = connection.prepareStatement("SELECT * FROM " + nameTable +" WHERE name =  '" + name + "'" );
        resultSet = preparedStatement.executeQuery();
        printResultSetStudentOrTeacher(resultSet, true);
    }

    private static void printResultSetStudentOrTeacher(ResultSet resultSet, Boolean studentOrTeacher) throws SQLException {
        if(studentOrTeacher) {
            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                String surname = resultSet.getString("surname");
                String group = resultSet.getString("group");
                int course = resultSet.getInt("course");

                System.out.printf("%d. %s %s %s %s %d \n", id, name, patronymic, surname, group, course);
            }
        }else{
            while (resultSet.next()) {

                int id = resultSet.getInt("Id");
                String name = resultSet.getString("name");
                String patronymic = resultSet.getString("patronymic");
                String surname = resultSet.getString("surname");
                String position = resultSet.getString("position");
                String department = resultSet.getString("department");
                int experience = resultSet.getInt("experience");

                System.out.printf("%d. %s %s %s %s %s %d \n", id, name, patronymic, surname, position, department, experience);
            }
        }
    }
}
