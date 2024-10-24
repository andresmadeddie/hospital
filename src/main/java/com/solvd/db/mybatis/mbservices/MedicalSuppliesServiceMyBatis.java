package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IMedicalSuppliesDAO;
import com.solvd.db.jdbc.models.MedicalSupplies;
import com.solvd.db.mybatis.mbdao.MedicalSuppliesDAOMyBatis;

import java.util.List;

public class MedicalSuppliesServiceMyBatis implements IMedicalSuppliesDAO {

    MedicalSuppliesDAOMyBatis medicalSuppliesDAOMyBatis = new MedicalSuppliesDAOMyBatis();

    @Override
    public MedicalSupplies getMedicalSupplyByName(String supplyName) {
        return null;
    }

    @Override
    public void insert(MedicalSupplies medicalSupplies) {
        medicalSuppliesDAOMyBatis.insert(medicalSupplies);
    }

    @Override
    public void update(MedicalSupplies medicalSupplies) {
        medicalSuppliesDAOMyBatis.update(medicalSupplies);
    }

    @Override
    public void deleteById(int id) {
        medicalSuppliesDAOMyBatis.deleteById(id);
    }

    @Override
    public MedicalSupplies getById(int id) {
        return medicalSuppliesDAOMyBatis.getById(id);
    }

    @Override
    public List<MedicalSupplies> getAll() {
        return medicalSuppliesDAOMyBatis.getAll();
    }
}
