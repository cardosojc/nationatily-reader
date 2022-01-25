package io.nationatily.application.usecase;

import io.nationatily.domain.Person;
import io.nationatily.application.port.output.DBPersonRetriever;
import io.nationatily.application.port.input.PersonRequestPort;
import jakarta.inject.Singleton;

@Singleton
public class FetchPersonRest implements PersonRequestPort {

    DBPersonRetriever personRetriever;

    public FetchPersonRest(DBPersonRetriever personRetriever) {
        this.personRetriever = personRetriever;
    }

    @Override
    public Person findNationalityByName(String name) {
        return personRetriever.findNationalityByName(name);
    }
}
