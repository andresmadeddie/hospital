package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.PatientDAO;
import com.solvd.db.jdbc.interfaces.IPatientDAO;
import com.solvd.db.jdbc.models.Patient;

import java.util.List;

public class PatientService implements IPatientDAO {

    PatientDAO patientDAO = new PatientDAO();

    @Override
    public Patient getPatientByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Patient patient) {
        patientDAO.insert(patient);
    }

    @Override
    public void update(Patient patient) {
        patientDAO.update(patient);
    }

    @Override
    public void deleteById(int id) {
        patientDAO.deleteById(id);
    }

    @Override
    public Patient getById(int id) {
        return patientDAO.getById(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAO.getAll();
    }
}
