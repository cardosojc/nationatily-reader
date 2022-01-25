package io.nationatily.application.service;

import io.nationatily.application.port.FakeDBPersonRetriever;
import io.nationatily.application.port.NationalityRequestPort;
import io.nationatily.domain.NationalityStats;
import io.nationatily.domain.Person;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Singleton
public class NationalityNumberService implements NationalityRequestPort {

    FakeDBPersonRetriever noOfNationalityRetriever;

    public NationalityNumberService(FakeDBPersonRetriever noOfNationalityRetriever) {
        this.noOfNationalityRetriever = noOfNationalityRetriever;
    }

    @Override
    public List<NationalityStats> findNoOfEmployessByNationality() {
        var personMap = noOfNationalityRetriever.getAllEmployees();
        return  personMap.values().stream().collect(groupingBy(Person::getNationality, counting())).entrySet().stream().map(a->new NationalityStats(a.getKey(), a.getValue())).collect(Collectors.toList());
    }
}
