package com.xzit.test;

import com.xzit.mapper.DriverInfoMapper;
import com.xzit.model.DriverQuery;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestQuery_way2 {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        DriverInfoMapper mapper = session.getMapper(DriverInfoMapper.class);
        List<DriverQuery> list = mapper.selectList();
        list.forEach(System.out::println);
        session.close();
    }
}
