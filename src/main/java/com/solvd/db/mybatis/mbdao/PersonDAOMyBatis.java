package com.solvd.db.mybatis.mbdao;

import com.solvd.db.jdbc.interfaces.IPersonDAO;
import com.solvd.db.jdbc.models.Person;
import com.solvd.db.mybatis.utils.MyBatisSqlFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class PersonDAOMyBatis implements IPersonDAO {

    private final SqlSessionFactory sqlSessionFactory = MyBatisSqlFactory.getSqlSessionFactory();

    @Override
    public void insert(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            personDao.insert(person);
            sqlSession.commit();
        }
    }

    @Override
    public void update(Person person) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            personDao.update(person);
            sqlSession.commit();
        }
    }

    @Override
    public void deleteById(int id) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            personDao.deleteById(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Person> getAll() {
        List<Person> persons;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            persons = personDao.getAll();
        }
        return persons;
    }

    @Override
    public Person getById(int id) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            person = personDao.getById(id);
        }
        return person;
    }

    @Override
    public Person getPersonByFirstName(String name) {
        Person person;
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            IPersonDAO personDao = sqlSession.getMapper(IPersonDAO.class);
            person = personDao.getPersonByFirstName(name);
        }
        return person;
    }
}