package io.nationatily.application.service;

import io.nationatily.adapter.DBPersonRetriever;
import io.nationatily.application.port.FakeDBPersonRetriever;
import io.nationatily.application.port.PersonRequestPort;
import io.nationatily.domain.Person;

public class DBPersonService implements PersonRequestPort {

    FakeDBPersonRetriever personRetriever;

    public DBPersonService() {
        personRetriever = new DBPersonRetriever();
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
