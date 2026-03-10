package com.xzit.test.Student;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestCount {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("李%");
        long c = mapper.count(student);
        System.out.println("总记录数 = " + c);
        session.close();
    }
}
