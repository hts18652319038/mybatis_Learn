package com.xzit.test;

import com.xzit.mapper.EmployeesMapper;
import com.xzit.mapper.StudentMapper;
import com.xzit.model.Employees;
import com.xzit.model.Student;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestEmployees {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        List<Employees> employees = mapper.selectList();
        employees.forEach(System.out::println);
        session.close();
    }
}
