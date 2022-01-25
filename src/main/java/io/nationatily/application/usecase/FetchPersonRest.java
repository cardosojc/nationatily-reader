package io.nationatily.application.usecase;

import io.nationatily.application.port.input.PersonRequestPort;
import io.nationatily.application.port.output.CountryRequestPort;
import io.nationatily.application.port.output.DBPersonRequestPort;
import io.nationatily.domain.Person;
import jakarta.inject.Singleton;

@Singleton
public class FetchPersonRest implements PersonRequestPort {

    final DBPersonRequestPort personRetriever;
    final CountryRequestPort countryRequestPort;

    public FetchPersonRest(DBPersonRequestPort personRetriever, CountryRequestPort countryRequestPort) {
        this.personRetriever = personRetriever;
        this.countryRequestPort = countryRequestPort;
    }

    @Override
    public Person findNationalityByName(String name) {
        var person = personRetriever.findNationalityByName(name);
        person.setCountry(countryRequestPort.fetchCountryFromDemonym(person.getNationality()));
        return person;
    }
}
