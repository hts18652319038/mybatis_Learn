package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelectCondition {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        Student student = new Student();
        student.setGender("男").setAge(22);
        List<Student> list = session.selectList("selectByCondition", student);
        list.forEach(System.out::println);
        session.close();
    }
}
