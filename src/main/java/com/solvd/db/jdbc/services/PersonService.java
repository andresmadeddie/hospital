package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.PersonDAO;
import com.solvd.db.jdbc.interfaces.IPersonDAO;
import com.solvd.db.jdbc.models.Person;

import java.util.List;

public class PersonService implements IPersonDAO {

    PersonDAO personDAO = new PersonDAO();

    @Override
    public Person getPersonByFirstName(String name) {
        return null;
    }

    @Override
    public void insert(Person person) {
        personDAO.insert(person);
    }

    @Override
    public void update(Person person) {
        personDAO.update(person);
    }

    @Override
    public void deleteById(int id) {
        personDAO.deleteById(id);
    }

    @Override
    public Person getById(int id) {
        return personDAO.getById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDAO.getAll();
    }
}
