package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IAppointmentDAO;
import com.solvd.db.jdbc.models.Appointment;
import com.solvd.db.mybatis.mbdao.AppointmentDAOMyBatis;

import java.util.List;

public class AppointmentServiceMyBatis implements IAppointmentDAO {

    AppointmentDAOMyBatis appointmentDAOMyBatis = new AppointmentDAOMyBatis();

    @Override
    public Appointment getAppointmentByPatientFirstName(String PatientFirstName) {
        return null;
    }

    @Override
    public void insert(Appointment appointment) {
        appointmentDAOMyBatis.insert(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentDAOMyBatis.update(appointment);
    }

    @Override
    public void deleteById(int id) {
        appointmentDAOMyBatis.deleteById(id);
    }

    @Override
    public Appointment getById(int id) {
        return appointmentDAOMyBatis.getById(id);
    }

    @Override
    public List<Appointment> getAll() {
        return appointmentDAOMyBatis.getAll();
    }
}
