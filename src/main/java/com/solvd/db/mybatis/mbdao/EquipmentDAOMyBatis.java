package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IEquipmentDAO;
import com.solvd.db.jdbc.models.Equipment;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EquipmentDAOMyBatis implements IEquipmentDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Equipment equipment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipmentDao.insert(equipment);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Equipment equipment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipmentDao.update(equipment);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipmentDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Equipment> getAll() {
        List<Equipment> equipments;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipments = equipmentDao.getAll();
        }
        return equipments;
    }

    @Override
    public Equipment getById(int id) {
        Equipment equipment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipment = equipmentDao.getById(id);
        }
        return equipment;
    }

    @Override
    public Equipment getEquipmentByName(String name) {
        Equipment equipment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IEquipmentDAO equipmentDao = sqlSession.getMapper(IEquipmentDAO.class);
            equipment = equipmentDao.getEquipmentByName(name);
        }
        return equipment;
    }

}
