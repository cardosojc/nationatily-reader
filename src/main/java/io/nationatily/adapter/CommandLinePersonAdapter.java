package io.nationatily.adapter;

import io.nationatily.application.service.DBPersonService;
import io.nationatily.domain.Person;
import io.nationatily.application.port.PersonRequestPort;
import io.nationatily.application.service.PersonService;

public class CommandLinePersonAdapter {
    public static void main(String[] args) {
        PersonRequestPort personRequest = new PersonService();
        Person person = personRequest.findNationalityByName("José");
        System.out.println(person.getNationality());
        PersonRequestPort dbPersonRequest = new DBPersonService();
        Person person1 = dbPersonRequest.findNationalityByName("Martin");
        System.out.println(person1.getNationality());
    }
}
