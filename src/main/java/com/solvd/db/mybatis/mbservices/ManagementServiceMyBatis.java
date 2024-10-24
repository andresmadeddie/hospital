package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IManagementDAO;
import com.solvd.db.jdbc.models.Management;
import com.solvd.db.mybatis.mbdao.ManagementDAOMyBatis;

import java.util.List;

public class ManagementServiceMyBatis implements IManagementDAO {

    ManagementDAOMyBatis managementDAOMyBatis = new ManagementDAOMyBatis();

    @Override
    public Management getManagementByPosition(String position) {
        return null;
    }

    @Override
    public void insert(Management management) {
        managementDAOMyBatis.insert(management);
    }

    @Override
    public void update(Management management) {
        managementDAOMyBatis.update(management);
    }

    @Override
    public void deleteById(int id) {
        managementDAOMyBatis.deleteById(id);
    }

    @Override
    public Management getById(int id) {
        return managementDAOMyBatis.getById(id);
    }

    @Override
    public List<Management> getAll() {
        return managementDAOMyBatis.getAll();
    }


}
