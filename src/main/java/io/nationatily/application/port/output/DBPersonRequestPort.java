package io.nationatily.application.port.output;

import io.nationatily.domain.Person;

import java.util.Map;

public interface DBPersonRequestPort {
    Person findNationalityByName(String name);
    Map<String,Person> getAllEmployees();
}
