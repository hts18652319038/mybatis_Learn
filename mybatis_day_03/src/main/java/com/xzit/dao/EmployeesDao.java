package com.xzit.dao;

import com.xzit.model.Employees;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

public interface EmployeesDao {
    default SqlSession getSession(){
        try {
            return new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml")).openSession();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    int save(Employees employees);
    int delete(int id);
    int update(Employees employees);
    List<Employees> selectList();
    Employees selectId(int id);
}
