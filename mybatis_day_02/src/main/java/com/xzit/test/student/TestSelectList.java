package com.xzit.test.student;

import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelectList {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        List<Student> list = session.selectList("selectList");
        list.forEach(System.out::println);
        session.close();
    }
}
