package io.nationatily.application.usecase;

import io.nationatily.application.port.output.DBPersonRequestPort;
import io.nationatily.application.port.input.NationalityRequestPort;
import io.nationatily.domain.NationalityStats;
import io.nationatily.domain.Person;
import jakarta.inject.Singleton;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@Singleton
public class FetchNationalityStats implements NationalityRequestPort {

    final DBPersonRequestPort noOfNationalityRetriever;

    public FetchNationalityStats(DBPersonRequestPort noOfNationalityRetriever) {
        this.noOfNationalityRetriever = noOfNationalityRetriever;
    }

    @Override
    public List<NationalityStats> findNoOfEmployessByNationality() {
        var personMap = noOfNationalityRetriever.getAllEmployees();
        return  personMap.values().stream().collect(groupingBy(Person::getNationality, counting())).entrySet().stream().map(a->new NationalityStats(a.getKey(), a.getValue())).collect(Collectors.toList());
    }
}
