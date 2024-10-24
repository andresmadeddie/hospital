package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IPatientDAO;
import com.solvd.db.jdbc.models.Patient;
import com.solvd.db.mybatis.mbdao.PatientDAOMyBatis;

import java.util.List;

public class PatientServiceMyBatis implements IPatientDAO {

    PatientDAOMyBatis patientDAOMyBatis = new PatientDAOMyBatis();

    @Override
    public Patient getPatientByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Patient patient) {
        patientDAOMyBatis.insert(patient);
    }

    @Override
    public void update(Patient patient) {
        patientDAOMyBatis.update(patient);
    }

    @Override
    public void deleteById(int id) {
        patientDAOMyBatis.deleteById(id);
    }

    @Override
    public Patient getById(int id) {
        return patientDAOMyBatis.getById(id);
    }

    @Override
    public List<Patient> getAll() {
        return patientDAOMyBatis.getAll();
    }
}
