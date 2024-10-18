package com.solvd.db.jdbc.models;

import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Nurse {

    @XmlAttribute
    private int nurseId;

    @XmlElement (name = "person", type = Person.class)
    private Person person;

    @XmlElement (name = "shift")
    private String shift;

    @XmlElement (name = "hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date hireDate;

    public int getNurseId() {
        return nurseId;
    }

    public void setNurseId(int nurseId) {
        this.nurseId = nurseId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseId=" + nurseId +
                ", person=" + person +
                ", shift='" + shift + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
