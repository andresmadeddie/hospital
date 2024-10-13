package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Doctor;

public interface IDoctorDAO extends IBaseDao<Doctor> {

    Doctor getDoctorByLicenseNumber(String licenseNumber);
}
