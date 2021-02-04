package com.dstu.p.interfaces;

import com.dstu.p.student.Student;
import com.dstu.p.teacher.Teacher;

import java.util.ArrayList;

public interface ServiceReadWrite {

    ArrayList<Student> readStudent(String filePath);
    ArrayList<Teacher> readTeacher(String filePath);
    void save(String fileName, String str);
}
