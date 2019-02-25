package com.imagemaker.example.person.service.impl;

import com.imagemaker.example.person.repository.PersonRepository;
import com.imagemaker.example.person.service.PersonService;
import com.imagemaker.example.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void setPersonRepository(PersonRepository personRepository){
        this.personRepository = personRepository;
    }

    public List<Person> retrievePersons(){
        List<Person> persons = personRepository.findAll();
        return persons;
    }

    @Override
    public Person getPerson(String person) {
        Optional<Person> optPer = personRepository.findById(person);
        return optPer.get();
    }

    @Override
    public void savePerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deletePerson(String person) {
        personRepository.deleteById(person);
    }

    @Override
    public void updatePerson(Person person) {
        personRepository.save(person);
    }


}
