package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "management")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("management")
public class Management {

    @XmlAttribute
    @JsonProperty("managementId")
    private int managementId;

    @XmlElement(name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement(name = "department")
    @JsonProperty("department")
    private String department;

    @XmlElement(name = "position")
    @JsonProperty("position")
    private String position;

    @XmlElement(name = "hireDate")
    @JsonProperty("hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
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

    @Override
    public String toString() {
        return "Management{" +
                "managementId=" + managementId +
                ", person=" + person +
                ", department='" + department + '\'' +
                ", position='" + position + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
