package com.xzit.test;

import com.xzit.mapper.PersonMapper;
import com.xzit.model.PersonQuery;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TestQuery_way1 {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        PersonMapper mapper = session.getMapper(PersonMapper.class);
        List<PersonQuery> list = mapper.selectList();
        list.forEach(System.out::println);
        session.close();
    }
}
