/**
 * Product by The Ivan
 *
 */
package com.dstu.entity;

import javax.persistence.*;

@Entity
@Table(name = "STUDENT")
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "SURNAME")
    private String surname;

    @OneToOne(cascade = CascadeType.ALL)
    private Party group;

    @Column(name = "COURSE")
    private int course;

    public Student() {
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

    public Party getGroup() {
        return group;
    }

    public void setGroup(Party group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return  "id: " + id +
                " name: " + name +
                " patronymic: " + patronymic +
                " surname: " + surname +
                " group: " + group +
                " course: " + course
                ;
    }
}
