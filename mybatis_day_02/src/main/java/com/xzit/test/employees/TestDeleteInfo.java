package com.xzit.test.employees;

import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDeleteInfo {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        session.delete("deleteStaff");
        session.close();
    }
}
