package com.a3fun.springredismysql.service;

import com.a3fun.springredismysql.entity.Person;
import com.a3fun.springredismysql.mapper.PersonMapper;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@CacheConfig(cacheNames = "users")
public class PersonService {

    @Resource
    PersonMapper personMapper;

    @Cacheable(key = "#id")
    public Person searchById(String id){
        return personMapper.searchById(id);
    }

    @CachePut(key = "#person.id")
    public Person updatePerson(Person person){
        personMapper.updatePerson(person);
        return person;
    }
}
