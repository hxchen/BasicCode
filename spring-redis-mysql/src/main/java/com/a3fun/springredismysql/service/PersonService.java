package com.a3fun.springredismysql.service;

import com.a3fun.springredismysql.entity.Person;
import com.a3fun.springredismysql.mapper.PersonMapper;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
public class PersonService {

    @Resource
    PersonMapper personMapper;

    @Cacheable( key = "'id='+#id")
    public Person searchById(String id){
        return personMapper.searchById(id);
    }
    @Cacheable(key = "'name='+#name")
    public List<Person> searchByName(String name) {
        return personMapper.searchByName(name);
    }

    /**
     * 更新
     * @param person
     * @return
     */
    @Caching(evict = {
            @CacheEvict(key = "'name='+#result.name", allEntries = true)
    })
    public Person updatePerson(Person person){
        personMapper.updatePerson(person);
        return person;
    }

    @Transactional(rollbackFor=Exception.class)
    public Person updatePersonInTransactional(Person person) throws Exception {
        personMapper.updatePerson(person);
        throw new Exception("update error");
    }

    public Person updatePersonTransactional(Person person){
        try{
            updatePersonInTransactional(person);
        }catch (Exception e){
            e.printStackTrace();
        }
        return person;
    }
}
