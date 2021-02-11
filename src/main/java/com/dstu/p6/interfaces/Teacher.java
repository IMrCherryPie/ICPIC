package com.dstu.p6.interfaces;

public interface Teacher
    extends Man {

    String getPosition();

    String getDepartment();

    int getExperience();


    void setPosition(String position);

    void setDepartment(String department);

    void setExperience(int experience);


}
