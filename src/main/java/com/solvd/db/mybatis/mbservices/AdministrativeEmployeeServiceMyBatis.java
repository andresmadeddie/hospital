package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IAdministrativeEmployeeDAO;
import com.solvd.db.jdbc.models.AdministrativeEmployee;
import com.solvd.db.mybatis.mbdao.AdministrativeEmployeeDAOMyBatis;

import java.util.List;

public class AdministrativeEmployeeServiceMyBatis implements IAdministrativeEmployeeDAO {

    AdministrativeEmployeeDAOMyBatis administrativeEmployeeDAOMyBatis = new AdministrativeEmployeeDAOMyBatis();

    @Override
    public AdministrativeEmployee getAdministrativeEmployeeByName(String name) {
        return null;
    }

    @Override
    public void insert(AdministrativeEmployee administrativeEmployee) {
        administrativeEmployeeDAOMyBatis.insert(administrativeEmployee);
    }

    @Override
    public void update(AdministrativeEmployee administrativeEmployee) {
        administrativeEmployeeDAOMyBatis.update(administrativeEmployee);
    }

    @Override
    public void deleteById(int id) {
        administrativeEmployeeDAOMyBatis.deleteById(id);
    }

    @Override
    public AdministrativeEmployee getById(int id) {
        return administrativeEmployeeDAOMyBatis.getById(id);
    }

    @Override
    public List<AdministrativeEmployee> getAll() {
        return administrativeEmployeeDAOMyBatis.getAll();
    }
}
