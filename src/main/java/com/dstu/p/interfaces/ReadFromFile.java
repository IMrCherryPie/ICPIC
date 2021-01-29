package com.dstu.p.interfaces;

import java.util.ArrayList;

public interface ReadFromFile {
    ArrayList<Student> readStudent(String filePath);
    void readTeacher(String filePath);
}
