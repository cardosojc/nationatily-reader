package io.nationatily.application.port;

import io.nationatily.domain.Person;

public interface PersonRequestPort {
    Person findNationalityByName(String name);
}
