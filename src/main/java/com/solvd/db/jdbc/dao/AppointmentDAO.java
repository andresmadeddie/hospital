package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IAppointmentDAO;
import com.solvd.db.jdbc.models.Appointment;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO implements IAppointmentDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private void SecureConnectionRelease(Connection con) {
        if (con != null) {
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Appointment getAppointmentByPatientFirstName(String PatientFirstName) {
        return null;
    }

    @Override
    public void insert(Appointment appointment) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO appointment (doctor_id, patient_id, appointment_date, reason_for_visit) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, appointment.getDoctor().getDoctorId());
            ps.setInt(2, appointment.getPatient().getPatientId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getReasonForVisit());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Appointment appointment) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE appointment SET doctor_id = ?, patient_id = ?, appointment_date = ?, reason_for_visit = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, appointment.getDoctor().getDoctorId());
            ps.setInt(2, appointment.getPatient().getPatientId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getReasonForVisit());
            ps.setInt(5, appointment.getAppointmentId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int appointmentId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM appointment WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, appointmentId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Appointment getById(int appointmentId) {
        Connection con = connectionPool.getConnection();
        Appointment appointment = new Appointment();
        String query = "SELECT * FROM appointment WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, appointmentId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    appointment.setDoctor(new DoctorDAO().getById(rs.getInt("doctor_id")));
                    appointment.setPatient(new PatientDAO().getById(rs.getInt("patient_id")));
                    appointment.setAppointmentDate(rs.getDate("appointment_date"));
                    appointment.setReasonForVisit(rs.getString("reason_for_visit"));
                    appointment.setAppointmentId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return appointment;
    }

    @Override
    public List<Appointment> getAll() {
        Connection con = connectionPool.getConnection();
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointment";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Appointment appointment = new Appointment();
                    appointment.setDoctor(new DoctorDAO().getById(rs.getInt("doctor_id")));
                    appointment.setPatient(new PatientDAO().getById(rs.getInt("patient_id")));
                    appointment.setAppointmentDate(rs.getDate("appointment_date"));
                    appointment.setReasonForVisit(rs.getString("reason_for_visit"));
                    appointment.setAppointmentId(rs.getInt("id"));
                    appointment.setAppointmentId(rs.getInt("id"));
                    appointments.add(appointment);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return appointments;
    }
}
