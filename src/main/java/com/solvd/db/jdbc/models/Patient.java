package com.solvd.db.jdbc.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.solvd.db.jaxb.DateAdapter;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.sql.Date;

@XmlRootElement(name = "patient")
@XmlAccessorType(XmlAccessType.FIELD)
@JsonRootName("patient")
public class Patient {

    @XmlAttribute
    @JsonProperty("patientId")
    private int patientId;

    @XmlElement (name = "person", type = Person.class)
    @JsonProperty("person")
    private Person person;

    @XmlElement(name = "admissionDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("admissionDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date admissionDate;

    @XmlElement(name = "dischargeDate")
    @XmlJavaTypeAdapter(DateAdapter.class)
    @JsonProperty("dischargeDate")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dischargeDate;

    @XmlElement(name = "medicalHistory")
    @JsonProperty("medicalHistory")
    private String medicalHistory;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", person=" + person +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", medicalHistory='" + medicalHistory + '\'' +
                '}';
    }
}
