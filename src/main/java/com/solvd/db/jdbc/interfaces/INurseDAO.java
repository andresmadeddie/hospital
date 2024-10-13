package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Nurse;

public interface INurseDAO extends IBaseDao<Nurse> {

    Nurse getNurseByPersonFirstName(String personFirstName);
}
