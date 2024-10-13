package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IDoctorDAO;
import com.solvd.db.jdbc.models.Doctor;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO implements IDoctorDAO {

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
    public Doctor getDoctorByLicenseNumber(String licenseNumber) {
        return null;
    }

    @Override
    public void insert(Doctor doctor) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO doctor (person_id, specialization, license_number, hire_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, doctor.getPerson().getPersonId());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getLicenseNumber());
            ps.setDate(4, doctor.getHireDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Doctor doctor) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE doctor SET person_id = ?, specialization = ?, license_number = ?, hire_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, doctor.getPerson().getPersonId());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getLicenseNumber());
            ps.setDate(4, doctor.getHireDate());
            ps.setInt(5, doctor.getDoctorId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int doctorId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM doctor WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, doctorId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Doctor getById(int doctorId) {
        Connection con = connectionPool.getConnection();
        Doctor doctor = new Doctor();
        String query = "SELECT * FROM doctor WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, doctorId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    doctor.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    doctor.setSpecialization(rs.getString("specialization"));
                    doctor.setLicenseNumber(rs.getString("license_number"));
                    doctor.setHireDate(rs.getDate("hire_date"));
                    doctor.setDoctorId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return doctor;
    }

    @Override
    public List<Doctor> getAll() {
        Connection con = connectionPool.getConnection();
        List<Doctor> doctors = new ArrayList<>();
        String query = "SELECT * FROM doctor";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Doctor doctor = new Doctor();
                    doctor.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    doctor.setSpecialization(rs.getString("specialization"));
                    doctor.setLicenseNumber(rs.getString("license_number"));
                    doctor.setHireDate(rs.getDate("hire_date"));
                    doctor.setDoctorId(rs.getInt("id"));
                    doctors.add(doctor);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return doctors;
    }
}
