package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestInsert {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("西施").setAge(22).setGender("女");
        mapper.insertSelective(student);
        //mapper.insert(new Student(null,"杜牧",30,"男"));
        session.commit();
        session.close();
    }
}
