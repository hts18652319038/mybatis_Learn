package com.xzit.test.Student;

import com.xzit.mapper.StudentMapper;
import com.xzit.model.Stu;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class TestInsertBatch {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Stu> list = new ArrayList<>();
        list.add(new Stu(0,"谢道韫",22,"女"));
        list.add(new Stu(0,"李世民",54,"男"));
        list.add(new Stu(0,"萧衍",28,"男"));
        list.add(new Stu(0,"雷武羯",36,"男"));
        mapper.insert(list);
        session.commit();
        session.close();
    }
}
