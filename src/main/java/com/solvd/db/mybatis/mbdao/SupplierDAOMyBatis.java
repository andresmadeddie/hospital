package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.ISupplierDAO;
import com.solvd.db.jdbc.models.Supplier;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class SupplierDAOMyBatis implements ISupplierDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            supplierDao.insert(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Supplier supplier) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            supplierDao.update(supplier);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            supplierDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Supplier> getAll() {
        List<Supplier> suppliers;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            suppliers = supplierDao.getAll();
        }
        return suppliers;
    }

    @Override
    public Supplier getById(int id) {
        Supplier supplier;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            supplier = supplierDao.getById(id);
        }
        return supplier;
    }

    @Override
    public Supplier getSupplierByName(String name) {
        Supplier supplier;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ISupplierDAO supplierDao = sqlSession.getMapper(ISupplierDAO.class);
            supplier = supplierDao.getSupplierByName(name);
        }
        return supplier;
    }
}
