/**
 * Product by The Ivan
 *
 */
package com.dstu.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TEACHER")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PATRONYMIC")
    private String patronymic;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "EXPERIENCE")
    private int experience;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinTable(
            name = "TEACHER_PARTY",
            joinColumns = @JoinColumn(name = "TEACHER_ID"),
            inverseJoinColumns = @JoinColumn(name = "PARTY_ID")
    )
    private List<Party> groups = new ArrayList<Party>();

    public Teacher() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public List<Party> getGroup() {
        return groups;
    }

    public void setGroup(ArrayList<Party> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "id: " + id +
                " name: " + name +
                " patronymic: " + patronymic +
                " surname: " + surname +
                " position: " + position +
                " department: " + department +
                " experience: " + experience
                ;
    }
}
