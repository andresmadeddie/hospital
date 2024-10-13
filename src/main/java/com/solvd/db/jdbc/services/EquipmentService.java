package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.EquipmentDAO;
import com.solvd.db.jdbc.interfaces.IEquipmentDAO;
import com.solvd.db.jdbc.models.Equipment;

import java.util.List;

public class EquipmentService implements IEquipmentDAO {

    EquipmentDAO equipmentDAO = new EquipmentDAO();

    @Override
    public Equipment getEquipmentByName(String equipmentName) {
        return null;
    }

    @Override
    public void insert(Equipment equipment) {
        equipmentDAO.insert(equipment);
    }

    @Override
    public void update(Equipment equipment) {
        equipmentDAO.update(equipment);
    }

    @Override
    public void deleteById(int id) {
        equipmentDAO.deleteById(id);
    }

    @Override
    public Equipment getById(int id) {
        return equipmentDAO.getById(id);
    }

    @Override
    public List<Equipment> getAll() {
        return equipmentDAO.getAll();
    }
}
