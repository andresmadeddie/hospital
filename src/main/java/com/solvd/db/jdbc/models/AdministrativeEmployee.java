package com.solvd.db.jdbc.models;

import java.sql.Date;

public class AdministrativeEmployee {

    private int adminId;
    private Person person;
    private String department;
    private Date hireDate;

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
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

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "AdministrativeEmployee{" +
                "adminId=" + adminId +
                ", person=" + person +
                ", department='" + department + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
