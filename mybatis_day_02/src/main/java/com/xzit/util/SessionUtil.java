package com.xzit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class SessionUtil {
    public static SqlSession getSession(boolean autoCommit){
        /*InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(inputStream);
        SqlSession session = factory.openSession();
        return session;*/
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")).openSession(autoCommit);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }

    public static SqlSession getSession(){
        try {
            return new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream("SqlMapConfig.xml")).openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
