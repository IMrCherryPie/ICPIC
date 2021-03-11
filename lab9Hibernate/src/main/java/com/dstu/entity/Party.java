package com.dstu.entity;

import javax.persistence.*;

@Entity
@Table(name = "PARTY")
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;


    public Party() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name: " + name
                ;
    }
}

