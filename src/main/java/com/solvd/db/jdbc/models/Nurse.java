package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "nurse")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("nurse")
public class Nurse {

    @XmlAttribute
    @JsonProperty("nurseId")
    private int nurseId;

    @XmlElement (name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement (name = "shift")
    @JsonProperty("shift")
    private String shift;

    @XmlElement (name = "hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("hireDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
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
