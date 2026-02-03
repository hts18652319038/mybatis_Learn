package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestSelectId {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        Student student = session.selectOne("selectById", 8);
        System.out.println(student);
        session.close();
    }
}
