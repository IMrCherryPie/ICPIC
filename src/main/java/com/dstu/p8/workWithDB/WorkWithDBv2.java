package com.dstu.p8.workWithDB;

import com.dstu.p6.student.Student;
import com.dstu.p6.teacher.Teacher;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

public class WorkWithDBv2<T> {
    private Statement statement;

    public void addNewData(ArrayList<T> arrayListMan, Statement statement) {
        this.statement = statement;
        if (!arrayListMan.isEmpty()) {
            if (arrayListMan.get(0) instanceof com.dstu.p6.interfaces.Student) {
                System.out.println("We are inside");
                simplePushDBStudent((ArrayList<Student>) arrayListMan);
            } else if (arrayListMan instanceof com.dstu.p6.interfaces.Teacher) {
                simplePushDBTeacher((ArrayList<Teacher>) arrayListMan);
            }
        }
    }

    private void simplePushDBStudent(ArrayList<Student> listStudent) {

        for (Student man : listStudent) {
            try {
                if (man instanceof Student) {
                    String tableName = "Student";
                    man.getClass().getSimpleName();
                    String name = man.getName();
                    String patronymic = man.getPatronymic();
                    String surname = man.getSurname();
                    String group = man.getGroup();
                    int course = man.getCourse();
                    System.out.println(man);
                    statement.executeUpdate("INSERT INTO " + tableName + " (`name`, patronymic, surname, `group`, course) " +
                            "VALUES ( '" + name + "', '" + patronymic + "', '" + surname + "', '" + group + "', " + course + ")");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void simplePushDBTeacher(ArrayList<Teacher> listStudent) {

        for (Teacher man : listStudent) {
            try {
                if (man instanceof Teacher) {

                    String tableName = man.getClass().getSimpleName();
                    String name = man.getName();
                    String patronymic = man.getPatronymic();
                    String surname = man.getSurname();
                    String position = man.getPosition();
                    String department =  man.getDepartment();
                    int experience =  man.getExperience();

                    /*statement.executeUpdate("DROP TABLE Teacher");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Teacher (id MEDIUMINT NOT NULL AUTO_INCREMENT, name CHAR(30) NOT NULL, PRIMARY KEY(id));");*/

                    statement.executeUpdate("INSERT INTO"+ tableName + " (`name`, patronymic, surname, `position`, department, experience) " +
                            "VALUES ( '" + name + "'," + "'" + patronymic + "'," + "'" + surname + "'," + "'" + position + "'," + "'" + department + "'," + experience + ")");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
