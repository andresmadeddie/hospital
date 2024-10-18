package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.INurseDAO;
import com.solvd.db.jdbc.models.Nurse;
import com.solvd.db.utils.connectionutils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NurseDAO implements INurseDAO {

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
    public Nurse getNurseByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Nurse nurse) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO nurse (person_id, shift, hire_date) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, nurse.getPerson().getPersonId());
            ps.setString(2, nurse.getShift());
            ps.setDate(3, nurse.getHireDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Nurse nurse) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE nurse SET person_id = ?, shift = ?, hire_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, nurse.getPerson().getPersonId());
            ps.setString(2, nurse.getShift());
            ps.setDate(3, nurse.getHireDate());
            ps.setInt(4, nurse.getNurseId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int nurseId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM nurse WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, nurseId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Nurse getById(int nurseId) {
        Connection con = connectionPool.getConnection();
        Nurse nurse = new Nurse();
        String query = "SELECT * FROM nurse WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, nurseId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    nurse.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    nurse.setShift(rs.getString("shift"));
                    nurse.setHireDate(rs.getDate("hire_date"));
                    nurse.setNurseId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return nurse;
    }

    @Override
    public List<Nurse> getAll() {
        Connection con = connectionPool.getConnection();
        List<Nurse> nurses = new ArrayList<>();
        String query = "SELECT * FROM nurse";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Nurse nurse = new Nurse();
                    nurse.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    nurse.setShift(rs.getString("shift"));
                    nurse.setHireDate(rs.getDate("hire_date"));
                    nurse.setNurseId(rs.getInt("id"));
                    nurses.add(nurse);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return nurses;
    }
}
