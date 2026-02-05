package com.xzit.dao.impl;

import com.xzit.dao.EmployeesDao;
import com.xzit.model.Employees;
import org.apache.ibatis.session.SqlSession;

import java.util.Collections;
import java.util.List;

public class EmployeesDaoImpl implements EmployeesDao {
    @Override
    public int save(Employees employees) {
        SqlSession session = getSession();
        int i = session.insert("insert", employees);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public int delete(int id) {
        SqlSession session = getSession();
        int i = session.delete("delete", id);
        session.commit();
        session.close();
        return 0;
    }

    @Override
    public int update(Employees employees) {
        SqlSession session = getSession();
        int i = session.update("update", employees);
        session.commit();
        session.close();
        return i;
    }

    @Override
    public List<Employees> selectList() {
        SqlSession session = getSession();
        List<Employees> list = session.selectList("selectList");
        session.close();
        return list;
    }

    @Override
    public Employees selectId(int id) {
        SqlSession session = getSession();
        Employees employees = session.selectOne("selectById", id);
        session.close();
        return employees;
    }
}
