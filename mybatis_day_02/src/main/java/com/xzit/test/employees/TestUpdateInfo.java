package com.xzit.test.employees;

import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestUpdateInfo {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        if (session != null) {
            session.update("updateInfo");
            session.commit();
        }
        if (session != null) {
            session.close();
        }
    }
}
