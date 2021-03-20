package com.a3fun.springredismysql.mapper;

import com.a3fun.springredismysql.entity.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author haixiangchen
 */
@Mapper
public interface PersonMapper {

    /**
     * ID查找
     * @param id
     * @return
     */
    @Select("SELECT * FROM Person WHERE id = #{id}")
    Person searchById(@Param("id") String id);


    /**
     * 名称查找
     * @param name
     * @return
     */
    @Select("SELECT * FROM Person WHERE name = #{name}")
    List<Person> searchByName(@Param("name") String name);

    /**
     * 更新用户
     * @param person
     * @return
     */
    @Update("UPDATE Person set name = #{person.name}, age = #{person.age} WHERE id = #{person.id}")
    int updatePerson(@Param("person") Person person);
}
