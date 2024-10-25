package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "administrativeEmployee")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("administrativeEmployee")
public class AdministrativeEmployee {

    @XmlAnyAttribute
    @JsonProperty("adminId")
    private int adminId;

    @XmlElement(name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement (name = "department")
    @JsonProperty("department")
    private String department;

    @XmlElement (name = "hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("hireDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
