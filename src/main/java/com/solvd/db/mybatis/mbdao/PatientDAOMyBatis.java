package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IPatientDAO;
import com.solvd.db.jdbc.models.Patient;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PatientDAOMyBatis implements IPatientDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Patient patient) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patientDao.insert(patient);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Patient patient) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patientDao.update(patient);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patientDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Patient> getAll() {
        List<Patient> patients;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patients = patientDao.getAll();
        }
        return patients;
    }

    @Override
    public Patient getById(int id) {
        Patient patient;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patient = patientDao.getById(id);
        }
        return patient;
    }

    @Override
    public Patient getPatientByPersonFirstName(String name) {
        Patient patient;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPatientDAO patientDao = sqlSession.getMapper(IPatientDAO.class);
            patient = patientDao.getPatientByPersonFirstName(name);
        }
        return patient;
    }
}
