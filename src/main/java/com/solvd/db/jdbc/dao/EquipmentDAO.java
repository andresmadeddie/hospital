package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IEquipmentDAO;
import com.solvd.db.jdbc.models.Equipment;
import com.solvd.db.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO implements IEquipmentDAO {
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
    public Equipment getEquipmentByName(String equipmentName) {
        return null;
    }

    @Override
    public void insert(Equipment equipment) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO equipment (name, type, purchase_date, warranty_end, supplier) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, equipment.getName());
            ps.setString(2, equipment.getType());
            ps.setDate(3, equipment.getPurchaseDate());
            ps.setDate(4, equipment.getWarrantyEnd());
            ps.setInt(5, equipment.getSupplier().getSupplierId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Equipment equipment) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE equipment SET name = ?, type = ?, purchase_date = ?, warranty_end = ?, supplier = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, equipment.getName());
            ps.setString(2, equipment.getType());
            ps.setDate(3, equipment.getPurchaseDate());
            ps.setDate(4, equipment.getWarrantyEnd());
            ps.setInt(5, equipment.getSupplier().getSupplierId());
            ps.setInt(6, equipment.getEquipmentId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int equipmentId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM equipment WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, equipmentId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Equipment getById(int equipmentId) {
        Connection con = connectionPool.getConnection();
        Equipment equipment = new Equipment();
        String query = "SELECT * FROM equipment WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, equipmentId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    equipment.setName(rs.getString("name"));
                    equipment.setType(rs.getString("type"));
                    equipment.setPurchaseDate(rs.getDate("purchase_date"));
                    equipment.setWarrantyEnd(rs.getDate("warranty_end"));
                    equipment.setSupplier(new SupplierDAO().getById(rs.getInt("supplier_id")));
                    equipment.setEquipmentId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return equipment;
    }

    @Override
    public List<Equipment> getAll() {
        Connection con = connectionPool.getConnection();
        List<Equipment> equipments = new ArrayList<>();
        String query = "SELECT * FROM equipment";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Equipment equipment = new Equipment();
                    equipment.setName(rs.getString("name"));
                    equipment.setType(rs.getString("type"));
                    equipment.setPurchaseDate(rs.getDate("purchase_date"));
                    equipment.setWarrantyEnd(rs.getDate("warranty_end"));
                    equipment.setSupplier(new SupplierDAO().getById(rs.getInt("supplier_id")));
                    equipment.setEquipmentId(rs.getInt("id"));
                    equipments.add(equipment);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return equipments;
    }
}
