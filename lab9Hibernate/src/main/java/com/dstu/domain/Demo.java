package com.dstu.domain;

import com.dstu.dao.PartyDAO;
import com.dstu.dao.StudentDAO;
import com.dstu.dao.TeacherDAO;
import com.dstu.entity.Party;
import com.dstu.entity.Student;
import com.dstu.entity.Teacher;

import java.util.ArrayList;

public class Demo {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

//        ArrayList<Student> list = new ReadWrite().readStudent("lab9Hibernate/src/main/resources/StudetsBD.txt");
//        for (Student student: list) {
//            System.out.println(student);
//        }

        PartyDAO partyDAO = new PartyDAO();

        ArrayList<Party> parties = (ArrayList<Party>) partyDAO.findAll(Party.class);
        System.out.println(parties);


    }

    private static void createBasicData() throws InstantiationException, IllegalAccessException {


        Party group1 = new Party();
        group1.setName("VIS");
        Party group2 = new Party();
        group2.setName("MIN");

        Teacher teacher1 = new Teacher();

        teacher1.setName("Asya");
        teacher1.setSurname("Petrova");
        teacher1.setPatronymic("Alekseevna");
        teacher1.setDepartment("IIVT");
        teacher1.setPosition("Dr. Of Since");
        teacher1.setExperience(3);
        ArrayList<Party> groups1 = new ArrayList<>();
        groups1.add(group1);
        teacher1.setGroup(groups1);

        Teacher teacher2 = new Teacher();

        teacher2.setName("Maxim");
        teacher2.setSurname("Privalov");
        teacher2.setPatronymic("Vladimirovich");
        teacher2.setDepartment("IIVT");
        teacher2.setPosition("Dr. of Since");
        teacher2.setExperience(6);
        ArrayList<Party> groups2 = new ArrayList<>();
        groups2.add(group2);
        teacher2.setGroup(groups2);

        Student student1 = new Student();

        student1.setName("Ivan");
        student1.setSurname("Popov");
        student1.setPatronymic("Yurevich");
        student1.setCourse(4);
        student1.setGroup(group1);

        Student student2 = new Student();

        student2.setName("Alexandr");
        student2.setSurname("Kovalenko");
        student2.setPatronymic("Grigorievich");
        student2.setCourse(4);
        student2.setGroup(group2);

        PartyDAO partyDAO = new PartyDAO();
        partyDAO.save(group1);
        partyDAO.save(group2);

        TeacherDAO teacherDAO = new TeacherDAO();
        teacherDAO.save(teacher1);
        teacherDAO.save(teacher2);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save(student1);
        studentDAO.save(student2);
    }
}
