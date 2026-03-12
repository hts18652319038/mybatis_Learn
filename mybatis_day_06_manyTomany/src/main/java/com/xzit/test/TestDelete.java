package com.xzit.test;

import com.xzit.mapper.UsersMapper;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        UsersMapper mapper = session.getMapper(UsersMapper.class);
        mapper.delete(3);
        // mapper.deleteUser(1);
        session.commit();
        session.close();
    }
}
