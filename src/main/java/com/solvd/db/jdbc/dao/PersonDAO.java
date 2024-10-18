package com.solvd.db.jdbc.dao;

import com.solvd.db.jdbc.interfaces.IPersonDAO;
import com.solvd.db.jdbc.models.Person;
import com.solvd.db.utils.connectionutils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonDAO implements IPersonDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance();

    private void SecureConnectionRelease(Connection con) {
        if (con != null) {
            try {
                connectionPool.releaseConnection(con);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Person getPersonByFirstName(String name) {
        return null;
    }

    @Override
    public void insert(Person person) {
        Connection con = connectionPool.getConnection();
        String query = "INSERT INTO person (first_name, last_name, dob, gender, address, phone_number, email) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setDate(3, person.getDob());
            ps.setString(4, person.getGender());
            ps.setString(5, person.getAddress());
            ps.setString(6, person.getPhoneNumber());
            ps.setString(7, person.getEmail());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void update(Person person) {
        Connection con = connectionPool.getConnection();
        String query = "UPDATE person SET first_name = ?, last_name = ?, dob = ?, gender = ?, address = ?, phone_number = ?, email = ? WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, person.getFirstName());
            ps.setString(2, person.getLastName());
            ps.setDate(3, person.getDob());
            ps.setString(4, person.getGender());
            ps.setString(5, person.getAddress());
            ps.setString(6, person.getPhoneNumber());
            ps.setString(7, person.getEmail());
            ps.setInt(8, person.getPersonId());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public void deleteById(int personId) {
        Connection con = connectionPool.getConnection();
        String query = "DELETE FROM person WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, personId);
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
    }

    @Override
    public Person getById(int personId) {
        Connection con = connectionPool.getConnection();
        Person person = new Person();
        String query = "SELECT * FROM person WHERE id = ?";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, personId);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setDob(rs.getDate("dob"));
                    person.setGender(rs.getString("gender"));
                    person.setAddress(rs.getString("address"));
                    person.setPhoneNumber(rs.getString("phone_number"));
                    person.setEmail(rs.getString("email"));
                    person.setPersonId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return person;
    }

    @Override
    public List<Person> getAll() {
        Connection con = connectionPool.getConnection();
        List<Person> persons = new ArrayList<>();
        String query = "SELECT * FROM person";

        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.execute();

            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Person person = new Person();
                    person.setFirstName(rs.getString("first_name"));
                    person.setLastName(rs.getString("last_name"));
                    person.setDob(rs.getDate("dob"));
                    person.setGender(rs.getString("gender"));
                    person.setAddress(rs.getString("address"));
                    person.setPhoneNumber(rs.getString("phone_number"));
                    person.setEmail(rs.getString("email"));
                    person.setPersonId(rs.getInt("id"));
                    persons.add(person);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            SecureConnectionRelease(con);
        }
        return persons;
    }
}
