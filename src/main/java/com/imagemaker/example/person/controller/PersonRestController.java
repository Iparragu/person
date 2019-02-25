package com.imagemaker.example.person.controller;

import com.imagemaker.example.person.service.PersonService;
import com.imagemaker.example.person.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {

    @Autowired
    private PersonService personService;

    public void setPersonService(PersonService personService){
        this.personService = personService;
    }

    @GetMapping("/api/person")
    public List<Person> getEmployees() {
        List<Person> persons = personService.retrievePersons();
        return persons;
    }

    @GetMapping("/api/person/{rut}")
    public Person getEmployee(@PathVariable(name="rut")String rut) {
        return personService.getPerson(rut);
    }

    @PostMapping("/api/person")
    public void saveEmployee(Person persons){
        personService.savePerson(persons);
        System.out.println("Employee Saved Successfully");
    }

    @DeleteMapping("/api/person/{rut}")
    public void deleteEmployee(@PathVariable(name="rut")String rut){
        personService.deletePerson(rut);
        System.out.println("Employee Deleted Successfully");
    }

    @PutMapping("/api/person/{rut}")
    public void updateEmployee(@RequestBody Person persons,
                               @PathVariable(name="rut")String rut){
        Person emp = personService.getPerson(rut);
        if(emp != null){
            personService.updatePerson(persons);
        }

    }
}
