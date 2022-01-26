package io.nationatily.adapter.output;

import io.nationatily.application.port.output.DBPersonRequestPort;
import io.nationatily.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBPersonRetriever implements DBPersonRequestPort {

    public Connection connect() {
        Connection connection = null;
        try {
            String PASSWORD = "docker";
            String USER = "postgres";
            String URL = "jdbc:postgresql://localhost:5432/persons";
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Person findNationalityByName(String input) {
        Connection con = connect();
        Person person = null;
        try (Statement stmt = con.createStatement()) {
            String selectSql = "SELECT * FROM persons "
            + "WHERE name = '" + input + "' ";
            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                while (resultSet.next()) {
                        person = new Person(resultSet.getString("name"), resultSet.getString("nationality"), null);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public Map<String, Person> getAllEmployees() {
        Connection con = connect();
        Map<String, Person> personsMap = new HashMap<>();
        try (Statement stmt = con.createStatement()) {
            String selectSql = "SELECT * FROM persons";
            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                while (resultSet.next()) {
                    Person person = new Person(resultSet.getString("name"), resultSet.getString("nationality"), null);
                    personsMap.put(person.getName(), person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personsMap;
    }
}
