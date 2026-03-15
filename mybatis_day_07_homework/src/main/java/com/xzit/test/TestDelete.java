package com.xzit.test;

import com.xzit.mapper.EmployeesMapper;
import com.xzit.model.EmployeesExample;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);

        // 1. 创建 Example 对象，用于构建删除条件
        EmployeesExample example = new EmployeesExample();
        EmployeesExample.Criteria criteria = example.createCriteria();

        // 2. 设置条件：地址中包含“陕西省”
        // 注意：使用 andAddrLike 并配合 % 通配符实现模糊匹配
        criteria.andAddrLike("%陕西省%");

        // 3. 调用逆向工程生成的删除 API
        // deleteByExample 会删除所有符合 criteria 条件的记录
        int deletedRows = mapper.deleteByExample(example);

        // 4. 打印结果并提交事务
        System.out.println("成功删除陕西省员工数量：" + deletedRows);
        session.commit();
        session.close();
    }
}
