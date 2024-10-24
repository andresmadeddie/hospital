package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IManagementDAO;
import com.solvd.db.jdbc.models.Management;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ManagementDAOMyBatis implements IManagementDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Management management) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            managementDao.insert(management);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Management management) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            managementDao.update(management);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            managementDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Management> getAll() {
        List<Management> managements;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            managements = managementDao.getAll();
        }
        return managements;
    }

    @Override
    public Management getById(int id) {
        Management management;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            management = managementDao.getById(id);
        }
        return management;
    }

    @Override
    public Management getManagementByPosition(String name) {
        Management management;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IManagementDAO managementDao = sqlSession.getMapper(IManagementDAO.class);
            management = managementDao.getManagementByPosition(name);
        }
        return management;
    }
}
