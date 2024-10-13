package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Appointment;

public interface IAppointmentDAO extends IBaseDao<Appointment> {

    Appointment getAppointmentByPatientFirstName(String PatientFirstName);
}
