package io.nationatily.adapter;

import io.nationatily.domain.Person;
import io.nationatily.application.port.PersonRequestPort;
import io.nationatily.application.service.PersonService;

public class CommandLinePersonAdapter {
    public static void main(String[] args) {
        PersonRequestPort personRequest = new PersonService();
        Person person = personRequest.findNationalityByName("José");
        System.out.println(person.getNationality());
    }
}
