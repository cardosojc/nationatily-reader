package io.nationatily.application.usecase;

import io.nationatily.adapter.output.DBPersonRetriever;
import io.nationatily.application.port.output.DBPersonRequestPort;
import io.nationatily.application.port.input.PersonRequestPort;
import io.nationatily.domain.Person;

public class FetchPerson implements PersonRequestPort {

    final DBPersonRequestPort personRetriever;

    public FetchPerson() {
        personRetriever = new DBPersonRetriever();
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
