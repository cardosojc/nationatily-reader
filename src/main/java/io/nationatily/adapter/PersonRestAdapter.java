package io.nationatily.adapter;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.nationatily.domain.Person;
import io.nationatily.application.port.PersonRequestPort;

@Controller("/nationality")
public class PersonRestAdapter {

    PersonRequestPort personRequest;

    public PersonRestAdapter(PersonRequestPort personRequest) {
        this.personRequest = personRequest;
    }

    @Get(uri = "/person/{name}", produces = MediaType.APPLICATION_JSON)
    public HttpResponse<Person> getPersonNationality(@PathVariable String name) {
        return HttpResponse.ok(personRequest.findNationalityByName(name));
    }
}
