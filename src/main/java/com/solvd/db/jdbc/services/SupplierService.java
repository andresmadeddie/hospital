package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.SupplierDAO;
import com.solvd.db.jdbc.interfaces.ISupplierDAO;
import com.solvd.db.jdbc.models.Supplier;

import java.util.List;

public class SupplierService implements ISupplierDAO {

    SupplierDAO supplierDAO = new SupplierDAO();

    @Override
    public Supplier getSupplierByName(String supplierName) {
        return null;
    }

    @Override
    public void insert(Supplier supplier) {
        supplierDAO.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDAO.update(supplier);
    }

    @Override
    public void deleteById(int id) {
        supplierDAO.deleteById(id);
    }

    @Override
    public Supplier getById(int id) {
        return supplierDAO.getById(id);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDAO.getAll();
    }
}
