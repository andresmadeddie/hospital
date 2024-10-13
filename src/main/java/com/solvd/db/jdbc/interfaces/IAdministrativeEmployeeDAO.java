package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.AdministrativeEmployee;

public interface IAdministrativeEmployeeDAO extends IBaseDao<AdministrativeEmployee> {

    AdministrativeEmployee getAdministrativeEmployeeByName(String name);
}