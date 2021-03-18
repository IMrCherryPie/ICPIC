package com.dstu.serice;

import com.dstu.entity.Student;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadWrite {
    public ArrayList<Student> readStudent(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Student> listStudents = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            // читаем посимвольно
            int c;
            int i = 0; // Подсчёт столбцов в строке
            int j = 1; // Подсчёт строк в Базе
            Student student = new Student();
            while ((c = reader.read()) != -1) {
                if (c != 44 && c != 13 && c != 10) {
                    stringBuilder.append((char) c);
                }
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
                            student.setCourse(stringToInt(stringBuilder.toString()));
                            break;
                        default:
                            System.out.println("Обнаружено большее количество столбцов в базе, не все данные обработаны.");
                            break;
                    }
                    stringBuilder = new StringBuilder();
                    i++;
                }
                if (c == 10) {
                    i = 0;
                    j++;
                    stringBuilder = new StringBuilder();
                    listStudents.add(student);
                    student = new Student();
                }
            }
            (student).setCourse(stringToInt(stringBuilder.toString()));
            listStudents.add((Student) student);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listStudents;
    }

    /**
     * Принимает на вход путь к файлу с базоай данных. Возвращает список обектов Teacher
     * Считывает посимвольно и записывает в объект, как только строка полностью считана отправляет объект в ArrayList
     *
     * @return
     */
//    public ArrayList<Teacher> readTeacher(String filePath) {
//        StringBuilder stringBuilder = new StringBuilder();
//        ArrayList<Teacher> listTeacher = new ArrayList<>();
//        try (FileReader reader = new FileReader(filePath)) {
//            // читаем посимвольно
//            int c;
//            int i = 0; // Подсчёт столбцов в строке
//            int j = 1; // Подсчёт строк в Базе
//            Teacher teacher = new Teacher();
//            while ((c = reader.read()) != -1) {
//                if (c != 44 && c != 13 && c != 10) {
//                    stringBuilder.append((char) c);
//                }
//                if (c == 44 || c == 10) {
//                    switch (i) {
//                        case (0):
//                            teacher.setName(stringBuilder.toString());
//                            break;
//                        case (1):
//                            teacher.setSurname(stringBuilder.toString());
//                            break;
//                        case (2):
//                            teacher.setPatronymic(stringBuilder.toString());
//                            break;
//                        case (3):
//                            teacher.setDepartment(stringBuilder.toString());
//                            break;
//                        case (4):
//                            teacher.setPosition(stringBuilder.toString());
//                            break;
//                        case (5):
//                            teacher.setExperience(stringToInt(stringBuilder.toString()));
//                            break;
//                        default:
//                            new ServiceReadWrite().toLog("Line 113 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " +
//                                    "Обнаружено большее количество столбцов в базе, не все данные обработаны. * Обрабатываемый файл: " + filePath + " Строка в БД: " + j);
//                            break;
//                    }
//                    stringBuilder = new StringBuilder();
//                    i++;
//                }
//                if (c == 10) {
//                    j++;
//                    i = 0;
//                    stringBuilder = new StringBuilder();
//                    listTeacher.add(teacher);
//                    teacher = new Teacher();
//                }
//            }
//            teacher.setExperience(stringToInt(stringBuilder.toString()));
//            listTeacher.add(teacher);
//        } catch (IOException ex) {
//            new ServiceReadWrite().toLog("Line 128 * src/main/java/com/dstu/p/service/ServiceReadWrite.java " + ex.getMessage());
//            System.out.println(ex.getMessage());
//        }
//        return listTeacher;
//    }

    /**
     * Преобразует строку в число, если это возможно.
     */
    private int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.err.print(string + "Неправильный формат строки!\n");
        }
        return 0;
    }
}
