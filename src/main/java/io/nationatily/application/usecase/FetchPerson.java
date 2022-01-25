package io.nationatily.application.usecase;

import io.nationatily.application.port.output.DBPersonRetriever;
import io.nationatily.application.port.input.PersonRequestPort;
import io.nationatily.domain.Person;

public class FetchPerson implements PersonRequestPort {

    DBPersonRetriever personRetriever;

    public FetchPerson() {
        personRetriever = new io.nationatily.adapter.output.DBPersonRetriever();
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
