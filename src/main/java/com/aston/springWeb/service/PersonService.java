package com.aston.springWeb.service;

import com.aston.springWeb.dto.PersonDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonService {
    @Autowired
    private PersonDto personDto;
    public String getPersonName(){
        return personDto.getName();
    }
}
