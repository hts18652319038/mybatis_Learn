package com.xzit.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xzit.mapper.EmployeesMapper;
import com.xzit.model.Employees;
import com.xzit.model.EmployeesExample;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        PageHelper.startPage(1, 3);
        // 创建查询条件
        EmployeesExample example = new EmployeesExample();
        EmployeesExample.Criteria criteria = example.createCriteria();
        // 设置过滤条件
        criteria.andAddrLike("%江苏省%");

        List<Employees> list = mapper.selectByExample(example);
        PageInfo<Employees> pageInfo = new PageInfo<>(list);
        // 打印结果
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页数据如下：");
        for (Employees employees : list) {
            System.out.println("ID: " + employees.getId() + ", 姓名: " + employees.getName() + ", 地址: " + employees.getAddr());
        }
    }
}
