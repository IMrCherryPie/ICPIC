package com.dstu.domain;

import com.dstu.dao.PartyDAO;
import com.dstu.dao.StudentDAO;
import com.dstu.dao.TeacherDAO;
import com.dstu.entity.Party;
import com.dstu.entity.PartyStudent;
import com.dstu.entity.Student;
import com.dstu.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Domain {
    public static void main(String[] args) {

        PartyDAO partyDAO = new PartyDAO();
        ArrayList<Party> partys = (ArrayList<Party>) partyDAO.findAll(Party.class);
        System.out.println(partys);

        StudentDAO studentDAO = new StudentDAO();
        ArrayList<Student> students = (ArrayList<Student>) studentDAO.findAll(Student.class);
        System.out.println(students);

        TeacherDAO teacherDAO = new TeacherDAO();
        ArrayList<Teacher> teachers = (ArrayList<Teacher>) teacherDAO.findAll(Teacher.class);
        System.out.println(teachers);

        System.out.println("--------------");

        System.out.println(teachers.get(0).getGroup());

        System.out.println("--------------");

        joinTable(studentDAO);

    }

    private static void joinTable(StudentDAO studentDAO) {
        List<Object[]> partyStudentList = studentDAO.findJ();

        List<PartyStudent> partyStudentList1 = new ArrayList<>();

        for (Object[] row : partyStudentList) {

            PartyStudent partyStudent = new PartyStudent();

            partyStudent.setSt_id((Integer) row[0]);
            partyStudent.setSt_name((String) row[1]);
            partyStudent.setPatronymic((String) row[2]);
            partyStudent.setSurname((String) row[3]);
            partyStudent.setSt_group_id((Integer) row[4]);
            partyStudent.setCourse((Integer) row[5]);
            partyStudent.setPat_id((Integer) row[6]);
            partyStudent.setPat_name((String) row[7]);

            System.out.println(partyStudent.getCourse());
            partyStudentList1.add(partyStudent);
        }
        System.out.println(partyStudentList1);
    }
}
