package io.nationatily.adapter.input;

import io.nationatily.application.port.input.PersonRequestPort;
import io.nationatily.application.usecase.FetchPerson;
import io.nationatily.application.usecase.FetchPersonFake;
import io.nationatily.domain.Person;

public class CommandLinePersonAdapter {
    public static void main(String[] args) {
        PersonRequestPort personRequest = new FetchPersonFake();
        Person person = personRequest.findNationalityByName("José");
        System.out.println(person.getNationality());
        PersonRequestPort dbPersonRequest = new FetchPerson();
        Person person1 = dbPersonRequest.findNationalityByName("Gustaf");
        System.out.println(person1.getNationality());
    }
}
