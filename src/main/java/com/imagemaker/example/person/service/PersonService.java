package com.imagemaker.example.person.service;


import com.imagemaker.example.person.entity.Person;

import java.util.List;

public interface PersonService {
    public  List<Person> retrievePersons();

    public Person getPerson(String person);

    public void savePerson(Person person);

    public void deletePerson(String person);

    public void updatePerson(Person person);
}
