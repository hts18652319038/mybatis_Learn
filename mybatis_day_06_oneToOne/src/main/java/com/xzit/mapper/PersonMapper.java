package com.xzit.mapper;

import com.xzit.model.Person;
import com.xzit.model.PersonQuery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PersonMapper {
    @Insert("insert into person values (null,#{pname},#{page})")
    void insert(Person person);
    @Select("SELECT * FROM person p JOIN driverinfo d ON p.pid=d.pid")
    List<PersonQuery> selectList();
}
