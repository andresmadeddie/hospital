package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IPatientDAO;
import com.solvd.db.jdbc.models.Patient;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO implements IPatientDAO {

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
    public Patient getPatientByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Patient patient) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO patient (person_id, admission_date, discharge_date, medical_history) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, patient.getPerson().getPersonId());
            ps.setDate(2, patient.getAdmissionDate());
            ps.setDate(3, patient.getDischargeDate());
            ps.setString(4, patient.getMedicalHistory());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Patient patient) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE patient SET person_id = ?, admission_date = ?, discharge_date = ?, medical_history = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, patient.getPerson().getPersonId());
            ps.setDate(2, patient.getAdmissionDate());
            ps.setDate(3, patient.getDischargeDate());
            ps.setString(4, patient.getMedicalHistory());
            ps.setInt(5, patient.getPatientId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int patientId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM patient WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, patientId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Patient getById(int patientId) {
        Connection con = connectionPool.getConnection();
        Patient patient = new Patient();
        String query = "SELECT * FROM patient WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, patientId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    patient.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    patient.setAdmissionDate(rs.getDate("admission_date"));
                    patient.setDischargeDate(rs.getDate("discharge_date"));
                    patient.setMedicalHistory(rs.getString("medical_history"));
                    patient.setPatientId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return patient;
    }

    @Override
    public List<Patient> getAll() {
        Connection con = connectionPool.getConnection();
        List<Patient> patients = new ArrayList<>();
        String query = "SELECT * FROM patient";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Patient patient = new Patient();
                    patient.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    patient.setAdmissionDate(rs.getDate("admission_date"));
                    patient.setDischargeDate(rs.getDate("discharge_date"));
                    patient.setMedicalHistory(rs.getString("medical_history"));
                    patient.setPatientId(rs.getInt("id"));
                    patients.add(patient);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return patients;
    }
}
