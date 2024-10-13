package com.solvd.db.jdbc.services;

import com.solvd.db.jdbc.dao.NurseDAO;
import com.solvd.db.jdbc.interfaces.INurseDAO;
import com.solvd.db.jdbc.models.Nurse;

import java.util.List;

public class NurseService implements INurseDAO {

    NurseDAO nurseDAO = new NurseDAO();

    @Override
    public Nurse getNurseByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Nurse nurse) {
        nurseDAO.insert(nurse);
    }

    @Override
    public void update(Nurse nurse) {
        nurseDAO.update(nurse);
    }

    @Override
    public void deleteById(int id) {
        nurseDAO.deleteById(id);
    }

    @Override
    public Nurse getById(int id) {
        return nurseDAO.getById(id);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseDAO.getAll();
    }
}
