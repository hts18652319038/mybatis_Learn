package com.xzit.test.employees;

import com.xzit.model.Employees;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelectInfo {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        List<Employees> list = session.selectList("selectInfo");
        list.forEach(System.out::println);
        session.close();
    }
}
