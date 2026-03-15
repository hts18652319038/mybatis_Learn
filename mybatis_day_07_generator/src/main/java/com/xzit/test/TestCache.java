package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class TestCache {
    public static void main(String[] args) throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("SqlMapConfig.xml"));
        SqlSession session = factory.openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectByExample(null);
        list.forEach(System.out::println);
        session.close();
        session = factory.openSession();
        System.out.println("=======================================");
        mapper = session.getMapper(StudentMapper.class);
        list = mapper.selectByExample(null);
        list.forEach(System.out::println);
        session.close();
    }
}
