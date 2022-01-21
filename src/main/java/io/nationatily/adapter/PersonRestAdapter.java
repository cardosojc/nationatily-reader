package io.nationatily.adapter;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.nationatily.application.port.NationalityRequestPort;
import io.nationatily.domain.NationalityStats;
import io.nationatily.domain.Person;
import io.nationatily.application.port.PersonRequestPort;

import java.util.List;

@Controller("/nationality")
public class PersonRestAdapter {

    PersonRequestPort personRequest;
    NationalityRequestPort nationalityRequestPort;

    public PersonRestAdapter(PersonRequestPort personRequest, NationalityRequestPort nationalityRequestPort) {
        this.personRequest = personRequest;
        this.nationalityRequestPort = nationalityRequestPort;
    }

    @Get(uri = "/person/{name}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> getPersonNationality(@PathVariable String name) {
        return HttpResponse.ok(personRequest.findNationalityByName(name));
    }

    @Get(uri = "/person/stats", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<List<NationalityStats>> getPersonNationality() {
        return HttpResponse.ok(nationalityRequestPort.findNoOfEmployessByNationality());
    }

}
