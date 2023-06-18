package com.a3fun.springredismysql.controller;

import com.a3fun.springredismysql.entity.Person;
import com.a3fun.springredismysql.service.PersonService;
import com.a3fun.springredismysql.service.TeacherService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author haixiangchen
 */
@Slf4j
@RestController(value = "/")
public class HomeController {
    @Autowired
    PersonService personService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(path = "search")
    public String search(@RequestParam("id") String id){
        Person person = personService.searchById(id);
        return JSONObject.toJSONString(person);
    }

    /**
     * 通过名称搜索
     * @param name
     * @return
     */
    @RequestMapping(path = "search_name")
    public String searchByName(@RequestParam("name") String name){
        List<Person> person = personService.searchByName(name);
        return JSONArray.toJSONString(person);
    }

    @RequestMapping(path = "update")
    public String search(@RequestParam("id") String id, @RequestParam("name") String name){
        Person person = personService.searchById(id);
        person.setName(name);
        personService.updatePerson(person);
        return JSONObject.toJSONString(person);
    }

    @RequestMapping(path = "teacher")
    public String teacher(){
        Person person = null;
        try {
            person = teacherService.updatePerson();
        }catch (Exception e){
            System.err.printf(e.getMessage());
        }
        return JSONObject.toJSONString(person);
    }

    @RequestMapping(path = "person")
    public String person(){
        Person person = personService.searchById("1");
        person.setName("Test");
        try {
            person = personService.updatePersonTransactional(person);
        }catch (Exception e){
            System.err.printf(e.getMessage());
        }
        return JSONObject.toJSONString(person);
    }

}
