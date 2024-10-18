package com.solvd.db.jdbc.models;

import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "administrativeEmployee")
@XmlAccessorType(XmlAccessType.FIELD)
public class AdministrativeEmployee {

    @XmlAnyAttribute
    private int adminId;

    @XmlElement(name = "person", type = Person.class)
    private Person person;

    @XmlElement (name = "department")
    private String department;

    @XmlElement (name = "hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
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
