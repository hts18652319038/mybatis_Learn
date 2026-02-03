package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestInsertObject {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        Student student = new Student();
        student.setName("李莹").setAge(24).setGender("女");
        session.insert("insertObject", student);
        //session.commit();
        session.close();
    }
}
