package com.dstu.p.student;

import com.dstu.p.man.Man;

import java.io.Serializable;

public class Student
        extends Man
        implements com.dstu.p.interfaces.Student, Serializable {

    private String group;

    private int course;

    public Student() {
    }
    public Student(String name, String surname, String patronymic, String group, int course){

        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        setCourse(course);
        setGroup(group);
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group= group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String toString(){
        return getName() + "," + getSurname() + "," + getPatronymic() + "," +  group + "," +  course;
    }




}
