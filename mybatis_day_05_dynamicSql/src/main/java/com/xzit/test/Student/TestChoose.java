package com.xzit.test.Student;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestChoose {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("王%");
        student.setAge(25);
        student.setGender("男");
        List<Student> list = mapper.selectConditionChoose(student);
        list.forEach(System.out::println);
        session.commit();
    }
}
