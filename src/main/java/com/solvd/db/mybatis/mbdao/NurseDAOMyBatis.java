package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.INurseDAO;
import com.solvd.db.jdbc.models.Nurse;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class NurseDAOMyBatis implements INurseDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Nurse nurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurseDao.insert(nurse);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Nurse nurse) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurseDao.update(nurse);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurseDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Nurse> getAll() {
        List<Nurse> nurses;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurses = nurseDao.getAll();
        }
        return nurses;
    }

    @Override
    public Nurse getById(int id) {
        Nurse nurse;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurse = nurseDao.getById(id);
        }
        return nurse;
    }

    @Override
    public Nurse getNurseByPersonFirstName(String name) {
        Nurse nurse;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            INurseDAO nurseDao = sqlSession.getMapper(INurseDAO.class);
            nurse = nurseDao.getNurseByPersonFirstName(name);
        }
        return nurse;
    }

}
