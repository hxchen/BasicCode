package com.a3fun.springredismysql.service;

import com.a3fun.springredismysql.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TeacherService {
    @Autowired
    PersonService personService;

    public Person updatePerson() throws Exception {
        Person person = personService.searchById("1");
        person.setName("Test");
        personService.updatePersonInTransactional(person);
        return person;
    }
}
