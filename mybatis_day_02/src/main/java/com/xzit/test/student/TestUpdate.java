package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        Student student = new Student(1, "李白", 22, "男");
        session.update("update",student);
        session.close();
    }
}
