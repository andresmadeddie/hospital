package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Equipment;

public interface IEquipmentDAO extends IBaseDao<Equipment> {

    Equipment getEquipmentByName(String equipmentName);
}

