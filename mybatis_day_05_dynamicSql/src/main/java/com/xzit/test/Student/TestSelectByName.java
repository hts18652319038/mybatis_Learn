package com.xzit.test.Student;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Stu;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelectByName {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Stu stu = new Stu();
        stu.setName("李");
        List<Stu> list = mapper.selectByName(stu);
        list.forEach(System.out::println);
        session.close();
    }
}
