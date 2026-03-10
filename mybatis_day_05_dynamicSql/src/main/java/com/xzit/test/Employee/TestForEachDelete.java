package com.xzit.test.Employee;

import com.xzit.mapper.EmployeeMapper;
import com.xzit.model.Employee;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestForEachDelete {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

        int[] ids = new int[]{5,6};
        mapper.delteCheck(ids);

        session.commit();
        session.close();
    }
}
