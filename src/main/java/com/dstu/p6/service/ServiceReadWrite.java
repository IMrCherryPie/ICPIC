/*
 * Popov IU
 * 30.01.2021
 *
 */

package com.dstu.p6.service;

import com.dstu.p6.teacher.Teacher;
import com.dstu.p6.student.Student;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class ServiceReadWrite
    implements com.dstu.p6.interfaces.ServiceReadWrite {
    /**
     * Принимает на вход путь к файлу с базоай данных. Возвращает список обектов Student
     * Считывает посимвольно и записывает в объект, как только строка полностью считана отправляет объект в ArrayList
    */
    public ArrayList<Student> readStudent(String nameFile) {
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<Student> listStudents = new ArrayList<>();
        try (FileReader reader = new FileReader(nameFile)) {
            // читаем посимвольно
            int c;
            int i = 0; // Подсчёт столбцов в строке
            int j = 1; // Подсчёт строк в Базе
            Student student = new Student();
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
                            new ServiceReadWrite().toLog("Line 54 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " +
                                    "Обнаружено большее количество столбцов в базе, не все данные обработаны. * Обрабатываемый файл: " + nameFile + " Строка в БД: " + j);
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
            student.setCourse(stringToInt(stringBuilder.toString()));
            listStudents.add(student);
        } catch (IOException ex) {
            new ServiceReadWrite().toLog("Line 70 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " + ex.getMessage());
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
            int i = 0; // Подсчёт столбцов в строке
            int j = 1; // Подсчёт строк в Базе
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
                            new ServiceReadWrite().toLog("Line 113 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " +
                                    "Обнаружено большее количество столбцов в базе, не все данные обработаны. * Обрабатываемый файл: " + filePath + " Строка в БД: " + j);
                            break;
                    }
                    stringBuilder = new StringBuilder();
                    i++;
                }
                if (c == 10) {
                    j++;
                    i = 0;
                    stringBuilder = new StringBuilder();
                    listTeacher.add(teacher);
                    teacher = new Teacher();
                }
            }
            teacher.setExperience(stringToInt(stringBuilder.toString()));
            listTeacher.add(teacher);
        } catch (IOException ex) {
            new ServiceReadWrite().toLog("Line 128 * src/main/java/com/dstu/p/service/ServiceReadWrite.java " + ex.getMessage());
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
            new ServiceReadWrite().toLog("Line 140 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " + e.getMessage());
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
            new ServiceReadWrite().toLog("Line 156 * src/main/java/com/dstu/p/service/ServiceReadWrite.java *  " + ex.getMessage());
            System.out.println(ex.getMessage());
        }
    }
    public void toLog(String str) {
        String filePath = "src/main/resources/log.txt";
        try (FileWriter writer = new FileWriter(filePath, true)) {
            // запись всей строки
            writer.write(new Date().toString() + " -> " + str + "\n");
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
