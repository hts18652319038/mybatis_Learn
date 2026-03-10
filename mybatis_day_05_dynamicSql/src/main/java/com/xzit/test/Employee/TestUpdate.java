package com.xzit.test.Employee;

import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee();
        employee.setAddr("四川省");
        employee.setSal(10000);
        employee.setJob("财务主任");
        mapper.update(employee);
        session.commit();
        session.close();
    }
}
