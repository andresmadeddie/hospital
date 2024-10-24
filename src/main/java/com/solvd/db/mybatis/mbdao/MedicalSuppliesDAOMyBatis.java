package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IMedicalSuppliesDAO;
import com.solvd.db.jdbc.models.MedicalSupplies;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MedicalSuppliesDAOMyBatis implements IMedicalSuppliesDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(MedicalSupplies medicalsupplies) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsuppliesDao.insert(medicalsupplies);
            sqlSession.commit();
        }
    }

    @Override
    public void update(MedicalSupplies medicalsupplies) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsuppliesDao.update(medicalsupplies);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsuppliesDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<MedicalSupplies> getAll() {
        List<MedicalSupplies> medicalsuppliess;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsuppliess = medicalsuppliesDao.getAll();
        }
        return medicalsuppliess;
    }

    @Override
    public MedicalSupplies getById(int id) {
        MedicalSupplies medicalsupplies;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsupplies = medicalsuppliesDao.getById(id);
        }
        return medicalsupplies;
    }

    @Override
    public MedicalSupplies getMedicalSupplyByName(String name) {
        MedicalSupplies medicalsupplies;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IMedicalSuppliesDAO medicalsuppliesDao = sqlSession.getMapper(IMedicalSuppliesDAO.class);
            medicalsupplies = medicalsuppliesDao.getMedicalSupplyByName(name);
        }
        return medicalsupplies;
    }
}
