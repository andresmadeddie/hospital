package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.IPersonDAO;
import com.solvd.db.jdbc.models.Person;
import com.solvd.db.mybatis.mbdao.PersonDAOMyBatis;

import java.util.List;

public class PersonServiceMyBatis implements IPersonDAO {

    PersonDAOMyBatis personDAOMyBatis = new PersonDAOMyBatis();

    @Override
    public Person getPersonByFirstName(String name) {
        return null;
    }

    @Override
    public void insert(Person person) {
        personDAOMyBatis.insert(person);
    }

    @Override
    public void update(Person person) {
        personDAOMyBatis.update(person);
    }

    @Override
    public void deleteById(int id) {
        personDAOMyBatis.deleteById(id);
    }

    @Override
    public Person getById(int id) {
        return personDAOMyBatis.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDAOMyBatis.getAll();
    }
}
