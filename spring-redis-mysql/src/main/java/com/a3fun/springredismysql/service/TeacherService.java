package com.a3fun.springredismysql.service;

import com.a3fun.springredismysql.entity.Person;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeacherService {
    @Resource
    PersonService personService;

    public Person updatePerson() throws Exception {
        Person person = personService.searchById("1");
        person.setName("Test");
        personService.updatePersonInTransactional(person);
        return person;
    }
}
