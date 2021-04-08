package com.dstu.entity;


public class PartyStudent {

    private int st_id;

    private String st_name;

    private String patronymic;

    private String surname;

    private int st_group_id;

    private int course;

    private int pat_id;

    private String pat_name;



    public PartyStudent() {
    }

    public int getSt_id() {
        return st_id;
    }

    public void setSt_id(Integer st_id) {
        this.st_id = st_id;
    }

    public String getSt_name() {
        return st_name;
    }

    public void setSt_name(String st_name) {
        this.st_name = st_name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSt_group_id() {
        return st_group_id;
    }

    public void setSt_group_id(int st_group_id) {
        this.st_group_id = st_group_id;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public int getPat_id() {
        return pat_id;
    }

    public void setPat_id(int pat_id) {
        this.pat_id = pat_id;
    }

    public String getPat_name() {
        return pat_name;
    }

    public void setPat_name(String pat_name) {
        this.pat_name = pat_name;
    }

    @Override
    public String toString() {
        return "st_id: " + st_id + "\n" +
                "st_name: " + st_name + "\n"+
                "patronymic: " + patronymic + "\n"+
                "surname: " + st_id + "\n"+
                "st_group_id: " + st_group_id + "\n"
                        ;
    }
}
