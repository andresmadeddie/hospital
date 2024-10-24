package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IAppointmentDAO;
import com.solvd.db.jdbc.models.Appointment;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class AppointmentDAOMyBatis implements IAppointmentDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDao.insert(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Appointment appointment) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDao.update(appointment);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointmentDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Appointment> getAll() {
        List<Appointment> appointments;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointments = appointmentDao.getAll();
        }
        return appointments;
    }

    @Override
    public Appointment getById(int id) {
        Appointment appointment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointment = appointmentDao.getById(id);
        }
        return appointment;
    }

    @Override
    public Appointment getAppointmentByPatientFirstName(String name) {
        Appointment appointment;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IAppointmentDAO appointmentDao = sqlSession.getMapper(IAppointmentDAO.class);
            appointment = appointmentDao.getAppointmentByPatientFirstName(name);
        }
        return appointment;
    }
}
