package io.nationatily.application.usecase;

import io.nationatily.adapter.output.PersonMapRetriever;
import io.nationatily.domain.Person;
import io.nationatily.application.port.output.DBPersonRetriever;
import io.nationatily.application.port.input.PersonRequestPort;

public class FetchPersonFake implements PersonRequestPort {

    DBPersonRetriever personRetriever;

    public FetchPersonFake() {
        personRetriever = new PersonMapRetriever();
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
