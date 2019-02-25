package com.imagemaker.example.person.repository;

import com.imagemaker.example.person.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,String>{
}
