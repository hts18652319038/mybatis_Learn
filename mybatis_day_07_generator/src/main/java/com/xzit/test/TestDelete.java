package com.xzit.test;

import com.xzit.mapper.StudentMapper;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        mapper.deleteByPrimaryKey(1);
        session.commit();
        session.close();
    }
}
