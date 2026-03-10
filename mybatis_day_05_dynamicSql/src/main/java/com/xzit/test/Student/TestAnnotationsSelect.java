package com.xzit.test.Student;

import com.xzit.mapper.StuMapper;
import com.xzit.model.Stu;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestAnnotationsSelect {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StuMapper mapper = session.getMapper(StuMapper.class);
        Stu stu = new Stu();
        stu.setName("李%");
        stu.setAge(25);
        List<Stu> list = mapper.selectCondition(stu);
        list.forEach(System.out::println);
        session.close();
    }
}
