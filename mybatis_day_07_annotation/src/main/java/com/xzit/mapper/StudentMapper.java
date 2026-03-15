package com.xzit.mapper;

import com.xzit.model.Student;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface StudentMapper {
    @Select("select * from student")
    @Results(id = "r",value={
            @Result(id = true,column="id",property="id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(column = "gender",property = "gender"),
            /*@Result(property = "teams",column = "tid",
                    one = @One(select = "com.xzit.mapper.TeamMapper.selectById",
                    fetchType = FetchType.LAZY))*/
            /*@Result(property = "teams",column = "tid",
                    many = @Many(select = "com.xzit.mapper.PlayerMapper.selectByTid",
                            fetchType = FetchType.LAZY))*/
    })
    List<Student> selectList();

    @Select("select id,name,age,gender from student")
    @ResultMap(value={"r"})
    List<Student> selectAll();
}
