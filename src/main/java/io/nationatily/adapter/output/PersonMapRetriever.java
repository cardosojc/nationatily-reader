package io.nationatily.adapter.output;

import io.nationatily.domain.Person;
import io.nationatily.application.port.output.DBPersonRequestPort;
import jakarta.inject.Singleton;

import java.util.Map;

@Singleton
public class PersonMapRetriever implements DBPersonRequestPort {

    private static final Map<String, Person> personMap;

    static {
        personMap = Map.ofEntries(
                Map.entry("Gustaf", new Person("Gustaf", "Swedish", "")),
                Map.entry("Albin", new Person("Albin", "Swedish","")),
                Map.entry("Martin", new Person("Martin", "Slovak","")),
                Map.entry("José", new Person("José", "Portuguese",""))
        );
    }

    @Override
    public Person findNationalityByName(String name) {
        return personMap.get(name);
    }

    @Override
    public Map<String, Person> getAllEmployees() {
        return personMap;
    }
}
