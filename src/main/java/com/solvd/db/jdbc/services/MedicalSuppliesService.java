package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.MedicalSuppliesDAO;
import com.solvd.db.jdbc.interfaces.IMedicalSuppliesDAO;
import com.solvd.db.jdbc.models.MedicalSupplies;

import java.util.List;

public class MedicalSuppliesService implements IMedicalSuppliesDAO {

    MedicalSuppliesDAO medicalSuppliesDAO = new MedicalSuppliesDAO();

    @Override
    public MedicalSupplies getMedicalSupplyByName(String supplyName) {
        return null;
    }

    @Override
    public void insert(MedicalSupplies medicalSupplies) {
        medicalSuppliesDAO.insert(medicalSupplies);
    }

    @Override
    public void update(MedicalSupplies medicalSupplies) {
        medicalSuppliesDAO.update(medicalSupplies);
    }

    @Override
    public void deleteById(int id) {
        medicalSuppliesDAO.deleteById(id);
    }

    @Override
    public MedicalSupplies getById(int id) {
        return medicalSuppliesDAO.getById(id);
    }

    @Override
    public List<MedicalSupplies> getAll() {
        return medicalSuppliesDAO.getAll();
    }
}
