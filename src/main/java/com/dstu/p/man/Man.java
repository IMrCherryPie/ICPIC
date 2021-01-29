package com.dstu.p.man;

import java.io.Serializable;

public class Man
        implements com.dstu.p.interfaces.Man, Serializable {

    private String name;

    private String patronymic;

    private String surname;



    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
