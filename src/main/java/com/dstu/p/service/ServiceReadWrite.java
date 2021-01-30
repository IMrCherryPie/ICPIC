/**
 * Popov IU
 * 30.01.2021
 *
 */

package com.dstu.p.service;

import com.dstu.p.teacher.Teacher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServiceReadWrite
    implements com.dstu.p.interfaces.ServiceReadWrite {
    /**
     * Принимает на вход путь к файлу с базоай данных. Возвращает список обектов Student
     * Считывает посимвольно и записывает в объект, как только строка полностью считана отправляет объект в ArrayList
    */
    public ArrayList<com.dstu.p.student.Student> readStudent(String nameFile) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<com.dstu.p.student.Student> listStudents = new ArrayList<>();
        try (FileReader reader = new FileReader(nameFile)) {
            // читаем посимвольно
            int c;
            int i = 0;
            com.dstu.p.student.Student student = new com.dstu.p.student.Student();
            while ((c = reader.read()) != -1) {
                if (c != 44 && c != 13 && c != 10 ) {
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
                if (c == 10) {
                    i = 0;
                    stringBuilder = new StringBuilder();
                    listStudents.add(student);
                    student = new com.dstu.p.student.Student();
                }
            }
            student.setCourse(stringToInt(stringBuilder.toString()));
            listStudents.add(student);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listStudents;
    }

    /**
     * Принимает на вход путь к файлу с базоай данных. Возвращает список обектов Teacher
     * Считывает посимвольно и записывает в объект, как только строка полностью считана отправляет объект в ArrayList
     */
    public ArrayList<Teacher> readTeacher(String filePath) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Teacher> listTeacher = new ArrayList<>();
        try (FileReader reader = new FileReader(filePath)) {
            // читаем посимвольно
            int c;
            int i = 0;
            Teacher teacher = new Teacher();
            while ((c = reader.read()) != -1) {
                if (c != 44 && c != 13 && c != 10 ) {
                    stringBuilder.append((char) c);
                }
                if (c == 44 || c == 10) {
                    switch (i) {
                        case (0):
                            teacher.setName(stringBuilder.toString());
                            break;
                        case (1):
                            teacher.setSurname(stringBuilder.toString());
                            break;
                        case (2):
                            teacher.setPatronymic(stringBuilder.toString());
                            break;
                        case (3):
                            teacher.setDepartment(stringBuilder.toString());
                            break;
                        case (4):
                            teacher.setPosition(stringBuilder.toString());
                            break;
                        case (5):
                            teacher.setExperience(stringToInt(stringBuilder.toString()));
                            break;
                        default:
                            System.out.println("Switch не сработал");
                            break;
                    }
                    stringBuilder = new StringBuilder();
                    i++;
                }
                if (c == 10) {
                    i = 0;
                    stringBuilder = new StringBuilder();
                    listTeacher.add(teacher);
                    teacher = new Teacher();
                }
            }
            teacher.setExperience(stringToInt(stringBuilder.toString()));
            listTeacher.add(teacher);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return listTeacher;
    }
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

    /**
     * Получает на вход путь к документу, в который нужно записать строку, строку и записывает её в конец документа
     */
    public void save(String fileName, String str) {

        try (FileWriter writer = new FileWriter(fileName, true)) {
            // запись всей строки
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void toLog(String str) {

        String filePath = "";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // запись всей строки
            writer.write(str);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
