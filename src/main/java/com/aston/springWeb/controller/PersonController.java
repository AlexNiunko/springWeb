package com.aston.springWeb.controller;


import com.aston.springWeb.entity.Person;
import com.aston.springWeb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @GetMapping("/find")
    public Person findPersonName(){
        return personService.getPerson();
    }

}
