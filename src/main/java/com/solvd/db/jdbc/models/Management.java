package com.solvd.db.jdbc.models;

import java.sql.Date;

public class Management {

    private int managementId;
    private Person person;
    private String department;
    private String position;
    private Date hireDate;

    public int getManagementId() {
        return managementId;
    }

    public void setManagementId(int managementId) {
        this.managementId = managementId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
