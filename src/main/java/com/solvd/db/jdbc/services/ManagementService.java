package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.ManagementDAO;
import com.solvd.db.jdbc.interfaces.IManagementDAO;
import com.solvd.db.jdbc.models.Management;

import java.util.List;

public class ManagementService implements IManagementDAO {

    ManagementDAO managementDAO = new ManagementDAO();

    @Override
    public Management getManagementByPosition(String position) {
        return null;
    }

    @Override
    public void insert(Management management) {
        managementDAO.insert(management);
    }

    @Override
    public void update(Management management) {
        managementDAO.update(management);
    }

    @Override
    public void deleteById(int id) {
        managementDAO.deleteById(id);
    }

    @Override
    public Management getById(int id) {
        return managementDAO.getById(id);
    }

    @Override
    public List<Management> getAll() {
        return managementDAO.getAll();
    }


}
