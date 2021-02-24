package com.dstu.p8.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ServiceRequestAndPrint {

    /**
     * Метод осущетсвляет запрос к таблице, указанной пользоватлем (через консоль) и выдачю всех полученных строк в консоль
     */
    public void conditionalRequest(Connection connection) throws SQLException {
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

    public void printResultSetStudentOrTeacher(ResultSet resultSet, Boolean studentOrTeacher) throws SQLException {
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
