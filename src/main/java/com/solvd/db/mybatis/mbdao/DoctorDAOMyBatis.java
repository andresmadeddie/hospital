package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IDoctorDAO;
import com.solvd.db.jdbc.models.Doctor;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class DoctorDAOMyBatis implements IDoctorDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Doctor doctor) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctorDao.insert(doctor);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Doctor doctor) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctorDao.update(doctor);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctorDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Doctor> getAll() {
        List<Doctor> doctors;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctors = doctorDao.getAll();
        }
        return doctors;
    }

    @Override
    public Doctor getById(int id) {
        Doctor doctor;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctor = doctorDao.getById(id);
        }
        return doctor;
    }

    @Override
    public Doctor getDoctorByLicenseNumber(String name) {
        Doctor doctor;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IDoctorDAO doctorDao = sqlSession.getMapper(IDoctorDAO.class);
            doctor = doctorDao.getDoctorByLicenseNumber(name);
        }
        return doctor;
    }
}
