package com.xzit.test.student;

import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession(true);
        // session.delete("delete",9);
        session.delete("deleteByName","李莹");
        session.commit();
        session.close();
    }
}
