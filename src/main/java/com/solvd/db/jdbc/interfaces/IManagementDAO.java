package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Management;

public interface IManagementDAO extends IBaseDao<Management> {

    Management getManagementByPosition(String position);
}
