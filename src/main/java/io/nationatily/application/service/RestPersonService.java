package io.nationatily.application.service;

import io.nationatily.adapter.PersonMapRetriever;
import io.nationatily.domain.Person;
import io.nationatily.application.port.FakeDBPersonRetriever;
import io.nationatily.application.port.PersonRequestPort;
import jakarta.inject.Singleton;

@Singleton
public class RestPersonService implements PersonRequestPort {

    FakeDBPersonRetriever personRetriever;

    public RestPersonService(FakeDBPersonRetriever personRetriever) {
        this.personRetriever = personRetriever;
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
