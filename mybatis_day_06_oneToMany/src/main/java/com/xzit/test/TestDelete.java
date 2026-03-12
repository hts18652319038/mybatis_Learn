package com.xzit.test;

import com.xzit.mapper.TeamMapper;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        TeamMapper teamMapper = session.getMapper(TeamMapper.class);
        teamMapper.delete(2);
        session.commit();
        session.close();
    }
}
