package io.nationatily.adapter;

import io.nationatily.application.port.FakeDBPersonRetriever;
import io.nationatily.domain.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBPersonRetriever implements FakeDBPersonRetriever {

    private final String URL = "jdbc:postgresql://localhost:5432/nationalitydb";
    private final String USER = "gustaf.nilsson";
    private final String PASSWORD = "";

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Person findNationalityByName(String input) {
        Connection con = connect();
        List<Person> persons = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String selectSql = "SELECT * FROM persons "
            + "WHERE name LIKE '" + input + "' ";
            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                while (resultSet.next()) {
                        Person person = new Person(resultSet.getString("name"), resultSet.getString("nationality"));
                        persons.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons.get(0);
    }

    @Override
    public Map<String, Person> getAllEmployees() {
        Connection con = connect();
        Map<String, Person> personsMap = new HashMap<>();
        try (Statement stmt = con.createStatement()) {
            String selectSql = "SELECT * FROM persons";
            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                while (resultSet.next()) {
                    Person person = new Person(resultSet.getString("name"), resultSet.getString("nationality"));
                    personsMap.put(person.getName(), person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return personsMap;
    }
}
