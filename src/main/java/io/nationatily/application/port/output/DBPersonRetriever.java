package io.nationatily.application.port.output;

import io.nationatily.domain.Person;

import java.util.Map;

public interface DBPersonRetriever {
    Person findNationalityByName(String name);
    Map<String,Person> getAllEmployees();
}
