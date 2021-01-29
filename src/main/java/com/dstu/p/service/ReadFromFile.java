package com.dstu.p.service;

import com.dstu.p.student.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFromFile implements com.dstu.p.interfaces.ReadFromFile {

        public  ArrayList<com.dstu.p.interfaces.Student> readStudent(String nameFile) {

            StringBuilder stringBuilder = new StringBuilder();
            ArrayList<com.dstu.p.interfaces.Student> listStudents = new ArrayList<>();
            try (FileReader reader = new FileReader(nameFile)) {
                // читаем посимвольно
                int c;
                String name;
                String surname;
                String patronymic;
                String group;
                int course;
                int i = 0;
                com.dstu.p.interfaces.Student student = new Student();

                while ((c = reader.read()) != -1) {
                    if (c!=44 )
                        stringBuilder.append((char) c);
                    if (c == 44 || c == 10) {
                        switch (i) {
                            case (0):
                                student.setName(stringBuilder.toString());
                                break;
                            case (1):
                                student.setSurname(stringBuilder.toString());
                                break;
                            case (2):
                                student.setPatronymic(stringBuilder.toString());
                                break;
                            case (3):
                                student.setGroup(stringBuilder.toString());
                                break;
                            case (4):
                                student.setCourse(stringToInt(stringBuilder.toString()));
                                break;
                            default:
                                System.out.println("Switch не сработал");
                                break;
                        }
                        stringBuilder = new StringBuilder();
                        i++;
                    }
                    if (c == 10){
                        i = 0;
                        stringBuilder = new StringBuilder();
                        listStudents.add(student);
                        student = new Student();
                    }
                }
                student.setCourse(stringToInt(stringBuilder.toString()));
                listStudents.add(student);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            return listStudents;
        }


    public void readTeacher(String filePath) {

    }

    private int stringToInt (String string){
        try {
            int in = Integer.parseInt(string);
            return in;
        } catch (NumberFormatException e) {
            System.err.print(string + "Неправильный формат строки!\n");
        }
        return 0;
    }
}
