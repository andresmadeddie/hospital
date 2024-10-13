package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Patient;

public interface IPatientDAO extends IBaseDao<Patient> {

    Patient getPatientByPersonFirstName(String personFirstName);
}
