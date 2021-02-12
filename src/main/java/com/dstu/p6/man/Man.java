package com.dstu.p6.man;

import java.io.Serializable;

public abstract class Man
        implements com.dstu.p6.interfaces.Man, Serializable {

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
