package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.AdministrativeEmployeeDAO;
import com.solvd.db.jdbc.interfaces.IAdministrativeEmployeeDAO;
import com.solvd.db.jdbc.models.AdministrativeEmployee;

import java.util.List;

public class AdministrativeEmployeeService implements IAdministrativeEmployeeDAO {

    AdministrativeEmployeeDAO administrativeEmployeeDAO = new AdministrativeEmployeeDAO();

    @Override
    public AdministrativeEmployee getAdministrativeEmployeeByName(String name) {
        return null;
    }

    @Override
    public void insert(AdministrativeEmployee administrativeEmployee) {
        administrativeEmployeeDAO.insert(administrativeEmployee);
    }

    @Override
    public void update(AdministrativeEmployee administrativeEmployee) {
        administrativeEmployeeDAO.update(administrativeEmployee);
    }

    @Override
    public void deleteById(int id) {
        administrativeEmployeeDAO.deleteById(id);
    }

    @Override
    public AdministrativeEmployee getById(int id) {
        return administrativeEmployeeDAO.getById(id);
    }

    @Override
    public List<AdministrativeEmployee> getAll() {
        return administrativeEmployeeDAO.getAll();
    }
}
