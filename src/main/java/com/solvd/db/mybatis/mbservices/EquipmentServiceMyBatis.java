package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IEquipmentDAO;
import com.solvd.db.jdbc.models.Equipment;
import com.solvd.db.mybatis.mbdao.EquipmentDAOMyBatis;

import java.util.List;

public class EquipmentServiceMyBatis implements IEquipmentDAO {

    EquipmentDAOMyBatis equipmentDAOMyBatis = new EquipmentDAOMyBatis();

    @Override
    public Equipment getEquipmentByName(String equipmentName) {
        return null;
    }

    @Override
    public void insert(Equipment equipment) {
        equipmentDAOMyBatis.insert(equipment);
    }

    @Override
    public void update(Equipment equipment) {
        equipmentDAOMyBatis.update(equipment);
    }

    @Override
    public void deleteById(int id) {
        equipmentDAOMyBatis.deleteById(id);
    }

    @Override
    public Equipment getById(int id) {
        return equipmentDAOMyBatis.getById(id);
    }

    @Override
    public List<Equipment> getAll() {
        return equipmentDAOMyBatis.getAll();
    }
}
