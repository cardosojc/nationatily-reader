package io.nationatily.adapter;

import io.nationatily.domain.Person;
import io.nationatily.application.port.FakeDBPersonRetriever;

import java.util.Map;

public class PersonMapRetriever implements FakeDBPersonRetriever {

    private static final Map<String, Person> personMap;

    static {
        personMap = Map.ofEntries(
                Map.entry("Gustaf", new Person("Gustaf", "Swedish")),
                Map.entry("Albin", new Person("Albin", "Swedish")),
                Map.entry("Martin", new Person("Martin", "Slovak")),
                Map.entry("José", new Person("José", "Portuguese"))
        );
    }

    @Override
    public Person findNationalityByName(String name) {
        return personMap.get(name);
    }
}
