package com.dstu.p6.interfaces;

import com.dstu.p6.student.Student;
import com.dstu.p6.teacher.Teacher;

import java.util.ArrayList;

public interface ServiceReadWrite {

    ArrayList<Student> readStudent(String filePath);
    ArrayList<Teacher> readTeacher(String filePath);
    void save(String fileName, String str);
}
