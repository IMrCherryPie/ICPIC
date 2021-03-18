package com.dstu.domain;

import com.dstu.dao.PartyDAO;
import com.dstu.dao.StudentDAO;
import com.dstu.dao.TeacherDAO;
import com.dstu.entity.Party;
import com.dstu.entity.Student;
import com.dstu.entity.Teacher;

import java.util.ArrayList;

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

    }
}
