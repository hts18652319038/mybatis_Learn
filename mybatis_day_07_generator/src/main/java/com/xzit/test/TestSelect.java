package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.model.StudentExample;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        StudentExample example = new StudentExample();
        example.createCriteria().andNameLike("%李%").andAgeLessThan(50);
        List<Student> list = mapper.selectByExample(example);
        list.forEach(System.out::println);
        /*Student student = mapper.selectByPrimaryKey(15);
        System.out.println(student);*/
        session.close();
    }
}
