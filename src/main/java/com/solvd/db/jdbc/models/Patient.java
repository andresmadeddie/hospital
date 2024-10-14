package com.solvd.db.jdbc.models;

import java.sql.Date;

public class Patient {

    private int patientId;
    private Person person;
    private Date admissionDate;
    private Date dischargeDate;
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
