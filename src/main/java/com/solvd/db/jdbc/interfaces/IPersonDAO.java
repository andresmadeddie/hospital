package com.solvd.db.jdbc.interfaces;

import com.solvd.db.jdbc.models.Person;

public interface IPersonDAO extends IBaseDao<Person> {

    Person getPersonByFirstName(String personFirstName);
}
