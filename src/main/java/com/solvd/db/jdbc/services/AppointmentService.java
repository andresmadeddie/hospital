package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.AppointmentDAO;
import com.solvd.db.jdbc.interfaces.IAppointmentDAO;
import com.solvd.db.jdbc.models.Appointment;

import java.util.List;

public class AppointmentService implements IAppointmentDAO {

    AppointmentDAO appointmentDAO = new AppointmentDAO();

    @Override
    public Appointment getAppointmentByPatientFirstName(String PatientFirstName) {
        return null;
    }

    @Override
    public void insert(Appointment appointment) {
        appointmentDAO.insert(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentDAO.update(appointment);
    }

    @Override
    public void deleteById(int id) {
        appointmentDAO.deleteById(id);
    }

    @Override
    public Appointment getById(int id) {
        return appointmentDAO.getById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentDAO.getAll();
    }
}
