package com.xzit.test;

import com.xzit.mapper.EmployeesMapper;
import com.xzit.model.Employees;
import com.xzit.model.EmployeesExample;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

public class TestUpdate {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);

        // 1. 创建 Example 对象用于构建 WHERE 条件
        EmployeesExample example = new EmployeesExample();
        example.createCriteria()
                .andAgeGreaterThan(27)
                .andJobEqualTo("销售员");

        // 2. 查出这些员工
        List<Employees> list = mapper.selectByExample(example);

        // 3. 循环修改并更新
        for (Employees emp : list) {
            // 在原工资基础上加 1000
            emp.setSal(emp.getSal().add(new BigDecimal("1000")));

            // 调用逆向工程生成的按主键更新 API
            mapper.updateByPrimaryKeySelective(emp);
        }

        session.commit();
        session.close();
    }
}
