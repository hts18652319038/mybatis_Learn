package com.xzit.test.Employee;

import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestCountSalary {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setAddr("江苏省");
        double salary = mapper.countSalary(employee);
        System.out.println("平均工资"+salary);
        session.close();
    }
}
