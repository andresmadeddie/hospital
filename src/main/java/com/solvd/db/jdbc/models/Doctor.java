package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "doctor")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("doctor")
public class Doctor {

    @XmlAttribute
    @JsonProperty("doctorId")
    private int doctorId;

    @XmlElement(name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement (name = "specialization")
    @JsonProperty("specialization")
    private String specialization;

    @XmlElement (name = "licenseNumber")
    @JsonProperty("licenseNumber")
    private String licenseNumber;

    @XmlElement (name = "hireDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("hireDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date hireDate;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "doctorId=" + doctorId +
                ", person=" + person +
                ", specialization='" + specialization + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", hireDate=" + hireDate +
                '}';
    }
}
