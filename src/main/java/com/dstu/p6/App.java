package com.dstu.p6;

import com.dstu.p6.service.Serialization;
import com.dstu.p6.service.ServiceReadWrite;
import com.dstu.p6.student.Student;
import com.dstu.p6.teacher.Teacher;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        String str11 = "src/main/resources/csv.csv";
        String pathStudent = "src/main/resources/student.bin";
        String teacherPath = "src/main/resources/teacher.bin";

        ServiceReadWrite read = new ServiceReadWrite();
        ArrayList<Student> students = read.readStudent(str11);
        for (Student student :students) {
            System.out.println(student.toString() + "\n");
        }
        new Serialization<Student>().writeObject("src/main/resources/student.bin",students);


        ArrayList<Teacher> teachers = read.readTeacher("src/main/resources/teachers.txt");
        for (Student student :students) {
            System.out.println(student.toString() + "\n");
        }
        new Serialization<Student>().writeObject("src/main/resources/student.bin",students);


        new Serialization<Teacher>().writeObject(teacherPath, teachers);
        new Serialization<Student>().writeObject(pathStudent, students);




    }


}
