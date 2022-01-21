package io.nationatily.application.port;

import io.nationatily.domain.Person;

import java.util.Map;

public interface FakeDBPersonRetriever {
    Person findNationalityByName(String name);
    Map<String,Person> getAllEmployees();
}
