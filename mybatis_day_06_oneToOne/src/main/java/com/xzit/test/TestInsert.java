package com.xzit.test;

import com.xzit.mapper.DriverInfoMapper;
import com.xzit.mapper.PersonMapper;
import com.xzit.model.DriverInfo;
import com.xzit.model.Person;
import com.xzit.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TestInsert {
    public static void main(String[] args) {
        SqlSession session = SessionUtil.getSession();
        PersonMapper p_mapper = session.getMapper(PersonMapper.class);
        p_mapper.insert(new Person(0,"李白",22));
        p_mapper.insert(new Person(0,"杜甫",27));
        p_mapper.insert(new Person(0,"李清照",32));

        DriverInfoMapper d_mapper = session.getMapper(DriverInfoMapper.class);
        d_mapper.insert(new DriverInfo(0,"A",1));
        d_mapper.insert(new DriverInfo(0,"B",2));
        d_mapper.insert(new DriverInfo(0,"C",3));

        session.commit();
        session.close();
    }
}
