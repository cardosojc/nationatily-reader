package io.nationatily.application.port;

import io.nationatily.domain.Person;

public interface FakeDBPersonRetriever {
    Person findNationalityByName(String name);
}
