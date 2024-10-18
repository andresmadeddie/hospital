package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IMedicalSuppliesDAO;
import com.solvd.db.jdbc.models.MedicalSupplies;
import com.solvd.db.utils.connectionutils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalSuppliesDAO implements IMedicalSuppliesDAO {

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
    public MedicalSupplies getMedicalSupplyByName(String supplyName) {
        return null;
    }

    @Override
    public void insert(MedicalSupplies medicalSupplies) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO medical_supplies (name, quantity, unit_price, supplier_id) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, medicalSupplies.getName());
            ps.setInt(2, medicalSupplies.getQuantity());
            ps.setFloat(3, medicalSupplies.getUnitPrice());
            ps.setInt(4, medicalSupplies.getSupplier().getSupplierId());

            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(MedicalSupplies medicalSupplies) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE medical_supplies SET name = ?, quantity = ?, unit_price = ?, supplier_id = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, medicalSupplies.getName());
            ps.setInt(2, medicalSupplies.getQuantity());
            ps.setFloat(3, medicalSupplies.getUnitPrice());
            ps.setInt(4, medicalSupplies.getSupplier().getSupplierId());
            ps.setInt(5, medicalSupplies.getSupplyId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int medicalSupplyId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM medical_supplies WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, medicalSupplyId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public MedicalSupplies getById(int medicalSupplyId) {
        Connection con = connectionPool.getConnection();
        MedicalSupplies medicalSupply = new MedicalSupplies();
        String query = "SELECT * FROM medical_supplies WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, medicalSupplyId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    medicalSupply.setName(rs.getString("name"));
                    medicalSupply.setQuantity(rs.getInt("quantity"));
                    medicalSupply.setUnitPrice(rs.getFloat("unit_price"));
                    medicalSupply.setSupplier(new SupplierDAO().getById(rs.getInt("supplier_id")));
                    medicalSupply.setSupplyId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return medicalSupply;
    }

    @Override
    public List<MedicalSupplies> getAll() {
        Connection con = connectionPool.getConnection();
        List<MedicalSupplies> medicalSupplies = new ArrayList<>();
        String query = "SELECT * FROM medical_supplies";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    MedicalSupplies medicalSupply = new MedicalSupplies();
                    medicalSupply.setName(rs.getString("name"));
                    medicalSupply.setQuantity(rs.getInt("quantity"));
                    medicalSupply.setUnitPrice(rs.getFloat("unit_price"));
                    medicalSupply.setSupplier(new SupplierDAO().getById(rs.getInt("supplier_id")));
                    medicalSupply.setSupplyId(rs.getInt("id"));
                    medicalSupplies.add(medicalSupply);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return medicalSupplies;
    }
}
