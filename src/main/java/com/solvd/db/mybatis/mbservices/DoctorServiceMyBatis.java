package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IDoctorDAO;
import com.solvd.db.jdbc.models.Doctor;
import com.solvd.db.mybatis.mbdao.DoctorDAOMyBatis;

import java.util.List;

public class DoctorServiceMyBatis implements IDoctorDAO {

    DoctorDAOMyBatis doctorDAOMyBatis = new DoctorDAOMyBatis();

    @Override
    public Doctor getDoctorByLicenseNumber(String licenseNumber) {
        return null;
    }

    @Override
    public void insert(Doctor doctor) {
        doctorDAOMyBatis.insert(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDAOMyBatis.update(doctor);
    }

    @Override
    public void deleteById(int id) {
        doctorDAOMyBatis.deleteById(id);
    }

    @Override
    public Doctor getById(int id) {
        return doctorDAOMyBatis.getById(id);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorDAOMyBatis.getAll();
    }
}
