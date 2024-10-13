package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.MedicalSupplies;

public interface IMedicalSuppliesDAO extends IBaseDao<MedicalSupplies> {

    MedicalSupplies getMedicalSupplyByName(String supplyName);
}
