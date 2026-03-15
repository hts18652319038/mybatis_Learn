package com.xzit.test;

import com.xzit.mapper.EmployeesMapper;
import com.xzit.model.Employees;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;

public class TestInsert {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        // 插入数据
        Employees emp7 = new Employees();
        emp7.setId(7);
        emp7.setName("张丽");
        emp7.setAddr("江苏省南京市");
        emp7.setAge(32);
        emp7.setJob("销售员");
        emp7.setSal(BigDecimal.valueOf(7000));
        mapper.insertSelective(emp7);

        // 插入 ID 为 8 的数据
        Employees emp8 = new Employees();
        emp8.setId(8);
        emp8.setName("张伟");
        emp8.setAddr("江苏省苏州市");
        emp8.setAge(26);
        emp8.setJob("职员");
        emp8.setSal(BigDecimal.valueOf(5000));
        mapper.insertSelective(emp8);

        // 插入 ID 为 9 的数据
        Employees emp9 = new Employees();
        emp9.setId(9);
        emp9.setName("王晓");
        emp9.setAddr("上海市");
        emp9.setAge(30);
        emp9.setJob("区域总监");
        emp9.setSal(BigDecimal.valueOf(20000));
        mapper.insertSelective(emp9);

        // 插入 ID 为 10 的数据
        Employees emp10 = new Employees();
        emp10.setId(10);
        emp10.setName("赵敏");
        emp10.setAddr("上海市");
        emp10.setAge(25);
        emp10.setJob("财务");
        emp10.setSal(BigDecimal.valueOf(10000));
        mapper.insertSelective(emp10);

        session.commit();
        session.close();
    }
}
