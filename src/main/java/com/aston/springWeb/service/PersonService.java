package com.aston.springWeb.service;


import com.aston.springWeb.entity.Person;
import com.aston.springWeb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    @Autowired
    PersonRepository personRepository;
    public Person getPerson(){
        return personRepository.findAll().get(0);
    }


}
