package com.solvd.db.mybatis.mbservices;

import com.solvd.db.jdbc.interfaces.INurseDAO;
import com.solvd.db.jdbc.models.Nurse;
import com.solvd.db.mybatis.mbdao.NurseDAOMyBatis;

import java.util.List;

public class NurseServiceMyBatis implements INurseDAO {

    NurseDAOMyBatis nurseDAOMyBatis = new NurseDAOMyBatis();

    @Override
    public Nurse getNurseByPersonFirstName(String personFirstName) {
        return null;
    }

    @Override
    public void insert(Nurse nurse) {
        nurseDAOMyBatis.insert(nurse);
    }

    @Override
    public void update(Nurse nurse) {
        nurseDAOMyBatis.update(nurse);
    }

    @Override
    public void deleteById(int id) {
        nurseDAOMyBatis.deleteById(id);
    }

    @Override
    public Nurse getById(int id) {
        return nurseDAOMyBatis.getById(id);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseDAOMyBatis.getAll();
    }
}
