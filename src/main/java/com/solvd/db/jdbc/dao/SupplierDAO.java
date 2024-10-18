package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.ISupplierDAO;
import com.solvd.db.jdbc.models.Supplier;
import com.solvd.db.utils.connectionutils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO implements ISupplierDAO {

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
    public Supplier getSupplierByName(String supplierName) {
        return null;
    }

    @Override
    public void insert(Supplier supplier) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO supplier (name, contact_person, phone_number, email) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getContactPerson());
            ps.setString(3, supplier.getPhoneNumber());
            ps.setString(4, supplier.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Supplier supplier) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE supplier SET name = ?, contact_person = ?, phone_number = ?, email = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getContactPerson());
            ps.setString(3, supplier.getPhoneNumber());
            ps.setString(4, supplier.getEmail());
            ps.setInt(5, supplier.getSupplierId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int supplierId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM supplier WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, supplierId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Supplier getById(int supplierId) {
        Connection con = connectionPool.getConnection();
        Supplier supplier = new Supplier();
        String query = "SELECT * FROM supplier WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, supplierId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    supplier.setName(rs.getString("name"));
                    supplier.setContactPerson(rs.getString("contact_person"));
                    supplier.setPhoneNumber(rs.getString("phone_number"));
                    supplier.setEmail(rs.getString("email"));
                    supplier.setSupplierId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return supplier;
    }

    @Override
    public List<Supplier> getAll() {
        Connection con = connectionPool.getConnection();
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM supplier";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Supplier supplier = new Supplier();
                    supplier.setName(rs.getString("name"));
                    supplier.setContactPerson(rs.getString("contact_person"));
                    supplier.setPhoneNumber(rs.getString("phone_number"));
                    supplier.setEmail(rs.getString("email"));
                    supplier.setSupplierId(rs.getInt("id"));
                    suppliers.add(supplier);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return suppliers;
    }
}
