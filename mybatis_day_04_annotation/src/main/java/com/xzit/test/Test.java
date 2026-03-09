package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        SqlSession session = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> list = mapper.selectList();
        list.forEach(System.out::println);

        System.out.println("====================按ID查找=====================");
        Student student = mapper.selectId(2);
        System.out.printf("按ID查找：", student);

        System.out.println("=====================更新========================");
        Student student1 = mapper.selectId(10);
        student1.setName("张宇");
        student1.setAge(18);
        student1.setGender("男");
        mapper.update(student1);
        session.commit();

        System.out.println("====================删除=========================");
        mapper.delete(13);
        session.commit();

        session.close();
    }
}
