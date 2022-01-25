package io.nationatily.application.port.input;

import io.nationatily.domain.Person;

public interface PersonRequestPort {
    Person findNationalityByName(String name);
}
