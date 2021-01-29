package com.dstu.p.teacher;

import com.dstu.p.man.Man;

import java.io.Serializable;

public class Teacher
        extends Man
        implements com.dstu.p.interfaces.Teacher, Serializable {


    private String position;

    private String department;

    private int experience;

    public Teacher(){};

    public Teacher(String name, String surname, String patronymic, String position, String department, int experience){
        setName(name);
        setSurname(surname);
        setPatronymic(patronymic);
        this.position = position;
        this.department = department;
        this.experience = experience;
    }

    public String getPosition() {
        return position;
    }

    public String getDepartment() {
        return department;
    }

    public int getExperience() {
        return experience;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String toString(){
        return getName() + "," + getSurname() + "," + getPatronymic() + "," + position + "," + department + "," + experience;
    }
}
