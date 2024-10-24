package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.ISupplierDAO;
import com.solvd.db.jdbc.models.Supplier;
import com.solvd.db.mybatis.mbdao.SupplierDAOMyBatis;

import java.util.List;

public class SupplierServiceMyBatis implements ISupplierDAO {

    SupplierDAOMyBatis supplierDAOMyBatis = new SupplierDAOMyBatis();

    @Override
    public Supplier getSupplierByName(String supplierName) {
        return null;
    }

    @Override
    public void insert(Supplier supplier) {
        supplierDAOMyBatis.insert(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        supplierDAOMyBatis.update(supplier);
    }

    @Override
    public void deleteById(int id) {
        supplierDAOMyBatis.deleteById(id);
    }

    @Override
    public Supplier getById(int id) {
        return supplierDAOMyBatis.getById(id);
    }

    @Override
    public List<Supplier> getAll() {
        return supplierDAOMyBatis.getAll();
    }
}
