package com.xzit.mapper;

import com.xzit.model.Stu;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StuMapper {
    @Select("<script>" +
            "select * from student" +
            "        <where>" +
            "            <if test=\"name!=null and name!=''\">" +
            "                and name like #{name}" +
            "            </if>" +
            "            <if test=\"age!=null and age!=0\">" +
            "                and age=#{age}" +
            "            </if>" +
            "            <if test=\"gender!=null and gender!=''\">" +
            "                and gender=#{gender}" +
            "            </if>" +
            "        </where>"+
            "</script>"
    )
    List<Stu> selectCondition(Stu stu);
}
