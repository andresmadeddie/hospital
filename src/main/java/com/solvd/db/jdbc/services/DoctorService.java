package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.DoctorDAO;
import com.solvd.db.jdbc.interfaces.IDoctorDAO;
import com.solvd.db.jdbc.models.Doctor;

import java.util.List;

public class DoctorService implements IDoctorDAO {

    DoctorDAO doctorDAO = new DoctorDAO();

    @Override
    public Doctor getDoctorByLicenseNumber(String licenseNumber) {
        return null;
    }

    @Override
    public void insert(Doctor doctor) {
        doctorDAO.insert(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDAO.update(doctor);
    }

    @Override
    public void deleteById(int id) {
        doctorDAO.deleteById(id);
    }

    @Override
    public Doctor getById(int id) {
        return doctorDAO.getById(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorDAO.getAll();
    }
}
