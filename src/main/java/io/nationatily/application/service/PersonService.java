package io.nationatily.application.service;

import io.nationatily.adapter.PersonMapRetriever;
import io.nationatily.domain.Person;
import io.nationatily.application.port.FakeDBPersonRetriever;
import io.nationatily.application.port.PersonRequestPort;

public class PersonService implements PersonRequestPort {

    FakeDBPersonRetriever personRetriever;

    public PersonService() {
        personRetriever = new PersonMapRetriever();
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
