package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IManagementDAO;
import com.solvd.db.jdbc.models.Management;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagementDAO implements IManagementDAO {

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
    public Management getManagementByPosition(String position) {
        return null;
    }

    @Override
    public void insert(Management management) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO management (person_id, department, position, hire_date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, management.getPerson().getPersonId());
            ps.setString(2, management.getDepartment());
            ps.setString(3, management.getPosition());
            ps.setDate(4, management.getHireDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Management management) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE management SET person_id = ?, department = ?, position= ?, hire_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, management.getPerson().getPersonId());
            ps.setString(2, management.getDepartment());
            ps.setString(3, management.getPosition());
            ps.setDate(4, management.getHireDate());
            ps.setInt(5, management.getManagementId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int managementId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM management WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, managementId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Management getById(int managementId) {
        Connection con = connectionPool.getConnection();
        Management management = new Management();
        String query = "SELECT * FROM management WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, managementId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    management.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    management.setDepartment(rs.getString("department"));
                    management.setPosition(rs.getString("position"));
                    management.setHireDate(rs.getDate("hireDate"));
                    management.setManagementId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return management;
    }

    @Override
    public List<Management> getAll() {
        Connection con = connectionPool.getConnection();
        List<Management> managements = new ArrayList<>();
        String query = "SELECT * FROM management";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Management management = new Management();
                    management.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    management.setDepartment(rs.getString("department"));
                    management.setPosition(rs.getString("position"));
                    management.setHireDate(rs.getDate("hireDate"));
                    management.setManagementId(rs.getInt("id"));
                    managements.add(management);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return managements;
    }
}
