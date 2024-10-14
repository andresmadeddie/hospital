package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IAdministrativeEmployeeDAO;
import com.solvd.db.jdbc.models.AdministrativeEmployee;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministrativeEmployeeDAO implements IAdministrativeEmployeeDAO {

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
    public AdministrativeEmployee getAdministrativeEmployeeByName(String name) {
        return null;
    }

    @Override
    public void insert(AdministrativeEmployee administrativeEmployee) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO administrative_employee (person_id, department, hire_date) VALUES (?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, administrativeEmployee.getPerson().getPersonId());
            ps.setString(2, administrativeEmployee.getDepartment());
            ps.setDate(3, administrativeEmployee.getHireDate());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(AdministrativeEmployee administrativeEmployee) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE administrative_employee SET person_id = ?, department = ?, hire_date = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, administrativeEmployee.getPerson().getPersonId());
            ps.setString(2, administrativeEmployee.getDepartment());
            ps.setDate(3, administrativeEmployee.getHireDate());
            ps.setInt(4, administrativeEmployee.getAdminId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int adminId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM administrative_employee WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, adminId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public AdministrativeEmployee getById(int adminId) {
        Connection con = connectionPool.getConnection();
        AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee();
        String query = "SELECT * FROM administrative_employee WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, adminId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    administrativeEmployee.setAdminId(rs.getInt("id"));
                    administrativeEmployee.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    administrativeEmployee.setDepartment(rs.getString("department"));
                    administrativeEmployee.setHireDate(rs.getDate("hire_date"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return administrativeEmployee;
    }

    @Override
    public List<AdministrativeEmployee> getAll() {
        Connection con = connectionPool.getConnection();
        List<AdministrativeEmployee> administrativeEmployees = new ArrayList<>();
        String query = "SELECT * FROM administrative_employee";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    AdministrativeEmployee administrativeEmployee = new AdministrativeEmployee();
                    administrativeEmployee.setAdminId(rs.getInt("id"));
                    administrativeEmployee.setPerson(new PersonDAO().getById(rs.getInt("person_id")));
                    administrativeEmployee.setDepartment(rs.getString("department"));
                    administrativeEmployee.setHireDate(rs.getDate("hire_date"));
                    administrativeEmployees.add(administrativeEmployee);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return administrativeEmployees;
    }
}
