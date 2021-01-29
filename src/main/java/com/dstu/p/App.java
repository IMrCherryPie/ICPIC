package com.dstu.p;

import com.dstu.p.service.Serialization;
import com.dstu.p.student.Student;
import com.dstu.p.teacher.Teacher;

import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        /*com.dstu.p.interfaces.ReadFromFile read = new ReadFromFile();
        ArrayList<Student> students = read.readStudent("D:\\DSTU\\Магистратура\\1 курс\\2 семестр\\Инструментальные средства проектирования информационных систем\\src\\main\\resources\\test.txt");
        for (Student student :students) {
            System.out.println(student.toString() + "\n");
        }*/
        ArrayList<Student> studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Victor","Ivanovich","Alehin","MIG",2));
        studentArrayList.add(new Student("Elizaveta","Igorevna","Alen","NOT",3));

        String pathStudent = "D:\\DSTU\\Магистратура\\1 курс\\2 семестр\\Инструментальные " +
                "средства проектирования информационных систем\\src\\main\\resources\\student.bin";
         new Serialization<Student>().readObject(pathStudent);

        ArrayList<Teacher> teacherArrayList = new ArrayList<>();
        teacherArrayList.add(new Teacher("Katy","Bong","Taylor","Lektor","IIVT",2));
        teacherArrayList.add(new Teacher("Mary","Lonkaster","Meridit","Lektor","MKMT",3));

        String teacherPath = "D:\\DSTU\\Магистратура\\1 курс\\2 семестр\\Инструментальные средства проектирования" +
                " информационных систем\\src\\main\\resources\\teacher.bin";

//        new Serialization<Teacher>().writeObject(teacherPath, teacherArrayList);

        new Serialization<>().readObject(teacherPath);

    }
}
