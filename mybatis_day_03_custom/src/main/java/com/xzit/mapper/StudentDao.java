package com.xzit.mapper;

import com.xzit.model.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentDao {
    @Select("select * from student")
    List<Student> selectList();
}
