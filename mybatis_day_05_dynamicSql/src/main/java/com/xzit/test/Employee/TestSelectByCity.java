package com.xzit.test.Employee;

import com.xzit.mapper.EmployeeMapper;
import com.xzit.mapper.StudentMapper;
import com.xzit.model.Employee;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelectByCity {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setAddr("江苏省");
        List<Employee> employees = mapper.selectCondition(employee);
        employees.forEach(System.out::println);
        session.close();
    }
}
