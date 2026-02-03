package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestInsertAndGetId {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        Student student = new Student();
        student.setName("孟安慷").setAge(25).setGender("男");
        session.insert("insertAndGetId", student);
        //session.commit();
        session.close();
        System.out.println(student.getId());
    }
}
